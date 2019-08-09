package br.com.lhmecatronica.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author anchite
 */
public class GenericoDAO extends Conexao {
	Connection conexao;
	public boolean resultado = false;
	ResultSet rs;
	// public List<Sabor> sabores;
	// public List<SaborIngrediente> lista;
	// Sabor sabor = new Sabor();

	public GenericoDAO() {

	}

	public void perssitencia(String SQL, Object... params) throws SQLException {
		beginTransaction();
		PreparedStatement pstmt = null;
		conexao = getConnectionFromContext();
		pstmt = conexao.prepareStatement(SQL);
		int i = 0;
		for (Object obje : params) {
			pstmt.setObject(++i, obje);
		}
		pstmt.executeUpdate();
	
	}

	public int perssitenciaGeradorID(String SQL, Object... params) throws SQLException {
		int id = 0;
		beginTransaction();
		PreparedStatement pstmt = null;
		conexao = getConnectionFromContext();
		pstmt = conexao.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
		int i = 0;
		for (Object obje : params) {
			pstmt.setObject(++i, obje);
		}
		pstmt.executeUpdate();

		ResultSet rset = pstmt.getGeneratedKeys();

		if (rset.next()) {
			id = rset.getInt(1);
		}
		return id;
	}

	public ResultSet executaSQL(String sql) {
		try {
			beginTransaction();
			conexao = getConnectionFromContext();
			Statement stm = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro RS", "erro conexão", 0);
		}
		return rs;
	}

	public <T> List<T> geradorListaGenerico(String query, QueryMapper<T> mapper) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		List<T> list = new ArrayList<T>();

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = mapper.mapping(rset);
		} finally {
			releaseAll(conn, stmt, rset);
		}

		return list;

	}

}