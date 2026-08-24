package net.shirojr.nbv.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.shirojr.nbv.block.util.Variation;
import net.shirojr.nbv.block.util.VariationHolder;
import net.shirojr.nbv.init.NBVTags;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public abstract class AbstractVariationBlock extends Block implements VariationHolder, Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    protected final Variation variant;

    public AbstractVariationBlock(Settings settings, Variation variant) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
        this.variant = variant;
    }

    @Override
    public Block getBlock() {
        return this;
    }

    @Override
    public Variation getVariant() {
        return this.variant;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        if (state.isIn(NBVTags.Blocks.BARRIER_RENDERING)) {
            return BlockRenderType.INVISIBLE;
        }
        return super.getRenderType(state);
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        if (state.isIn(NBVTags.Blocks.BARRIER_RENDERING)) return true;
        return super.isTransparent(state, world, pos);
    }

    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        if (state.isIn(NBVTags.Blocks.BARRIER_RENDERING)) {
            return 1.0f;
        }
        return super.getAmbientOcclusionLightLevel(state, world, pos);
    }

    protected VoxelShape createCardinalRotatedShape(int[] points, Direction direction, BlockHalf half) {
        int verticalOffset = half == BlockHalf.TOP ? 8 : 0;
        return switch (direction) {
            case NORTH -> createCuboidShape(
                    points[0], points[1] + verticalOffset, points[2],
                    points[3], points[4] + verticalOffset, points[5]
            );
            case SOUTH -> createCuboidShape(
                    16 - points[3], points[1] + verticalOffset, 16 - points[5],
                    16 - points[0], points[4] + verticalOffset, 16 - points[2]
            );
            case WEST -> createCuboidShape(
                    points[2], points[1] + verticalOffset, 16 - points[3],
                    points[5], points[4] + verticalOffset, 16 - points[0]
            );
            case EAST -> createCuboidShape(
                    16 - points[5], points[1] + verticalOffset, points[0],
                    16 - points[2], points[4] + verticalOffset, points[3]
            );
            default -> VoxelShapes.fullCube();
        };
    }

    protected VoxelShape createRotatedAxisShape(int[] points, Direction direction) {
        return switch (direction) {
            case NORTH -> createCuboidShape(
                    points[0], points[1], points[2],
                    points[3], points[4], points[5]
            );
            case SOUTH -> createCuboidShape(
                    16 - points[3], points[1], 16 - points[5],
                    16 - points[0], points[4], 16 - points[2]
            );
            case WEST -> createCuboidShape(
                    points[2], points[1], 16 - points[3],
                    points[5], points[4], 16 - points[0]
            );
            case EAST -> createCuboidShape(
                    16 - points[5], points[1], points[0],
                    16 - points[2], points[4], points[3]
            );
            case DOWN -> createCuboidShape(
                    points[0], points[2], points[1],
                    points[3], points[5], points[4]
            ); // Y<->Z swap
            case UP -> createCuboidShape(points[0], 16 - points[5], 16 - points[4],
                    points[3], 16 - points[2], 16 - points[1]
            ); // Y<->Z swap + flip Y&Z
        };
    }

    protected VoxelShape createRotatedAxisShape(int[] points, Direction direction, WallMountLocation wallMountLocation) {
        int[] mountingRotatedPoints = switch (wallMountLocation) {
            case WALL -> points;
            case FLOOR -> toFloorOrCeilingPoints(points, false);
            case CEILING -> toFloorOrCeilingPoints(points, true);
        };

        return switch (direction) {
            case NORTH -> createCuboidShape(
                    mountingRotatedPoints[0], mountingRotatedPoints[1], mountingRotatedPoints[2],
                    mountingRotatedPoints[3], mountingRotatedPoints[4], mountingRotatedPoints[5]
            );
            case SOUTH -> createCuboidShape(
                    16 - mountingRotatedPoints[3], mountingRotatedPoints[1], 16 - mountingRotatedPoints[5],
                    16 - mountingRotatedPoints[0], mountingRotatedPoints[4], 16 - mountingRotatedPoints[2]
            );
            case WEST -> createCuboidShape(
                    mountingRotatedPoints[2], mountingRotatedPoints[1], 16 - mountingRotatedPoints[3],
                    mountingRotatedPoints[5], mountingRotatedPoints[4], 16 - mountingRotatedPoints[0]
            );
            case EAST -> createCuboidShape(
                    16 - mountingRotatedPoints[5], mountingRotatedPoints[1], mountingRotatedPoints[0],
                    16 - mountingRotatedPoints[2], mountingRotatedPoints[4], mountingRotatedPoints[3]
            );
            default -> throw new IllegalStateException("WallPlateBlock FACING must be horizontal, got " + direction);
        };
    }

    private int[] toFloorOrCeilingPoints(int[] points, boolean ceiling) {
        int thickness = points[5] - points[2];
        int yMin = ceiling ? 16 - thickness : 0;
        int yMax = ceiling ? 16 : thickness;
        return new int[]{points[0], yMin, points[1], points[3], yMax, points[4]};
    }

    protected VoxelShape createRotatedShape(int[] points, Direction direction) {
        return switch (direction) {
            case DOWN -> createCuboidShape(
                    points[0], 16 - points[4], points[2],
                    points[3], 16 - points[1], points[5]
            );
            case UP -> createCuboidShape(
                    points[0], points[1], points[2],
                    points[3], points[4], points[5]
            );
            case SOUTH -> createCuboidShape(
                    points[0], points[2], points[1],
                    points[3], points[5], points[4]
            );
            case NORTH -> createCuboidShape(
                    points[0], points[2], 16 - points[4],
                    points[3], points[5], 16 - points[1]
            );
            case WEST -> createCuboidShape(
                    16 - points[4], points[0], points[2],
                    16 - points[1], points[3], points[5]
            );
            case EAST -> createCuboidShape(
                    points[1], points[0], points[2],
                    points[4], points[3], points[5]
            );
        };
    }

    protected VoxelShape createRotatedAxisShape(int[] points, Direction.Axis axis) {
        return switch (axis) {
            case X -> createCuboidShape(points[1], points[0], points[2], points[4], points[3], points[5]); // swap X<->Y
            case Z -> createCuboidShape(points[0], points[2], points[1], points[3], points[5], points[4]); // swap Y<->Z
            default ->
                    createCuboidShape(points[0], points[1], points[2], points[3], points[4], points[5]); // Y-axis (no swap)
        };
    }
}

