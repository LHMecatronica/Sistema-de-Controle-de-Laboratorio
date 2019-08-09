package br.com.lhmecatronica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lhmecatronica.util.GenericoDAO;

/**
 *
 * @author anchite
 * 
 */
public class NavegadorDAO extends GenericoDAO {
	//String SQL = "SELECT * FROM CLIENTE ";
	ResultSet resultset;
	List<String> ret = new ArrayList<>();
	List<List<String>> result = new ArrayList<>();
	int linhaAtual, totalDeLinhas = 0;

	public List<String> listar(String SQL){
		try {
			result.clear();
			resultset = executaSQL(SQL);
			int numcols = resultset.getMetaData().getColumnCount();
			linhaAtual = 0;

			while (resultset.next()) {
				List<String> row = new ArrayList<>(numcols); // new list per row

				for (int i = 1; i <= numcols; i++) { // don't skip the last column, use <=
					row.add(resultset.getString(i));
				}
				result.add(row); // add it to the result
			}
			// ret = new ArrayList<String>();
			totalDeLinhas = result.size();
			ret = result.get(0);

			System.out.print(ret);
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<String> Proxima(){
		ret = result.get(linhaAtual += 1);
		System.out.print(ret);
		return ret;
	}
	
	public List<String> Anterior(){
		ret = result.get(linhaAtual -= 1);
		System.out.print(ret);
		return ret;
	}
	
	public List<String> Ultimo(){
		linhaAtual=totalDeLinhas-1;
		ret = result.get(linhaAtual);
		System.out.print(ret);
		return ret;
	}
}
