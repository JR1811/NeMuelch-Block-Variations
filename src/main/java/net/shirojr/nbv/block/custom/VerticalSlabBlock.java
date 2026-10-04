package net.shirojr.nbv.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.shirojr.nbv.NBVMain;
import net.shirojr.nbv.block.util.Variation;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class VerticalSlabBlock extends AbstractVariationBlock {
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public VerticalSlabBlock(Settings settings, Variation variant) {
        super(settings, variant);
        this.setDefaultState(this.getDefaultState()
                .with(FACING, Direction.NORTH)
        );
    }

    @Override
    public Identifier getBaseModel() {
        return NBVMain.getNeMuelchId("block/base_vertical_slab");
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createRotatedShape(new int[]{0, 0, 0, 16, 8, 16}, state.get(FACING).getOpposite());
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext ctx) {
        if (!ctx.getStack().isOf(this.asItem())) return super.canReplace(state, ctx);
        if (ctx.getPlayer() != null && ctx.getPlayer().isSneaking()) return super.canReplace(state, ctx);
        if (!ctx.canReplaceExisting()) {
            return state.get(FACING) == getNewFacing(ctx).getOpposite();
        }
        Direction stateFacing = state.get(FACING);
        Direction placementFacing = ctx.getSide();
        if (stateFacing == placementFacing.getOpposite()) {
            return true;
        }

        Vec3d localHitPos = ctx.getHitPos().subtract(Vec3d.of(ctx.getBlockPos()));
        double selectedCoordinate = stateFacing.getAxis().choose(localHitPos.x, localHitPos.y, localHitPos.z);
        if (stateFacing.getDirection() == Direction.AxisDirection.POSITIVE) {
            return selectedCoordinate < 0.5;
        } else {
            return selectedCoordinate > 0.5;
        }
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState existing = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (existing.isOf(this)) {
            return this.getVariant().parentBlock().getDefaultState();
        }
        BlockState placementState = super.getPlacementState(ctx);
        if (placementState == null) return null;

        return placementState.with(FACING, getNewFacing(ctx));
    }

    private Direction getNewFacing(ItemPlacementContext ctx) {
        Direction side = ctx.getSide();
        if (side.getAxis().isHorizontal()) return side.getOpposite();
        if (ctx.getPlayer() != null) return ctx.getPlayer().getHorizontalFacing();
        return this.getDefaultState().get(FACING);
    }
}
