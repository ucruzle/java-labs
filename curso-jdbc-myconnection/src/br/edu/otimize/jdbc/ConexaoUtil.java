package br.edu.otimize.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.otimize.jdbc.dto.CategoriaDTO;

public class ConexaoUtil {
	
	private static ConexaoUtil conexaoUtil;
	
	public static ConexaoUtil getInstance() {
		
		if(conexaoUtil == null) {
			conexaoUtil = new ConexaoUtil();
		}
		
		return conexaoUtil;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
		return DriverManager.getConnection("jdbc:sqlserver://LATITUDE3440:1433;databaseName=Northwind2003;user=sa;password=3jd64lsai9;");
	}
	
	/*
	public static void main(String[] args) {
		try {
			System.out.println(getInstance().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	*/
	
	public void listar() throws SQLException {
		
		Connection connection = null;
		
		try {
			
			connection = getConnection();
			
			String sql = "select * from Categorias";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				System.out.printf(" %d: %15s - %10s \n",
				          resultSet.getInt("CodigoDaCategoria"),
				          resultSet.getString("NomeDaCategoria"),
				          resultSet.getString("Descricao"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha a conexão
			connection.close();
		}
		
	}
	
	/*
	
	public static void main(String[] args) {
		try {
			getInstance().listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	*/
	
	public void inserir(CategoriaDTO categoriaDTO) throws SQLException {
		
		Connection connection = null;
		
		try {
			
			connection = getConnection();
			
			String sql = " INSERT INTO Categorias(NomeDaCategoria, Descricao)" + 
			             " VALUES(?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, categoriaDTO.getNomeDaCategoria());
			statement.setString(2, categoriaDTO.getDescricao());
			
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}
	
	public void atualizar(CategoriaDTO categoriaDTO) throws SQLException {
		
		Connection connection = null;
		
		try {
			
			connection = getConnection();
			
			String sql = " UPDATE Categorias" +
			                " SET NomeDaCategoria = ?" +
					           ", Descricao = ?" + 
			              " WHERE CodigoDaCategoria = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, categoriaDTO.getNomeDaCategoria());
			statement.setString(2, categoriaDTO.getDescricao());
			statement.setInt(3, categoriaDTO.getCodigoDaCategoria());
			
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}
	
	public void remover(Integer codigoDaCategoria) throws SQLException {
		
		Connection connection = null;
		
		try {
			
			connection = getConnection();
			
			String sql = "DELETE FROM Categorias WHERE CodigoDaCategoria = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, codigoDaCategoria);
			
			statement.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}
	
	/*
	
	public static void main(String[] args) {
		
		CategoriaDTO dto = null;
		
		try {
			
			dto = new CategoriaDTO();
			
			// dto.setDescricao("Oba Java");
			// dto.setNomeDaCategoria("Java Ini");
			// getInstance().inserir(dto);
			
			// dto.setDescricao("Java");
			// dto.setNomeDaCategoria("Mundo Java");
			// dto.setCodigoDaCategoria(9);
			// getInstance().atualizar(dto);
			
			// dto.setCodigoDaCategoria(13);
			// getInstance().remover(dto.getCodigoDaCategoria());
			
			getInstance().listar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	*/
}
