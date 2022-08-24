package net.minecraft.hzdzfalling.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.hzdzfalling.network.HzdzFalling2ModVariables;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class TimerProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.world);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double rd = 0;
		if (HzdzFalling2ModVariables.MapVariables.get(world).time == 600) {
			HzdzFalling2ModVariables.MapVariables.get(world).time = 0;
			HzdzFalling2ModVariables.MapVariables.get(world).syncData(world);
			rd = Mth.nextInt(new Random(), 1, 5);
			if (rd == 1) {
				ZombiefallingProcedure.execute(world);
			}
			if (rd == 2) {
				SlimefallingProcedure.execute(world);
			}
			if (rd == 3) {
				SliverfishfallingProcedure.execute(world);
			}
			if (rd == 4) {
				SkeletonfallingProcedure.execute(world);
			}
			if (rd == 5) {
				ChestfallingProcedure.execute(world);
			}
		}
		HzdzFalling2ModVariables.MapVariables.get(world).time = HzdzFalling2ModVariables.MapVariables.get(world).time + 1;
		HzdzFalling2ModVariables.MapVariables.get(world).syncData(world);
	}
}
