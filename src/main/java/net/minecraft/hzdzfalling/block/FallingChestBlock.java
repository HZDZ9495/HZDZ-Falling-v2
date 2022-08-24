
package net.minecraft.hzdzfalling.block;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.hzdzfalling.procedures.FallingChestChangeProcedure;
import net.minecraft.hzdzfalling.init.HzdzFalling2ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import java.util.Random;

public class FallingChestBlock extends Block {
	public FallingChestBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false).noDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		FallingChestChangeProcedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 20);
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(HzdzFalling2ModBlocks.FALLING_CHEST.get(), renderType -> renderType == RenderType.cutout());
	}
}
