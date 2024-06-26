package me.pigauts.voxelmenus.api.flag;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FlagMap {

    private final Map<String, Flag> flagsByName = new HashMap<>();

    public FlagMap(Collection<Flag> flags) {
        for (Flag flag : flags) {
            if (flag == null) continue;
            flagsByName.put(flag.name(), flag);
        }
    }

    public boolean contains(String name) {
        return flagsByName.containsKey(name);
    }

    public boolean contains(Flag flag) {
        return contains(flag.name());
    }

    public void addFlag(Flag flag) {
        flagsByName.put(flag.name(), flag);
    }

    public void removeFlag(String name) {
        flagsByName.remove(name);
    }

    public void removeFlag(Flag flag) {
        removeFlag(flag.name());
    }

    public Collection<Flag> all() {
        return flagsByName.values();
    }

    public Collection<String> names() {
        return flagsByName.keySet();
    }

    public Flag getFlag(String name) {
        return flagsByName.get(name);
    }

    public int getWeight(String name) {
        Flag flag = getFlag(name);
        return flag == null ? 0 : flag.weight();
    }

}
