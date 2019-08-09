package br.com.lhmecatronica.persistencia;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class OsCabecalho implements Serializable {
	
	int idOs;
	int idCliente;
	int idMontadora;
	int idModulo;
	int dataOs;
	Data dataEntrada;
	Data dataOrcamento;
	Data dataAutorizacao;
	Data dataReparo;
	Data dataGarantia;
	Data anoVeiculo;
	String codidoErro;
	String defeito;
	
	OsCorpo osCorpo;
	
	
	

	public OsCabecalho(int idCliente, int idMontadora, int idModulo, int dataOs, Data dataEntrada, Data dataOrcamento, Data dataAutorizacao, Data dataReparo, Data dataGarantia, Data anoVeiculo,
			String codidoErro, String defeito) {
		super();
		this.idCliente = idCliente;
		this.idMontadora = idMontadora;
		this.idModulo = idModulo;
		this.dataOs = dataOs;
		this.dataEntrada = dataEntrada;
		this.dataOrcamento = dataOrcamento;
		this.dataAutorizacao = dataAutorizacao;
		this.dataReparo = dataReparo;
		this.dataGarantia = dataGarantia;
		this.anoVeiculo = anoVeiculo;
		this.codidoErro = codidoErro;
		this.defeito = defeito;
		}
	
	

	

	public int getIdOs() {
		return idOs;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public int getIdMontadora() {
		return idMontadora;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public int getDataOs() {
		return dataOs;
	}

	public Data getDataEntrada() {
		return dataEntrada;
	}

	public Data getDataOrcamento() {
		return dataOrcamento;
	}

	public Data getDataAutorizacao() {
		return dataAutorizacao;
	}

	public Data getDataReparo() {
		return dataReparo;
	}

	public Data getDataGarantia() {
		return dataGarantia;
	}

	public Data getAnoVeiculo() {
		return anoVeiculo;
	}

	public String getCodidoErro() {
		return codidoErro;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setIdOs(int idOs) {
		this.idOs = idOs;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdMontadora(int idMontadora) {
		this.idMontadora = idMontadora;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public void setDataOs(int dataOs) {
		this.dataOs = dataOs;
	}

	public void setDataEntrada(Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setDataOrcamento(Data dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public void setDataAutorizacao(Data dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public void setDataReparo(Data dataReparo) {
		this.dataReparo = dataReparo;
	}

	public void setDataGarantia(Data dataGarantia) {
		this.dataGarantia = dataGarantia;
	}

	public void setAnoVeiculo(Data anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public void setCodidoErro(String codidoErro) {
		this.codidoErro = codidoErro;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	
	
}
