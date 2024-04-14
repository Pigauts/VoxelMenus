package me.pigauts.voxelmenus.core.builder.function;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.core.builder.Builder;
import org.jetbrains.annotations.NotNull;

public abstract class FunctionBuilder extends Builder<Function> {

    protected int repetitions = 0;

    public FunctionBuilder() {}

    public FunctionBuilder(@NotNull Config config) {
        super(config);
        repetitions = config.getInt("repetitions");
    }

    public FunctionBuilder setRepetitions(int repetitions) {
        this.repetitions = repetitions;
        return this;
    }

}
