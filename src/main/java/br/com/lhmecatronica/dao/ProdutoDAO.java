package br.com.lhmecatronica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;

import br.com.lhmecatronica.persistencia.Produto;
import br.com.lhmecatronica.util.GenericoDAO;

/**
 *
 * @author anchite
 */
public class ProdutoDAO extends GenericoDAO {

	ResultSet rs1 = null;
	Statement stm1 = null;
	int linhaProduto = 0;
	static int linhaFiltro = 0;
	int maxProduto = 0;
	List<Produto> produtos;
	String SQL;
	int novo = 0;
	

	private static ProdutoDAO instance = null;

	private ProdutoDAO() {
	}

	public static ProdutoDAO getInstance() {
		if (instance == null) {
			System.out.println("Instancia de ClienteDao foi Criada");
			instance = new ProdutoDAO();
		}
		return instance;
	}

	public static void enfInstance() {
		instance = null;
	}

	public Produto pesquisaID(Produto mod) throws SQLException {
		String sql = "select * from produto where ID = " + mod.getId() + "";
		try (ResultSet rs = executaSQL(sql)) {
			rs.first();
			mod.setCodigo(rs.getInt("CODIGO"));
			mod.setDescricao(rs.getString("DESCRICAO"));
			mod.setSubGrupo_ID(rs.getInt("SUBGRUPO_ID"));
			mod.setAplicacao(rs.getString("APLICACAO"));
			mod.setUndComercial(rs.getString("UND_COMERCIAL"));
			mod.setUnd_Tributavel(rs.getString("UND_TRIBUTAVEL"));
			mod.setNcm(rs.getString("NCM"));
			mod.setCfop(rs.getInt("CFOP"));
			mod.setGtin(rs.getString("GTIN"));
			mod.setGtinUnidadeTributavel(rs.getString("GTINUNIDADETRIBUTAVEL"));
			mod.setImagem(rs.getString("IMAGEM"));
			mod.setPRECO_VENDA(rs.getBigDecimal("PRECO_VENDA"));
			mod.setCSOSN(rs.getString("CSOSN"));
			return mod;
		}
	}

	public List<Produto> pesquisaProduto(String SQL) throws SQLException {
		List<Produto> lista = new ArrayList<>();
		try (ResultSet rs = executaSQL(SQL);) {
			while (rs.next()) {
				lista.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(8)));
			}
			return lista;
		}
	}

	

	public void PesquisaUltimo(Produto produto) {
		try {
			ResultSet rs = executaSQL("select * from produto order by CFOP");
			produto.setCodigo(rs.getInt(1));
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	

	
}
