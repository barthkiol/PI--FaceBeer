package bo;

import java.util.List;

import classes.*;
import dao.*;

public class ApreciadorBo {

	
	public String salvar(Apreciador apreciador) throws Exception {
		validarDadosGrupo(apreciador);

		// Chamar a DAo para inserir o apreciador no BD
		ApreciadorDao dao = new ApreciadorDao();
		try {
			return dao.salvar(apreciador);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(Apreciador apreciador) throws Exception {
		validarDadosGrupo(apreciador);

		// Chamar a DAo para alterar o apreciador no BD
		ApreciadorDao dao = new ApreciadorDao();
		try {
			return dao.alterar(apreciador);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	public String deletar(Apreciador apreciador) throws Exception {
		
		// Chamar a DAo para deletar o apreciador no BD
		ApreciadorDao dao = new ApreciadorDao();
		try {
			return dao.deletar(apreciador);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}	
	
	public List<Apreciador> consultar() throws Exception{	
		
		ApreciadorDao dao = new ApreciadorDao();
		try {
			return dao.consultar();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}			
	}	

	private void validarDadosGrupo(Apreciador apreciador) throws Exception {
		// Validação da regra de negócio
		if (apreciador.getNome().equals("")) {
			throw new Exception("Nome do apreciador não pode ficar em branco!");
		}
		if (apreciador.getCpf().equals("")) {
			throw new Exception("CPF do apreciador não pode ficar em branco!");
		}
		if (apreciador.getSenhaA().equals("")) {
			throw new Exception("Senha do apreciador não pode ficar em branco!");
		}
		if (apreciador.getUsuarioA().equals("")) {
			throw new Exception("Usuario do apreciador não pode ficar em branco!");
		}
		if (apreciador.getEmail().equals("")) {
			throw new Exception("Email do apreciador não pode ficar em branco!");
		}
	}
}
