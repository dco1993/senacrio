package entity;

import java.io.Serializable;

public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 7918227260120583363L;
	private Integer id;
	private String nome;
	private String comentario;
	private String bairro;
	private Integer nota;
	private String ativo;
	
	public Comentario() {
		
	}
	
	public Comentario(String nome, String comentario, String bairro, Integer nota, String ativo) {
		this.nome=nome;
		this.comentario=comentario;
		this.bairro=bairro;
		this.nota=nota;
		this.ativo=ativo;
	}
	
	public Comentario(String nome, String comentario, String bairro, Integer nota) {
		this.nome=nome;
		this.comentario=comentario;
		this.bairro=bairro;
		this.nota=nota;
	}
	
	public Comentario(Integer id, String nome, String comentario, String bairro, Integer nota, String ativo) {
		this.id=id;
		this.nome=nome;
		this.comentario=comentario;
		this.bairro=bairro;
		this.nota=nota;
		this.ativo=ativo;
	}
	
	@Override
	public String toString() {
		return	"Id: " + id + "\nNome: " + nome + "\nComentario: " + comentario + "\nBairro: : " + bairro + "\nNota: " + nota + "\nAtivo: " + ativo;
 	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	public String getAtivo() {
		return ativo;
	}
	
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
