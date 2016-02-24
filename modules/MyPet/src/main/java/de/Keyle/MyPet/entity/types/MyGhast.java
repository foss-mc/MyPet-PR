/*
 * This file is part of mypet
 *
 * Copyright (C) 2011-2016 Keyle
 * mypet is licensed under the GNU Lesser General Public License.
 *
 * mypet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mypet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.entity.types;

import de.Keyle.MyPet.api.entity.DefaultInfo;
import de.Keyle.MyPet.api.entity.MyPetType;
import de.Keyle.MyPet.api.player.MyPetPlayer;
import de.Keyle.MyPet.entity.MyPet;
import org.bukkit.ChatColor;

import static de.Keyle.MyPet.api.entity.LeashFlag.Impossible;
import static org.bukkit.Material.SULPHUR;

@DefaultInfo(food = {SULPHUR}, leashFlags = {Impossible})
public class MyGhast extends MyPet implements de.Keyle.MyPet.api.entity.types.MyGhast {
    public MyGhast(MyPetPlayer petOwner) {
        super(petOwner);
    }

    public double getYSpawnOffset() {
        return 4;
    }

    @Override
    public MyPetType getPetType() {
        return MyPetType.Ghast;
    }

    @Override
    public String toString() {
        return "MyGhast{owner=" + getOwner().getName() + ", name=" + ChatColor.stripColor(petName) + ", exp=" + experience.getExp() + "/" + experience.getRequiredExp() + ", lv=" + experience.getLevel() + ", status=" + status.name() + ", skilltree=" + (skillTree != null ? skillTree.getName() : "-") + ", worldgroup=" + worldGroup + "}";
    }
}