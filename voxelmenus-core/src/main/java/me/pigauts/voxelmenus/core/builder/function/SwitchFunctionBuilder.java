package me.pigauts.voxelmenus.core.builder.function;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.factory.ConditionFactory;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.function.Condition;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.function.SwitchCase;
import me.pigauts.voxelmenus.function.action.ActionSet;
import me.pigauts.voxelmenus.util.FactoryUtil;
import me.pigauts.voxelmenus.util.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static me.pigauts.voxelmenus.util.Utils.pathOf;

public class SwitchFunctionBuilder extends FunctionBuilder {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    private final List<SwitchCase> switchCases = new ArrayList<>();

    public SwitchFunctionBuilder() {}

    public SwitchFunctionBuilder(@NotNull Config config) {
        super(config);
        ConditionFactory switchCondition = plugin.getConditionFactory(config.getString("switch"));
        if (switchCondition == null) return;

        for (String key : config.getKeys(false)) {
            if (Utils.isEqual(key, "switch", "default")) continue;

            SwitchCase switchCase = createSwitchCase(config, key, switchCondition);
            if (switchCase == null) continue;

            switchCases.add(switchCase);
        }

        SwitchCase defaultCase = createSwitchCase(config, "default", switchCondition);
        switchCases.add(defaultCase != null ? defaultCase : SwitchCase.DEFAULT_BREAK);

    }

    public static SwitchCase createSwitchCase(Config config, String switchCase, ConditionFactory switchCondition) {
        String value = Utils.getStringSplitAt(switchCase, "=", 1);
        if (value == null) return null;

        Condition condition = switchCondition.create(value);
        if (condition == null) return null;

        Action action = ActionSet.of(config.getList(FactoryUtil::createAction, switchCase));
        boolean breakCycle = config.getBoolean(pathOf(switchCase, "break"), true);

        return new SwitchCase(condition, action, breakCycle);
    }


    @Override
    public Function build() {
        return null;
    }

}
