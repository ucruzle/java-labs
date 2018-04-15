package br.northwind.otimize.jdbc.bo;

import br.northwind.otimize.jdbc.dao.LoginDAO;
import br.northwind.otimize.jdbc.dto.LoginDTO;
import br.northwind.otimize.jdbc.exception.NegocioException;

public class LoginBO {
	
	public boolean logar(LoginDTO loginDTO) throws NegocioException {

		boolean resultado = false;
		
		try {
			
			if (loginDTO.getLogin() == null || "".equals(loginDTO.getLogin())) {
				throw new NegocioException("Login obrigatorio!");
			} else if (loginDTO.getSenha() == null || "".equals(loginDTO.getSenha())) {
				throw new NegocioException("Senha obrigatorio!");
			} else {
				LoginDAO dao = new LoginDAO();
				resultado = dao.logar(loginDTO);
			}
			
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		
		return resultado;
		
	}

}
