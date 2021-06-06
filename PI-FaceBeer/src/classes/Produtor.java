package classes;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Produtor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cnpj;
	private String email;
	private String telefone;
	private String nome;
	private String senhaP;
	private String usuarioP;
	
	public Produtor() {
		
	}

	public Produtor(int id, String cnpj, String email, String telefone, String nome, String senhaP, String usuarioP) {
		this.id = id;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.nome = nome;
		this.senhaP = senhaP;
		this.usuarioP = usuarioP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenhaP() {
		return senhaP;
	}

	public void setSenhaP(String senhaP) {
		this.senhaP = senhaP;
	}

	public String getUsuarioP() {
		return usuarioP;
	}

	public void setUsuarioP(String usuarioP) {
		this.usuarioP = usuarioP;
	}

	@Override
	public String toString() {
		return "Produtor [id=" + id + ", cnpj=" + cnpj + ", email=" + email + ", telefone=" + telefone + ", nome="
				+ nome + ", senhaP=" + senhaP + ", usuarioP=" + usuarioP + "]";
	}
	
	public String nomeProdutor() {
		return nome;
	}
}
