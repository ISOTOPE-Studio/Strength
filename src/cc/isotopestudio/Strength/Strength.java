package cc.isotopestudio.Strength;

import java.io.File;
import java.sql.Connection;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cc.isotopestudio.Strength.sql.SqlManager;
import cc.isotopestudio.Strength.sql.MySQL;

public class Strength extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("����ǿ��").append("]").append(ChatColor.RESET).toString();
	public static final String pluginName = "Strength";

	// mySQL
	public static MySQL MySQL;
	public static Connection c;

	public void createFile(String name) {

		File file;
		file = new File(getDataFolder(), name + ".yml");
		if (!file.exists()) {
			saveDefaultConfig();
		}
	}

	@Override
	public void onEnable() {
		getLogger().info("���������ļ���");

		createFile("config");
		if (SqlManager.connectMySQL(this) == false) {
			getLogger().info(pluginName + "�޷�����!");
			getLogger().info(pluginName + "���ݿ��޷����ӣ�");
			this.getPluginLoader().disablePlugin(this);
		}
		PluginManager pm = this.getServer().getPluginManager();
		// pm.registerEvents(new WorldListener(this), this);

		// this.getCommand("LimitedWorld").setExecutor(new ReloadCommand(this));

		getLogger().info(pluginName + "�ɹ�����!");
		getLogger().info(pluginName + "��ISOTOPE Studio����!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info(pluginName + "�ɹ�ж��!");
	}

	public void onReload() {
		this.reloadConfig();
		getLogger().info(pluginName + "�ɹ�����!");
		getLogger().info(pluginName + "��ISOTOPE Studio����!");
	}
}
