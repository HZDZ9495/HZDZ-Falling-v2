package net.minecraft.hzdzfalling.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

public class FallingChestChangeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double rd = 0;
		rd = Mth.nextInt(new Random(), 1, 5);
		if (rd == 1) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						"/setblock ~ ~ ~ minecraft:chest{LootTable:\"chests/end_city_treasure\"} destroy");
		}
		if (rd == 2) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						"/setblock ~ ~ ~ minecraft:chest{LootTable:\"chests/desert_pyramid\"} destroy");
		}
		if (rd == 3) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						"/setblock ~ ~ ~ minecraft:chest{LootTable:\"chests/simple_dungeon\"} destroy");
		}
		if (rd == 4) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						"/setblock ~ ~ ~ minecraft:chest{LootTable:\"chests/stronghold_library\"} destroy");
		}
		if (rd == 5) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						"/setblock ~ ~ ~ minecraft:chest{LootTable:\"chests/bastion_treasure\"} destroy");
		}
	}
}
