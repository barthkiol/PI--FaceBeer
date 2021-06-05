package classes;

import javax.persistence.*;


@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	
	public Pais() {
		
	}


	public Pais(int id, String nome) {
		this.id = id;
		this.nome = nome;
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


	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
	
}
