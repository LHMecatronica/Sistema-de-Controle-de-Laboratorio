package br.com.lhmecatronica.persistencia;

public class Montadora {

	int id;
	String montadora;
	String modelo;
	String versao;
	String calculador;
	String bc;
	String immo;
	
	
	public Montadora(int id, String montadora, String modelo, String versao, String calculador, String bc, String immo) {
		super();
		this.id = id;
		this.montadora = montadora;
		this.modelo = modelo;
		this.versao = versao;
		this.calculador = calculador;
		this.bc = bc;
		this.immo = immo;
	}
	
	public Montadora(String montadora) {
		super();
		this.montadora = montadora;
	}

	public int getId() {
		return id;
	}
	public String getMontadora() {
		return montadora;
	}
	public String getModelo() {
		return modelo;
	}
	public String getVersao() {
		return versao;
	}
	public String getCalculador() {
		return calculador;
	}
	public String getBc() {
		return bc;
	}
	public String getImmo() {
		return immo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public void setCalculador(String calculador) {
		this.calculador = calculador;
	}
	public void setBc(String bc) {
		this.bc = bc;
	}
	public void setImmo(String immo) {
		this.immo = immo;
	}

	@Override
	public String toString() {
		return id + "-" +montadora ;
	}

		
}
