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
import br.com.lhmecatronica.persistencia.Componente;
import br.com.lhmecatronica.persistencia.Fabricante;
import br.com.lhmecatronica.persistencia.cmbMontadora;
import br.com.lhmecatronica.util.GenericoDAO;

public class ComponenteDao extends GenericoDAO {

	ResultSet rs;
	PreparedStatement stm1;
	ResultSet rs1;

	private Componente componente;
	private int linhaProduto;
	private int maxProduto;
	private List<Componente> listaComponentes = new ArrayList<>();

	private static ComponenteDao instance = null;

	
    public Vector<String> Fabricantes() {
		
		Vector<String> fab = new Vector<String>();
		ResultSet rs = executaSQL("select * from componente group by _Fabricante");
		try {
			while (rs.next()) {
				fab.addElement(rs.getString("_Fabricante"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fab;
		
	}
    
    
 public Vector<String> Ecapsulamento() {
		
		Vector<String> fab = new Vector<String>();
		ResultSet rs = executaSQL("select _Encapsulamento from componente group by _Encapsulamento");
		try {
			while (rs.next()) {
				fab.addElement(rs.getString("_Encapsulamento"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fab;
		
	}
    

    public Vector<String> Descricao() {
		
		Vector<String> fab = new Vector<String>();
		ResultSet rs = executaSQL("select * from componente group by _Descricao");
		try {
			while (rs.next()) {
				fab.addElement(rs.getString("_Descricao"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fab;
		
	}
	
	
	public ResultSet listar(String SQL) {
		
			return rs = executaSQL(SQL);
	}

	public static ComponenteDao getInstance() {
		if (instance == null) {
			instance = new ComponenteDao();
		}
		return instance;
	}

	public Componente primeiro(String SQL) {
		listaComponentes = new ArrayList<Componente>();
		try {
			rs1 = executaSQL(SQL);
			while (rs1.next()) {
				listaComponentes.add(new Componente());
			}
			linhaProduto = 0;
			maxProduto = listaComponentes.size();
			return listaComponentes.get(linhaProduto);
		} catch (SQLException ex) {
			Logger.getLogger(ComponenteGUI.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public Componente Refresh(String SQL) {
		listaComponentes = new ArrayList<Componente>();
		try {
			rs1 = executaSQL(SQL);
			while (rs1.next()) {
				listaComponentes.add(new Componente());
			}
			maxProduto = listaComponentes.size();
			return listaComponentes.get(linhaProduto);
		} catch (SQLException ex) {
			Logger.getLogger(ComponenteGUI.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public Componente proximo() {
		if (linhaProduto < maxProduto) {
			return componente = listaComponentes.get(linhaProduto += 1);
		} else {
			return componente = listaComponentes.get(linhaProduto);
		}
	}

	public Componente anterior() {
		if (linhaProduto > 0) {
			return componente = listaComponentes.get(linhaProduto -= 1);
		} else {
			return componente = listaComponentes.get(linhaProduto);
		}
	}

	public Componente ultimo() {
		linhaProduto = maxProduto - 1;
		return componente = listaComponentes.get(linhaProduto);
	}

	public int getMaxProduto() {
		return maxProduto;
	}

	public int getLinhaProduto() {
		return linhaProduto;
	}

}
