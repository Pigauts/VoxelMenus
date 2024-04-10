package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.flag.FlagMap;
import me.pigauts.voxelmenus.core.holder.Placeholder;
import me.pigauts.voxelmenus.util.Pair;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuEntry extends Button {

    private final String name;
    private final FlagMap flags;
    private final List<Placeholder> placeholders;

    public MenuEntry(ItemStack icon, Map<ClickType, Function> functions, boolean locked, String name, FlagMap flags, List<Placeholder> placeholders) {
        super(icon, functions, locked);
        this.name = name;
        this.flags = flags;
        this.placeholders = placeholders;
    }

    public static MenuEntry create(Config config) {
        List<Placeholder> placeholders = new ArrayList<>();
        for (Pair<String, String> pair : config.getStringPairList("placeholders")) {
            placeholders.add(new Placeholder(pair.key(), pair.value()));
        }
        return null;
    }

    public void apply(Button button) {
        Material material = getType();
        if (material != Material.AIR) {
            button.setType(material);
        }

        int amount = getAmount();
        if (amount != 0) {
            button.setAmount(amount);
        }

        ItemMeta buttonMeta = button.getItemMeta();
        ItemMeta entryMeta = getItemMeta();

        if (entryMeta.hasDisplayName()) {
            buttonMeta.setDisplayName(entryMeta.getDisplayName());
        }

        if (entryMeta.hasLore()) {
            buttonMeta.setLore(entryMeta.getLore());
        }

        if (entryMeta.hasEnchants()) {
            buttonMeta.getEnchants().putAll(entryMeta.getEnchants());
        }

        if (!entryMeta.getItemFlags().isEmpty()) {
            buttonMeta.getItemFlags().addAll(entryMeta.getItemFlags());
        }

        if (entryMeta.hasCustomModelData()) {
            buttonMeta.setCustomModelData(entryMeta.getCustomModelData());
        }

        if (entryMeta.hasAttributeModifiers()) {
            buttonMeta.getAttributeModifiers().putAll(entryMeta.getAttributeModifiers());
        }
    }

}
