package br.com.lhmecatronica.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.*;
import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;

import br.com.lhmecatronica.dao.OsDao;
import br.com.lhmecatronica.persistencia.Componente;
import br.com.lhmecatronica.util.Biblioteca;
import br.com.lhmecatronica.util.GenericoDAO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;

public class FormularioOS extends JInternalFrame {
	private JTable tabClientes;
	private JTextField textField_1;
	private JPanel panel;
	private JTextField txtPesqClienteNome;
	private JLabel lblCliente;
	private JPanel panel_1;
	private JLabel lblMarca;
	private JPanel panel_2;
	private JTextField textField_3;
	private JTextField textField_4;
	 JDateChooser jtfTermino;
	 private JTextField textField;
	 private JTextField txtPesquisaComponentes;
	 private JTextField txtQTD;
	 private JTable tabPecas;
	 private JTable tabOsLista;
	 private JTextField textField_6;
	 private JTextField textField_8;
	 OsDao osDao = new OsDao();
	 private JTextField txtPesqClienteCPF;
	 private JTextField txtIdCliente;
	 private JTextField textField_9;
	 private JTextField textField_2;
	 private JTextField textField_10;
	 private JTextField textField_11;
	 private JTextField textField_12;
	 private JTextField textField_13;
	 private JTextField textField_14;
	 private JTextField textField_15;
	 private JTextField txtIDComponente;
	 
	 public String SQL;
	
	 Componente componente = new Componente();
	 GenericoDAO dao = new GenericoDAO(); 
	 Biblioteca biblioteca = new Biblioteca();
	 
