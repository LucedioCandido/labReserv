package labReserv.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sala")
public class Sala {
	
	@Id
	@Column(name="idSala")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idLab")
	private Long idLab;
	
	@Column(name="nome")
	private String nome;

	
	
	public Sala() {
		super();
	}
	
	public Sala(Long idLab, String nome) {
		super();
		this.idLab = idLab;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdLab() {
		return idLab;
	}

	public void setIdLab(Long idLab) {
		this.idLab = idLab;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
