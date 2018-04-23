package br.northwind.otimize.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.northwind.otimize.jdbc.ConexaoUtil;
import br.northwind.otimize.jdbc.dto.PessoaDTO;
import br.northwind.otimize.jdbc.exception.PersistenciaException;

public class PessoaDAO implements IPersistenciaDAO<PessoaDTO> {

	@Override
	public void inserir(PessoaDTO pessoaDTO) throws PersistenciaException {
		
		try {
			
			String sql = " INSERT INTO Pessoas(Nome, CPF, Endereco, Sexo, DtNasc)" +
			             " VALUES(?, ?, ?, ?, ?)";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(5, new Date(pessoaDTO.getDtNascimento().getTime()));
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO) throws PersistenciaException {
		
		try {
			
			String sql = "UPDATE Pessoas SET Nome     = ?, " +
						                   " CPF      = ?," +
										   " Endereco = ?," +
										   " Sexo     = ?," +
										   " DtNasc   = ? " +
									 " WHERE Id       = ?";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setLong(2, pessoaDTO.getCpf());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(5, new Date(pessoaDTO.getDtNascimento().getTime()));
			statement.setInt(6, pessoaDTO.getIdPessoa());
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
	}

	@Override
	public void remover(Integer idPessoa) throws PersistenciaException {
		
		try {
			
			String sql = "DELETE FROM Pessoas WHERE ID_PESSOA = ?";
		
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idPessoa);
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
	}

	@Override
	public List<PessoaDTO> retornarTodos() throws PersistenciaException {
		
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		
		try {
			
			String sql = "SELECT * FROM Pessoas";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("Id"));
				pessoaDTO.setNome(resultSet.getString("Nome"));
				pessoaDTO.setCpf(resultSet.getLong("CPF"));
				pessoaDTO.setDtNascimento(resultSet.getDate("DtNasc"));
				pessoaDTO.setEndereco(resultSet.getString("Endereco"));
				pessoaDTO.setSexo(resultSet.getString("Sexo").charAt(0));
				
				listaPessoas.add(pessoaDTO);
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
		return listaPessoas;
	}

	@Override
	public PessoaDTO retornaPorId(Integer id) throws PersistenciaException {
		
		PessoaDTO pessoaDTO = null;
		
		try {
			
			String sql = "SELECT * FROM Pessoas WHERE Id = ?";
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				
				pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("Id"));
				pessoaDTO.setNome(resultSet.getString("Nome"));
				pessoaDTO.setCpf(resultSet.getLong("CPF"));
				pessoaDTO.setDtNascimento(resultSet.getDate("DtNasc"));
				pessoaDTO.setEndereco(resultSet.getString("Endereco"));
				pessoaDTO.setSexo(resultSet.getString("Sexo").charAt(0));
				
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
		return pessoaDTO;
		
	}
	
	public List<PessoaDTO> filtraPessoa(String nome, Long cpf, String sexo) throws PersistenciaException  {
		
		List<PessoaDTO> lista = new ArrayList<>();
		
		try {
			
			String sql = "SELECT * FROM Pessoas ";
			
			if (nome != null && !nome.equals("")) {
				sql += " WHERE Nome = ?";
			}
			
			if (cpf != null && !cpf.equals("")) {
				sql += " AND CPF = ?";
			}
			
			if (sexo!= null && !sexo.equals("")) {
				sql += " AND Sexo = ?";
			}
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			if (nome != null && !nome.equals("")) {
				statement.setString(1, nome);
			}
			
			if (cpf != null && !cpf.equals("")) {
				statement.setLong(2, cpf);
			}
			
			if (sexo!= null && !sexo.equals("")) {
				statement.setString(3, sexo);
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("Id"));
				pessoaDTO.setNome(resultSet.getString("Nome"));
				pessoaDTO.setCpf(resultSet.getLong("CPF"));
				pessoaDTO.setDtNascimento(resultSet.getDate("DtNasc"));
				pessoaDTO.setEndereco(resultSet.getString("Endereco"));
				pessoaDTO.setSexo(resultSet.getString("Sexo").charAt(0));
				lista.add(pessoaDTO);
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
		return lista;
	}

}
