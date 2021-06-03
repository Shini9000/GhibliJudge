package com.shini9000.ghiblijudge.guis.childguis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.shini9000.ghiblijudge.utils.Utils;

import java.util.Objects;

public class SubmitPlot {
	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 9;
	
	public SubmitPlot() {
			
	}
	
	public static void initialize() {
		inventory_name = Utils.chat("&dSubmit a plot");
		inv = Bukkit.createInventory((InventoryHolder)null, inv_rows);
		
	}
	
	public static Inventory GUI(Player p) {
		Inventory toReturn = Bukkit.createInventory((InventoryHolder)null, inv_rows, inventory_name);
		Utils.createItem(inv, "DIAMOND", 1, 1, "&6Plot name", "&7Name your plot");
		Utils.createItem(inv, "DIAMOND", 1, 2, "&6Plot Description", "&7Give a description");
		Utils.createItem(inv, "DIAMOND", 1, 3, "&6Notes", "&7Check notes");
		Utils.createItem(inv, "DIAMOND", 1, 4, "&6Status", "Accepted/Rejected");
		Utils.createItem(inv, "BARRIER", 1, 9, "&4Close", "&7Close the menu.");
		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if (clicked == null) {
			p.sendMessage(Utils.chat("&7Select and option..."));
			p.openInventory(SubmitPlot.GUI(p));
		} else if (Objects.requireNonNull(clicked.getItemMeta()).getDisplayName().equals(Utils.chat("&6Plot name"))) {
			p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Plot Description"))) {
		    p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Notes"))) {
			p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&6Status"))) {
			p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&4Close"))) {
			p.closeInventory();
		}
	}

}