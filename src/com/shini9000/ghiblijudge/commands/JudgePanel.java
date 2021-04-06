package com.shini9000.ghiblijudge.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.shini9000.ghiblijudge.Judge;
import com.shini9000.ghiblijudge.guis.JudgeGUI;
import com.shini9000.ghiblijudge.utils.Utils;

public class JudgePanel implements CommandExecutor {
    @SuppressWarnings("unused")
	private Judge plugin;

    public JudgePanel(Judge plugin) {
        this.plugin = plugin;
        plugin.getCommand("Judge").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat("* You are unable to use this command!"));
            return true;
        } else {
            Player p = (Player)sender;
            if (p.hasPermission("ghiblijudge.judge")) {
            	p.openInventory(JudgeGUI.GUI(p));
                return true;
            } else {
                p.sendMessage(Utils.chat("&cYou lack permission!"));
            }

            return true;
        }
    }
}