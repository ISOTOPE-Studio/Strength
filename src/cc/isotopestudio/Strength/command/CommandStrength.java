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
						new StringBuilder(Strength.prefix).append(ChatColor.RED).append("����Ҫ��Ҳ���ִ��").toString());
				return true;
			}
			Player player = (Player) sender;
			if (args.length > 0 && !args[0].equalsIgnoreCase("help")) {
				return true;
			} else {
				player.sendMessage(
						new StringBuilder(Strength.prefix).append(ChatColor.GREEN).append("�����˵�").toString());
				sender.sendMessage(
						new StringBuilder().append(ChatColor.GREEN).append("/renwu accept ��ʼÿ������").toString());
				sender.sendMessage(
						new StringBuilder().append(ChatColor.GREEN).append("/renwu info �鿴���������Ϣ").toString());
				sender.sendMessage(
						new StringBuilder().append(ChatColor.GREEN).append("/renwu today �鿴����������Ϣ").toString());
				return true;
			}
		}
		return false;
	}
}
