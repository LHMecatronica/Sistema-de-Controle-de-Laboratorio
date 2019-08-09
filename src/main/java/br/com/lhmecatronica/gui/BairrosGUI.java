package br.com.lhmecatronica.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import br.com.lhmecatronica.dao.BairroDAO;
import br.com.lhmecatronica.dao.NavegadorDAO;
import br.com.lhmecatronica.persistencia.Bairro;
import br.com.lhmecatronica.util.ColunaGrid;
import br.com.lhmecatronica.util.GenericoDAO;
import br.com.lhmecatronica.util.TableModelGenerico;

public class BairrosGUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ButtonColumn buttonColumn;
	BairroDAO bairroDAO;
	Bairro bairro;
	int largura = 690;
	int altura = 530;
	private int acao = 0; // 1 incluir ou 0 editar registro
	private JPanel panel;
	NavegadorDAO navegadorDAO = new NavegadorDAO();
	GenericoDAO genericoDAO = null;
	List<String> retorno = new ArrayList<>();
	private List<Bairro> bairros;
	private TableModelGenerico<Bairro> tableModel;
	// List<List<String>> bairros = new ArrayList<>();
	String navegadorSQL = "SELECT * FROM BAIRRO order by NOME_BAIRRO";

	public BairrosGUI() {
		setUndecorated(true);
		setModal(true);
		getContentPane().setMinimumSize(new Dimension(635, 530));
		setMinimumSize(new Dimension(635, 495));
		setAlwaysOnTop(true);
		// naveg = new NavegadorDAO();
		bairro = new Bairro();
		bairros = new ArrayList<>();
		bairroDAO = new BairroDAO();
		// clienteDAO = ClienteDAO.getInstance();
		initComponents();
		genericoDAO = new GenericoDAO();

		carregarCampos(bairros);
		EditarCampos(false);
		configuraGrid();
		localizaBairro();
	}

	public void initComponents() {
		setTitle("Manutenção de Clientes");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(128, 0, 128));
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(650, 460));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 615, 476);
		getContentPane().setPreferredSize(new Dimension(631, 495));
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		panel.setLayout(null);

		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jLabel1.setOpaque(true);
		jLabel1.setBackground(Color.ORANGE);
		jLabel1.setBounds(6, 11, 600, 60);
		panel.add(jLabel1);

		jLabel1.setFont(new java.awt.Font("Liberation Mono", 1, 24)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setIcon(null); // NOI18N
		jLabel1.setText("Manutenção de Bairros");
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
				genericoDAO = null;
				dispose();
			}
		});
		btnSair.setBounds(22, 405, 60, 60);
		panel.add(btnSair);

		btnSair.setIcon(new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/sair.gif"))); // NOI18N
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
		btnNovo.setBounds(232, 405, 60, 60);
		panel.add(btnNovo);
		btnNovo.setIcon(new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/24x24_ADD.png"))); // NOI18N
		btnNovo.setOpaque(false);
		btnStop = new javax.swing.JButton();
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genericoDAO.rollbackTransaction();
				carregarCampos(bairros);
				EditarCampos(false);
			}
		});
		btnStop.setBounds(92, 405, 60, 60);
		panel.add(btnStop);

		btnStop.setIcon(
				new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/24x24 stop.png"))); // NOI18N
		btnStop.setToolTipText("");
		btnApaga = new javax.swing.JButton();
		btnApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				navegadorSQL = "Delete from cliente WHERE ID = ?";
				try {
					genericoDAO.perssitencia(navegadorSQL, bairro.getId());

					carregarCampos(navegadorDAO.listar(navegadorSQL));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		btnApaga.setBounds(162, 405, 60, 60);
		panel.add(btnApaga);

		btnApaga.setIcon(
				new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/24x24_Delete.png")));
		txtBairro = new javax.swing.JTextField();
		txtBairro.setSelectedTextColor(new Color(0, 128, 128));
		txtBairro.setSelectionColor(new Color(255, 255, 0));
		txtBairro.setForeground(new Color(0, 0, 139));
		txtBairro.setBounds(77, 357, 278, 32);
		panel.add(txtBairro);
		txtBairro.setDisabledTextColor(new Color(47, 79, 79));
		txtBairro.setEnabled(false);

		txtBairro.setFont(new java.awt.Font("Liberation Sans", 1, 14));
		lblNome = new javax.swing.JLabel();
		lblNome.setBounds(6, 355, 60, 32);
		panel.add(lblNome);
		lblNome.setForeground(Color.BLUE);

		lblNome.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblNome.setText("Bairro :");
		btnEdita = new javax.swing.JButton();
		btnEdita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = 0;
				EditarCampos(true);
			}
		});
		btnEdita.setBounds(372, 405, 60, 60);
		panel.add(btnEdita);

		btnEdita.setIcon(
				new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/24x24_Altera.png"))); // NOI18N
		btnEdita.setToolTipText("");
		btnGrava = new javax.swing.JButton();
		btnGrava.setBounds(302, 405, 60, 60);
		panel.add(btnGrava);

		btnGrava.setIcon(
				new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/24x24_Save.png"))); // NOI18N
		btnGrava.setToolTipText("");
		btnLupa = new javax.swing.JButton();
		btnLupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnLupa.setBounds(442, 405, 60, 60);
		panel.add(btnLupa);

		btnLupa.setIcon(
				new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/24x24_Lupa.png")));
		lblTaxaEntrega = new javax.swing.JLabel();
		lblTaxaEntrega.setBounds(361, 355, 141, 32);
		panel.add(lblTaxaEntrega);
		lblTaxaEntrega.setForeground(Color.BLUE);

		lblTaxaEntrega.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16)); // NOI18N
		lblTaxaEntrega.setText("Taxa de Entrega :");
		txtTaxaEntrega = new javax.swing.JTextField();
		txtTaxaEntrega.setSelectedTextColor(new Color(0, 128, 128));
		txtTaxaEntrega.setSelectionColor(new Color(255, 255, 0));
		txtTaxaEntrega.setForeground(new Color(0, 0, 139));
		txtTaxaEntrega.setDisabledTextColor(new Color(47, 79, 79));
		txtTaxaEntrega.setBounds(514, 358, 87, 32);
		panel.add(txtTaxaEntrega);

		txtTaxaEntrega.setFont(new Font("Arial", Font.BOLD, 14));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 82, 599, 264);
		panel.add(scrollPane);

		gridBairros = new JTable();
		gridBairros.setFont(new Font("Dialog", Font.PLAIN, 12));
		scrollPane.setViewportView(gridBairros);
		btnGrava.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bairro = carregarObjeto();
				try {

					if (acao == 0) {

						String SQL = "UPDATE BAIRRO SET NOME_BAIRRO = ?, TX_ENTREGA = ? WHERE ID = ?";

						genericoDAO.perssitencia(SQL, bairro.getNomeBairro(), bairro.getTxEntrega(), bairro.getId());
					} else {
						String SQL = "Insert into BAIRRO (NOME_BAIRRO, TX_ENTREGA)" + "values(?,?)";
						genericoDAO.perssitencia(navegadorSQL, bairro.getNomeBairro(), bairro.getTxEntrega());
					}
					genericoDAO.endTransaction();

					EditarCampos(false);

				} catch (SQLException e) {
					genericoDAO.rollbackTransaction();
					e.printStackTrace();
				}

			}
		});

	}

	private void carregarCampos(List bairros) {
		if (bairro == null) {
			txtBairro.setText("");
			txtTaxaEntrega.setText("");
		} else {
			// txtIdCliente.setText(bairros.get(0).toString());
			// txtBairro.setText(bairros.get(1).toString());
			// txtTaxaEntrega.setText(bairros.get(2).toString());
			carregarObjeto();
		}
	}

	private Bairro carregarObjeto() {
		// bairro.setId(Integer.parseInt(txtIdCliente.getText()));
		// bairro.setNomeBairro(txtBairro.getText());
		// bairro.setTxEntrega(new BigDecimal(txtTaxaEntrega.getText()));
		// txtPontoReferencia.setText("inclir");
		return bairro;
	}

	public void EditarCampos(Boolean status) {
		txtBairro.setEnabled(status);
		txtTaxaEntrega.setEnabled(status);
	}

	private void configuraGrid() {

		tableModel = new TableModelGenerico<>(new Bairro());
		gridBairros.setModel(tableModel);
		Field fields[] = Bairro.class.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(ColunaGrid.class)) {
			}
		}
		int indiceColuna = 0;

		for (Field f : fields) {
			if (f.isAnnotationPresent(ColunaGrid.class)) {
				ColunaGrid m = f.getAnnotation(ColunaGrid.class);
				if (m.mostraColuna()) {
					gridBairros.getColumnModel().getColumn(indiceColuna).setPreferredWidth(m.largura());
				}
				indiceColuna++;
			}
		}
	}

	public void localizaBairro() {
		ResultSet rsBairro = genericoDAO.executaSQL(navegadorSQL);
		try {
			while (rsBairro.next()) {
				delete0 = new JButton("1");
				bairro = new Bairro();
				bairro.setId(rsBairro.getInt("ID"));
				bairro.setNomeBairro(rsBairro.getString("NOME_BAIRRO"));
				bairro.setTxEntrega(rsBairro.getBigDecimal("TX_ENTREGA"));
				bairro.setDelete("Apagar");
				bairro.setEditar("Editar");
				bairros.add(bairro);

			}
			tableModel.setValues(bairros);
			buttonColumn = new ButtonColumn(gridBairros, 3);
			//buttonColumn.renderButton.setIcon(new ImageIcon(BairrosGUI.class.getResource("/recursos/imagem/botoes/navegacao/24x24_Delete.png")));
			buttonColumn = new ButtonColumn(gridBairros, 4);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	private javax.swing.JButton btnApaga, btnEdita, btnGrava, btnLupa, btnNovo, btnSair, btnStop, delete0;
	private javax.swing.JLabel jLabel1, lblNome, lblTaxaEntrega;
	private javax.swing.JTextField txtBairro, txtTaxaEntrega;

	private String sQL;
	private JTable gridBairros;
	private JScrollPane scrollPane;

}
