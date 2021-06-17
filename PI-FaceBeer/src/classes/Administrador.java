package classes;


import javax.persistence.*;


@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String nomeAdm;
	private String senhaAdm;
	private String usuarioAdm;
	


	public Administrador() {
		
	}

	public Administrador(int id, String nome, String senha, String user) {
		this.id = id;
		this.nomeAdm = nome;
		this.senhaAdm = senha;
		this.usuarioAdm = user;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeAdm() {
		return nomeAdm;
	}

	public void setNomeAdm(String nomeAdm) {
		this.nomeAdm = nomeAdm;
	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(String senhaAdm) {
		this.senhaAdm = senhaAdm;
	}

	public String getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setUsuarioAdm(String usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nomeAdm=" + nomeAdm + ", senhaAdm=" + senhaAdm + ", usuarioAdm="
				+ usuarioAdm + "]";
	}

	

	

}
