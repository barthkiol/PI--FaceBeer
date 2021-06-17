package bo;

import java.util.List;

import classes.*;
import dao.*;

public class ProdutorBo {

	
	public String salvar(Produtor produtor) throws Exception {
		validarDadosGrupo(produtor);

		// Chamar a DAo para inserir o produtor no BD
		ProdutorDao dao = new ProdutorDao();
		try {
			return dao.salvar(produtor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Produtor produtor) throws Exception {
		validarDadosGrupo(produtor);

		// Chamar a DAo para alterar o produtor no BD
		ProdutorDao dao = new ProdutorDao();
		try {
			return dao.alterar(produtor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	public String deletar(Produtor produtor) throws Exception {
		
		// Chamar a DAo para deletar o produtor no BD
		ProdutorDao dao = new ProdutorDao();
		try {
			return dao.deletar(produtor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}	
	
	public List<Produtor> consultar() throws Exception{	
		
		ProdutorDao dao = new ProdutorDao();
		try {
			return dao.consultar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosGrupo(Produtor produtor) throws Exception {
		// Validação da regra de negócio
		if (produtor.getNome().equals("")) {
			throw new Exception("Nome não pode ficar em branco!");
		}
		if (produtor.getCnpj().equals("")) {
			throw new Exception("CNPJ não pode ficar em branco!");
		}
		if (produtor.getCnpj().length() > 14) {
			throw new Exception("CNPJ inválido!");
		}
		if (produtor.getSenhaP().equals("")) {
			throw new Exception("Senha não pode ficar em branco!");
		}
		if (produtor.getUsuarioP().equals("")) {
			throw new Exception("Usuario não pode ficar em branco!");
		}
		if (produtor.getEmail().equals("")) {
			throw new Exception("Email não pode ficar em branco!");
		}
	}
}
