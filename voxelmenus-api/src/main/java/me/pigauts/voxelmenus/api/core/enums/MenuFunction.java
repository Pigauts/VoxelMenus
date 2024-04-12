package me.pigauts.voxelmenus.api.core.enums;

import java.util.Arrays;
import java.util.List;

public class MenuFunction {

    private MenuFunction() {}

    public static final String OPEN = "on-open";
    public static final String CLOSE = "on-close";
    public static final String UPDATE = "on-update";
    public static final String BACKTRACK = "on-backtrack";
    public static final String PAGE_TURN = "on-page-turn";
    public static final String ATLAS_SCROLL = "on-atlas-scroll";

    private static final List<String> VALUES = Arrays.asList(OPEN, CLOSE, UPDATE, BACKTRACK, PAGE_TURN, ATLAS_SCROLL);

    public static List<String> values() {
        return VALUES;
    }

}
