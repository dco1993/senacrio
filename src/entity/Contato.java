package entity;

import java.io.Serializable;

public class Contato implements Serializable {
	
	
	private static final long serialVersionUID = -4742809912524209718L;
	private Integer id;
	private String nome;
	private String email;
	private Integer idade;
	private String conheceu;
	private String mensagem;
	
	//construtor
	public Contato(){
		
	}
	
	public Contato(String nome, String email, Integer idade, String conheceu, String mensagem){
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.conheceu = conheceu;
		this.mensagem = mensagem;
	}
	
	public Contato(Integer id, String nome, String email, Integer idade, String conheceu, String mensagem) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.conheceu = conheceu;
		this.mensagem = mensagem;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nIdade: " + idade + "\nComo conheceu: " + conheceu + "\nDuvidas e Sugestões " + mensagem;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String getConheceu() {
		return conheceu;
	}
	
	public void setConheceu(String conheceu) {
		this.conheceu = conheceu;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
