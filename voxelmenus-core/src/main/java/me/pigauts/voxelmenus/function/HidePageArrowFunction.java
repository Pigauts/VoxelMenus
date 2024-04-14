package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.menu.button.*;
import me.pigauts.voxelmenus.api.menu.view.*;
import me.pigauts.voxelmenus.api.player.*;

public class HidePageArrowFunction implements Function {

    private final TemplateButton nextButton, backButton, disguise;
    private final int[] nextButtons, backButtons;

    public HidePageArrowFunction(TemplateButton nextButton, TemplateButton backButton, TemplateButton disguise, int[] nextArrows, int[] backArrows) {
        this.nextButton = nextButton;
        this.backButton = backButton;
        this.disguise = disguise;
        this.nextButtons = nextArrows;
        this.backButtons = backArrows;
    }

    @Override
    public void run(MenuPlayer player) {
        player.getOpenView(PagedView.class).ifPresent(view -> {
            MenuMeta meta = view.getMenuMeta();

            if (view.getTotalPages() == 1) {
                meta.setButton(disguise, nextButtons);
                meta.setButton(disguise, backButtons);
            } else if (view.isFirstPage()) {
                meta.setButton(disguise, backButtons);
                meta.setButton(nextButton, nextButtons);
            } else if (view.isLastPage()) {
                meta.setButton(disguise, nextButtons);
                meta.setButton(backButton, backButtons);
            } else {
                meta.setButton(disguise, backButtons);
                meta.setButton(disguise, nextButtons);
                meta.setButton(backButton, backButtons);
                meta.setButton(nextButton, nextButtons);
            }
        });
    }

}
