package labReserv.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipamento")
public class Equipamento {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idSala")
	private Long idSala;
	
	@Column(name="tombamento")
	private Long tombamento;
	
	@Column(name = "nome")
	private String nome;

		
	
	public Equipamento() {
		super();
	}

	public Equipamento(Long idSala, Long tombamento, String nome) {
		super();
		this.idSala = idSala;
		this.tombamento = tombamento;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public Long getTombamento() {
		return tombamento;
	}

	public void setTombamento(Long tombamento) {
		this.tombamento = tombamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
	
	
	
}
