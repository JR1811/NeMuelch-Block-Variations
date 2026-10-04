package net.shirojr.nbv.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
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

    /*@Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (hand != Hand.MAIN_HAND || player.isSneaking()) return super.onUse(state, world, pos, player, hand, hit);
        if (!(state.getBlock() instanceof AbstractVariationBlock block)) {
            return super.onUse(state, world, pos, player, hand, hit);
        }
        if (world instanceof ServerWorld serverWorld) {
            Block parentBlock = block.getVariant().parentBlock();
            serverWorld.setBlockState(pos, parentBlock.getDefaultState());
            BlockSoundGroup soundGroup = parentBlock.getSoundGroup(state);
            serverWorld.playSound(null, pos, soundGroup.getPlaceSound(), SoundCategory.BLOCKS);
            if (!player.isCreative() && !player.isSpectator()) {
                player.getMainHandStack().decrement(1);
            }
        }
        return ActionResult.SUCCESS;
    }*/

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createRotatedShape(new int[]{0, 0, 0, 16, 8, 16}, state.get(FACING));
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos placedPos = ctx.getBlockPos();
        if (world.getBlockState(placedPos).isOf(this)) {
            return this.getVariant().parentBlock().getPlacementState(ctx);
        }

        BlockState placementState = super.getPlacementState(ctx);
        if (placementState == null) return null;

        Direction hitDirection = ctx.getSide();
        if (hitDirection.getAxis().isHorizontal()) {
            placementState = placementState.with(FACING, hitDirection);
        } else {
            Vec3d hitPos = ctx.getHitPos();
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
        }
        return placementState;
    }
}
