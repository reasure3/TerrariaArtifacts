package com.reasure.terrartifacts.block

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.reasure.terrartifacts.block.properties.HorizontalPart
import com.reasure.terrartifacts.block.properties.ModBlockStateProperties
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.InteractionResult
import net.minecraft.world.MenuProvider
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.EnumProperty
import net.minecraft.world.level.material.MapColor
import net.minecraft.world.level.material.PushReaction
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.Shapes
import net.minecraft.world.phys.shapes.VoxelShape

class TinkerersWorkshopBlock(properties: Properties = Properties.of()) : HorizontalDirectionalBlock(
    properties
        .mapColor(MapColor.COLOR_RED)
        .sound(SoundType.WOOD)
        .strength(2.5f)
        .noOcclusion()
        .pushReaction(PushReaction.IGNORE)
) {
    init {
        registerDefaultState(stateDefinition.any().setValue(PART, HorizontalPart.LEFT))
    }

    override fun codec(): MapCodec<out HorizontalDirectionalBlock> = CODEC

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(FACING, PART)
    }

    // 블록 설치 가능한지 검사
    override fun getStateForPlacement(context: BlockPlaceContext): BlockState? {
        val lookDirection = context.horizontalDirection
        val clickedPos = context.clickedPos
        val otherPartPos = clickedPos.relative(lookDirection.clockWise)
        val level = context.level
        if (level.getBlockState(otherPartPos).canBeReplaced(context)
            && level.worldBorder.isWithinBounds(otherPartPos)
        ) {
            return defaultBlockState().setValue(FACING, lookDirection.opposite)
        }
        return null
    }

    // 한 쪽 부쉈을 때 다른 쪽도 부서지게
    override fun updateShape(
        state: BlockState,
        direction: Direction,
        neighborState: BlockState,
        level: LevelAccessor,
        pos: BlockPos,
        neighborPos: BlockPos
    ): BlockState {
        if (direction == getNeighbourDirection(state.getValue(PART), state.getValue(FACING))) {
            if (!neighborState.isCounterPart(state)) {
                return Blocks.AIR.defaultBlockState()
            }
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos)
    }

    // 크리에이티브 모드에서 블록 부슬 때 아이템 드랍 방지
    override fun playerWillDestroy(level: Level, pos: BlockPos, state: BlockState, player: Player): BlockState {
        if (!level.isClientSide() && player.isCreative) {
            val part = state.getValue(PART)
            if (part == HorizontalPart.RIGHT) {
                val leftPos = pos.relative(getNeighbourDirection(part, state.getValue(FACING)))
                val leftState = level.getBlockState(leftPos)
                if (leftState.isCounterPart(state)) {
                    level.setBlock(leftPos, Blocks.AIR.defaultBlockState(), 35)
                    /**
                     * 왼쪽 블록 부쉈을 때 이벤트 발송
                     * @see net.minecraft.client.renderer.LevelRenderer.levelEvent
                     */
                    level.levelEvent(player, 2001, leftPos, Block.getId(leftState))
                }
            }
        }
        return super.playerWillDestroy(level, pos, state, player)
    }

    private fun getNeighbourDirection(part: HorizontalPart, direction: Direction): Direction {
        return when (part) {
            HorizontalPart.LEFT -> direction.counterClockWise
            HorizontalPart.RIGHT -> direction.clockWise
        }
    }

    private fun BlockState.isCounterPart(state: BlockState): Boolean {
        return this.`is`(this@TinkerersWorkshopBlock)
                && getValue(PART) != state.getValue(PART)
                && getValue(FACING) == state.getValue(FACING)
    }

    override fun getShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape {
        return when (state.getValue(FACING)) {
            Direction.NORTH -> if (state.getValue(PART) == HorizontalPart.LEFT) LEFT_SHAPE else RIGHT_SHAPE
            Direction.SOUTH -> if (state.getValue(PART) == HorizontalPart.LEFT) RIGHT_SHAPE else LEFT_SHAPE
            Direction.WEST -> if (state.getValue(PART) == HorizontalPart.LEFT) CLOCK_LEFT_SHAPE else CLOCK_RIGHT_SHAPE
            Direction.EAST -> if (state.getValue(PART) == HorizontalPart.LEFT) CLOCK_RIGHT_SHAPE else CLOCK_LEFT_SHAPE
            else -> LEFT_SHAPE
        }
    }

    override fun setPlacedBy(level: Level, pos: BlockPos, state: BlockState, placer: LivingEntity?, stack: ItemStack) {
        super.setPlacedBy(level, pos, state, placer, stack)
        if (!level.isClientSide()) {
            val facing = state.getValue(FACING)
            val otherPartPos = pos.relative(facing.counterClockWise)
            level.setBlock(
                otherPartPos, state.setValue(PART, HorizontalPart.RIGHT), 3
            )
            level.blockUpdated(otherPartPos, Blocks.AIR)
            state.updateNeighbourShapes(level, pos, 3)
        }
    }

    override fun useWithoutItem(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        hitResult: BlockHitResult
    ): InteractionResult {
        if (!level.isClientSide()) {
            player.openMenu(state.getMenuProvider(level, pos))
        }
        return InteractionResult.sidedSuccess(level.isClientSide())
    }

    // TODO 조합창 만들기
    override fun getMenuProvider(state: BlockState, level: Level, pos: BlockPos): MenuProvider? {
        return super.getMenuProvider(state, level, pos)
    }

    companion object {
        private val CODEC: MapCodec<TinkerersWorkshopBlock> =
            RecordCodecBuilder.mapCodec { it.group(propertiesCodec()).apply(it, ::TinkerersWorkshopBlock) }

        val PART: EnumProperty<HorizontalPart> = ModBlockStateProperties.HORIZONTAL_PART

        private val LEFT_SHAPE: VoxelShape = Shapes.or(
            box(0.0, 14.0, 1.0, 11.0, 17.0, 15.0), // table
            box(0.0, 1.0, 2.0, 7.0, 14.0, 14.0), // body
            box(7.0, 11.0, 1.0, 9.0, 14.0, 15.0), // hinger
            box(5.0, 0.0, 2.0, 8.0, 1.0, 14.0) // leg
        )
        private val RIGHT_SHAPE: VoxelShape = Shapes.or(
            box(5.0, 14.0, 1.0, 16.0, 17.0, 15.0), // table
            box(9.0, 1.0, 2.0, 16.0, 14.0, 14.0), // body
            box(7.0, 11.0, 1.0, 9.0, 14.0, 15.0), // hinger
            box(8.0, 0.0, 2.0, 11.0, 1.0, 14.0) // leg
        )
        private val CLOCK_LEFT_SHAPE: VoxelShape = Shapes.or(
            box(1.0, 14.0, 5.0, 15.0, 17.0, 16.0), // table
            box(2.0, 1.0, 9.0, 14.0, 14.0, 16.0), // body
            box(1.0, 11.0, 7.0, 15.0, 14.0, 9.0), // hinger
            box(2.0, 0.0, 8.0, 14.0, 1.0, 11.0) // leg
        )
        private val CLOCK_RIGHT_SHAPE: VoxelShape = Shapes.or(
            box(1.0, 14.0, 0.0, 15.0, 17.0, 11.0), // table
            box(2.0, 1.0, 0.0, 14.0, 14.0, 7.0), // body
            box(1.0, 11.0, 7.0, 15.0, 14.0, 9.0), // hinger
            box(2.0, 0.0, 5.0, 14.0, 1.0, 8.0) // leg
        )
    }
}