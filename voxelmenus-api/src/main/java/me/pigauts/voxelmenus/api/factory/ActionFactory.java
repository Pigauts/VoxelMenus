package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.core.ParseUtils;
import me.pigauts.voxelmenus.api.function.Action;

import java.util.List;

@FunctionalInterface
public interface ActionFactory extends ConfigFactory<Action> {

    Action create(Config config);

    default Action create(String value) {
        return null;
    }

    @FunctionalInterface
    interface Def extends ActionFactory {

        @Override
        default Action create(Config config) {
            return create();
        }

        @Override
        default Action create(String value) {
            return create();
        }

        Action create();

    }

    @FunctionalInterface
    interface Bol extends ActionFactory {

        @Override
        default Action create(Config config) {
            return create(config.getBoolean());
        }

        @Override
        default Action create(String value) {
            return create(ParseUtils.parseBoolean(value));
        }

        Action create(boolean value);

    }

    @FunctionalInterface
    interface Int extends ActionFactory {

        @Override
        default Action create(Config config) {
            return create(config.getInt());
        }

        @Override
        default Action create(String value) {
            return create(ParseUtils.parseInteger(value));
        }

        Action create(int value);

    }

    @FunctionalInterface
    interface Str extends ActionFactory {

        @Override
        default Action create(Config config) {
            return create(config.getString());
        }

        Action create(String value);

    }

    @FunctionalInterface
    interface StrList extends ActionFactory {

        @Override
        default Action create(Config config) {
            return create(config.getStringList());
        }

        @Override
        default Action create(String value) {
            return create(ParseUtils.parseStringList(value));
        }

        Action create(List<String> value);

    }

}


