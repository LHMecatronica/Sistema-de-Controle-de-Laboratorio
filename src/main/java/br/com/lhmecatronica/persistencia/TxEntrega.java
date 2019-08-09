package br.com.lhmecatronica.persistencia;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.lhmecatronica.util.ColunaGrid;

/**
 *
 * @author anchite
 */
public class TxEntrega implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @ColunaGrid(nome = "Id", largura = 10)
    Integer id;
    BigDecimal valor;

    public TxEntrega() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public BigDecimal getValor() {
	return valor;
    }

    public void setValor(BigDecimal valor) {
	this.valor = valor;
    }

}
