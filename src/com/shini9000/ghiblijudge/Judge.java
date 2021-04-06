package com.shini9000.ghiblijudge;

import org.bukkit.plugin.java.JavaPlugin;

import com.shini9000.ghiblijudge.commands.JudgePanel;
import com.shini9000.ghiblijudge.commands.UserSubmitCommand;
import com.shini9000.ghiblijudge.guis.JudgeGUI;
import com.shini9000.ghiblijudge.guis.SubmitGUI;
import com.shini9000.ghiblijudge.guis.childguis.JudgePlotHistory;
import com.shini9000.ghiblijudge.guis.childguis.JudgePlots;
import com.shini9000.ghiblijudge.guis.childguis.SubmitPlot;
import com.shini9000.ghiblijudge.guis.childguis.UserPlotHistory;

public class Judge extends JavaPlugin {
	public Judge() {
	}
	
	public void onEnable() {
		JudgeGUI.initialize();
		SubmitGUI.initialize();
		JudgePlotHistory.initialize();
		JudgePlots.initialize();
		SubmitPlot.initialize();
		UserPlotHistory.initialize();
		new JudgePanel(this);
		new UserSubmitCommand(this);
		
	}
	
	public void onDisable() {
		
	}

}
