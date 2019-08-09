package br.com.lhmecatronica.persistencia;

import java.io.Serializable;

import br.com.lhmecatronica.util.ColunaGrid;

/**
 *
 * @author anchite
 */
public class Cliente implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    @ColunaGrid(nome = "Id", largura = 10)
    private Integer id;
    private Integer idBairro;
    private String cpf;
    @ColunaGrid(nome = "Nome", largura = 255)
    private String nome;
    private String cep;
    private String logradouro;
    private String nr;
    private String complemento;
    private String cidade;
    private String uf;
    private String pais;
    private String DDD;
    private String fixo;
    private String celular;
    private String email;
    private Bairro bairro;
    private TxEntrega txEntrega;

    public Bairro getBairro() {
	return bairro;
    }

    public void setBairro(Bairro bairro) {
	this.bairro = bairro;
    }

    public TxEntrega getTxEntrega() {
	return txEntrega;
    }

    public void setTxEntrega(TxEntrega txEntrega) {
	this.txEntrega = txEntrega;
    }

    public Cliente() {
    }

    public Cliente(Integer id, String nome) {
	this.id = id;
	this.nome = nome;
    }

    public Cliente(Integer id, String nome, String logradouro, String nr) {
	this.id = id;
	this.nome = nome;
	this.logradouro = logradouro;
	this.nr = nr;
    }

    public Integer getIdBairro() {
	return idBairro;
    }

    public void setIdBairro(Integer idBairro) {
	this.idBairro = idBairro;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCep() {
	return cep;
    }

    public void setCep(String cep) {
	this.cep = cep;
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

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf;
    }

    public String getPais() {
	return pais;
    }

    public void setPais(String pais) {
	this.pais = pais;
    }

    public String getFixo() {
	return fixo;
    }

    public void setFixo(String fixo) {
	this.fixo = fixo;
    }

    public String getCelular() {
	return celular;
    }

    public void setCelular(String celular) {
	this.celular = celular;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getDDD() {
	return DDD;
    }

    public void setDDD(String dDD) {
	DDD = dDD;
    }

}
