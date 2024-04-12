package me.pigauts.voxelmenus.api.menu.atlas;

import me.pigauts.voxelmenus.api.menu.button.TemplateButton;

public class Atlas extends AtlasWindow {

    private final TemplateButton[][] atlas;

    public Atlas(TemplateButton[][] atlas, int length, int height) {
        super(length, height);
        this.atlas = atlas;
    }

    public TemplateButton[][] getAtlas() {
        return atlas;
    }

    public TemplateButton getButton(int row, int column) {
        return atlas[row][column];
    }

    public TemplateButton[] getButtons(AtlasWindow window) {
        TemplateButton[] buttons = new TemplateButton[window.size()];

        for (int i = 0; i < window.size(); i++) {
            AtlasPos pos = window.getPosition(i);
            buttons[i] = atlas[pos.getX()][pos.getY()];
        }

        return buttons;
    }

    @Override
    public Atlas clone() {
        return new Atlas(atlas.clone(), length(), height());
    }

}
