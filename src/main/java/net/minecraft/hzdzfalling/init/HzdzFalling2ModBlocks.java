
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.minecraft.hzdzfalling.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.hzdzfalling.block.FallingChestBlock;
import net.minecraft.hzdzfalling.HzdzFalling2Mod;

public class HzdzFalling2ModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, HzdzFalling2Mod.MODID);
	public static final RegistryObject<Block> FALLING_CHEST = REGISTRY.register("falling_chest", () -> new FallingChestBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			FallingChestBlock.registerRenderLayer();
		}
	}
}
