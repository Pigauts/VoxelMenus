package me.pigauts.voxelmenus.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Flags {

    private final Map<String, Flag> flagsByName = new HashMap<>();

    public Flags(Collection<Flag> flags) {
        for (Flag flag : flags) {
            if (flag == null) continue;
            flagsByName.put(flag.name(), flag);
        }
    }

    public Collection<Flag> all() {
        return flagsByName.values();
    }

    public Flag getFlag(String name) {
        return flagsByName.get(name);
    }

    public int getWeight(String name) {
        Flag flag = getFlag(name);
        return flag == null ? 0 : flag.weight();
    }

}
