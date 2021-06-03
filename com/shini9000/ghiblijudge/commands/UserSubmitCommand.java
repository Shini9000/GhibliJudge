package com.shini9000.ghiblijudge.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.shini9000.ghiblijudge.Judge;
import com.shini9000.ghiblijudge.guis.SubmitGUI;

public class UserSubmitCommand implements CommandExecutor {
    @SuppressWarnings("unused")
	private Judge plugin;

    public UserSubmitCommand(Judge plugin) {
        this.plugin = plugin;
        plugin.getCommand("Submit").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        p.openInventory(SubmitGUI.GUI(p));
        return true;
    }
}