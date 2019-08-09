package br.com.lhmecatronica.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import br.com.lhmecatronica.dao.ComponenteDao;
import br.com.lhmecatronica.persistencia.Componente;
import br.com.lhmecatronica.util.Biblioteca;
import br.com.lhmecatronica.util.GenericoDAO;
import net.proteanit.sql.DbUtils;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ListarComponenteGUI extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ComponenteDao dao = new ComponenteDao();
	GenericoDAO DaoGenerico = new GenericoDAO();
	Biblioteca biblioteca = new Biblioteca();
	String SQL;
	Componente componente;
	Boolean edicao=false;
	
	
	public ListarComponenteGUI() {
		
	Tela();
	CamposEdicao(false);
	TelaPrincipal.menu(false);
	CarregaTabela();
	if(tabComponente.getRowCount()>0){
		CarregarTela(0);
	}
		
	}
	

	public void Tela() {
		setPreferredSize(new Dimension(1356, 725));
		setFocusable(false);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setIconifiable(true);
		getContentPane().setBackground(new Color(128, 0, 128));
		setBackground(new Color(169, 169, 169));
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(5, 547, 1342, 168);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtCodigo = new JTextField();
		txtCodigo.setToolTipText("Código Comercial do Componente");
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(79, 11, 123, 32);
		panel.add(txtCodigo);
		txtCodigo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtCodigo.setColumns(10);

		JLabel lblCompCodigo = new JLabel("Codigo :");
		lblCompCodigo.setBackground(new Color(0, 0, 128));
		lblCompCodigo.setOpaque(true);
		lblCompCodigo.setForeground(new Color(255, 255, 0));
		lblCompCodigo.setBounds(12, 6, 199, 42);
		panel.add(lblCompCodigo);
		lblCompCodigo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblCompCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));

		cmbFabricante = new JComboBox();
		cmbFabricante.setEnabled(false);
		cmbFabricante.setBounds(92, 61, 226, 33);
		panel.add(cmbFabricante);
		cmbFabricante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbFabricante.setFont(new Font("Dialog", Font.PLAIN, 14));
		cmbFabricante.setModel(new DefaultComboBoxModel(dao.Ecapsulamento()));
		 		

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setOpaque(true);
		lblFabricante.setBackground(new Color(0, 0, 128));
		lblFabricante.setForeground(new Color(255, 255, 0));
		lblFabricante.setBounds(12, 54, 310, 48);
		panel.add(lblFabricante);
		lblFabricante.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblFabricante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		cmbTipo = new JComboBox();
		cmbTipo.setEnabled(false);
		cmbTipo.setBounds(266, 10, 782, 33);
		panel.add(cmbTipo);
		cmbTipo.setModel(new DefaultComboBoxModel(dao.Descricao()));
		cmbTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		cmbTipo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setOpaque(true);
		lblTipo.setBackground(new Color(0, 0, 128));
		lblTipo.setForeground(new Color(255, 255, 0));
		lblTipo.setBounds(220, 6, 844, 42);
		panel.add(lblTipo);
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTipo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		cmbEncapsulamento = new JComboBox();
		cmbEncapsulamento.setEnabled(false);
		cmbEncapsulamento.setBounds(455, 61, 180, 33);
		panel.add(cmbEncapsulamento);
		cmbEncapsulamento.setModel(new DefaultComboBoxModel(dao.Ecapsulamento()));
		cmbEncapsulamento.setFont(new Font("Dialog", Font.PLAIN, 14));
		cmbEncapsulamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		txtEquivalencia = new JTextField();
		txtEquivalencia.setEnabled(false);
		txtEquivalencia.setEditable(false);
		txtEquivalencia.setBounds(761, 62, 49, 32);
		panel.add(txtEquivalencia);
		txtEquivalencia.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtEquivalencia.setColumns(10);
		txtEquivalencia.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		pnlComandos = new JPanel();
		pnlComandos.setBounds(1100, 11, 234, 144);
		panel.add(pnlComandos);
		pnlComandos.setLayout(null);
		
				btnSair = new JButton("");
				btnSair.setBounds(6, 12, 70, 54);
				pnlComandos.add(btnSair);
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							TelaPrincipal.menu(true);
							ListarComponenteGUI.this.dispose();
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				btnSair.setIcon(new ImageIcon(ListarComponenteGUI.class.getResource("/imagem/botoes/navegacao/sair.gif")));
				btnSair.setToolTipText("Fechar Tela");
				
						btnSalvar = new JButton("");
						btnSalvar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								PersistenciCarrega();
								Grava();
								CarregaTabela();
								CarregarTela(0);
								CamposEdicao(false);
							}
						});
						btnSalvar.setBounds(82, 12, 70, 54);
						pnlComandos.add(btnSalvar);
						btnSalvar.setIcon(new ImageIcon(ListarComponenteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Save.png")));
						btnSalvar.setToolTipText("Salvar");
						
						JButton button_4 = new JButton("");
						button_4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								edicao=false;
								CamposEdicao(true);
								LimparCampos();
								txtCodigo.requestFocus();
							}
						});
						button_4.setIcon(new ImageIcon(ListarComponenteGUI.class.getResource("/imagem/botoes/navegacao/24x24_ADD.png")));
						button_4.setToolTipText("Incuir novo registro");
						button_4.setBounds(158, 12, 70, 54);
						pnlComandos.add(button_4);
						
						JButton button = new JButton("");
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								edicao=true;
								CamposEdicao(true);
							}
						});
						button.setIcon(new ImageIcon(ListarComponenteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Altera.png")));
						button.setToolTipText("Alterar Registro");
						button.setBounds(6, 78, 70, 54);
						pnlComandos.add(button);
						
						JButton button_1 = new JButton("");
						button_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									int[] RowIndexArray = tabComponente.getSelectedRows();
									
									
									 for ( int i = 0; i < RowIndexArray.length; i++ )
								        {
										 ID = Integer.parseInt(tabComponente.getModel().getValueAt(RowIndexArray[i],0)+"");
										 DaoGenerico.perssitencia("DELETE FROM componente WHERE _idComponente = ?", ID);
								        }
									
									 int escolha = JOptionPane.showConfirmDialog(null,"Confirma a Exclusão?","EXCLUIR",JOptionPane.OK_CANCEL_OPTION);
									 if (escolha == 0){
										 
										 DaoGenerico.endTransaction();
									 }else{
										 DaoGenerico.rollbackTransaction();
									 }
									
									CarregaTabela();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									DaoGenerico.rollbackTransaction();
								}
							}
						});
						button_1.setIcon(new ImageIcon(ListarComponenteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Delete.png")));
						button_1.setToolTipText("Apagar Registro selecionado");
						button_1.setBounds(82, 78, 70, 54);
						pnlComandos.add(button_1);
						
						JButton button_2 = new JButton("");
						button_2.setToolTipText("Fechar Tela");
						button_2.setBounds(158, 78, 70, 54);
						pnlComandos.add(button_2);
						
								JLabel lblEncapsulamento = new JLabel("Encapsulamento:");
								lblEncapsulamento.setOpaque(true);
								lblEncapsulamento.setBackground(new Color(0, 0, 128));
								lblEncapsulamento.setForeground(new Color(255, 255, 0));
								lblEncapsulamento.setBounds(332, 54, 312, 48);
								panel.add(lblEncapsulamento);
								lblEncapsulamento.setFont(new Font("Dialog", Font.PLAIN, 14));
								lblEncapsulamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
								
										JLabel lblCodigoSimilar = new JLabel("Codigo  Similar:");
										lblCodigoSimilar.setOpaque(true);
										lblCodigoSimilar.setBackground(new Color(0, 0, 128));
										lblCodigoSimilar.setForeground(new Color(255, 255, 0));
										lblCodigoSimilar.setBounds(654, 54, 170, 48);
										panel.add(lblCodigoSimilar);
										lblCodigoSimilar.setFont(new Font("Dialog", Font.PLAIN, 14));
										lblCodigoSimilar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										
										cmbGaveta = new JComboBox();
										cmbGaveta.setEditable(true);
										cmbGaveta.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
										cmbGaveta.setFont(new Font("Dialog", Font.PLAIN, 14));
										cmbGaveta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										cmbGaveta.setBounds(896, 61, 49, 33);
										panel.add(cmbGaveta);
										
										JLabel lblGaveta = new JLabel("Gaveta : ");
										lblGaveta.setOpaque(true);
										lblGaveta.setForeground(Color.YELLOW);
										lblGaveta.setFont(new Font("Dialog", Font.PLAIN, 14));
										lblGaveta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										lblGaveta.setBackground(new Color(0, 0, 128));
										lblGaveta.setBounds(834, 54, 123, 48);
										panel.add(lblGaveta);
										
										cmbDivisao = new JComboBox();
										cmbDivisao.setEditable(true);
										cmbDivisao.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
										cmbDivisao.setFont(new Font("Dialog", Font.PLAIN, 14));
										cmbDivisao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										cmbDivisao.setBounds(1031, 62, 59, 33);
										panel.add(cmbDivisao);
										
										JLabel lblDiviso = new JLabel("Divisâo");
										lblDiviso.setOpaque(true);
										lblDiviso.setForeground(Color.YELLOW);
										lblDiviso.setFont(new Font("Dialog", Font.PLAIN, 14));
										lblDiviso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										lblDiviso.setBackground(new Color(0, 0, 128));
										lblDiviso.setBounds(967, 54, 129, 48);
										panel.add(lblDiviso);
										
										txtPrCompra = new JTextField();
										txtPrCompra.setFont(new Font("Dialog", Font.PLAIN, 14));
										txtPrCompra.setColumns(10);
										txtPrCompra.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										txtPrCompra.setBounds(119, 119, 161, 32);
										panel.add(txtPrCompra);
										
										JLabel lblPreoCompra = new JLabel("Preço Compra : ");
										lblPreoCompra.setOpaque(true);
										lblPreoCompra.setForeground(Color.YELLOW);
										lblPreoCompra.setFont(new Font("Dialog", Font.PLAIN, 14));
										lblPreoCompra.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										lblPreoCompra.setBackground(new Color(0, 0, 128));
										lblPreoCompra.setBounds(12, 112, 279, 48);
										panel.add(lblPreoCompra);
										
										txtPrVenda = new JTextField();
										txtPrVenda.setFont(new Font("Dialog", Font.PLAIN, 14));
										txtPrVenda.setColumns(10);
										txtPrVenda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										txtPrVenda.setBounds(405, 121, 161, 32);
										panel.add(txtPrVenda);
										
										JLabel lblPreoVenda = new JLabel("Preço Venda : ");
										lblPreoVenda.setOpaque(true);
										lblPreoVenda.setForeground(Color.YELLOW);
										lblPreoVenda.setFont(new Font("Dialog", Font.PLAIN, 14));
										lblPreoVenda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
										lblPreoVenda.setBackground(new Color(0, 0, 128));
										lblPreoVenda.setBounds(301, 112, 290, 48);
										panel.add(lblPreoVenda);
						
						panel_1 = new JPanel();
						panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						panel_1.setBackground(SystemColor.textHighlight);
						panel_1.setBounds(5, 7, 1342, 529);
						getContentPane().add(panel_1);
						panel_1.setLayout(null);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						scrollPane.setOpaque(false);
						scrollPane.setBounds(4, 69, 1333, 454);
						panel_1.add(scrollPane);
						scrollPane.setBackground(SystemColor.info);
						
						tabComponente = new JTable();
						tabComponente.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								CarregarTela(tabComponente.getSelectedRow());
							}
						});
						tabComponente.setRowHeight(25);
						tabComponente.setFont(new Font("Dialog", Font.PLAIN, 14));
						tabComponente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
						scrollPane.setViewportView(tabComponente);
						
						lblCadastroDeComponentes = new JLabel("Cadastro de Componentes");
						lblCadastroDeComponentes.setHorizontalAlignment(SwingConstants.CENTER);
						lblCadastroDeComponentes.setOpaque(true);
						lblCadastroDeComponentes.setForeground(Color.YELLOW);
						lblCadastroDeComponentes.setFont(new Font("Dialog", Font.PLAIN, 40));
						lblCadastroDeComponentes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						lblCadastroDeComponentes.setBackground(new Color(0, 0, 128));
						lblCadastroDeComponentes.setBounds(4, 11, 1333, 55);
						panel_1.add(lblCadastroDeComponentes);

	} // Fim tela

	
	private void CarregarTela(int i) {
		
		ID = Integer.parseInt(tabComponente.getModel().getValueAt(i,0).toString());
		txtCodigo.setText(tabComponente.getModel().getValueAt(i,1).toString());
		cmbTipo.setSelectedItem(tabComponente.getModel().getValueAt(i,2).toString());
		cmbFabricante.setSelectedItem(tabComponente.getModel().getValueAt(i,3).toString());
		cmbEncapsulamento.setSelectedItem(tabComponente.getModel().getValueAt(i,4).toString());
		cmbGaveta.setSelectedItem(tabComponente.getModel().getValueAt(i,5).toString());
		cmbDivisao.setSelectedItem(tabComponente.getModel().getValueAt(i,6).toString());
		txtPrCompra.setText(tabComponente.getModel().getValueAt(i,7).toString());
		txtPrVenda.setText(tabComponente.getModel().getValueAt(i,8).toString());
		txtEquivalencia.setText(tabComponente.getModel().getValueAt(i,9).toString());
		cmbTipo.setModel(new DefaultComboBoxModel(dao.Descricao()));
		cmbFabricante.setModel(new DefaultComboBoxModel(dao.Fabricantes()));
		cmbEncapsulamento.setModel(new DefaultComboBoxModel(dao.Ecapsulamento()));
		
		
	}
	
	protected void CamposEdicao(boolean b) {
		txtCodigo.setEditable(b);
		txtCodigo.setEnabled(b);
		cmbTipo.setEditable(b);
		cmbTipo.setEnabled(b);
		cmbEncapsulamento.setEditable(b);
		cmbEncapsulamento.setEnabled(b);
		cmbFabricante.setEditable(b);
		cmbFabricante.setEnabled(b);
		txtEquivalencia.setEditable(b);
		txtEquivalencia.setEnabled(b);
		cmbGaveta.setEditable(b);
		cmbGaveta.setEnabled(b);
		cmbDivisao.setEditable(b);
		cmbDivisao.setEnabled(b);
		txtPrCompra.setEditable(b);
		txtPrCompra.setEnabled(b);
		txtPrVenda.setEditable(b);
		txtPrVenda.setEnabled(b);
		
		
	}
	
	protected void PersistenciCarrega() {
		
		
		componente = new Componente(
				txtCodigo.getText(),
				cmbTipo.getSelectedItem()+"",
				cmbFabricante.getSelectedItem()+"",
				cmbEncapsulamento.getSelectedItem()+"",
				Integer.parseInt(txtEquivalencia.getText()+""),
				Integer.parseInt(cmbGaveta.getSelectedIndex()+""),
				Integer.parseInt(cmbDivisao.getSelectedIndex()+""),
				biblioteca.formataToBigDecimal(biblioteca.trocarVirgulaPorPonto(txtPrCompra.getText())+""),
				biblioteca.formataToBigDecimal(biblioteca.trocarVirgulaPorPonto(txtPrVenda.getText())+"")
				);
		
	}

	


	protected void LimparCampos() {
		
		txtCodigo.setText("");
		cmbTipo.setSelectedItem("");
		cmbEncapsulamento.setSelectedItem("");
		cmbFabricante.setSelectedItem("");
		txtEquivalencia.setText("");
		
	}

	private Object[] DefaultComboBoxModel(List<String> fabricantes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void Grava(){
		
		if(edicao){
			SQL= "UPDATE componente set _CodigoComponente = ?,_Descricao = ?,_Fabricante = ?,_Encapsulamento = ?,_Equivalente = ?,_Gaveta = ?,_Divisao = ?,_PrecoCompra = ?,_PrecoVenda = ? where _idComponente ="+ID;
			
		}else{
			
			SQL= "INSERT INTO componente(_CodigoComponente,_Descricao,_Fabricante,_Encapsulamento,_Equivalente,_Gaveta,_Divisao,_PrecoCompra,_PrecoVenda)VALUES(?,?,?,?,?,?,?,?,?)";
		}
		try {
			DaoGenerico.perssitencia(SQL,
					txtCodigo.getText(),
					cmbTipo.getSelectedItem()+"",
					cmbFabricante.getSelectedItem()+"",
					cmbEncapsulamento.getSelectedItem()+"",
					Integer.parseInt(txtEquivalencia.getText()+""),
					Integer.parseInt(cmbGaveta.getSelectedItem().toString()),
					Integer.parseInt(cmbDivisao.getSelectedItem().toString()),
					biblioteca.formataToBigDecimal(biblioteca.trocarVirgulaPorPonto(txtPrCompra.getText())+""),
					biblioteca.formataToBigDecimal(biblioteca.trocarVirgulaPorPonto(txtPrVenda.getText())+""));
			DaoGenerico.endTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void CarregaTabela(){
		tabComponente.setModel(DbUtils.resultSetToTableModel(dao.listar("select _idComponente as 'ID', _CodigoComponente as 'Código', _Descricao as 'Descrição',"
				+ " _Fabricante as 'Fabricante', _Encapsulamento as 'Envólucro',_Gaveta as 'Gaveta', _Divisao as 'Divisão', FORMAT(_PrecoCompra,2,'de_DE')  as 'Preço Compra', FORMAT(_PrecoVenda,2,'de_DE') as 'Preço venda',  _Equivalente as 'Similar' from componente")));
		
		tabComponente.getColumnModel().getColumn(0).setResizable(false);
		tabComponente.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabComponente.getColumnModel().getColumn(0).setMaxWidth(40);
		tabComponente.getColumnModel().getColumn(1).setResizable(false);
		tabComponente.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabComponente.getColumnModel().getColumn(1).setMaxWidth(120);
		tabComponente.getColumnModel().getColumn(2).setResizable(false);
		tabComponente.getColumnModel().getColumn(2).setPreferredWidth(450);
		tabComponente.getColumnModel().getColumn(2).setMaxWidth(550);
		tabComponente.getColumnModel().getColumn(3).setResizable(false);
		tabComponente.getColumnModel().getColumn(3).setPreferredWidth(220);
		tabComponente.getColumnModel().getColumn(3).setMaxWidth(220);
		tabComponente.getColumnModel().getColumn(4).setResizable(false);
		tabComponente.getColumnModel().getColumn(4).setPreferredWidth(80);
		tabComponente.getColumnModel().getColumn(5).setResizable(false);
		tabComponente.getColumnModel().getColumn(5).setPreferredWidth(30);
		tabComponente.getColumnModel().getColumn(6).setResizable(false);
		tabComponente.getColumnModel().getColumn(6).setPreferredWidth(30);
		tabComponente.getColumnModel().getColumn(7).setResizable(false);
		tabComponente.getColumnModel().getColumn(7).setPreferredWidth(60);
		tabComponente.getColumnModel().getColumn(8).setResizable(false);
		tabComponente.getColumnModel().getColumn(8).setPreferredWidth(60);
		tabComponente.getColumnModel().getColumn(9).setResizable(false);
		tabComponente.getColumnModel().getColumn(9).setPreferredWidth(30);
	}
	/*****************************************************************************************************
	 * Declaração Variaveis
	 ******************************************************************************************************/
	private JTextField txtCodigo;
	private JTextField txtEquivalencia;
	private JButton btnSair, btnSalvar;
	private JComboBox<?> cmbFabricante, cmbTipo, cmbEncapsulamento;
	private JPanel panel;
	private JPanel pnlComandos;
	private JTable tabComponente;
	private JPanel panel_1;
	private JTextField textField_1;
	private JComboBox cmbGaveta, cmbDivisao;
	private JTextField txtPrCompra;
	private JTextField txtPrVenda;
	
	private int ID;
	private JLabel lblCadastroDeComponentes;
}
