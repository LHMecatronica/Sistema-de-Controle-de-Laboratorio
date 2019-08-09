package br.com.lhmecatronica.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import br.com.lhmecatronica.dao.ComponenteDao;
import br.com.lhmecatronica.util.Biblioteca;
import br.com.lhmecatronica.util.GenericoDAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;


public class EstoqueGUI extends JInternalFrame {
	ComponenteDao dao = new ComponenteDao();
	GenericoDAO DaoGenerico = new GenericoDAO();
	Biblioteca biblioteca = new Biblioteca();
	
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tabComponente;
	private JTextField textField_1;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public EstoqueGUI() {
		TelaPrincipal.menu(false);
		tela();
		CarregaTabela();

	}
	
	public void tela(){
	setBounds(100, 100, 1500, 717);
	setPreferredSize(new Dimension(1500, 700));
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBounds(0, 558, 1484, 118);
	panel.setLayout(null);
	panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panel.setBackground(new Color(70, 130, 180));
	getContentPane().add(panel);
	
	textField_5 = new JTextField();
	textField_5.setFont(new Font("Dialog", Font.PLAIN, 14));
	textField_5.setEnabled(false);
	textField_5.setEditable(false);
	textField_5.setColumns(10);
	textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	textField_5.setBounds(763, 11, 220, 32);
	panel.add(textField_5);
	
	textField = new JTextField();
	textField.setToolTipText("Código Comercial do Componente");
	textField.setFont(new Font("Dialog", Font.PLAIN, 14));
	textField.setEnabled(false);
	textField.setEditable(false);
	textField.setColumns(10);
	textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	textField.setBounds(79, 11, 123, 32);
	panel.add(textField);
	
	JLabel label = new JLabel("Codigo :");
	label.setOpaque(true);
	label.setForeground(Color.YELLOW);
	label.setFont(new Font("Dialog", Font.PLAIN, 14));
	label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	label.setBackground(new Color(0, 0, 128));
	label.setBounds(12, 6, 199, 42);
	panel.add(label);
	
	JPanel panel_1 = new JPanel();
	panel_1.setLayout(null);
	panel_1.setBounds(1003, 6, 471, 92);
	panel.add(panel_1);
	
	JButton button = new JButton("");
	button.setIcon(new ImageIcon(EstoqueGUI.class.getResource("/imagem/botoes/navegacao/sair.gif")));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				TelaPrincipal.menu(true);
				EstoqueGUI.this.dispose();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	button.setToolTipText("Fechar Tela");
	button.setBounds(10, 11, 70, 54);
	panel_1.add(button);
	
	JButton button_1 = new JButton("");
	button_1.setToolTipText("Fechar Tela");
	button_1.setBounds(90, 11, 70, 54);
	panel_1.add(button_1);
	
	textField_2 = new JTextField();
	textField_2.setFont(new Font("Dialog", Font.PLAIN, 14));
	textField_2.setEnabled(false);
	textField_2.setEditable(false);
	textField_2.setColumns(10);
	textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	textField_2.setBounds(119, 66, 161, 32);
	panel.add(textField_2);
	
	JLabel label_7 = new JLabel("Preço Compra : ");
	label_7.setOpaque(true);
	label_7.setForeground(Color.YELLOW);
	label_7.setFont(new Font("Dialog", Font.PLAIN, 14));
	label_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	label_7.setBackground(new Color(0, 0, 128));
	label_7.setBounds(12, 59, 279, 48);
	panel.add(label_7);
	
	textField_3 = new JTextField();
	textField_3.setFont(new Font("Dialog", Font.PLAIN, 14));
	textField_3.setEnabled(false);
	textField_3.setEditable(false);
	textField_3.setColumns(10);
	textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	textField_3.setBounds(405, 68, 161, 32);
	panel.add(textField_3);
	
	JLabel label_8 = new JLabel("Preço Venda : ");
	label_8.setOpaque(true);
	label_8.setForeground(Color.YELLOW);
	label_8.setFont(new Font("Dialog", Font.PLAIN, 14));
	label_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	label_8.setBackground(new Color(0, 0, 128));
	label_8.setBounds(301, 59, 290, 48);
	panel.add(label_8);
	
	JLabel label_6 = new JLabel("Divisâo");
	label_6.setOpaque(true);
	label_6.setForeground(Color.YELLOW);
	label_6.setFont(new Font("Dialog", Font.PLAIN, 14));
	label_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	label_6.setBackground(new Color(0, 0, 128));
	label_6.setBounds(703, 5, 290, 42);
	panel.add(label_6);
	
	textField_1 = new JTextField();
	textField_1.setFont(new Font("Dialog", Font.PLAIN, 14));
	textField_1.setEnabled(false);
	textField_1.setEditable(false);
	textField_1.setColumns(10);
	textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	textField_1.setBounds(315, 11, 123, 32);
	panel.add(textField_1);
	
	JLabel lblQuantidade = new JLabel("Quantidade: ");
	lblQuantidade.setOpaque(true);
	lblQuantidade.setForeground(Color.YELLOW);
	lblQuantidade.setFont(new Font("Dialog", Font.PLAIN, 14));
	lblQuantidade.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	lblQuantidade.setBackground(new Color(0, 0, 128));
	lblQuantidade.setBounds(221, 6, 232, 42);
	panel.add(lblQuantidade);
	
	JDateChooser dateChooser = new JDateChooser();
	dateChooser.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
	dateChooser.setBounds(519, 11, 174, 32);
	panel.add(dateChooser);
	
	JLabel lblData = new JLabel("Data : ");
	lblData.setOpaque(true);
	lblData.setForeground(Color.YELLOW);
	lblData.setFont(new Font("Dialog", Font.PLAIN, 14));
	lblData.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	lblData.setBackground(new Color(0, 0, 128));
	lblData.setBounds(466, 6, 232, 42);
	panel.add(lblData);
	
	JPanel panel_2 = new JPanel();
	panel_2.setLayout(null);
	panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panel_2.setBackground(SystemColor.textHighlight);
	panel_2.setBounds(0, 0, 1484, 547);
	getContentPane().add(panel_2);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setOpaque(false);
	scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	scrollPane.setBackground(SystemColor.info);
	scrollPane.setBounds(10, 78, 1464, 458);
	panel_2.add(scrollPane);
	
	tabComponente = new JTable();
	tabComponente.setRowHeight(25);
	tabComponente.setFont(new Font("Dialog", Font.PLAIN, 14));
	tabComponente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	scrollPane.setColumnHeaderView(tabComponente);
	
	JLabel lblControleDeEstoque = new JLabel("Controle de Estoque");
	lblControleDeEstoque.setHorizontalAlignment(SwingConstants.CENTER);
	lblControleDeEstoque.setOpaque(true);
	lblControleDeEstoque.setForeground(Color.YELLOW);
	lblControleDeEstoque.setFont(new Font("Dialog", Font.PLAIN, 34));
	lblControleDeEstoque.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	lblControleDeEstoque.setBackground(new Color(0, 0, 128));
	lblControleDeEstoque.setBounds(10, 11, 1464, 56);
	panel_2.add(lblControleDeEstoque);
		
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
}
