package net.shirojr.nbv.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.shirojr.nbv.NBVMain;
import net.shirojr.nbv.block.util.Variation;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class WallPlateBlock extends AbstractVariationBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<WallMountLocation> FACE = Properties.WALL_MOUNT_LOCATION;

    public WallPlateBlock(Settings settings, Variation variant) {
        super(settings, variant);
        this.setDefaultState(this.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(FACE, WallMountLocation.WALL)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, FACE);
    }

    @Override
    public Identifier getBaseModel() {
        return NBVMain.getNeMuelchId("block/base_wall_plate");
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = super.getPlacementState(ctx);
        if (state == null) return null;
        Direction direction = ctx.getSide().getOpposite();
        if (direction.getAxis() == Direction.Axis.Y) {
            state = state
                    .with(FACE, direction == Direction.UP ? WallMountLocation.CEILING : WallMountLocation.FLOOR)
                    .with(FACING, ctx.getHorizontalPlayerFacing());
        } else {
            PlayerEntity player = ctx.getPlayer();
            Direction wallDirection = player != null && player.isSneaking() ? ctx.getHorizontalPlayerFacing() : direction;
            state = state
                    .with(FACE, WallMountLocation.WALL)
                    .with(FACING, wallDirection);
        }
        return state;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createRotatedAxisShape(new int[]{0, 4, 0, 16, 12, 1}, state.get(FACING), state.get(FACE));
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(FACING, mirror.apply(state.get(FACING)));
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
