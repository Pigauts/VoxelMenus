package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.core.ParseUtils;
import me.pigauts.voxelmenus.api.function.Condition;

@FunctionalInterface
public interface ConditionFactory extends ConfigFactory<Condition> {

    Condition create(Config config);

    default Condition create(java.lang.String value) {
        return null;
    }

    @FunctionalInterface
    interface Str extends ConditionFactory {

        @Override
        default Condition create(Config config) {
            return create(config.getString());
        }

        Condition create(String value);

    }

    @FunctionalInterface
    interface Int extends ConditionFactory {

        @Override
        default Condition create(Config config) {
            return create(config.getInt());
        }

        @Override
        default Condition create(String value) {
            return create(ParseUtils.parseInteger(value));
        }

        Condition create(int value);

    }

}
