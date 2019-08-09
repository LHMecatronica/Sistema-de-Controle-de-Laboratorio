package br.com.lhmecatronica.persistencia;

public class cmbModelo {

	String modelo;

	

	public cmbModelo(String modelo) {
		super();
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return modelo;
	}
	
		
}
