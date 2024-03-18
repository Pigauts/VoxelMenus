package me.pigauts.voxelmenus.menu.widget.entries;

import me.pigauts.voxelmenus.menu.widget.Entry;

public interface MenuEntries extends Iterable<Entry> {

    Entry get(int index);

    void set(int index, Entry entry);

    void add(Entry entry);

    int size();

    void sort(String type);

}
