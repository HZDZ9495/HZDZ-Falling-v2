package net.minecraft.hzdzfalling.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.hzdzfalling.init.HzdzFalling2ModBlocks;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ChestfallingProcedure {
	public static void execute(LevelAccessor world) {
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				if (entityiterator instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("\u5956\u52B1\u7BB1\uFF01"), (true));
				if (world instanceof ServerLevel _level)
					FallingBlockEntity.fall(_level,
							new BlockPos(entityiterator.getX() + Mth.nextDouble(new Random(), -32, 32),
									entityiterator.getY() + Mth.nextDouble(new Random(), 16, 32),
									entityiterator.getZ() + Mth.nextDouble(new Random(), -32, 32)),
							HzdzFalling2ModBlocks.FALLING_CHEST.get().defaultBlockState());
			}
		}
	}
}
