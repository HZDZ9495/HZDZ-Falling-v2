package net.minecraft.hzdzfalling.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class SkeletonfallingProcedure {
	public static void execute(LevelAccessor world) {
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				if (entityiterator instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("\u9AB7\u9AC5\u96E8"), (true));
				for (int index0 = 0; index0 < (int) (15); index0++) {
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private LevelAccessor world;

						public void start(LevelAccessor world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performCommand(
										new CommandSourceStack(CommandSource.NULL,
												new Vec3((entityiterator.getX() + Mth.nextDouble(new Random(), -32, 32)),
														(entityiterator.getY() + Mth.nextDouble(new Random(), 16, 32)),
														(entityiterator.getZ() + Mth.nextDouble(new Random(), -32, 32))),
												Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon minecraft:skeleton ~ ~1 ~ {FallDistance:-255}");
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 5);
				}
			}
		}
	}
}
