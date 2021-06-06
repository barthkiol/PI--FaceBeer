package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Aroma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@ManyToMany(mappedBy="aromas")
	private List<Cerveja> cervejas;
	
	public List<Cerveja> getCervejas() {
		return cervejas;
	}
//	public void setCervejas(List<Cerveja> cervejas) {
//		this.cervejas = cervejas;
//	}
	
	public void adicionaCerveja(Cerveja p) {
		cervejas.add(p);
	}
	public void removeCerveja(Cerveja p) {
		cervejas.remove(p);
	}
	public Cerveja getCerveja(int posicao) {
		return cervejas.get(posicao);
	}
	
	public Aroma() {
		cervejas = new ArrayList<Cerveja>();
	}


	public Aroma(int id, String nome) {
		this.id = id;
		this.nome = nome;
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


	@Override
	public String toString() {
		return nome;
	}
	
	
	
	
}
