package br.com.otimiza.oqueejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

	public static void main(String args[]) {
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://LATITUDE3440:1433;databaseName=Northwind2003;user=sa;password=3jd64lsai9;");
			Statement statement = connection.createStatement();
			statement.executeQuery("select CodigoDaCategoria, NomeDaCategoria, Descricao from Categorias");
			ResultSet resultSet = statement.getResultSet();
			
			while (resultSet.next()) {
				
				System.out.printf(" %d: %15s - %10s \n",
						          resultSet.getInt("CodigoDaCategoria"),
						          resultSet.getString("NomeDaCategoria"),
						          resultSet.getString("Descricao"));
				
			}
		} 
		catch (Exception exception) {
			System.out.println("Erro: " + exception.getMessage());
		}
	}
	
}
