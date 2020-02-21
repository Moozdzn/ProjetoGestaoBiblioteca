package pt.europeia.Bibliotech.models;
/**
 *Classe do objeto Biblioteca com o devido construtor,getters e setters
 */
public class Biblioteca {
	private String idBiblioteca;
	private String nome;
	private int idUniversidade;
	
	public Biblioteca(String idBiblioteca, String nome,int idUniversidade) {
		this.idBiblioteca = idBiblioteca;
		this.nome = nome;
		this.idUniversidade = idUniversidade;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getIdBiblioteca() {
		return idBiblioteca;
	}
	
	public int getIdUniversidade() {
		return idUniversidade;
	}
	
	public String toString() {
		return this.nome;
	}
}
