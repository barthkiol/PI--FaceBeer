package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Apreciador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "TB_APRECIADOR_CERVEJA",  // nome da tabela relacional no BD		
			// lado dominante/lado forte
			joinColumns = {
					@JoinColumn(name = "apreciador_id")
					
			},
			//lado dominado/lado fraco
			inverseJoinColumns = {
					@JoinColumn(name = "cerveja_id")
			}	
		)
		
	private List<Cerveja> cervejas;
	
	public List<Cerveja> getCervejas() {
		return cervejas;
	}
	
	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}
	public void adicionaCerveja(Cerveja c) {
		this.cervejas.add(c);
	}
	public void removeCerveja(Cerveja c) {
		cervejas.remove(c);
	}	
	public Cerveja getCerveja(int posicao) {
		return cervejas.get(posicao);
	}
	
	private String nome;
	private String cpf;
	private String email;
	private Date datanasc;
	private String usuarioA;
	private String senhaA;
	private String telefone;
	
	


	public Apreciador() {
		cervejas = new ArrayList<Cerveja>();
	}

	public Apreciador(int id, String nome, String cpf, String email, Date datanasc, String usuarioA, String senhaA,
			String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.datanasc = datanasc;
		this.usuarioA = usuarioA;
		this.senhaA = senhaA;
		this.telefone = telefone;
		cervejas = new ArrayList<Cerveja>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date date1) {
		this.datanasc = date1;
	}

	public String getUsuarioA() {
		return usuarioA;
	}

	public void setUsuarioA(String usuarioA) {
		this.usuarioA = usuarioA;
	}

	public String getSenhaA() {
		return senhaA;
	}

	public void setSenhaA(String senhaA) {
		this.senhaA = senhaA;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Apreciador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", datanasc=" + datanasc
				+ ", usuarioA=" + usuarioA + ", senhaA=" + senhaA + ", telefone=" + telefone + "]";
	}

}
