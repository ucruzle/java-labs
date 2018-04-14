package br.northwind.otimize.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.northwind.otimize.jdbc.ConexaoUtil;
import br.northwind.otimize.jdbc.dto.CategoriaDTO;
import br.northwind.otimize.jdbc.exception.PersistenciaException;

public class CategoriaDAO implements IPersistenciaDAO<CategoriaDTO> {

	@Override
	public void inserir(CategoriaDTO categoriaDTO) throws PersistenciaException {
		
		try {
			
			String sql = " INSERT INTO Categorias(NomeDaCategoria, Descricao)" + 
			             " VALUES(?, ?)";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoriaDTO.getNomeDaCategoria());
			statement.setString(2, categoriaDTO.getDescricao());
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		} 
		
	}

	@Override
	public void atualizar(CategoriaDTO categoriaDTO) throws PersistenciaException {
		
		try {
			
			String sql = " UPDATE Categorias" +
			                " SET NomeDaCategoria = ?" +
					           ", Descricao = ?" + 
			              " WHERE CodigoDaCategoria = ?";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoriaDTO.getNomeDaCategoria());
			statement.setString(2, categoriaDTO.getDescricao());
			statement.setInt(3, categoriaDTO.getCodigoDaCategoria());
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		} 
		
	}

	@Override
	public void remover(Integer id) throws PersistenciaException {
		
		try {
			
			String sql = "DELETE FROM Categorias WHERE CodigoDaCategoria = ?";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		} 
		
	}

	@Override
	public List<CategoriaDTO> retornarTodos() throws PersistenciaException {
		
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		
		try {
			
			String sql = "select * from Categorias";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				CategoriaDTO dto = new CategoriaDTO();
				dto.setCodigoDaCategoria(resultSet.getInt("CodigoDaCategoria"));
				dto.setNomeDaCategoria(resultSet.getString("NomeDaCategoria"));
				dto.setDescricao(resultSet.getString("Descricao"));
				
				categorias.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		} 
		
		return categorias;
	}

	@Override
	public CategoriaDTO retornaPorId(Integer id) throws PersistenciaException {
		
		CategoriaDTO dto = null;
		
		try {
			
			String sql = "select * from Categorias where CodigoDaCategoria = ?";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			connection.close();
			
			if (resultSet.next()) {
				dto = new CategoriaDTO();
				dto.setCodigoDaCategoria(resultSet.getInt("CodigoDaCategoria"));
				dto.setNomeDaCategoria(resultSet.getString("NomeDaCategoria"));
				dto.setDescricao(resultSet.getString("Descricao"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
		return dto;
	}

	
}
