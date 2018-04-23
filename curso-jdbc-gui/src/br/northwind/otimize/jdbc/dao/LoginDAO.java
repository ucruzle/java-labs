package br.northwind.otimize.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import br.northwind.otimize.jdbc.ConexaoUtil;
import br.northwind.otimize.jdbc.dto.LoginDTO;
import br.northwind.otimize.jdbc.exception.PersistenciaException;

public class LoginDAO implements IPersistenciaDAO<LoginDTO> {
	
	public boolean logar(LoginDTO loginDTO) throws PersistenciaException {
		
		boolean resultado = false;
		
		try {
			
			String sql = "select * from Acessos where Login = ? and Senha = ?";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, loginDTO.getLogin());
			statement.setString(2, loginDTO.getSenha());
			
			ResultSet resultSet = statement.executeQuery();
			resultado = resultSet.next();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
		return resultado;
	}
	
	@Override
	public void inserir(LoginDTO obj) throws PersistenciaException {
		
	}

	@Override
	public void atualizar(LoginDTO obj) throws PersistenciaException {
		
	}

	@Override
	public void remover(Integer id) throws PersistenciaException {
		
	}

	@Override
	public List<LoginDTO> retornarTodos() throws PersistenciaException {
		return null;
	}

	@Override
	public LoginDTO retornaPorId(Integer id) throws PersistenciaException {
		return null;
	}
	
}
