package classes;


import javax.persistence.*;


@Entity
public class Suporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String texto;
	
	@ManyToOne
	private Produtor produtor;
	


	public Suporte() {
		
	}

	public Suporte(int id, String texto) {
		this.id = id;
		this.texto = texto;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Produtor getProdutor() {
		return produtor;
	}

	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}

	@Override
	public String toString() {
		return "Suporte [id=" + id + ", texto=" + texto + ", produtor=" + produtor + "]";
	}

	

	

	

}
