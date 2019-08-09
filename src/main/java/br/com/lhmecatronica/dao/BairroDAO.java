package br.com.lhmecatronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import br.com.lhmecatronica.persistencia.Bairro;
import br.com.lhmecatronica.util.GenericoDAO;

public class BairroDAO extends GenericoDAO{
    public Vector<Bairro> pesquisaBairro() throws SQLException {
	Vector<Bairro> bairros = new Vector<Bairro>();
	beginTransaction(); 
	Connection conectar = getConnection();
     PreparedStatement stmt = conectar.prepareStatement("select * from bairro order by NOME_BAIRRO");
     ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
	    Bairro obj = new Bairro(rs.getInt("ID"), rs.getString("NOME_BAIRRO"));
	    bairros.add(obj);
	}
	return bairros;
    }

}
