package pt.europeia.Bibliotech.models;
/**
 *Classe do objeto Staff com o devido construtor,getters e setters
 */
public class Staff {
	protected int idStaff;
	protected String nome;
	protected String dataNascimento;
	protected String cargo;
	
	
	
	
	public Staff(int idStaff, String nome,String dataNascimento, String cargo) {
		this.idStaff = idStaff;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
		
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNacimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public int getIdStaff() {
		return idStaff;
	}



	
	
	
	
	
}
