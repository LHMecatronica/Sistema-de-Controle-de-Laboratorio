package br.com.lhmecatronica.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class ComponenteGUI extends JInternalFrame {

	
	
	/*******************************************************************************************************************
	 * 
	 * Classe Inicial
	 * 
	 ******************************************************************************************************************/
	public ComponenteGUI() {
		setInheritsPopupMenu(true);
		Tela();
	} // fim componenteGUI

	/******************************************************************************************************************
	 * 
	 * Formatação da Tela
	 * 
	 *******************************************************************************************************************/
	public void Tela() {
		TelaPrincipal.menu(false);
		setPreferredSize(new Dimension(1000, 320));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 920, 221);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
					
			}
		});
		
		
		
		txtCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		
		txtCodigo.setBounds(72, 11, 130, 32);
		panel.add(txtCodigo);
		txtCodigo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtCodigo.setColumns(10);

		JLabel lblCompCodigo = new JLabel("Codigo :");
		lblCompCodigo.setBounds(10, 11, 63, 33);
		panel.add(lblCompCodigo);
		lblCompCodigo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblCompCodigo.setFont(new Font("Dialog", Font.PLAIN, 14));

		txtDescricao = new JTextField();
		txtDescricao.setBounds(315, 11, 615, 32);
		panel.add(txtDescricao);
		txtDescricao.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDescricao.setColumns(10);
		txtDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(236, 11, 80, 33);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDescrio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		cmbFabricante = new JComboBox();
		cmbFabricante.setBounds(103, 54, 180, 33);
		panel.add(cmbFabricante);
		cmbFabricante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbFabricante.setFont(new Font("Dialog", Font.PLAIN, 14));
		cmbFabricante.setModel(new DefaultComboBoxModel(new String[] { "1 - Bosch", "2 - Magnet Marelli", "3 - Delphi" }));

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(10, 54, 90, 33);
		panel.add(lblFabricante);
		lblFabricante.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblFabricante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		cmbTipo = new JComboBox();
		cmbTipo.setBounds(405, 54, 180, 33);
		panel.add(cmbTipo);
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] { "1 - Drive", "2 - Regulador", "3 -Processador" }));
		cmbTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		cmbTipo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(312, 54, 90, 33);
		panel.add(lblTipo);
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTipo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblEncapsulamento = new JLabel("Encapsulamento:");
		lblEncapsulamento.setBounds(623, 54, 121, 33);
		panel.add(lblEncapsulamento);
		lblEncapsulamento.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEncapsulamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		cmbEncapsulamento = new JComboBox();
		cmbEncapsulamento.setBounds(747, 54, 180, 33);
		panel.add(cmbEncapsulamento);
		cmbEncapsulamento.setModel(new DefaultComboBoxModel(new String[] { "1 - DIP8", "2 - DIP16", "3 - SOIC8", "4 - QFP64" }));
		cmbEncapsulamento.setFont(new Font("Dialog", Font.PLAIN, 14));
		cmbEncapsulamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblCodigoSimilar = new JLabel("Codigo  Similar:");
		lblCodigoSimilar.setBounds(10, 98, 112, 33);
		panel.add(lblCodigoSimilar);
		lblCodigoSimilar.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCodigoSimilar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		textField = new JTextField();
		textField.setBounds(123, 99, 130, 32);
		panel.add(textField);
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JList list = new JList();
		list.setBounds(280, 98, 232, 111);
		panel.add(list);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lstCodigo = new JList();
	
		lstCodigo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lstCodigo.setBounds(730, 98, 180, 111);
		panel.add(lstCodigo);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 240, 920, 79);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
				btnSair = new JButton("");
				btnSair.setBounds(11, 11, 89, 54);
				panel_1.add(btnSair);
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							TelaPrincipal.menu(true);
							ComponenteGUI.this.dispose();
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				btnSair.setIcon(new ImageIcon(ComponenteGUI.class.getResource("/imagem/botoes/navegacao/sair.gif")));
				btnSair.setToolTipText("Fechar Tela");
				
						btnSalvar = new JButton("");
						btnSalvar.setBounds(114, 11, 89, 54);
						panel_1.add(btnSalvar);
						btnSalvar.setIcon(new ImageIcon(ComponenteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Save.png")));
						btnSalvar.setToolTipText("Fechar Tela");

	} // Fim tela

	/*****************************************************************************************************
	 * Declaração Variaveis
	 ******************************************************************************************************/
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JTextField textField;
	private JButton btnSair, btnSalvar;
	private JComboBox cmbFabricante, cmbTipo, cmbEncapsulamento;
	private JPanel panel;
	private JPanel panel_1;
	private JList lstCodigo;

}
