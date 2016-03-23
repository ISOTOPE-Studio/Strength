package cc.isotopestudio.Strength.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.isotopestudio.Strength.Strength;

public class CommandStrength implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("quest")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(
						new StringBuilder(Strength.prefix).append(ChatColor.RED).append("必须要玩家才能执行").toString());
				return true;
			}
			Player player = (Player) sender;
			if (args.length > 0 && !args[0].equalsIgnoreCase("help")) {
				return true;
			} else {
				player.sendMessage(
						new StringBuilder(Strength.prefix).append(ChatColor.GREEN).append("帮助菜单").toString());
				sender.sendMessage(
						new StringBuilder().append(ChatColor.GREEN).append("/renwu accept 开始每日任务").toString());
				sender.sendMessage(
						new StringBuilder().append(ChatColor.GREEN).append("/renwu info 查看你的任务信息").toString());
				sender.sendMessage(
						new StringBuilder().append(ChatColor.GREEN).append("/renwu today 查看今日任务信息").toString());
				return true;
			}
		}
		return false;
	}
}
