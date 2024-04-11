package me.pigauts.voxelmenus.api.core.placeholder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PlaceholderMap implements Iterable<Placeholder> {

    private final Map<String, Placeholder> placeholders = new HashMap<>();

    public String get(String id) {
        return placeholders.get(id).toString();
    }

    public Placeholder getPlaceholder(String id) {
        return new Placeholder(id, get(id));
    }

    public void add(Placeholder placeholder) {
        placeholders.put(placeholder.id(), placeholder);
    }

    public void add(String id, Object value) {
        placeholders.put(id, new Placeholder(id, value));
    }

    public void remove(String id) {
        placeholders.remove(id);
    }

    public void clear() {
        placeholders.clear();
    }

    public boolean hasPlaceholder(String id) {
        return placeholders.containsKey(id);
    }

    @Override
    public Iterator<Placeholder> iterator() {
        return placeholders.values().iterator();
    }

}
