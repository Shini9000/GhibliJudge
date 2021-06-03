package com.shini9000.ghiblijudge.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {
    public Utils() {

    }

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static ItemStack createItem(Inventory inv, String materialString, int amount, int invSlot, String displayName, String... loreString) {
        List<String> lore = new ArrayList();
        ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(chat(displayName));
        String[] var12 = loreString;
        int var11 = loreString.length;

        for(int var10 = 0; var10 < var11; ++var10) {
            String s = var12[var10];
            lore.add(chat(s));
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot, item);
        return item;
    }

    public static ItemStack createItem2(Inventory inv, String materialString, int amount, int invSlot, String displayName, String... loreString) {
        List<String> lore = new ArrayList();
        ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(chat(displayName));
        String[] var12 = loreString;
        int var11 = loreString.length;

        for(int var10 = 0; var10 < var11; ++var10) {
            String s = var12[var10];
            lore.add(chat(s));
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot, item);
        return item;
    }
}