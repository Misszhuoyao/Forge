/*
 * Minecraft Forge
 * Copyright (c) 2016.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.fml.common;

import java.util.List;
import java.util.Set;

import net.minecraftforge.fml.common.functions.ModNameFunction;
import net.minecraftforge.fml.common.versioning.ArtifactVersion;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.annotations.SerializedName;

/**
 * @author cpw
 *
 */
public class ModMetadata
{
    @SerializedName("modid")
    public String modId;
    public String name;
    public String description = "";

    public String url = "";
    @Deprecated //Never really used for anything and format is undefined. See updateJSON for replacement.
    public String updateUrl = "";
    /**
     * URL to update json file. Format is defined here: https://gist.github.com/LexManos/7aacb9aa991330523884
     */
    public String updateJSON = "";

    public String logoFile = "";
    public String version = "";
    public List<String> authorList = Lists.newArrayList();
    public String credits = "";
    public String parent = "";
    public String[] screenshots;

    // this field is not for use in the json
    public transient ModContainer parentMod;
    // this field is not for use in the json
    public transient List<ModContainer> childMods = Lists.newArrayList();

    public boolean useDependencyInformation;
    public Set<ArtifactVersion> requiredMods = Sets.newHashSet();
    public List<ArtifactVersion> dependencies = Lists.newArrayList();
    public List<ArtifactVersion> dependants = Lists.newArrayList();
    // this field is not for use in the json
    public transient boolean autogenerated;

    public ModMetadata()
    {
    }

    public String getChildModCountString()
    {
        return String.format("%d child mod%s", childMods.size(), childMods.size() != 1 ? "s" : "");
    }

    public String getAuthorList()
    {
        return Joiner.on(", ").join(authorList);
    }

    public String getChildModList()
    {
        return Joiner.on(", ").join(Lists.transform(childMods, new ModNameFunction()));
    }

    public String printableSortingRules()
    {
        return "";
    }
}
