package cc.isotopestudio.Strength.sql;

import java.sql.*;

import cc.isotopestudio.Strength.Strength;
import cc.isotopestudio.Strength.data.PlayerData;

public class SqlManager {

	public static boolean connectMySQL(Strength plugin) {
		String host = plugin.getConfig().getString("mySQL.host");
		String port = plugin.getConfig().getString("mySQL.port");
		String user = plugin.getConfig().getString("mySQL.user");
		String pw = plugin.getConfig().getString("mySQL.password");
		String db = plugin.getConfig().getString("mySQL.database");
		Strength.MySQL = new MySQL(host, port, db, user, pw);
		Strength.c = null;
		try {
			Strength.c = Strength.MySQL.openConnection();
		} catch (ClassNotFoundException e) {
			plugin.getLogger().info(Strength.pluginName + "数据库出错 Error1");
			return false;
		} catch (SQLException e) {
			plugin.getLogger().info(Strength.pluginName + "数据库出错 Error2");
			return false;
		}		
		Statement statement = null;
		try {
			statement = Strength.c.createStatement();
		} catch (SQLException e1) {
			plugin.getLogger().info(Strength.pluginName + "数据库出错 Error3");
			return false;
		}
		PlayerData.statement = statement;
		
		return true;
	}

}
