package net.minecraft.hzdzfalling.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class FireballfallingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.2) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getFireball(Level level, double ax, double ay, double az) {
						AbstractHurtingProjectile entityToSpawn = new LargeFireball(EntityType.FIREBALL, level);
						entityToSpawn.xPower = ax;
						entityToSpawn.yPower = ay;
						entityToSpawn.zPower = az;
						return entityToSpawn;
					}
				}.getFireball(projectileLevel, 0, (-1), 0);
				_entityToSpawn.setPos((entity.getX() + Mth.nextDouble(new Random(), -32, 32)), 100,
						(entity.getZ() + Mth.nextDouble(new Random(), -32, 32)));
				_entityToSpawn.shoot(0, (-1), 0, 2, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getFireball(Level level, double ax, double ay, double az) {
						AbstractHurtingProjectile entityToSpawn = new WitherSkull(EntityType.WITHER_SKULL, level);
						entityToSpawn.xPower = ax;
						entityToSpawn.yPower = ay;
						entityToSpawn.zPower = az;
						return entityToSpawn;
					}
				}.getFireball(projectileLevel, 0, (-1), 0);
				_entityToSpawn.setPos((entity.getX() + Mth.nextDouble(new Random(), -32, 32)), 100,
						(entity.getZ() + Mth.nextDouble(new Random(), -32, 32)));
				_entityToSpawn.shoot(0, (-1), 0, 2, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getFireball(Level level, double ax, double ay, double az) {
						AbstractHurtingProjectile entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, level);
						entityToSpawn.xPower = ax;
						entityToSpawn.yPower = ay;
						entityToSpawn.zPower = az;
						return entityToSpawn;
					}
				}.getFireball(projectileLevel, 0, (-1), 0);
				_entityToSpawn.setPos((entity.getX() + Mth.nextDouble(new Random(), -32, 32)), 100,
						(entity.getZ() + Mth.nextDouble(new Random(), -32, 32)));
				_entityToSpawn.shoot(0, (-1), 0, 2, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback) {
						AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, 5, 1);
				_entityToSpawn.setPos((entity.getX() + Mth.nextDouble(new Random(), -32, 32)), 100,
						(entity.getZ() + Mth.nextDouble(new Random(), -32, 32)));
				_entityToSpawn.shoot(0, (-1), 0, 2, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
