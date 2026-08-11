package net.shirojr.nbv.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
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
public class QuarterSlabBlock extends AbstractVariationBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<BlockHalf> HALF = Properties.BLOCK_HALF;

    public QuarterSlabBlock(Settings settings, Variation variant) {
        super(settings, variant);
        this.setDefaultState(this.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(HALF, BlockHalf.BOTTOM)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, HALF);
    }

    @Override
    public Identifier getBaseModel() {
        return NBVMain.getNeMuelchId("block/base_quarter_slab");
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState placementState = super.getPlacementState(ctx);
        if (placementState == null) return null;
        Vec3d hitPos = ctx.getHitPos().subtract(ctx.getBlockPos().toCenterPos());
        placementState = placementState.with(HALF, hitPos.y >= 0 ? BlockHalf.TOP : BlockHalf.BOTTOM);
        boolean west = hitPos.x < 0;
        boolean north = hitPos.z < 0;
        Direction facing;
        if (north && west) {
            facing = Direction.NORTH;
        } else if (north) {
            facing = Direction.EAST;
        } else if (west) {
            facing = Direction.WEST;
        } else {
            facing = Direction.SOUTH;
        }
        placementState = placementState.with(FACING, facing);
        return placementState;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createCardinalRotatedShape(new int[]{0, 0, 0, 8, 8, 8}, state.get(FACING), state.get(HALF));
    }
}
