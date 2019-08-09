package br.com.lhmecatronica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.lhmecatronica.persistencia.Bairro;
import br.com.lhmecatronica.persistencia.Cliente;
import br.com.lhmecatronica.persistencia.PesquisaClienteEntrega;
import br.com.lhmecatronica.util.GenericoDAO;

/**
 * @author anchite
 * Sistema de Controle de laboratório
 */

public class ClienteDAO extends GenericoDAO {
	// List<PesquisaClienteEntrega> listaClientesEntregas;
	// PesquisaClienteEntrega pesquisaClienteEntrega;

	Cliente cliente;
	List<Cliente> clientes;
	int linhaFiltro, linhaCliente, maxCliente;
	String SQL;
	Statement stm;
	ResultSet rs;
	GenericoDAO genericoDAO = null;

	private static ClienteDAO instance = null;

	private ClienteDAO() {
		genericoDAO = new GenericoDAO();

	}

	public static ClienteDAO getInstance() {
		if (instance == null) {
			System.out.println("Instancia de ClienteDao foi Criada");
			instance = new ClienteDAO();
		}
		return instance;
	}

	public static void enfInstance() {
		instance = null;
	}

	public Cliente primeiro(boolean vaiParaPrimeniroRegistro) {
		clientes = new ArrayList<>();
		try {
			String sql = "SELECT * FROM CLIENTE inner join BAIRRO" + " on CLIENTE.ID_BAIRRO = BAIRRO.ID";
			beginTransaction();
			ResultSet rs = executaSQL(sql);
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("CLIENTE.ID"));
				cliente.setIdBairro(rs.getInt("CLIENTE.ID_BAIRRO"));
				cliente.setCpf(rs.getString("CLIENTE.CPF"));
				cliente.setNome(rs.getString("CLIENTE.NOME"));
				cliente.setCep(rs.getString("CLIENTE.CEP"));
				cliente.setLogradouro(rs.getString("CLIENTE.LOGRADOURO"));
				cliente.setNr(rs.getString("CLIENTE.NR"));
				cliente.setComplemento(rs.getString("CLIENTE.COMPLEMENTO"));
				cliente.setCidade(rs.getString("CLIENTE.CIDADE"));
				cliente.setUf(rs.getString("CLIENTE.UF"));
				cliente.setPais(rs.getString("CLIENTE.PAIS"));
				cliente.setFixo(rs.getString("CLIENTE.FIXO"));
				cliente.setEmail(rs.getString("CLIENTE.EMAIL"));
				Bairro bairro = new Bairro();
				bairro.setId(rs.getInt("BAIRRO.ID"));
				bairro.setNomeBairro(rs.getString("BAIRRO.NOME_BAIRRO"));
				cliente.setBairro(bairro);
				clientes.add(cliente);
			}
			if (vaiParaPrimeniroRegistro == true) {
				linhaCliente = 0;
			}
			maxCliente = clientes.size();
			return clientes.get(linhaCliente);
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public Cliente proximo() {
		if (linhaCliente <= maxCliente - 1) {
			return cliente = clientes.get(linhaCliente += 1);
		} else {
			JOptionPane.showMessageDialog(null, "Este é o Último Registro", "Navegação Registros de Clientes",
					maxCliente, null);
			return cliente = clientes.get(linhaCliente);
		}
	}

	public Cliente anterior() {
		if (linhaCliente > 0) {
			return cliente = clientes.get(linhaCliente -= 1);
		} else {
			JOptionPane.showMessageDialog(null, "Este é o Primeiro Registro", "Navegação Registros de Clientes",
					maxCliente, null);
			return cliente = clientes.get(linhaCliente);
		}
	}

	public Cliente ultimo() {
		linhaCliente = maxCliente - 1;
		return cliente = clientes.get(linhaCliente);
	}

	public Cliente pesquisaID(Cliente mod) {
		String sql = "SELECT"
				+ " cliente.ID,"
				+ "cliente.CPF,"
				+ " cliente.NOME,"
				+ " cliente.CEP,"
				+ " cliente.LOGRADOURO,"
				+ " cliente.NR,"
				+ " cliente.COMPLEMENTO,"
				+ " cliente.CIDADE,"
				+ " cliente.FIXO,"
				+ " bairro.NOME_BAIRRO,"
				+ " bairro.TX_ENTREGA"
				+ " FROM cliente inner join bairro on cliente.ID_BAIRRO = bairro.ID"
				//+ " inner join tx_entrega on bairro.TX_ENTREGA = tx_entrega.ID"
				+ " where cliente.ID = "+mod.getId();
		try {
			beginTransaction();
			ResultSet rs = executaSQL(sql);
			rs.first();
			//mod.setId(rs.getInt(0));
			mod.setCpf(rs.getString(2));
			mod.setNome(rs.getString(3));
			mod.setCep(rs.getString(4));
			mod.setLogradouro(rs.getString(5));
			mod.setNr(rs.getString(6));
			mod.setComplemento(rs.getString(7));
			mod.setCidade(rs.getString(8));
			mod.setFixo(rs.getString(9));
			
			//mod.setUf(rs.getString("cliente.UF"));
			//mod.setPais(rs.getString("cliente.PAIS"));
			Bairro bairro = new Bairro();
			bairro.setNomeBairro(rs.getString(10));
			bairro.setTxEntrega(rs.getBigDecimal(11));
			mod.setBairro(bairro);
			

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro buscar Id do Cliente", "erro conexão", 0);
		}
		return mod;
	}

	public List<PesquisaClienteEntrega> pesquisaCliente(String sql) throws SQLException {
		List<PesquisaClienteEntrega> lista = new ArrayList<>();
		beginTransaction();
		ResultSet rs = executaSQL(sql);
		while (rs.next()) {
			lista.add(new PesquisaClienteEntrega(rs.getInt("cliente.ID"), rs.getString("cliente.nome"),
					rs.getString("cliente.logradouro"), rs.getString("cliente.nr"), rs.getString("bairro.nome_bairro"),
					rs.getString("cliente.fixo"), rs.getBigDecimal("tx_entrega")));
		}
		return lista;
	}
}
