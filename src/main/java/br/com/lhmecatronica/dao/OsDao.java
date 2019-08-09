package br.com.lhmecatronica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


import br.com.lhmecatronica.gui.ComponenteGUI;
import br.com.lhmecatronica.persistencia.Cliente;
import br.com.lhmecatronica.persistencia.Componente;
import br.com.lhmecatronica.persistencia.Montadora;
import br.com.lhmecatronica.persistencia.OsCorpo;
import br.com.lhmecatronica.persistencia.cmbModelo;
import br.com.lhmecatronica.persistencia.cmbMontadora;
import br.com.lhmecatronica.util.GenericoDAO;

public class OsDao extends GenericoDAO {

	ResultSet rs;
	PreparedStatement stm1;
	ResultSet rs1;

	private OsCorpo osCorpo;
	private int linhaProduto;
	private int maxProduto;
	private List<OsCorpo> listaOS;

	private static OsDao instance = null;

	public ResultSet listarCliente(String SQL) {

			rs1 = executaSQL(SQL);
			return rs1;
	}
	
	public ResultSet listarComponentes(String SQL) {

		rs1 = executaSQL(SQL);
		return rs1;
}

	public Vector<cmbMontadora> veiculoMontadora() {
		
		Vector<cmbMontadora> grupos = new Vector<cmbMontadora>();
		ResultSet rs = executaSQL("select * from Montadora group by _montadora");
		try {
			while (rs.next()) {
				cmbMontadora obj = new cmbMontadora(rs.getString("_montadora"));
				grupos.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grupos;
		
	}
	
   public Vector<cmbModelo> veiculoModelo(String SQL) {
		
		Vector<cmbModelo> grupos = new Vector<cmbModelo>();
		ResultSet rs = executaSQL(SQL);
		try {
			while (rs.next()) {
				cmbModelo obj = new cmbModelo(rs.getString("_modelo"));
				grupos.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grupos;
		
	}
	

	public static OsDao getInstance() {
		if (instance == null) {
			instance = new OsDao();
		}
		return instance;
	}

	public OsCorpo primeiro(String SQL) {
		listaOS = new ArrayList<OsCorpo>();
		try {
			rs1 = executaSQL(SQL);
			while (rs1.next()) {
				listaOS.add(new OsCorpo());
			}
			linhaProduto = 0;
			maxProduto = listaOS.size();
			return listaOS.get(linhaProduto);
		} catch (SQLException ex) {
			Logger.getLogger(ComponenteGUI.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public OsCorpo Refresh(String SQL) {
		listaOS = new ArrayList<OsCorpo>();
		try {
			rs1 = executaSQL(SQL);
			while (rs1.next()) {
				listaOS.add(new OsCorpo());
			}
			maxProduto = listaOS.size();
			return listaOS.get(linhaProduto);
		} catch (SQLException ex) {
			Logger.getLogger(ComponenteGUI.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public OsCorpo proximo() {
		if (linhaProduto < maxProduto) {
			return osCorpo = listaOS.get(linhaProduto += 1);
		} else {
			return osCorpo = listaOS.get(linhaProduto);
		}
	}

	public OsCorpo anterior() {
		if (linhaProduto > 0) {
			return osCorpo = listaOS.get(linhaProduto -= 1);
		} else {
			return osCorpo = listaOS.get(linhaProduto);
		}
	}

	public OsCorpo ultimo() {
		linhaProduto = maxProduto - 1;
		return osCorpo = listaOS.get(linhaProduto);
	}

	public int getMaxProduto() {
		return maxProduto;
	}

	public int getLinhaProduto() {
		return linhaProduto;
	}

}
