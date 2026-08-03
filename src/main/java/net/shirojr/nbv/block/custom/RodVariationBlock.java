package net.shirojr.nbv.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.shirojr.nbv.NBVMain;
import net.shirojr.nbv.block.util.Variation;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class RodVariationBlock extends AbstractVariationBlock {
    public static final DirectionProperty FACING = Properties.FACING;

    private final boolean isKnobbed;

    public RodVariationBlock(Settings settings, Variation variant, boolean isKnobbed) {
        super(settings, variant);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
        this.isKnobbed = isKnobbed;
    }

    @Override
    public Identifier getBaseModel() {
        return NBVMain.getNeMuelchId("block/base%s_rod".formatted(this.isKnobbed ? "_knobbed" : ""));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState placementState = super.getPlacementState(ctx);
        if (placementState == null) return null;
        return placementState.with(FACING, ctx.getSide());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int[][] elements;
        if (this.isKnobbed) {
            elements = new int[][]{
                    {7, 0, 7, 9, 12, 9},
                    {6, 12, 6, 10, 16, 10},
            };
        } else {
            elements = new int[][]{
                    {7, 0, 7, 9, 16, 9}
            };
        }
        VoxelShape result = VoxelShapes.empty();
        for (int[] element : elements) {
            result = VoxelShapes.union(result, createRotatedShape(element, state.get(FACING)));
        }
        return result;
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
