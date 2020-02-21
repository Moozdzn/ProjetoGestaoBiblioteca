package pt.europeia.Bibliotech.models;
/**
 *Classe do objeto Livro com o devido construtor,getters e setters
 */
public class Livro {
	
	private String name;
	private String author;
	private String publisher;
	private String language;
	private String isbn;
	private String barcode;
	private String publishYear;
	private String description;
	private String genre;
	private String idBiblioteca;
	private boolean reservado;
	
	
	public Livro(String name, String author, String publisher, String language,String iSBN,  String barcode,
			String publishYear, String description, String genre,String idBiblioteca, boolean reservado) {
		this.isbn =  iSBN;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.language = language;		
		this.barcode = barcode;
		this.publishYear = publishYear;
		this.description = description;
		this.genre = genre;
		this.idBiblioteca = idBiblioteca;
		this.reservado = reservado;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setiSBN(String iSBN) {
		this.isbn = iSBN;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getIdBiblioteca() {
		return idBiblioteca;
	}
	public void setIdBiblioteca(String idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}
	public String getReservado() {
		return reservado ? "Sim" : "Não";
	}
	public boolean isReservado() {
		return reservado;
	}
	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

}
