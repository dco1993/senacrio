package entity;

import java.io.Serializable;

public class Admin implements Serializable {
	
	
	private static final long serialVersionUID = -3171639544694741060L;
	private Integer id;
	private String login;
	private String senha;
	
	//construtor
	public Admin(){
		
	}
	
	public Admin(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Admin(Integer id, String login, String senha){
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	@Override
	public String toString() {

		return "ID: " + id + "\nLogin: " + login + "\nSenha: " + senha;
	}
	
	//get e set
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
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
		Admin other = (Admin) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
