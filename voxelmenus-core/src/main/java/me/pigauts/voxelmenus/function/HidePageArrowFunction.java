package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.view.PagedView;
import me.pigauts.voxelmenus.api.menu.MenuMeta;
import me.pigauts.voxelmenus.menu.widget.Button;

public class HidePageArrowFunction implements Function {

    private final Button nextButton, backButton, disguise;
    private final int[] nextButtons, backButtons;

    public HidePageArrowFunction(Button nextButton, Button backButton, Button disguise, int[] nextArrows, int[] backArrows) {
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
