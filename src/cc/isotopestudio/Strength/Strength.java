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
			.append("体质强化").append("]").append(ChatColor.RESET).toString();
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
		getLogger().info("加载配置文件中");

		createFile("config");
		if (SqlManager.connectMySQL(this) == false) {
			getLogger().info(pluginName + "无法加载!");
			getLogger().info(pluginName + "数据库无法连接！");
			this.getPluginLoader().disablePlugin(this);
		}
		PluginManager pm = this.getServer().getPluginManager();
		// pm.registerEvents(new WorldListener(this), this);

		// this.getCommand("LimitedWorld").setExecutor(new ReloadCommand(this));

		getLogger().info(pluginName + "成功加载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info(pluginName + "成功卸载!");
	}

	public void onReload() {
		this.reloadConfig();
		getLogger().info(pluginName + "成功重载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
	}
}
