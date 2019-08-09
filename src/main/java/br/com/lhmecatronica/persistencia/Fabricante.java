package br.com.lhmecatronica.persistencia;

public class Fabricante {
	
	int id;
	String _Descricao;
	
	
	
	
	public Fabricante(String _Descricao) {
		super();
		this._Descricao = _Descricao;
	}
	public int getId() {
		return id;
	}
	public String get_Descricao() {
		return _Descricao;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void set_Descricao(String _Descricao) {
		this._Descricao = _Descricao;
	}
	@Override
	public String toString() {
		return  _Descricao;
	}
	

}
