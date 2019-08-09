package br.com.lhmecatronica.persistencia;

import java.math.BigDecimal;

import br.com.lhmecatronica.util.ColunaGrid;

public class Componente{

int	idComponente;
int	idEncapsulamento;
int	idTipoComponente;
int	idFabricante;
int	idSimilaridade;
String	CodigoComponente;
String	Descricao;
String Fabricante;
String Encapsulamento;
int	Gaveta;
int	Divisao;
int	Equivalente;
BigDecimal	PrecoCompra;
BigDecimal	PrecoVenda;


public Componente(String codigoComponente, String descricao, String fabricante, String encapsulamento, int equivalente, int gaveta, int divisao, BigDecimal precoCompra, BigDecimal precoVenda) {
	
	CodigoComponente = codigoComponente;
	Descricao = descricao;
	Fabricante = fabricante;
	Encapsulamento = encapsulamento;
	Gaveta = gaveta;
	Divisao = divisao;
	Equivalente = equivalente;
	PrecoCompra = precoCompra;
	PrecoVenda = precoVenda;
}

public Componente() {
	// TODO Auto-generated constructor stub
}

public int getIdComponente() {
	return idComponente;
}

public void setIdComponente(int idComponente) {
	this.idComponente = idComponente;
}

public int getIdEncapsulamento() {
	return idEncapsulamento;
}
public int getIdTipoComponente() {
	return idTipoComponente;
}
public int getIdFabricante() {
	return idFabricante;
}
public int getIdSimilaridade() {
	return idSimilaridade;
}
public String getCodigoComponente() {
	return CodigoComponente;
}
public String getDescricao() {
	return Descricao;
}
public String getFabricante() {
	return Fabricante;
}
public String getEncapsulamento() {
	return Encapsulamento;
}
public int getGaveta() {
	return Gaveta;
}
public int getDivisao() {
	return Divisao;
}
public int getEquivalente() {
	return Equivalente;
}
public BigDecimal getPrecoCompra() {
	return PrecoCompra;
}
public BigDecimal getPrecoVenda() {
	return PrecoVenda;
}
public void setIdEncapsulamento(int idEncapsulamento) {
	this.idEncapsulamento = idEncapsulamento;
}
public void setIdTipoComponente(int idTipoComponente) {
	this.idTipoComponente = idTipoComponente;
}
public void setIdFabricante(int idFabricante) {
	this.idFabricante = idFabricante;
}
public void setIdSimilaridade(int idSimilaridade) {
	this.idSimilaridade = idSimilaridade;
}
public void setCodigoComponente(String codigoComponente) {
	CodigoComponente = codigoComponente;
}
public void setDescricao(String descricao) {
	Descricao = descricao;
}
public void setFabricante(String fabricante) {
	Fabricante = fabricante;
}
public void setEncapsulamento(String encapsulamento) {
	Encapsulamento = encapsulamento;
}
public void setGaveta(int gaveta) {
	Gaveta = gaveta;
}
public void setDivisao(int divisao) {
	Divisao = divisao;
}
public void setEquivalente(int equivalente) {
	Equivalente = equivalente;
}
public void setPrecoCompra(BigDecimal precoCompra) {
	PrecoCompra = precoCompra;
}
public void setPrecoVenda(BigDecimal precoVenda) {
	PrecoVenda = precoVenda;
}


}
