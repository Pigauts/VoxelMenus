package me.pigauts.voxelmenus.menu.widget.entries;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.menu.widget.Entry;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomEntries implements MenuEntries {

    private final List<Entry> entries;

    public CustomEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public static MenuEntries fromConfig(Config config) {
        if (config == null) return null;

        List<Entry> entries = new ArrayList<>();
        for (Config section : config.getSections("entries")) {
            Entry entry = Entry.fromConfig(section);
            if (entry != null) {
                entries.add(entry);
            }
        }

        return new CustomEntries(entries);
    }

    @Override
    public Entry get(int index) {
        if (index < 0 || index >= entries.size()) return null;
        return entries.get(index);
    }

    @Override
    public void set(int index, Entry entry) {

    }

    @Override
    public void add(Entry entry) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void sort(String type) {

    }

    @NotNull
    @Override
    public Iterator<Entry> iterator() {
        return entries.iterator();
    }
}
