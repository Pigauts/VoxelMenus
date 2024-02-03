package me.pigauts.voxelmenus.item;

import me.pigauts.voxelmenus.config.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    private Material type;
    private int amount;

    private String name = " ";
    private List<String> lore = null;
    private boolean enchanted = false;
    private int modelData = -1;

    public ItemBuilder(Config config) {
        this.type = config.getMaterial("material", Material.DIRT);
        this.amount = config.getInt("amount", 1);

        if (config.isSet("name")) this.name = config.getColorString("name");
        if (config.isSet("lore")) {
            this.lore = config.getStringList("lore");
            this.lore.replaceAll(string -> ChatColor.translateAlternateColorCodes('&', string));
        }
        this.enchanted = config.getBoolean("enchanted", false);
        this.modelData = config.getInt("model-data", -1);

    }

    public ItemStack build() {
        ItemStack item = new ItemStack(type, amount);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);
        if (modelData != -1) meta.setCustomModelData(modelData);
        if (enchanted) {
            meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }

}
