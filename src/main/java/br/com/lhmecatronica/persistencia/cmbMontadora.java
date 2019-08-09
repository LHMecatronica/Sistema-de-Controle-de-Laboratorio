package br.com.lhmecatronica.persistencia;

public class cmbMontadora {
	
	String montadora;

	
	public cmbMontadora(String montadora) {
		super();
		this.montadora = montadora;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	@Override
	public String toString() {
		return montadora;
	}
	
	

}
