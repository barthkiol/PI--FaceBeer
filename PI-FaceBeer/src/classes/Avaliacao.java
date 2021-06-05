package classes;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String descricao;
	private float nota;
	
	@ManyToOne
	private Apreciador apreciador;
	
	@ManyToOne
	private Cerveja cerveja;

	public Avaliacao() {
		
	}

	public Avaliacao(int id, String descricao, float nota, Apreciador apreciador, Cerveja cerveja) {
		this.id = id;
		this.descricao = descricao;
		this.nota = nota;
		this.apreciador = apreciador;
		this.cerveja = cerveja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public Apreciador getApreciador() {
		return apreciador;
	}

	public void setApreciador(Apreciador apreciador) {
		this.apreciador = apreciador;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", descricao=" + descricao + ", nota=" + nota + ", apreciador=" + apreciador
				+ ", cerveja=" + cerveja + "]";
	}
	
	
}
