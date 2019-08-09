package br.com.lhmecatronica.persistencia;

import java.math.BigDecimal;

import br.com.lhmecatronica.util.ColunaGrid;

public class PesquisaClienteEntrega {

    @ColunaGrid(nome = "Id", largura = 40)
    Integer id;
    Integer idBairro;
    @ColunaGrid(nome = "Nome", largura = 280)
    String nome;
    @ColunaGrid(nome = "CPF", largura = 150)
    String CPF;
    String logradouro;
    String nr;
    String nomeBairro;
    @ColunaGrid(nome = "Contato", largura = 120)
    String contato;
    @ColunaGrid(nome = "Taxa", largura = 60)
    BigDecimal taxa;

    public PesquisaClienteEntrega(Integer id, String nome, String logradouro, String nr, String nomeBairro,
	    String contato, BigDecimal taxa) {
	super();
	this.id = id;
	this.nome = nome;
	this.logradouro = logradouro;
	this.nr = nr;
	this.nomeBairro = nomeBairro;
	this.contato = contato;
	this.taxa = taxa;
    }

    public PesquisaClienteEntrega() {
	// TODO Auto-generated constructor stub
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getIdBairro() {
	return idBairro;
    }

    public void setIdBairro(Integer idBairro) {
	this.idBairro = idBairro;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getLogradouro() {
	return logradouro;
    }

    public void setLogradouro(String logradouro) {
	this.logradouro = logradouro;
    }

    public String getNr() {
	return nr;
    }

    public void setNr(String nr) {
	this.nr = nr;
    }

    public String getNomeBairro() {
	return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
	this.nomeBairro = nomeBairro;
    }

    public String getContato() {
	return contato;
    }

    public void setContato(String contato) {
	this.contato = contato;
    }

    public BigDecimal getTaxa() {
	return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
	this.taxa = taxa;
    }

    public String getCPF() {
	return CPF;
    }

    public void setCPF(String cPF) {
	CPF = cPF;
    }
}