	public FormularioOS() {
		TelaPrincipal.menu(false);
		setRootPaneCheckingEnabled(false);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().setBackground(new Color(245, 222, 179));
		setIconifiable(true);
		setPreferredSize(new Dimension(1395, 800));
		setBounds(100, 100, 1395, 831);
		getContentPane().setLayout(null);
		
		JLabel lblOrdemEServio = new JLabel("Ordem e Serviço");
		lblOrdemEServio.setForeground(new Color(255, 255, 0));
		lblOrdemEServio.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOrdemEServio.setBounds(10, 11, 1377, 44);
		lblOrdemEServio.setBackground(new Color(0, 0, 128));
		lblOrdemEServio.setOpaque(true);
		lblOrdemEServio.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdemEServio.setFont(new Font("Arial", Font.PLAIN, 38));
		getContentPane().add(lblOrdemEServio);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(643, 64, 743, 151);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_1.setBounds(10, 51, 726, 89);
		panel_1.add(scrollPane_1);
		
		tabClientes = new JTable();
		tabClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtIdCliente.setText(tabClientes.getModel().getValueAt(tabClientes.getSelectedRow(),0).toString());
			}
		});
		tabClientes.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_1.setViewportView(tabClientes);
		tabClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "CPF", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabClientes.getColumnModel().getColumn(0).setResizable(false);
		tabClientes.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabClientes.getColumnModel().getColumn(0).setMinWidth(60);
		tabClientes.getColumnModel().getColumn(0).setMaxWidth(60);
		tabClientes.getColumnModel().getColumn(1).setResizable(false);
		tabClientes.getColumnModel().getColumn(1).setPreferredWidth(365);
		tabClientes.getColumnModel().getColumn(1).setMinWidth(365);
		tabClientes.getColumnModel().getColumn(1).setMaxWidth(365);
		tabClientes.getColumnModel().getColumn(2).setResizable(false);
		tabClientes.getColumnModel().getColumn(2).setPreferredWidth(120);
		tabClientes.getColumnModel().getColumn(2).setMinWidth(120);
		tabClientes.getColumnModel().getColumn(2).setMaxWidth(120);
		tabClientes.getColumnModel().getColumn(3).setResizable(false);
		tabClientes.getColumnModel().getColumn(3).setPreferredWidth(105);
		tabClientes.getColumnModel().getColumn(3).setMinWidth(105);
		tabClientes.getColumnModel().getColumn(3).setMaxWidth(105);
		tabClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		txtPesqClienteNome = new JTextField();
		txtPesqClienteNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String SQL = "SELECT cliente.ID as 'ID', cliente.NOME as 'Nome', cliente.CPF as 'CPF',cliente.TELEFONE as 'Telefone' from cliente where NOME like '%" + txtPesqClienteNome.getText()+ "%'";
				tabClientes.setModel(DbUtils.resultSetToTableModel(osDao.listarCliente(SQL)));
			}
		});
		txtPesqClienteNome.setBounds(269, 12, 205, 30);
		panel_1.add(txtPesqClienteNome);
		txtPesqClienteNome.setFont(new Font("Arial", Font.BOLD, 12));
		txtPesqClienteNome.setColumns(10);
		
		lblCliente = new JLabel("Cliente Nome :");
		lblCliente.setBounds(162, 14, 107, 14);
		panel_1.add(lblCliente);
		lblCliente.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblClienteCpf = new JLabel("Cliente CPF:");
		lblClienteCpf.setFont(new Font("Arial", Font.BOLD, 14));
		lblClienteCpf.setBounds(486, 14, 94, 14);
		panel_1.add(lblClienteCpf);
		
		txtPesqClienteCPF = new JTextField();
		txtPesqClienteCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String SQL = "SELECT cliente.ID as 'ID', cliente.NOME as 'Nome', cliente.CPF as 'CPF',cliente.TELEFONE as 'Telefone' from cliente where CPF like '%" + txtPesqClienteCPF.getText()+ "%'";
				tabClientes.setModel(DbUtils.resultSetToTableModel(osDao.listarCliente(SQL)));
			}
		});
		txtPesqClienteCPF.setFont(new Font("Arial", Font.BOLD, 12));
		txtPesqClienteCPF.setColumns(10);
		txtPesqClienteCPF.setBounds(580, 14, 156, 30);
		panel_1.add(txtPesqClienteCPF);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBackground(Color.BLUE);
		panel_8.setBounds(10, 7, 140, 43);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblId_1 = new JLabel("ID : ");
		lblId_1.setForeground(Color.YELLOW);
		lblId_1.setBounds(6, 10, 33, 23);
		panel_8.add(lblId_1);
		lblId_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtIdCliente.setBounds(39, 8, 91, 30);
		panel_8.add(txtIdCliente);
		txtIdCliente.setFont(new Font("Arial", Font.BOLD, 12));
		txtIdCliente.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 64, 321, 75);
		panel.setBackground(new Color(178, 34, 34));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(255, 255, 0));
		lblId.setBounds(10, 9, 55, 25);
		panel.add(lblId);
		lblId.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(new Color(255, 255, 0));
		lblData.setBounds(10, 39, 55, 27);
		panel.add(lblData);
		lblData.setFont(new Font("Arial", Font.BOLD, 16));
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Numero OS");
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(69, 9, 142, 25);
		panel.add(textField_1);
		textField_1.setFont(new Font("Arial", Font.BOLD, 14));
		textField_1.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("Data entrada o equipamento");
		textField_9.setEnabled(false);
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Arial", Font.BOLD, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(69, 39, 142, 25);
		panel.add(textField_9);
		
		JButton btnNovaOs = new JButton("Nova OS");
		btnNovaOs.setToolTipText("OS anterior");
		btnNovaOs.setBounds(214, 6, 97, 28);
		panel.add(btnNovaOs);
		
		JButton btnPesquisarOs = new JButton("Pesquisar OS");
		btnPesquisarOs.setToolTipText("OS anterior");
		btnPesquisarOs.setBounds(214, 39, 97, 28);
		panel.add(btnPesquisarOs);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 230, 488, 149);
		panel_2.setBackground(new Color(70, 130, 180));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 11, 59, 20);
		panel_2.add(lblMarca);
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox cmbMarca = new JComboBox();
		
		cmbMarca.setBounds(79, 8, 183, 29);
		cmbMarca.setModel(new DefaultComboBoxModel(osDao.veiculoMontadora()));
		panel_2.add(cmbMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.BOLD, 14));
		lblModelo.setBounds(10, 42, 73, 20);
		panel_2.add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Arial", Font.BOLD, 14));
		lblAno.setBounds(288, 11, 40, 20);
		panel_2.add(lblAno);
		
		JComboBox cmbModelo = new JComboBox();
		cmbModelo.setBounds(79, 42, 369, 29);
		cmbModelo.setModel(new DefaultComboBoxModel(osDao.veiculoModelo("select * from Montadora where _montadora = 'fiat'")));
		panel_2.add(cmbModelo);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.BOLD, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(326, 9, 117, 28);
		panel_2.add(textField_8);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(508, 230, 878, 149);
		panel_3.setBackground(new Color(128, 128, 0));
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblMdulo = new JLabel("Módulo:");
		lblMdulo.setBounds(10, 12, 70, 26);
		panel_3.add(lblMdulo);
		lblMdulo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblDefeitoReclemado = new JLabel("Defeito Reclamado:");
		lblDefeitoReclemado.setBounds(10, 56, 141, 30);
		panel_3.add(lblDefeitoReclemado);
		lblDefeitoReclemado.setFont(new Font("Arial", Font.BOLD, 14));
		
		textField_3 = new JTextField();
		textField_3.setBounds(152, 53, 663, 58);
		panel_3.add(textField_3);
		textField_3.setFont(new Font("Arial", Font.BOLD, 14));
		textField_3.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(75, 8, 239, 37);
		panel_3.add(comboBox_1);
		
		JLabel lblCodigoDeErro = new JLabel("Codigo de Erro:");
		lblCodigoDeErro.setBounds(328, 12, 124, 26);
		panel_3.add(lblCodigoDeErro);
		lblCodigoDeErro.setFont(new Font("Arial", Font.BOLD, 14));
		
		textField_4 = new JTextField();
		textField_4.setBounds(446, 7, 369, 38);
		panel_3.add(textField_4);
		textField_4.setFont(new Font("Arial", Font.BOLD, 14));
		textField_4.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(341, 64, 296, 151);
		panel_4.setBackground(new Color(0, 128, 128));
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblEntrada = new JLabel("Orçamento: ");
		lblEntrada.setOpaque(true);
		lblEntrada.setBackground(new Color(224, 255, 255));
		lblEntrada.setForeground(new Color(0, 0, 255));
		lblEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntrada.setBounds(11, 5, 133, 24);
		panel_4.add(lblEntrada);
		lblEntrada.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblOramento = new JLabel("Autorização: ");
		lblOramento.setOpaque(true);
		lblOramento.setBackground(new Color(224, 255, 255));
		lblOramento.setForeground(new Color(0, 0, 255));
		lblOramento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOramento.setBounds(11, 34, 133, 24);
		panel_4.add(lblOramento);
		lblOramento.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblAutorizao = new JLabel("Reparo : ");
		lblAutorizao.setOpaque(true);
		lblAutorizao.setBackground(new Color(224, 255, 255));
		lblAutorizao.setForeground(new Color(0, 0, 255));
		lblAutorizao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutorizao.setBounds(11, 63, 133, 24);
		panel_4.add(lblAutorizao);
		lblAutorizao.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblReparo = new JLabel("Entrega : ");
		lblReparo.setOpaque(true);
		lblReparo.setBackground(new Color(224, 255, 255));
		lblReparo.setForeground(new Color(0, 0, 255));
		lblReparo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReparo.setBounds(11, 92, 133, 24);
		panel_4.add(lblReparo);
		lblReparo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblRetornoGarantia = new JLabel("Retorno Garantia: ");
		lblRetornoGarantia.setOpaque(true);
		lblRetornoGarantia.setBackground(new Color(224, 255, 255));
		lblRetornoGarantia.setForeground(new Color(0, 0, 255));
		lblRetornoGarantia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRetornoGarantia.setFont(new Font("Arial", Font.BOLD, 14));
		lblRetornoGarantia.setBounds(11, 121, 133, 24);
		panel_4.add(lblRetornoGarantia);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		dateChooser.setBounds(151, 5, 142, 24);
		panel_4.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setVisible(false);
		dateChooser_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		dateChooser_1.setBounds(151, 34, 142, 24);
		panel_4.add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setVisible(false);
		dateChooser_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		dateChooser_2.setBounds(151, 63, 142, 24);
		panel_4.add(dateChooser_2);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setVisible(false);
		dateChooser_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		dateChooser_3.setBounds(151, 121, 142, 24);
		panel_4.add(dateChooser_3);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setVisible(false);
		dateChooser_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		dateChooser_4.setBounds(151, 92, 142, 24);
		panel_4.add(dateChooser_4);
		
		JPanel jpnNavegacao = new JPanel();
		jpnNavegacao.setBounds(10, 154, 323, 61);
		getContentPane().add(jpnNavegacao);
		jpnNavegacao.setVerifyInputWhenFocusTarget(false);
		jpnNavegacao.setEnabled(false);
		jpnNavegacao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jpnNavegacao.setBackground(new Color(0, 139, 139));
		jpnNavegacao.setLayout(null);
		
		JButton button_2 = new JButton("");
		button_2.setToolTipText("Primeira OS");
		button_2.setIcon(new ImageIcon(FormularioOS.class.getResource("/imagem/botoes/navegacao/primeiro_registro.gif")));
		button_2.setBounds(5, 5, 49, 53);
		jpnNavegacao.add(button_2);
		
		JButton button_1 = new JButton("");
		button_1.setToolTipText("OS anterior");
		button_1.setIcon(new ImageIcon(FormularioOS.class.getResource("/imagem/botoes/navegacao/registro_anterior.gif")));
		button_1.setBounds(59, 5, 49, 53);
		jpnNavegacao.add(button_1);
		
		JButton button = new JButton("");
		button.setToolTipText("próxima OS");
		button.setIcon(new ImageIcon(FormularioOS.class.getResource("/imagem/botoes/navegacao/proximo_registro.gif")));
		button.setBounds(215, 5, 49, 53);
		jpnNavegacao.add(button);
		
		JButton button_3 = new JButton("");
		button_3.setToolTipText("Última OS");
		button_3.setIcon(new ImageIcon(FormularioOS.class.getResource("/imagem/botoes/navegacao/ultimo_registro.gif")));
		button_3.setBounds(269, 5, 49, 53);
		jpnNavegacao.add(button_3);
		
		textField_15 = new JTextField();
		textField_15.setToolTipText("Numero OS");
		textField_15.setFont(new Font("Arial", Font.BOLD, 14));
		textField_15.setColumns(10);
		textField_15.setBounds(113, 5, 97, 40);
		jpnNavegacao.add(textField_15);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBounds(973, 722, 317, 69);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal.menu(true);
				dispose();
			}
		});
		button_4.setBounds(10, 5, 63, 58);
		panel_6.add(button_4);
		button_4.setIcon(new ImageIcon(FormularioOS.class.getResource("/imagem/botoes/navegacao/sair.gif")));
		
		JButton button_5 = new JButton("");
		button_5.setBounds(83, 5, 63, 58);
		panel_6.add(button_5);
		button_5.setIcon(new ImageIcon(FormularioOS.class.getResource("/imagem/botoes/navegacao/24x24_Save.png")));
		
		JLabel lblValorTotal = new JLabel("Valor Total : ");
		lblValorTotal.setOpaque(true);
		lblValorTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorTotal.setForeground(Color.BLUE);
		lblValorTotal.setFont(new Font("Arial", Font.BOLD, 14));
		lblValorTotal.setBackground(new Color(224, 255, 255));
		lblValorTotal.setBounds(985, 666, 149, 33);
		getContentPane().add(lblValorTotal);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(1141, 665, 142, 33);
		getContentPane().add(textField);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_7.setBounds(10, 394, 654, 223);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblCdigo = new JLabel("PESQUISAR : ");
		lblCdigo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblCdigo.setBounds(10, 5, 92, 33);
		panel_7.add(lblCdigo);
		lblCdigo.setOpaque(true);
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setForeground(Color.BLUE);
		lblCdigo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCdigo.setBackground(new Color(224, 255, 255));
		
		JLabel lblDescrio = new JLabel("DESCRIÇÃO : ");
		lblDescrio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblDescrio.setBounds(10, 53, 93, 33);
		panel_7.add(lblDescrio);
		lblDescrio.setOpaque(true);
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setForeground(Color.BLUE);
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 12));
		lblDescrio.setBackground(new Color(224, 255, 255));
		
		JLabel lblQuantidade = new JLabel("QUANTIDADE : ");
		lblQuantidade.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblQuantidade.setBounds(230, 185, 92, 33);
		panel_7.add(lblQuantidade);
		lblQuantidade.setOpaque(true);
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setForeground(Color.BLUE);
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 12));
		lblQuantidade.setBackground(new Color(224, 255, 255));
		
		txtPesquisaComponentes = new JTextField();
		txtPesquisaComponentes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SelecionarComponente();
			}
		});
		txtPesquisaComponentes.setBounds(113, 5, 531, 33);
		panel_7.add(txtPesquisaComponentes);
		txtPesquisaComponentes.setFont(new Font("Arial", Font.BOLD, 14));
		txtPesquisaComponentes.setColumns(10);
		
		txtQTD = new JTextField();
		txtQTD.setBounds(332, 185, 92, 33);
		panel_7.add(txtQTD);
		txtQTD.setFont(new Font("Arial", Font.BOLD, 14));
		txtQTD.setColumns(10);
		
		JButton btnGrava = new JButton("Grava");
		btnGrava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BigDecimal precoTotal = new BigDecimal(100.25);
				SQL ="INSERT INTO ositens(_idOS,_idItens,_idQtd,_valorUnit,_valorTotal,_valorMOD) VALUES(?,?,?,?,?,?)";
				try {
					dao.perssitencia(SQL,1,Integer.parseInt(txtIDComponente.getText()),Integer.parseInt(txtQTD.getText()),precoTotal,0.00,0.00);
					dao.endTransaction();
					SelecionarOSItens();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGrava.setIcon(new ImageIcon(FormularioOS.class.getResource("/imagem/botoes/navegacao/24x24 AdicionaProduto.png")));
		btnGrava.setBounds(434, 174, 125, 44);
		panel_7.add(btnGrava);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(113, 49, 531, 119);
		panel_7.add(scrollPane);
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		tabPecas = new JTable();
		tabPecas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
					componente.setCodigoComponente((tabPecas.getModel().getValueAt(tabPecas.getSelectedRow(),0).toString()));
					txtIDComponente.setText(componente.getCodigoComponente());
					componente.setPrecoCompra(new BigDecimal(12.25));
					
							
			}
		});
		tabPecas.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(tabPecas);
		tabPecas.setFont(new Font("Arial", Font.BOLD, 12));		tabPecas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Codigo", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabPecas.getColumnModel().getColumn(0).setResizable(false);
		tabPecas.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabPecas.getColumnModel().getColumn(0).setMinWidth(30);
		tabPecas.getColumnModel().getColumn(0).setMaxWidth(30);
		tabPecas.getColumnModel().getColumn(1).setResizable(false);
		tabPecas.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabPecas.getColumnModel().getColumn(1).setMinWidth(50);
		tabPecas.getColumnModel().getColumn(1).setMaxWidth(50);
		tabPecas.getColumnModel().getColumn(2).setResizable(false);
		tabPecas.getColumnModel().getColumn(2).setPreferredWidth(300);
		tabPecas.getColumnModel().getColumn(2).setMinWidth(300);
		tabPecas.getColumnModel().getColumn(2).setMaxWidth(300);
		tabPecas.getColumnModel().getColumn(3).setResizable(false);
		tabPecas.getColumnModel().getColumn(3).setMinWidth(75);
		tabPecas.getColumnModel().getColumn(3).setMaxWidth(75);
		
		JLabel lblIdComponente = new JLabel("ID Componente : ");
		lblIdComponente.setOpaque(true);
		lblIdComponente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdComponente.setForeground(Color.BLUE);
		lblIdComponente.setFont(new Font("Arial", Font.BOLD, 12));
		lblIdComponente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblIdComponente.setBackground(new Color(224, 255, 255));
		lblIdComponente.setBounds(10, 185, 103, 33);
		panel_7.add(lblIdComponente);
		
		txtIDComponente = new JTextField();
		txtIDComponente.setEditable(false);
		txtIDComponente.setFont(new Font("Arial", Font.BOLD, 14));
		txtIDComponente.setColumns(10);
		txtIDComponente.setBounds(117, 185, 103, 33);
		panel_7.add(txtIDComponente);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(679, 390, 702, 233);
		getContentPane().add(scrollPane_2);
		
		tabOsLista = new JTable();
		tabOsLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SelecionarOSItens();
			}
		});
		tabOsLista.setGridColor(Color.BLACK);
		scrollPane_2.setViewportView(tabOsLista);
		tabOsLista.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Codigo", "Descri\u00E7\u00E3o", "Qtd", "Pr Unit", "Pr Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabOsLista.getColumnModel().getColumn(0).setResizable(false);
		tabOsLista.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabOsLista.getColumnModel().getColumn(1).setResizable(false);
		tabOsLista.getColumnModel().getColumn(1).setPreferredWidth(70);
		tabOsLista.getColumnModel().getColumn(2).setResizable(false);
		tabOsLista.getColumnModel().getColumn(2).setPreferredWidth(260);
		tabOsLista.getColumnModel().getColumn(3).setResizable(false);
		tabOsLista.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabOsLista.getColumnModel().getColumn(4).setResizable(false);
		tabOsLista.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabOsLista.getColumnModel().getColumn(5).setResizable(false);
		tabOsLista.getColumnModel().getColumn(5).setPreferredWidth(124);
		tabOsLista.setShowHorizontalLines(false);
		tabOsLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblMoDeObra = new JLabel("Mão de Obra : ");
		lblMoDeObra.setOpaque(true);
		lblMoDeObra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoDeObra.setForeground(Color.BLUE);
		lblMoDeObra.setFont(new Font("Arial", Font.BOLD, 14));
		lblMoDeObra.setBackground(new Color(224, 255, 255));
		lblMoDeObra.setBounds(983, 627, 149, 33);
		getContentPane().add(lblMoDeObra);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(1140, 627, 142, 33);
		getContentPane().add(textField_6);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(100, 149, 237));
		panel_9.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_9.setBounds(10, 632, 571, 159);
		getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		JCheckBox chckbxInjetor = new JCheckBox("Bicos Injetores Ok");
		chckbxInjetor.setForeground(new Color(255, 255, 0));
		chckbxInjetor.setOpaque(false);
		chckbxInjetor.setBounds(6, 3, 127, 23);
		panel_9.add(chckbxInjetor);
		
		JCheckBox chckbxBoninas = new JCheckBox("Bobinas Ok");
		chckbxBoninas.setForeground(new Color(255, 255, 0));
		chckbxBoninas.setOpaque(false);
		chckbxBoninas.setBounds(6, 29, 127, 23);
		panel_9.add(chckbxBoninas);
		
		JCheckBox chckbxRelePrincipal = new JCheckBox("Rele Principal Ok");
		chckbxRelePrincipal.setForeground(new Color(255, 255, 0));
		chckbxRelePrincipal.setOpaque(false);
		chckbxRelePrincipal.setBounds(6, 55, 127, 23);
		panel_9.add(chckbxRelePrincipal);
		
		JCheckBox chckbxRleBomba = new JCheckBox("Rêle Bomba Ok");
		chckbxRleBomba.setForeground(new Color(255, 255, 0));
		chckbxRleBomba.setOpaque(false);
		chckbxRleBomba.setBounds(6, 81, 127, 23);
		panel_9.add(chckbxRleBomba);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 3, 428, 23);
		panel_9.add(textField_2);
		textField_2.setFont(new Font("Arial", Font.BOLD, 11));
		textField_2.setColumns(10);
		
		JCheckBox chckbxEletroventiladorOk = new JCheckBox("Eletroventilador OK");
		chckbxEletroventiladorOk.setForeground(new Color(255, 255, 0));
		chckbxEletroventiladorOk.setOpaque(false);
		chckbxEletroventiladorOk.setBounds(6, 107, 127, 23);
		panel_9.add(chckbxEletroventiladorOk);
		
		JCheckBox chckbxComScanner = new JCheckBox("Com. Scanner");
		chckbxComScanner.setForeground(new Color(255, 255, 0));
		chckbxComScanner.setOpaque(false);
		chckbxComScanner.setBounds(6, 133, 127, 23);
		panel_9.add(chckbxComScanner);
		
		textField_10 = new JTextField();
		textField_10.setBounds(137, 29, 428, 23);
		panel_9.add(textField_10);
		textField_10.setFont(new Font("Arial", Font.BOLD, 11));
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(137, 55, 428, 23);
		panel_9.add(textField_11);
		textField_11.setFont(new Font("Arial", Font.BOLD, 11));
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(137, 81, 428, 23);
		panel_9.add(textField_12);
		textField_12.setFont(new Font("Arial", Font.BOLD, 11));
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(137, 107, 428, 23);
		panel_9.add(textField_13);
		textField_13.setFont(new Font("Arial", Font.BOLD, 11));
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(137, 133, 428, 23);
		panel_9.add(textField_14);
		textField_14.setFont(new Font("Arial", Font.BOLD, 11));
		textField_14.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_10.setBackground(new Color(253, 245, 230));
		panel_10.setBounds(584, 633, 379, 158);
		getContentPane().add(panel_10);
		panel_10.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(5, 4, 369, 149);
		panel_10.add(editorPane);

	}
	
	private void SelecionarComponente() {
		SQL = "SELECT _idComponente as ID, _CodigoComponente as Codigo,_Descricao as Descrição, _PrecoCompra as Preço FROM componentes  where _CodigoComponente like '%" + txtPesquisaComponentes.getText()+ "%'";
		tabPecas.setModel(DbUtils.resultSetToTableModel(osDao.listarCliente(SQL)));
		tabPecas.getColumnModel().getColumn(0).setResizable(false);
		tabPecas.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabPecas.getColumnModel().getColumn(1).setResizable(false);
		tabPecas.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabPecas.getColumnModel().getColumn(2).setResizable(false);
		tabPecas.getColumnModel().getColumn(2).setPreferredWidth(300);
		tabPecas.getColumnModel().getColumn(3).setResizable(false);
		tabPecas.getColumnModel().getColumn(3).setPreferredWidth(80);
	}
	
	private void SelecionarOSItens() {
		SQL = "SELECT _idItens as ID, _CodigoComponente  as CODIGO, _Descricao as Descrição,_idQtd as 'Qtd', _valorUnit as 'Pr Unt',_valorTotal as'Pr Total' from ositens inner join componentes on ositens._idItens = componentes._idComponente";
		tabOsLista.setModel(DbUtils.resultSetToTableModel(osDao.listarCliente(SQL)));
		tabOsLista.getColumnModel().getColumn(0).setResizable(false);
		tabOsLista.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabOsLista.getColumnModel().getColumn(1).setResizable(false);
		tabOsLista.getColumnModel().getColumn(1).setPreferredWidth(70);
		tabOsLista.getColumnModel().getColumn(2).setResizable(false);
		tabOsLista.getColumnModel().getColumn(2).setPreferredWidth(260);
		tabOsLista.getColumnModel().getColumn(3).setResizable(false);
		tabOsLista.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabOsLista.getColumnModel().getColumn(4).setResizable(false);
		tabOsLista.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabOsLista.getColumnModel().getColumn(5).setResizable(false);
		tabOsLista.getColumnModel().getColumn(5).setPreferredWidth(124);
		tabOsLista.setShowHorizontalLines(false);
		tabOsLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
