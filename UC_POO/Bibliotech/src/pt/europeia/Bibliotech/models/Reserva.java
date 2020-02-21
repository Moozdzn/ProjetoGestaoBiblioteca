package pt.europeia.Bibliotech.models;

import java.util.Date;

import org.joda.time.DateTime;

/**
 *Classe do objeto Reserva com o devido construtor,getters e setters
 */

public class Reserva {
	private int user;
	private String codigoDeBarras;
	private String idBiblioteca;
	//Date dt = new Date();
	String dtInicial;
	String dtFinal;
	public Reserva(int user, String codigoDeBarras, String idBiblioteca, String dtInicial, String dtFinal) {	
		this.user = user;
		this.codigoDeBarras = codigoDeBarras;
		this.idBiblioteca = idBiblioteca;
		this.dtInicial = dtInicial;
		this.dtFinal = dtFinal;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public String getIdBiblioteca() {
		return idBiblioteca;
	}
	public void setIdBiblioteca(String idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}
	public String getDtInicial() {
		return dtInicial;
	}
	public void setDtInicial(String dtInicial) {
		this.dtInicial = dtInicial;
	}
	public String getDtFinal() {
		return dtFinal;
	}
	public void setDtFinal(String dtFinal) {
		this.dtFinal = dtFinal;
	}
	
		
	
}
