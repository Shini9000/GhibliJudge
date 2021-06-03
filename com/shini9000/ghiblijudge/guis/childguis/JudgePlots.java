package com.shini9000.ghiblijudge.guis.childguis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.shini9000.ghiblijudge.utils.Utils;

import java.util.Objects;

public class JudgePlots {
	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 54;
	
	public JudgePlots() {
			
	}
	
	public static void initialize() {
		inventory_name = Utils.chat("&1Plots");
		inv = Bukkit.createInventory(null, inv_rows);
		
	}
	
	public static Inventory GUI(Player p) {
		Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);
		//(PLOTS... I think these would need to be filled with items automatically... from the plots system... but im sure
		//involves SQL database to get the info needed... 
		//player does command > saves to database > database writes to here)
		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if (clicked == null) {
			p.sendMessage(Utils.chat("&7Select and option..."));
			p.openInventory(JudgePlots.GUI(p));
		} else if (Objects.requireNonNull(clicked.getItemMeta()).getDisplayName().equals(Utils.chat("&61"))) {
			p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&62"))) {
		    p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&63"))) {
			p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&64"))) {
			p.closeInventory();
		} else if (clicked.getItemMeta().getDisplayName().equals(Utils.chat("&65"))) {
			p.closeInventory();
		}
	}

}
