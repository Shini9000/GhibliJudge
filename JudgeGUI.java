package com.shini9000.ghiblijudge.guis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.shini9000.ghiblijudge.guis.childguis.JudgePlotHistory;
import com.shini9000.ghiblijudge.guis.childguis.JudgePlots;
import com.shini9000.ghiblijudge.utils.Utils;

public class JudgeGUI {
	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 9;
	
	public JudgeGUI() {
			
	}
	
	public static void initialize() {
		inventory_name = Utils.chat("&dJudge Panel");
		inv = Bukkit.createInventory((InventoryHolder)null, inv_rows);
		
	}
	
	public static Inventory GUI(Player p) {
		Inventory toReturn = Bukkit.createInventory((InventoryHolder)null, inv_rows, inventory_name);
		Utils.createItem(inv, "WOODEN_AXE", 1, 1, "&6Plots", "&7View the currently available plots.");
		Utils.createItem(inv, "END_CRYSTAL", 1, 2, "&6Plots history", "&7View the history of all plots.");
		Utils.createItem(inv, "DIAMOND_BLOCK", 1, 7, "&6Rankup", "&7HeadJudge randup.");
		Utils.createItem(inv, "DIRT_BLOCK", 1, 8, "&6Rankdown", "&7HeadJudge rankdown.");
		Utils.createItem(inv, "BARRIER", 1, 9, "&4Close", "&7Close the menu.");
		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if (clicked == null) {
			p.sendMessage(Utils.chat("&7Select and option..."));
			p.openInventory(JudgeGUI.GUI(p));
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Plots"))) {
			p.closeInventory();
			p.openInventory(JudgePlots.GUI(p));
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Plots history"))) {
		    p.closeInventory();
		    p.openInventory(JudgePlotHistory.GUI(p));
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Rankup"))) {
			p.closeInventory();
			//Luckperms thing
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Rankdown"))) {
			p.closeInventory();
			//Luckperms thing
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&4Close"))) {
			p.closeInventory();
		}
	}

}
