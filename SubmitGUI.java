package com.shini9000.ghiblijudge.guis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.shini9000.ghiblijudge.guis.childguis.SubmitPlot;
import com.shini9000.ghiblijudge.guis.childguis.UserPlotHistory;
import com.shini9000.ghiblijudge.utils.Utils;

public class SubmitGUI {
	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 9;
	
	public SubmitGUI() {
			
	}
	
	public static void initialize() {
		inventory_name = Utils.chat("&5Submit a plot");
		inv = Bukkit.createInventory((InventoryHolder)null, inv_rows);
		
	}
	
	public static Inventory GUI(Player p) {
		Inventory toReturn = Bukkit.createInventory((InventoryHolder)null, inv_rows, inventory_name);
		Utils.createItem(inv, "WOODEN_AXE", 1, 1, "&6Submit Plot", "&7Submit a plot.");
		Utils.createItem(inv, "END_CRYSTAL", 1, 2, "&6Your history", "&7View the history of your plots.");
		Utils.createItem(inv, "BOOK", 1, 8, "&6Apply", "&7Apply to become a Judge.");
		Utils.createItem(inv, "BARRIER", 1, 9, "&4Close", "&7Close the menu.");
		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if (clicked == null) {
			p.sendMessage(Utils.chat("&7Select and option..."));
			p.openInventory(SubmitGUI.GUI(p));
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Plots"))) {
			p.closeInventory();
			p.openInventory(SubmitPlot.GUI(p));
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Plots history"))) {
		    p.closeInventory();
		    p.openInventory(UserPlotHistory.GUI(p));
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Rankup"))) {
			p.closeInventory();
			p.sendMessage(Utils.chat("&7Apply at > &8EDITLINK"));
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&4Close"))) {
			p.closeInventory();
		}
	}

}
