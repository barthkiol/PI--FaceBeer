package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Cerveja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private String nome;
	private float temperatura;
	private float teorAlc;
	private int volume;
	
	
	@ManyToMany
	@JoinTable(name = "TB_CERVEJA_AROMA",  // nome da tabela relacional no BD		
			// lado dominante/lado forte
			joinColumns = {
					@JoinColumn(name = "cerveja_id")
					
			},
			//lado dominado/lado fraco
			inverseJoinColumns = {
					@JoinColumn(name = "aroma_id")
			}	
		)
	private List<Aroma> aromas;
	public List<Aroma> getAroma() {
		return aromas;
	}
//	public void setAromas(List<Aroma> aromas) {
//		this.aromas = aromas;
//	}
	
	public void adicionaAroma(Aroma p) {
		aromas.add(p);
	}
	public void removeAroma(Aroma p) {
		aromas.remove(p);
	}
	public Aroma getAroma(int posicao) {
		return aromas.get(posicao);
	}
	
	@ManyToOne
	private Amargor amargor;
	
	@ManyToOne
	private Pais pais;
	
	@ManyToOne
	private Coloracao cor;
	
	@ManyToOne
	private Estilo estilo;
	
	@ManyToOne
	private Produtor produtor;

	@ManyToMany(mappedBy="cervejas")
	private List<Apreciador> apreciadores;
	public List<Apreciador> getApreciador() {
		return apreciadores;
	}
//	public void setApreciadors(List<Apreciador> apreciadors) {
//		this.apreciadors = apreciadors;
//	}
	
	public void adicionaApreciador(Apreciador p) {
		apreciadores.add(p);
	}
	public void removeApreciador(Apreciador p) {
		apreciadores.remove(p);
	}
	public Apreciador getApreciador(int posicao) {
		return apreciadores.get(posicao);
	}
	
	public Cerveja() {
		aromas = new ArrayList<Aroma>();
		apreciadores = new ArrayList<Apreciador>();
	}



	public Cerveja(int id, String descricao, String nome, float temperatura, float teorAlc, int volume, Amargor amargor,
			Pais pais, Coloracao cor, Estilo estilo, Produtor produtor) {
		
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.temperatura = temperatura;
		this.teorAlc = teorAlc;
		this.volume = volume;
		this.amargor = amargor;
		this.pais = pais;
		this.cor = cor;
		this.estilo = estilo;
		this.produtor = produtor;
		aromas = new ArrayList<Aroma>();
		apreciadores = new ArrayList<Apreciador>();
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



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public float getTemperatura() {
		return temperatura;
	}



	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}



	public float getTeorAlc() {
		return teorAlc;
	}



	public void setTeorAlc(float teorAlc) {
		this.teorAlc = teorAlc;
	}



	public int getVolume() {
		return volume;
	}



	public void setVolume(int volume) {
		this.volume = volume;
	}



	public List<Aroma> getAromas() {
		return aromas;
	}



	public void setAromas(List<Aroma> aromas) {
		this.aromas = aromas;
	}



	public Amargor getAmargor() {
		return amargor;
	}



	public void setAmargor(Amargor amargor) {
		this.amargor = amargor;
	}



	public Pais getPais() {
		return pais;
	}



	public void setPais(Pais pais) {
		this.pais = pais;
	}



	public Coloracao getCor() {
		return cor;
	}



	public void setCor(Coloracao cor) {
		this.cor = cor;
	}



	public Estilo getEstilo() {
		return estilo;
	}



	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}



	public Produtor getProdutor() {
		return produtor;
	}



	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}



	public List<Apreciador> getApreciadores() {
		return apreciadores;
	}



	public void setApreciadores(List<Apreciador> apreciadores) {
		this.apreciadores = apreciadores;
	}



	@Override
	public String toString() {
		return "Cerveja [id=" + id + ", descricao=" + descricao + ", nome=" + nome + ", temperatura=" + temperatura
				+ ", teorAlc=" + teorAlc + ", volume=" + volume + ", aromas=" + aromas + ", amargor=" + amargor
				+ ", pais=" + pais + ", cor=" + cor + ", estilo=" + estilo + ", produtor=" + produtor
				+ ", apreciadores=" + apreciadores + "]";
	}

	

}
