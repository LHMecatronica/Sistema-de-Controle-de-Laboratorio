package br.com.lhmecatronica.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.lhmecatronica.util.ColunaGrid;

/**
 *
 * @author anchite
 */
public class Bairro implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@ColunaGrid(nome = "Id", largura = 60)
	private Integer id;

	@ColunaGrid(nome = "Bairro", largura = 250)
	private String nomeBairro;

	@ColunaGrid(nome = "TX. Entrega", largura = 100, podeEditar = true)
	private BigDecimal txEntrega;

	@ColunaGrid(nome = "Apagar", largura = 50,podeEditar = true)
	String delete;

	@ColunaGrid(nome = "Editar", largura = 50,podeEditar = true)
	String editar;

	public Bairro() {
	}

	public Bairro(Integer id, String nomeBairro, BigDecimal txEntrega) {
		this.id = id;
		this.nomeBairro = nomeBairro;
		this.txEntrega = txEntrega;
	}

	public Bairro(Integer id, String nomeBairro) {
		this.id = id;
		this.nomeBairro = nomeBairro;
	}

	public String getEditar() {
		return editar;
	}

	public void setEditar(String editar) {
		this.editar = editar;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public BigDecimal getTxEntrega() {
		return txEntrega;
	}

	public void setTxEntrega(BigDecimal txEntrega) {
		this.txEntrega = txEntrega;
	}

	public String toString() {
		return id +" - " + nomeBairro;
	}

	
}
