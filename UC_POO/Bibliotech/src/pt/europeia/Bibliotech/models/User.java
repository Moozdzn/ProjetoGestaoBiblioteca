package pt.europeia.Bibliotech.models;
/**
 *Classe do objeto user com o devido construtor,getters e setters
 */
public class User {
	protected int idUser;
	protected String password;
	protected boolean cargo;
	
	
	public User(int idUser, String password,boolean cargo) {
		this.idUser = idUser;
		this.password = password;
		this.cargo = cargo;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getCargo() {
		return cargo;
	}
	
	public void setCargo(boolean cargo) {
		this.cargo = cargo;
	}
	
	
	
}
