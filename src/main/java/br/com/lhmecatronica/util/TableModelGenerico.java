/*
 */
package br.com.lhmecatronica.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelGenerico<T> extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<T> linhas;
    private final String[] colunas;
    private final String[] atributos;
    private final boolean[] podeEditar;
    private final Class[] classeParametro;
    private final String[] metodoGet;

    public TableModelGenerico(T bean) {
	this.linhas = new ArrayList<>();

	Field fields[] = bean.getClass().getDeclaredFields();
	int nrColunas = 0;
	for (Field f : fields) {
	    if (f.isAnnotationPresent(ColunaGrid.class)) {
		nrColunas++;
	    }
	}

	this.colunas = new String[nrColunas];
	this.atributos = new String[nrColunas];
	this.podeEditar = new boolean[nrColunas];
	this.classeParametro = new Class[nrColunas];
	this.metodoGet = new String[nrColunas];

	int indiceColuna = 0;
	for (Field f : fields) {
	    if (f.isAnnotationPresent(ColunaGrid.class)) {
		ColunaGrid m = f.getAnnotation(ColunaGrid.class);
		if (m.mostraColuna()) {
		    if (m.nome().equals("")) {
			this.colunas[indiceColuna] = f.getName();
		    } else {
			this.colunas[indiceColuna] = m.nome();
		    }
		    this.atributos[indiceColuna] = f.getName();
		    this.podeEditar[indiceColuna] = m.podeEditar();
		    this.classeParametro[indiceColuna] = f.getType();
		    if (m.metodoGet().equals("")) {
			this.metodoGet[indiceColuna] = "get" + Biblioteca.primeiraMaiuscula(atributos[indiceColuna]);
		    } else {
			this.metodoGet[indiceColuna] = m.metodoGet();
		    }
		    indiceColuna++;
		}
	    }
	}
    }

    @Override
    public int getRowCount() {
	return linhas.size();
    }

    @Override
    public int getColumnCount() {
	return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
	return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
	return classeParametro[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	try {
	    T obj = linhas.get(rowIndex);
	    return getMetodo(obj, this.metodoGet[columnIndex]);
	} catch (Exception ex) {
	    return null;
	}
    }

    private Object getMetodo(Object obj, String nomeMetodo) throws Exception {
	String metodos[] = nomeMetodo.split("\\.");
	if (metodos.length == 1) {
	    Method metodo = obj.getClass().getDeclaredMethod(metodos[0]);
	    return metodo.invoke(obj);
	} else {
	    for (String s : metodos) {
		obj = getMetodo(obj, s);
	    }
	}
	return obj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	try {
	    T obj = linhas.get(rowIndex);
	    Method metodo = obj.getClass().getDeclaredMethod(
		    "set" + Biblioteca.primeiraMaiuscula(atributos[columnIndex]), classeParametro[columnIndex]);
	    metodo.invoke(obj, aValue);
	} catch (Exception ex) {
	    // ex.printStackTrace();
	}
	fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	return podeEditar[columnIndex];
    }

    public List<T> getValues() {
	return linhas;
    }

    public void setValues(List<T> linhas) {
	this.linhas = linhas;
	fireTableDataChanged();
    }

    public T getRow(int rowIndex) {
	return linhas.get(rowIndex);
    }

    public void setRow(T campo, int rowIndex) {
	linhas.set(rowIndex, campo);
	fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void adicionaRegistro(T campo) {
	linhas.add(campo);
	fireTableRowsInserted(linhas.size() - 1, linhas.size() - 1);
    }

    public void removeRegistro(int rowIndex) {
	linhas.remove(rowIndex);
	fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void limpaRegistros() {
	linhas.clear();
	fireTableDataChanged();
    }

    public void setValues(Object compras) {
	throw new UnsupportedOperationException("Not supported yet."); // To
								       // change
								       // body
								       // of
								       // generated
								       // methods,
								       // choose
								       // Tools
								       // |
								       // Templates.
    }
}
