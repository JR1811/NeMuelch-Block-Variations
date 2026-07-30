package net.shirojr.nbv.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.shirojr.nbv.NBVMain;
import net.shirojr.nbv.block.util.Variation;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.function.Function;

@SuppressWarnings("deprecation")
public class VerticalStairBlock extends AbstractVariationBlock {
    public static final EnumProperty<Corner> CORNER = EnumProperty.of("corner", Corner.class);
    public static final Function<Corner, VoxelShape> SHAPES = Util.memoize(corner ->
            VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(), corner.getCutout(), BooleanBiFunction.ONLY_FIRST)
    );

    public VerticalStairBlock(Settings settings, Variation variant) {
        super(settings, variant);
        this.setDefaultState(this.getDefaultState().with(CORNER, Corner.NORTH_WEST));
    }

    @Override
    public Identifier getBaseModel() {
        return NBVMain.getNeMuelchId("block/base_vertical_stair");
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(CORNER);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState placementState = super.getPlacementState(ctx);
        if (placementState == null) return null;
        Direction side = ctx.getSide();
        Vec3d hitPos = ctx.getHitPos();
        double x = (int) hitPos.getX() - hitPos.getX();
        if (x < 0) x = 1 - Math.abs(x);
        double z = (int) hitPos.getZ() - hitPos.getZ();
        if (z < 0) z = 1 - Math.abs(z);

        return placementState.with(CORNER, Corner.determineCorner(side, x, z));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES.apply(state.get(CORNER));
    }

    public enum Corner implements StringIdentifiable {
        NORTH_WEST(Block.createCuboidShape(8, 0, 8, 16, 16, 16)),
        NORTH_EAST(Block.createCuboidShape(0, 0, 8,  8, 16, 16)),
        SOUTH_EAST(Block.createCuboidShape(0, 0, 0,  8, 16,  8)),
        SOUTH_WEST(Block.createCuboidShape(8, 0, 0, 16, 16,  8));

        private final VoxelShape cutout;

        Corner(VoxelShape cutout) {
            this.cutout = cutout;
        }

        @Override
        public String asString() {
            return this.name().toLowerCase(Locale.ROOT);
        }

        public VoxelShape getCutout() {
            return cutout;
        }

        public static Corner determineCorner(Direction side, double x, double z) {
            boolean isLowerX = x < 0.5;
            boolean isLowerZ = z < 0.5;

            return switch (side) {
                case UP, DOWN -> {
                    if (isLowerX && isLowerZ) yield SOUTH_EAST;
                    if (isLowerX) yield NORTH_EAST;
                    if (isLowerZ) yield SOUTH_WEST;
                    yield NORTH_WEST;
                }
                case NORTH -> isLowerX ? SOUTH_EAST : SOUTH_WEST;
                case EAST -> isLowerZ ? SOUTH_WEST : NORTH_WEST;
                case SOUTH -> isLowerX ? NORTH_EAST : NORTH_WEST;
                case WEST -> isLowerZ ? SOUTH_EAST : NORTH_EAST;
            };
        }
    }
}
