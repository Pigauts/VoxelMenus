package me.pigauts.voxelmenus.menu.widget.entries;

import me.pigauts.voxelmenus.menu.widget.Entry;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class MaterialEntries implements MenuEntries {

    public static final MaterialEntries DEFAULT_ENTRIES = new MaterialEntries();

    @Override
    public Entry get(int index) {
        return null;
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
        return null;
    }
}
