package me.pigauts.voxelmenus.config.factory.menu;

import me.pigauts.voxelmenus.Helper;
import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.function.ClickFunction;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class DynamicMenuFactory extends CustomMenuFactory {

    @Override
    public Menu createMenu(Config config) {

        Map<String, ItemStack> customItems = createCustomItems(config);
        Map<String, ClickFunction> customButtons = createCustomButtons(config);

        ConditionalMap<Contents> contentsByCondition = new ConditionalMap<>();

        for (String key : config.getKeys("layouts", false)) {

            String path = Helper.buildPath("layouts", key);

            Condition condition = config.areSections(path + ".conditions")
                    ? FactoryUtil.createConditionSet(config.getSection(path + ".conditions"))
                    : null;

            Contents contents = new Contents(key,
                    mapLayoutToValues(config.getLayout(path + ".contents"), customItems),
                    mapLayoutToValues(config.getLayout(path + ".buttons"), customButtons));

            contentsByCondition.put(condition, contents);
        }

        return new DynamicMenu(
                createName(config),
                createTitle(config),
                createSize(config),
                createRefresh(config),
                createOpenFunction(config),
                createCloseFunction(config),
                contentsByCondition);
    }

}
