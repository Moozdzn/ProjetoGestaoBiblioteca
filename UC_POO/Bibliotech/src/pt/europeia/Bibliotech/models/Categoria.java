package pt.europeia.Bibliotech.models;
/**
 *Classe do objeto categoria com o devido construtor,getters e setters
 */
public class Categoria {
	private String idCategoria;
	private String nome;
	
	public Categoria(String idCategoria) {
		this.idCategoria = idCategoria;
		
	}
	
	public String getIdCategoria() {
		return idCategoria;
	}
	
	public String toString() {
		return this.idCategoria;
	}
}
