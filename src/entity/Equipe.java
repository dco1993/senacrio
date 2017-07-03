package entity;

import java.io.Serializable;
import java.sql.Date;

public class Equipe implements Serializable {
	
	
	private static final long serialVersionUID = -3226125939725684416L;
	
	private Integer id;
	private String nome;
	private String desc;
	private String foto;
	private Date tempoprof; 
	
	//construtores
	public Equipe() {
		
	}
	
	public Equipe (String nome, String desc, String foto, Date tempoprof){
		this.nome = nome;
		this.desc = desc;
		this.foto = foto;
		this.tempoprof = tempoprof;
	}
	
	public Equipe(Integer id, String nome, String desc, String foto, Date tempoprof){
		this.id = id;
		this.nome = nome;
		this.desc = desc;
		this.foto = foto;
		this.tempoprof = tempoprof;
	}
	
	@Override
	public String toString() {	
	return "id: " + id + "\nNome: " + nome + "\nDescrição: " + desc + "\nFoto: " + foto + "\nTempo de Profissão: " + tempoprof;
	}
	
	//get e set
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
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Date getTempoprof() {
		return tempoprof;
	}
	
	public void setTempoprof(Date tempoprof) {
		this.tempoprof = tempoprof;
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
		Equipe other = (Equipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
