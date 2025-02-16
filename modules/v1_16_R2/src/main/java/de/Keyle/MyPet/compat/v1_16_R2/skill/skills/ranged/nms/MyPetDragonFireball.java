/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2020 Keyle
 * MyPet is licensed under the GNU Lesser General Public License.
 *
 * MyPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.compat.v1_16_R2.skill.skills.ranged.nms;

import de.Keyle.MyPet.api.entity.skill.ranged.EntityMyPetProjectile;
import de.Keyle.MyPet.api.util.Compat;
import de.Keyle.MyPet.compat.v1_16_R2.entity.EntityMyPet;
import de.Keyle.MyPet.compat.v1_16_R2.skill.skills.ranged.bukkit.CraftMyPetDragonFireball;
import net.minecraft.server.v1_16_R2.*;

@Compat("v1_16_R2")
public class MyPetDragonFireball extends EntityDragonFireball implements EntityMyPetProjectile {

    protected float damage = 0;
    protected int deathCounter = 100;
    protected CraftMyPetDragonFireball bukkitEntity = null;

    public MyPetDragonFireball(World world, EntityMyPet entityliving, double d0, double d1, double d2) {
        super(world, entityliving, d0, d1, d2);
    }

    @Override
    public EntityMyPet getShooter() {
        return (EntityMyPet) super.getShooter();
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    @Override
    public void setDirection(double d0, double d1, double d2) {
        d0 += this.random.nextGaussian() * 0.2D;
        d1 += this.random.nextGaussian() * 0.2D;
        d2 += this.random.nextGaussian() * 0.2D;
        double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
        this.dirX = (d0 / d3 * 0.1D);
        this.dirY = (d1 / d3 * 0.1D);
        this.dirZ = (d2 / d3 * 0.1D);
    }

    @Override
    public CraftMyPetDragonFireball getBukkitEntity() {
        if (this.bukkitEntity == null) {
            this.bukkitEntity = new CraftMyPetDragonFireball(this.world.getServer(), this);
        }
        return this.bukkitEntity;
    }

    @Override
    public void saveData(NBTTagCompound nbtTagCompound) {
    }

    @Override
    public void loadData(NBTTagCompound nbtTagCompound) {
    }

    @Override
    protected void a(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition.getType() == MovingObjectPosition.EnumMovingObjectType.ENTITY) {
            Entity entity = ((MovingObjectPositionEntity) movingObjectPosition).getEntity();
            if (entity instanceof EntityLiving) {
                entity.damageEntity(DamageSource.projectile(this, getShooter()), damage);
            }
        }

        die();
    }

    @Override
    public void tick() {
        try {
            super.tick();
            if (deathCounter-- <= 0) {
                die();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}