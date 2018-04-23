package br.northwind.otimize.jdbc.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import br.northwind.otimize.jdbc.dao.PessoaDAO;
import br.northwind.otimize.jdbc.dto.PessoaDTO;
import br.northwind.otimize.jdbc.exception.NegocioException;
import br.northwind.otimize.jdbc.exception.ValidacaoException;

public class PessoaBO {
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public void cadastrar(PessoaDTO dto) throws NegocioException {
		
		try {
			PessoaDAO dao = new PessoaDAO();
			dao.inserir(dto);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		
	}
	
	public String[][] listagem() throws NegocioException {
		
		int numCols = 6;
		PessoaDAO dao = null;
		List<PessoaDTO> lista = null;
		String[][] listaRetorno = null;
		
		try {
			
			dao = new PessoaDAO();
			lista = dao.retornarTodos();
			listaRetorno = new String[lista.size()][numCols];
			
			for (int i = 0; i < lista.size(); i++) {
				PessoaDTO dto = lista.get(i);
				listaRetorno[i][0] = dto.getIdPessoa().toString();
				listaRetorno[i][1] = dto.getNome();
				listaRetorno[i][2] = dto.getCpf().toString();
				listaRetorno[i][3] = dto.getEndereco();
				listaRetorno[i][4] = dto.getSexo() == 'M' ? "Masculino" : "Feminino";
				listaRetorno[i][5] = dateFormat.format(dto.getDtNascimento());
			}
			
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		
		return listaRetorno;
		
	}
	
	public boolean validaNome(String nome) throws ValidacaoException {
		boolean ehValido = true;
		if (nome == null || nome.equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo nome é obrigatório");
		} else if (nome.length() > 30) {
			ehValido = false;
			throw new ValidacaoException("Campo nome comporta no máximo 30 caracteres");
		}
		return ehValido;
	}
	
	public boolean validaCpf(String cpf) throws ValidacaoException {
		boolean ehValido = true;
		if (cpf == null || cpf.equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo CPF é obrigatório");
		} else if (cpf.length() != 11) {
			ehValido = false;
			throw new ValidacaoException("Campo CPF deve ter 11 dígitos");
		} else {
			char[] digitos = cpf.toCharArray();
			for (char digito : digitos) {
				if (!Character.isDigit(digito)) {
					ehValido = false;
					throw new ValidacaoException("Campo CPF é somente numérico");
				}
			}
		}
		return ehValido;
	}
	
	public boolean validaEndereco(String endereco) throws ValidacaoException {
		boolean ehValido = true;
		if (endereco == null || endereco.equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo endereço é obrigatório");
		} else if (endereco.length() > 50) {
			ehValido = false;
			throw new ValidacaoException("Campo endereço comporta no máximo 30 caracteres");
		}
		return ehValido;
	}
	
	public boolean validaDataDeNascimento(String dtNasc) throws ValidacaoException {
		boolean ehValido = true;
		if (dtNasc == null || dtNasc.equals("")) {
			ehValido = false;
			throw new ValidacaoException("Campo Data de Nascimento é obrigatório");
		} else {
			try {
				dateFormat.parse(dtNasc);
			} catch (ParseException e) {
				ehValido = false;
				throw new ValidacaoException("Formato inválido de data");
			}
		}
		return ehValido;
	}
	
	public String[][] listaConsulta(String nome, Long cpf, char sexo) throws NegocioException {
		
		int numCols = 6;
		PessoaDAO dao = null;
		List<PessoaDTO> lista = null;
		String[][] listaRetorno = null;
		
		try {
			
			dao = new PessoaDAO();
			lista = dao.filtraPessoa(nome, cpf, String.valueOf(sexo));
			listaRetorno = new String[lista.size()][numCols];
			
			for (int i = 0; i < lista.size(); i++) {
				PessoaDTO dto = lista.get(i);
				listaRetorno[i][0] = dto.getIdPessoa().toString();
				listaRetorno[i][1] = dto.getNome();
				listaRetorno[i][2] = dto.getCpf().toString();
				listaRetorno[i][3] = dto.getEndereco();
				listaRetorno[i][4] = dto.getSexo() == 'M' ? "Masculino" : "Feminino";
				listaRetorno[i][5] = dateFormat.format(dto.getDtNascimento());
			}
			
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		
		return listaRetorno;
		
	}

}
