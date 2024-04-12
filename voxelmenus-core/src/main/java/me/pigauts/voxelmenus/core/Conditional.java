package me.pigauts.voxelmenus.core;

import me.pigauts.voxelmenus.api.function.Condition;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

/**
 * A conditional wrapper that associates a condition with a result.
 * The result is provided if the associated condition is met for a given player.
 *
 * @param <T> The type of the result.
 */
public class Conditional<T> {

    private final Condition condition;
    private final T result;

    /**
     * Constructs a new Conditional instance with the specified condition and result.
     *
     * @param condition The condition to be evaluated.
     * @param result    The result associated with the condition.
     */
    public Conditional(Condition condition, T result) {
        this.condition = condition;
        this.result = result;
    }

    /**
     * Checks if the condition is met for the specified player.
     *
     * @param player The player to check the condition against.
     * @return {@code true} if the condition is met, otherwise {@code false}.
     */
    public boolean isMet(MenuPlayer player) {
        return condition.isMet(player);
    }

    /**
     * Gets the result associated with this conditional.
     *
     * @return The result.
     */
    public T getResult() {
        return result;
    }

    /**
     * Evaluates the condition for the specified player.
     * Returns the result if the condition is met, otherwise returns null.
     *
     * @param player The player to evaluate the condition against.
     * @return The result if the condition is met, otherwise null.
     */
    public T evaluate(MenuPlayer player) {
        return condition.isMet(player) ? result : null;
    }
}
