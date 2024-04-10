package me.pigauts.voxelmenus.item;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class ItemBuilder {

    private Material type;
    private int amount;

    private String name = " ";
    private List<String> lore = null;
    private boolean enchanted = false;
    private int modelData = -1;

    public ItemBuilder(Material type) {
        this.type = type;
    }

    public ItemBuilder(Material type, int amount) {
        this.type = type;
        this.amount = amount;
    }

//    public ItemBuilder(Config config) {
//        this.type = config.getMaterial("material", Material.DIRT);
//        this.amount = config.getInt("amount", 1);
//
//        if (config.isSet("name")) this.name = config.getString("name");
//        if (config.isSet("lore")) {
//            this.lore = config.getStringList("lore");
//            this.lore.replaceAll(string -> ChatColor.translateAlternateColorCodes('&', string));
//        }
//        this.enchanted = config.getBoolean("enchanted", false);
//        this.modelData = config.getInt("model-data", -1);
//
//    }

    public static ItemStack createPlayerHead(OfflinePlayer player) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setOwningPlayer(player);
        head.setItemMeta(skullMeta);
        return head;
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
