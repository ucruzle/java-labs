package br.northwind.otimize.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoUtil {
	
private static ResourceBundle config;
	
	private static ConexaoUtil conexaoUtil;
	
	private ConexaoUtil() {
		config = ResourceBundle.getBundle("config");
	}
	
	public static ConexaoUtil getInstance() {
		
		if(conexaoUtil == null) {
			conexaoUtil = new ConexaoUtil();
		}
		
		return conexaoUtil;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(config.getString("br.northwind.otimiza.db.driver.mssqlserver"));		
		return DriverManager.getConnection(config.getString("br.northwind.otimiza.db.url.conexao"));
	}

}
