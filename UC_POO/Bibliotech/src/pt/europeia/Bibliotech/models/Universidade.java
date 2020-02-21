package pt.europeia.Bibliotech.models;
/**
 *Classe do objeto Universidade com o devido construtor,getters e setters
 */
public class Universidade {
	protected int idUniversidade;
	protected String nome;
	
	
	
	public Universidade(int idUniversidade, String nome) {
		this.idUniversidade = idUniversidade;
		this.nome = nome;
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdUniversidade() {
		return idUniversidade;
	}


	
	
	
	
}
