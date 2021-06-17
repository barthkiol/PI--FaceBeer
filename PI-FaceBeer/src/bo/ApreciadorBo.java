package bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import classes.Apreciador;
import dao.ApreciadorDao;

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
			throw new Exception("Nome não pode ficar em branco!");
		}
		if (apreciador.getCpf().equals("")) {
			throw new Exception("CPF não pode ficar em branco!");
		}
		if (apreciador.getCpf().length() > 11) {
			throw new Exception("CPF não é válido!");
		}
		if (apreciador.getSenhaA().equals("")) {
			throw new Exception("Senha não pode ficar em branco!");
		}
		if (apreciador.getUsuarioA().equals("")) {
			throw new Exception("Usuario não pode ficar em branco!");
		}
		if (apreciador.getEmail().equals("")) {
			throw new Exception("Email não pode ficar em branco!");
		}
		if (apreciador.getTelefone().equals("")) {
			throw new Exception("Telefone não pode ficar em branco!");
		}
		
	}
	
	public static int calculaIdade(String dataNasc) throws Exception {

		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascInput = null;
		try {
			dataNascInput = sdf.parse(dataNasc);
		} catch (Exception e) {
			throw new Exception("Idade inválida!");
		}
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNascInput);
		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();
		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {
			age--;
		}
		return age;
	}
	
	public Date dataApreciador(String dataNasc) throws Exception {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascInput = null;
		int i = calculaIdade(dataNasc);
		if (i >= 18) {
			dataNascInput = sdf.parse(dataNasc);
			return dataNascInput;
		} else {
			return null;
		}
	}
}
