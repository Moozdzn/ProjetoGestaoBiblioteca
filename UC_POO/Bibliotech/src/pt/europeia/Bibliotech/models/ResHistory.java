package pt.europeia.Bibliotech.models;

/**
 *Classe do objeto ResHistory com o devido construtor,getters e setters
 */
public class ResHistory {

private String titulo;
private String autor;
private String editora;
private String barcode;
private String uNome;
private String dataMax;


public ResHistory(String titulo, String autor, String editora, String barcode, String uNome, String dataMax) {
	super();
	this.titulo = titulo;
	this.autor = autor;
	this.editora = editora;
	this.barcode = barcode;
	this.uNome = uNome;
	this.dataMax = dataMax;
}


public String getTitulo() {
	return titulo;
}


public void setTitulo(String titulo) {
	this.titulo = titulo;
}


public String getAutor() {
	return autor;
}


public void setAutor(String autor) {
	this.autor = autor;
}


public String getEditora() {
	return editora;
}


public void setEditora(String editora) {
	this.editora = editora;
}


public String getBarcode() {
	return barcode;
}


public void setBarcode(String barcode) {
	this.barcode = barcode;
}


public String getUNome() {
	return uNome;
}


public void setUNome(String uNome) {
	this.uNome = uNome;
}


public String getDataMax() {
	return dataMax;
}


public void setDataMax(String dataMax) {
	this.dataMax = dataMax;
}



}
