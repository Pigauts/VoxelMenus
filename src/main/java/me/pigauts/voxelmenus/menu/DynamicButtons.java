package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.menu.button.Button;

public record DynamicButtons(Condition condition, Button[] buttons) { }
