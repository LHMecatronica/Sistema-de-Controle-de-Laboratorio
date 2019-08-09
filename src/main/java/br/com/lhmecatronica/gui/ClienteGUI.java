package br.com.lhmecatronica.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.com.lhmecatronica.dao.BairroDAO;
import br.com.lhmecatronica.dao.ClienteDAO;
import br.com.lhmecatronica.persistencia.Bairro;
import br.com.lhmecatronica.persistencia.Cliente;
import br.com.lhmecatronica.util.Biblioteca;
import br.com.lhmecatronica.util.GenericoDAO;

public class ClienteGUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private javax.swing.JButton btnApaga, btnEdita, btnGrava, btnLupa, btnNovo, btnSair, btnStop;

	private javax.swing.JLabel jLabel1, lblBairro, lblCEP, lblCPFCliente, lblCPF, lblCidade, lblComplemento,
			lblLogradouro, lblNR, lblNome, lblPais, lblUF;

	private javax.swing.JTextField txtCEPCliente, txtCPFCliente, txtCidadeCliente, txtComplementoCliente, txtIdCliente,
			txtLogradouroCliente, txtNRCliente, txtNomeCliente, txtPaisCliente, txtUFCliente, txtEmail, txtFixo;

	private JButton btnPrimeiro;
	private JComboBox<?> jcbBairro;

	Cliente cliente;
	BairroDAO bairroDAO;
	Bairro bairro;
	String SQL = null;
	private int acao = 0; // 1 incluir ou 0 editar registro
	private JPanel panel;
	private JTextField txtPontoReferencia;
	ClienteDAO clienteDAO = null;
	GenericoDAO genericoDAO = null;
	List<String> retorno = new ArrayList<>();
	

	public ClienteGUI() {
		
		
		TelaPrincipal.menu(false);
		setRootPaneCheckingEnabled(false);
		getContentPane().setPreferredSize(new Dimension(610, 560));
		
		
		setPreferredSize(new Dimension(670, 515));
		setSize(new Dimension(666, 540));
		
		cliente = new Cliente();
		bairro = new Bairro();
		bairroDAO = new BairroDAO();
		clienteDAO = ClienteDAO.getInstance();
		initComponents();
		genericoDAO = new GenericoDAO();
        
		preecherJcbBairro();
		cliente = clienteDAO.primeiro(true);
		carregarCampos(cliente);
		EditarCampos(false);
		String SQL = null;
	}

	public void initComponents() {
		setLocation(new Point(0, -20));
		setInheritsPopupMenu(true);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setResizable(false);
		getContentPane().getSize(new Dimension(getSize().width-10, getSize().height-10));
		getContentPane().setBackground(new Color(128, 0, 128));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(656, 500));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);

		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jLabel1.setOpaque(true);
		jLabel1.setBackground(Color.ORANGE);
		jLabel1.setBounds(6, 11, 634, 60);
		panel.add(jLabel1);

		jLabel1.setFont(new java.awt.Font("Liberation Mono", 1, 24)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setIcon(null); // NOI18N
		jLabel1.setText("Manutenção de Clientes");
		jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnSair = new javax.swing.JButton();
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					genericoDAO.releaseTransaction();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				genericoDAO=null;
				TelaPrincipal.menu(true);
				dispose();
			}
		});
		btnSair.setBounds(16, 401, 60, 60);
		panel.add(btnSair);

		btnSair.setIcon(new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/sair.gif"))); // NOI18N
		btnSair.setPreferredSize(new java.awt.Dimension(60, 30));
		btnSair.setRequestFocusEnabled(false);
		btnNovo = new javax.swing.JButton();
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = 1;
				EditarCampos(true);
				carregarCampos(null);
			}
		});
		btnNovo.setBounds(226, 401, 60, 60);
		panel.add(btnNovo);
		btnNovo.setIcon(new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/24x24_ADD.png"))); // NOI18N
		btnNovo.setOpaque(false);
		btnStop = new javax.swing.JButton();
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericoDAO.rollbackTransaction();
				carregarCampos(cliente);
				EditarCampos(false);
			}
		});
		btnStop.setBounds(86, 401, 60, 60);
		panel.add(btnStop);

		btnStop.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/24x24 stop.png"))); // NOI18N
		btnStop.setToolTipText("");
		btnApaga = new javax.swing.JButton();
		btnApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SQL = "Delete from cliente WHERE ID = ?";
				try {
					genericoDAO.perssitencia(SQL, cliente.getId());

					carregarCampos(clienteDAO.primeiro(true));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		btnApaga.setBounds(156, 401, 60, 60);
		panel.add(btnApaga);

		btnApaga.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Delete.png"))); // NOI18N
		txtIdCliente = new javax.swing.JTextField();
		txtIdCliente.setForeground(new Color(0, 0, 139));
		txtIdCliente.setBounds(514, 99, 122, 25);
		panel.add(txtIdCliente);

		txtIdCliente.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
		txtIdCliente.setEnabled(false);
		txtIdCliente.setName(""); // NOI18N
		txtNomeCliente = new javax.swing.JTextField();
		txtNomeCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtNomeCliente.setSelectionColor(new Color(255, 255, 0));
		txtNomeCliente.setForeground(new Color(0, 0, 139));
		txtNomeCliente.setBounds(264, 142, 372, 25);
		panel.add(txtNomeCliente);
		txtNomeCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtNomeCliente.setEnabled(false);

		txtNomeCliente.setFont(new java.awt.Font("Liberation Sans", 1, 14));
		txtLogradouroCliente = new javax.swing.JTextField();
		txtLogradouroCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtLogradouroCliente.setSelectionColor(new Color(255, 255, 0));
		txtLogradouroCliente.setForeground(new Color(0, 0, 139));
		txtLogradouroCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtLogradouroCliente.getText().length() >= 70) {
					txtLogradouroCliente.setEnabled(false);
				}
			}
		});
		txtLogradouroCliente.setBounds(113, 178, 523, 25);
		panel.add(txtLogradouroCliente);
		txtLogradouroCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtLogradouroCliente.setEnabled(false);

		txtLogradouroCliente.setFont(new java.awt.Font("Liberation Sans", 1, 14));
		txtCidadeCliente = new javax.swing.JTextField();
		txtCidadeCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtCidadeCliente.setSelectionColor(new Color(255, 255, 0));
		txtCidadeCliente.setForeground(new Color(0, 0, 139));
		txtCidadeCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtCidadeCliente.setBounds(499, 246, 141, 29);
		panel.add(txtCidadeCliente);

		txtCidadeCliente.setFont(new java.awt.Font("Liberation Sans", 1, 14));
		txtNRCliente = new javax.swing.JTextField();
		txtNRCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtNRCliente.setSelectionColor(new Color(255, 255, 0));
		txtNRCliente.setForeground(new Color(0, 0, 139));
		txtNRCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtNRCliente.setBounds(40, 211, 97, 25);
		panel.add(txtNRCliente);

		txtNRCliente.setFont(new java.awt.Font("Liberation Sans", 1, 14));
		lblCPFCliente = new javax.swing.JLabel();
		lblCPFCliente.setBounds(348, 98, 148, 24);
		panel.add(lblCPFCliente);

		lblCPFCliente.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
		lblCPFCliente.setText("Código do Cliente:");
		lblNome = new javax.swing.JLabel();
		lblNome.setBounds(194, 137, 60, 24);
		panel.add(lblNome);
		lblNome.setForeground(Color.BLUE);

		lblNome.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblNome.setText("Nome:");
		lblLogradouro = new javax.swing.JLabel();
		lblLogradouro.setBounds(6, 178, 97, 24);
		panel.add(lblLogradouro);
		lblLogradouro.setForeground(Color.BLUE);

		lblLogradouro.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblLogradouro.setText("Logradouro:");
		lblCEP = new javax.swing.JLabel();
		lblCEP.setBounds(6, 280, 60, 30);
		panel.add(lblCEP);
		lblCEP.setForeground(Color.BLUE);

		lblCEP.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblCEP.setText("CEP:");
		lblBairro = new javax.swing.JLabel();
		lblBairro.setBounds(6, 249, 53, 24);
		panel.add(lblBairro);
		lblBairro.setForeground(Color.BLUE);

		lblBairro.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblBairro.setText("Bairro:");
		lblCidade = new javax.swing.JLabel();
		lblCidade.setBounds(407, 249, 70, 24);
		panel.add(lblCidade);
		lblCidade.setForeground(Color.BLUE);

		lblCidade.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblCidade.setText("Cidade:");
		lblNR = new javax.swing.JLabel();
		lblNR.setBounds(6, 210, 24, 24);
		panel.add(lblNR);
		lblNR.setForeground(Color.BLUE);

		lblNR.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblNR.setText("Nr.");
		lblComplemento = new javax.swing.JLabel();
		lblComplemento.setBounds(146, 210, 115, 24);
		panel.add(lblComplemento);
		lblComplemento.setForeground(Color.BLUE);

		lblComplemento.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblComplemento.setText("Complemento:");
		txtComplementoCliente = new javax.swing.JTextField();
		txtComplementoCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtComplementoCliente.setSelectionColor(new Color(255, 255, 0));
		txtComplementoCliente.setForeground(new Color(0, 0, 139));
		txtComplementoCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtComplementoCliente.setBounds(264, 211, 376, 25);
		panel.add(txtComplementoCliente);

		txtComplementoCliente.setFont(new java.awt.Font("Liberation Sans", 1, 14));
		txtPaisCliente = new javax.swing.JTextField();
		txtPaisCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtPaisCliente.setSelectionColor(new Color(255, 255, 0));
		txtPaisCliente.setForeground(new Color(0, 0, 139));
		txtPaisCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtPaisCliente.setBounds(329, 283, 70, 30);
		panel.add(txtPaisCliente);

		txtPaisCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblPais = new javax.swing.JLabel();
		lblPais.setBounds(275, 283, 50, 24);
		panel.add(lblPais);
		lblPais.setForeground(Color.BLUE);

		lblPais.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblPais.setText("Pais:");
		btnEdita = new javax.swing.JButton();
		btnEdita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = 0;
				EditarCampos(true);
			}
		});
		btnEdita.setBounds(366, 401, 60, 60);
		panel.add(btnEdita);

		btnEdita.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Altera.png"))); // NOI18N
		btnEdita.setToolTipText("");
		btnGrava = new javax.swing.JButton();
		btnGrava.setBounds(296, 401, 60, 60);
		panel.add(btnGrava);

		btnGrava.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Save.png"))); // NOI18N
		btnGrava.setToolTipText("");
		btnLupa = new javax.swing.JButton();
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BairrosGUI bairrosGUI = new BairrosGUI();
				bairrosGUI.setVisible(true);
			
			}
		});
		btnLupa.setBounds(436, 401, 60, 60);
		panel.add(btnLupa);

		btnLupa.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/24x24_Lupa.png")));
		lblUF = new javax.swing.JLabel();
		lblUF.setBounds(184, 283, 40, 25);
		panel.add(lblUF);
		lblUF.setForeground(Color.BLUE);

		lblUF.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblUF.setText("UF:");
		txtUFCliente = new javax.swing.JTextField();
		txtUFCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtUFCliente.setSelectionColor(new Color(255, 255, 0));
		txtUFCliente.setForeground(new Color(0, 0, 139));
		txtUFCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtUFCliente.setBounds(216, 283, 48, 30);
		panel.add(txtUFCliente);

		txtUFCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblCPF = new javax.swing.JLabel();
		lblCPF.setBounds(6, 137, 60, 24);
		panel.add(lblCPF);
		lblCPF.setForeground(Color.BLUE);

		lblCPF.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblCPF.setText("CPF:");
		txtCPFCliente = new javax.swing.JFormattedTextField();
		txtCPFCliente.setEnabled(false);
		txtCPFCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String cpf = txtCPFCliente.getText().replace(".", "").replace("-", "").trim();

				if (cpf.length() == 3) {
					txtCPFCliente.setText(cpf + ".");
				} else if (cpf.length() == 6) {
					txtCPFCliente.setText(txtCPFCliente.getText() + ".");
				} else if (cpf.length() == 9) {
					txtCPFCliente.setText(txtCPFCliente.getText() + "-");
				}
				// jtfCPF.setText(cpf);
				if (Biblioteca.validaCpfCnpj(cpf)) {
					txtCPFCliente.setEnabled(false);
					// SessaoUsuario.cpfCliente = cpf;
				} else {
					if (cpf.length() > 10) {
						txtCPFCliente.setText("");
					}
				}
			}
		});
		txtCPFCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtCPFCliente.setSelectionColor(new Color(255, 255, 0));
		txtCPFCliente.setForeground(new Color(0, 0, 139));
		txtCPFCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtCPFCliente.setBounds(69, 137, 115, 30);
		panel.add(txtCPFCliente);
		txtCPFCliente.setFont(new java.awt.Font("Arial", 1, 14));
		txtCEPCliente = new javax.swing.JFormattedTextField();
		txtCEPCliente.setSelectedTextColor(new Color(0, 128, 128));
		txtCEPCliente.setSelectionColor(new Color(255, 255, 0));
		txtCEPCliente.setForeground(new Color(0, 0, 139));
		txtCEPCliente.setDisabledTextColor(new Color(47, 79, 79));
		txtCEPCliente.setBounds(60, 283, 108, 30);
		panel.add(txtCEPCliente);
		txtCEPCliente.setFont(new java.awt.Font("Arial", 1, 14));

		btnPrimeiro = new JButton("");
		btnPrimeiro.setBounds(10, 84, 53, 40);
		panel.add(btnPrimeiro);
		btnPrimeiro.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/primeiro_registro.gif")));

		JButton btnAnterior = new JButton("");
		btnAnterior.setBounds(65, 84, 53, 40);
		panel.add(btnAnterior);
		btnAnterior.addActionListener(new ActionListener() {
			private String nome;

			public void actionPerformed(ActionEvent e) {
				cliente = clienteDAO.anterior();

				carregarCampos(cliente);
			}
		});
		btnAnterior.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/registro_anterior.gif")));

		JButton btnProximo = new JButton("");
		btnProximo.setBounds(183, 84, 53, 40);
		panel.add(btnProximo);
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = clienteDAO.proximo();
				carregarCampos(cliente);

			}
		});
		btnProximo.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/proximo_registro.gif")));

		JButton btnUltimo = new JButton("");
		btnUltimo.setBounds(239, 84, 53, 40);
		panel.add(btnUltimo);
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = clienteDAO.ultimo();
				carregarCampos(cliente);
			}
		});
		btnUltimo.setIcon(
				new ImageIcon(ClienteGUI.class.getResource("/imagem/botoes/navegacao/ultimo_registro.gif")));

		JLabel lblEmail = new JLabel();
		lblEmail.setBounds(6, 356, 70, 24);
		panel.add(lblEmail);
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setText("E-Mail :");
		lblEmail.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));

		txtEmail = new JTextField();
		txtEmail.setSelectedTextColor(new Color(0, 128, 128));
		txtEmail.setSelectionColor(new Color(255, 255, 0));
		txtEmail.setForeground(new Color(0, 0, 139));
		txtEmail.setDisabledTextColor(new Color(47, 79, 79));
		txtEmail.setBounds(76, 357, 564, 33);
		panel.add(txtEmail);
		txtEmail.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblFixo = new JLabel();
		lblFixo.setBounds(407, 286, 80, 24);
		panel.add(lblFixo);
		lblFixo.setForeground(Color.BLUE);
		lblFixo.setText("Telefone:");
		lblFixo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));

		jcbBairro = new JComboBox();
		jcbBairro.setForeground(new Color(0, 0, 139));
		jcbBairro.setBounds(60, 246, 305, 28);
		panel.add(jcbBairro);
		jcbBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		jcbBairro.setFont(new Font("Arial", Font.BOLD, 14));

		txtFixo = new JTextField();
		txtFixo.setSelectedTextColor(new Color(0, 128, 128));
		txtFixo.setSelectionColor(new Color(255, 255, 0));
		txtFixo.setForeground(new Color(0, 0, 139));
		txtFixo.setDisabledTextColor(new Color(47, 79, 79));
		txtFixo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String fixo = txtFixo.getText().replace(".", "").replace("-", "").trim();
				String c = "0";
				switch (fixo.length()) {
				case 1:
					txtFixo.setText("(" + fixo);
					break;
				case 3:
					txtFixo.setText(txtFixo.getText() + ") ");
					break;
				case 9:
					c = fixo.substring(5, 6).toString();
					if (!c.equals("9")) {
						txtFixo.setText(txtFixo.getText() + " - ");
					}
					break;
				case 10:
					c = fixo.substring(5, 6).toString();
					if (c.equals("9")) {
						txtFixo.setText(txtFixo.getText() + " - ");
					}
					break;
				case 15:
					c = fixo.substring(5, 6).toString();
					if (!c.equals("9")) {
						txtFixo.setEnabled(false);
					}
					break;
				case 16:
					txtFixo.setEnabled(false);
					break;
				}
			}
		});
		txtFixo.setBounds(492, 283, 148, 30);
		panel.add(txtFixo);
		txtFixo.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblPontoReferencia = new JLabel();
		lblPontoReferencia.setText("Ponto Referencia :");
		lblPontoReferencia.setForeground(Color.BLUE);
		lblPontoReferencia.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblPontoReferencia.setBounds(6, 321, 148, 30);
		panel.add(lblPontoReferencia);

		txtPontoReferencia = new JTextField();
		txtPontoReferencia.setSelectedTextColor(new Color(0, 128, 128));
		txtPontoReferencia.setSelectionColor(new Color(255, 255, 0));
		txtPontoReferencia.setForeground(new Color(0, 0, 139));
		txtPontoReferencia.setDisabledTextColor(new Color(47, 79, 79));
		txtPontoReferencia.setText((String) null);
		txtPontoReferencia.setFont(new Font("Dialog", Font.BOLD, 14));
		txtPontoReferencia.setEnabled(false);
		txtPontoReferencia.setBounds(155, 318, 485, 33);
		panel.add(txtPontoReferencia);

		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = clienteDAO.primeiro(true);
				carregarCampos(cliente);
			}
		});
		btnGrava.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cliente = carregarObjeto();
				try {
					
					if (acao == 0) {

						SQL = "UPDATE cliente SET CPF = ?, NOME = ?, LOGRADOURO = ?,  NR = ?, COMPLEMENTO = ?, CEP = ?, CIDADE = ?, UF = ?, PAIS = ?, FIXO = ?,"
								+ " EMAIl = ?, ID_BAIRRO = ? WHERE ID = ?";

						genericoDAO.perssitencia(SQL, cliente.getCpf(), cliente.getNome(), cliente.getLogradouro(),
								cliente.getNr(), cliente.getComplemento(), cliente.getCep(), cliente.getCidade(),
								cliente.getUf(), cliente.getPais(), cliente.getFixo(), cliente.getEmail(),
								cliente.getIdBairro(), cliente.getId());
					} else {
						SQL = "Insert into cliente (CPF,NOME,LOGRADOURO,NR,COMPLEMENTO,CEP,CIDADE,UF,PAIS,FIXO,EMAIl,ID_BAIRRO)"
								+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
						genericoDAO.perssitencia(SQL, cliente.getCpf(), cliente.getNome(), cliente.getLogradouro(),
								cliente.getNr(), cliente.getComplemento(), cliente.getCep(), cliente.getCidade(),
								cliente.getUf(), cliente.getPais(), cliente.getFixo(), cliente.getEmail(),
								cliente.getIdBairro());
					}
					genericoDAO.endTransaction();
					EditarCampos(false);

				} catch (SQLException e) {
					genericoDAO.rollbackTransaction();;
					// TODO Auto-generated catch block

					e.printStackTrace();
				}

			}
		});

	}

	private void carregarCamposComLista(List<String> lista) {
		int n = -1;
		txtCPFCliente.setText(lista.get(2));
		txtNomeCliente.setText(lista.get(3));
		txtCEPCliente.setText(lista.get(4));
		txtLogradouroCliente.setText(lista.get(5));
		txtNRCliente.setText(lista.get(n += 1));
		txtComplementoCliente.setText(lista.get(n += 1));
		txtCidadeCliente.setText(lista.get(n += 1));
		txtUFCliente.setText(lista.get(n += 1));
		txtPaisCliente.setText(lista.get(n += 1));
		txtFixo.setText(lista.get(n += 1));
		txtEmail.setText(lista.get(n += 1));
		txtPontoReferencia.setText(lista.get(n += 1));
	}

	private void carregarCampos(Cliente cliente) {
		if (cliente == null) {

			txtCPFCliente.setText("");
			txtNomeCliente.setText("");
			txtLogradouroCliente.setText("");
			txtNRCliente.setText("");
			txtComplementoCliente.setText("");
			txtCidadeCliente.setText("");
			txtCEPCliente.setText("");
			txtUFCliente.setText("");
			txtPaisCliente.setText("");
			txtFixo.setText("");
			txtEmail.setText("");
			txtPontoReferencia.setText("");
		} else {
			txtIdCliente.setText(cliente.getId().toString());
			txtCPFCliente.setText(cliente.getCpf());
			txtNomeCliente.setText(cliente.getNome());
			txtLogradouroCliente.setText(cliente.getLogradouro());
			txtNRCliente.setText(cliente.getNr());
			txtComplementoCliente.setText(cliente.getComplemento());
			txtCidadeCliente.setText(cliente.getCidade());
			txtCEPCliente.setText(cliente.getCep());
			txtUFCliente.setText(cliente.getUf());
			txtPaisCliente.setText(cliente.getPais());
			txtFixo.setText(cliente.getFixo());
			txtEmail.setText(cliente.getEmail());
			txtPontoReferencia.setText("inclir");
			jcbBairro.setEditable(true);
			jcbBairro.setSelectedItem(cliente.getBairro().getId() + " - " + cliente.getBairro().getNomeBairro());
			jcbBairro.setEditable(false);

			// txtBairroCliente.setText(cliente.getBairro());
		}
	}

	private Cliente carregarObjeto() {
		cliente.setId(Integer.parseInt(txtIdCliente.getText()));
		cliente.setCpf(txtCPFCliente.getText());
		cliente.setNome(txtNomeCliente.getText());
		cliente.setLogradouro(txtLogradouroCliente.getText());
		cliente.setNr(txtNRCliente.getText());
		cliente.setComplemento(txtComplementoCliente.getText());
		cliente.setCidade(txtCidadeCliente.getText());
		cliente.setCep(txtCEPCliente.getText());
		cliente.setUf(txtUFCliente.getText());
		cliente.setPais(txtPaisCliente.getText());
		cliente.setFixo(txtFixo.getText());
		cliente.setEmail(txtEmail.getText());
		// txtPontoReferencia.setText("inclir");

		String bairro = jcbBairro.getSelectedItem().toString();
		int fim = bairro.indexOf(" - ");
		cliente.setIdBairro(Integer.parseInt(bairro.substring(0, fim)));
		return cliente;
	}

	public void EditarCampos(Boolean status) {
		txtCEPCliente.setEnabled(status);
		txtCPFCliente.setEnabled(status);
		txtCidadeCliente.setEnabled(status);
		txtComplementoCliente.setEnabled(status);
		txtLogradouroCliente.setEnabled(status);
		txtNRCliente.setEnabled(status);
		txtNomeCliente.setEnabled(status);
		txtPaisCliente.setEnabled(status);
		txtUFCliente.setEnabled(status);
		txtEmail.setEnabled(status);
		txtFixo.setEnabled(status);
		jcbBairro.setEnabled(status);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void preecherJcbBairro() {
		try {
			jcbBairro.setModel(new DefaultComboBoxModel(bairroDAO.pesquisaBairro()));
		} catch (SQLException ex) {
			//Logger.getLogger(ProdutoGUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
