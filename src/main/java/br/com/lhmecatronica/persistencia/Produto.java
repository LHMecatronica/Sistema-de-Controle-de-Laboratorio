package br.com.lhmecatronica.persistencia;

import java.math.BigDecimal;

import br.com.lhmecatronica.util.ColunaGrid;

/**
 * @author anchite
 */
public class Produto {

    private Integer id;
    @ColunaGrid(nome = "Id", largura = 30)
    private String idItem;
    @ColunaGrid(nome = "Descrição do produto", largura = 350)
    private String descricao;
    private Integer codigo;
    private Integer subGrupoID;
    private String aplicacao;
    private String undComercial;
    @ColunaGrid(nome = "Unid", largura = 30)
    private String und_Tributavel;
    private String ncm;
    private Integer cfop;
    private String gtin;
    private String gtinUnidadeTributavel;
    private String imagem;
    private BigDecimal MARGEM;
    private BigDecimal PRECO_VENDA;
    private BigDecimal QTD_COMPRA;
    private String ACAO;
    private String CSOSN;
    private int idFamilia;
    private String nomeFamila;
    private String undadeFamilia;
    private String tipoPDV;
    private int PDV;

    

    public Produto(Integer id, Integer codigo, String descricao) {
	this.id = id;
	this.codigo = codigo;
	this.descricao = descricao;
    }

    public Produto(Integer id, String descricao) {
	this.id = id;
	this.descricao = descricao;
    }

    public Produto(Integer id, String descricao, String und_Tributavel) {
	this.id = id;
	this.descricao = descricao;
	this.und_Tributavel = und_Tributavel;
    }

    public Produto(Integer id, String descricao, String undComercial, BigDecimal PRECO_VENDA) {
	this.id = id;
	this.descricao = descricao;
	this.undComercial = undComercial;
	this.PRECO_VENDA = PRECO_VENDA;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getCodigo() {
	return codigo;
    }

    public void setCodigo(Integer codigo) {
	this.codigo = codigo;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Integer getSubGrupoID() {
	return subGrupoID;
    }

    public void setSubGrupo_ID(Integer subGrupoID) {
	this.subGrupoID = subGrupoID;
    }

    public String getAplicacao() {
	return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
	this.aplicacao = aplicacao;
    }

    public String getUndComercial() {
	return undComercial;
    }

    public void setUndComercial(String undComercial) {
	this.undComercial = undComercial;
    }

    public String getUnd_Tributavel() {
	return und_Tributavel;
    }

    public void setUnd_Tributavel(String und_Tributavel) {
	this.und_Tributavel = und_Tributavel;
    }

    public String getNcm() {
	return ncm;
    }

    public void setNcm(String ncm) {
	this.ncm = ncm;
    }

    public Integer getCfop() {
	return cfop;
    }

    public void setCfop(Integer cfop) {
	this.cfop = cfop;
    }

    public String getGtin() {
	return gtin;
    }

    public void setGtin(String gtin) {
	this.gtin = gtin;
    }

    public String getGtinUnidadeTributavel() {
	return gtinUnidadeTributavel;
    }

    public void setGtinUnidadeTributavel(String gtinUnidadeTributavel) {
	this.gtinUnidadeTributavel = gtinUnidadeTributavel;
    }

    public String getImagem() {
	return imagem;
    }

    public void setImagem(String imagem) {
	this.imagem = imagem;
    }

    public BigDecimal getMARGEM() {
	return MARGEM;
    }

    public void setMARGEM(BigDecimal MARGEM) {
	this.MARGEM = MARGEM;
    }

    public BigDecimal getPRECO_VENDA() {
	return PRECO_VENDA;
    }

    public void setPRECO_VENDA(BigDecimal PRECO_VENDA) {
	this.PRECO_VENDA = PRECO_VENDA;
    }

    public BigDecimal getQTD_COMPRA() {
	return QTD_COMPRA;
    }

    public void setQTD_COMPRA(BigDecimal QTD_COMPRA) {
	this.QTD_COMPRA = QTD_COMPRA;
    }

    public String getACAO() {
	return ACAO;
    }

    public void setACAO(String ACAO) {
	this.ACAO = ACAO;
    }

    public int getPDV() {
	return PDV;
    }

    public void setPDV(int PDV) {
	this.PDV = PDV;
    }

    public String getCSOSN() {
	return CSOSN;
    }

    public void setCSOSN(String CSOSN) {
	this.CSOSN = CSOSN;
    }

    @Override
    public String toString() {
	return id + " - " + descricao + " - " + undComercial;
    }

    public int getIdFamilia() {
	return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
	this.idFamilia = idFamilia;
    }

    public String getNomeFamila() {
	return nomeFamila;
    }

    public void setNomeFamila(String nomeFamila) {
	this.nomeFamila = nomeFamila;
    }

    public String getUndadeFamilia() {
	return undadeFamilia;
    }

    public void setUndadeFamilia(String undadeFamilia) {
	this.undadeFamilia = undadeFamilia;
    }

    public String getTipoPDV() {
	return tipoPDV;
    }

    public void setTipoPDV(String tipoPDV) {
	this.tipoPDV = tipoPDV;
    }

}
