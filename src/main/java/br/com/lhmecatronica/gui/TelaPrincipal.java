package br.com.lhmecatronica.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.Frame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class TelaPrincipal {

	private JFrame frame;
	public JMenuBar menuBar;
	static JMenu mnPrincipal,mnOrdemDeServio,mnComponentes;
	static JMenuItem mntmClientes ;
	static JMenuItem mntmComponentes ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}

					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		 menuBar = new JMenuBar();
		 menuBar.setBackground(SystemColor.inactiveCaption);
		frame.setJMenuBar(menuBar);

		painelPrincipal = new JDesktopPane();
		painelPrincipal.setForeground(Color.YELLOW);
		painelPrincipal.setBackground(Color.WHITE);
		frame.getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		mnPrincipal = new JMenu("Cadastro");
		mnPrincipal.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/48 x 48 Man.png")));
		mnPrincipal.setBackground(SystemColor.inactiveCaption);
		mnPrincipal.setForeground(Color.BLUE);
		mnPrincipal.setFont(new Font("Arial Black", Font.PLAIN, 17));
		menuBar.add(mnPrincipal);

		mntmComponentes = new JMenuItem("Módulo");
		mntmComponentes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24X24_Download.png")));
		mntmComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComponenteGUI componenteGUI = new ComponenteGUI();
				ChamaTela(componenteGUI);
			}
		});
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24_Cliente.png")));
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteGUI clienteGUI = new ClienteGUI();
				ChamaTela(clienteGUI);
			}
		});
		mnPrincipal.add(mntmClientes);
		mnPrincipal.add(mntmComponentes);
		
		JMenuItem mntmConsultaComponentes = new JMenuItem("Componentes");
		mntmConsultaComponentes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24_Grupo.png")));
		mntmConsultaComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListarComponenteGUI listarComponenteGUI = new ListarComponenteGUI();
				ChamaTela(listarComponenteGUI);

			}
		});
		mnPrincipal.add(mntmConsultaComponentes);
		
		mntmEstoque = new JMenuItem("Estoque");
		mntmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstoqueGUI estoqueGUI = new EstoqueGUI();
				ChamaTela(estoqueGUI);
			}
		});
		mntmEstoque.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24 AdicionaProduto.png")));
		mnPrincipal.add(mntmEstoque);
		
		mnOrdemDeServio = new JMenu("Ordem de Serviço");
		mnOrdemDeServio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/48 x 48 Info.png")));
		mnOrdemDeServio.setBackground(SystemColor.inactiveCaption);
		mnOrdemDeServio.setForeground(Color.BLUE);
		mnOrdemDeServio.setFont(new Font("Arial Black", Font.PLAIN, 17));
		menuBar.add(mnOrdemDeServio);
		
		JMenuItem mntmEntrada = new JMenuItem("Entrada");
		mntmEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioOS formularioOS = new FormularioOS();
				ChamaTela(formularioOS);
			}
		});
		mntmEntrada.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24_Produtos.png")));
		mnOrdemDeServio.add(mntmEntrada);
		
		JMenuItem mntmOramento = new JMenuItem("Orçamento");
		mntmOramento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24 Propriedades.png")));
		mnOrdemDeServio.add(mntmOramento);
		
		JMenuItem mntmReparo = new JMenuItem("Reparo");
		mntmReparo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24 Certificado.png")));
		mnOrdemDeServio.add(mntmReparo);
		
		mnComponentes = new JMenu("Caixa");
		mnComponentes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/48 x 48 Money.png")));
		mnComponentes.setBackground(SystemColor.inactiveCaption);
		mnComponentes.setForeground(Color.BLUE);
		mnComponentes.setFont(new Font("Arial Black", Font.PLAIN, 17));
		menuBar.add(mnComponentes);
		
		JMenuItem mntmRecebimento = new JMenuItem("Recebimento");
		mntmRecebimento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24_caixa.png")));
		mnComponentes.add(mntmRecebimento);
		
		JMenuItem mntmRetirada = new JMenuItem("Retirada");
		mntmRetirada.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24_lista.png")));
		mnComponentes.add(mntmRetirada);
		
		JMenuItem mntmFechamento = new JMenuItem("Fechamento");
		mntmFechamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/menu/24x24 inutilizar.png")));
		mnComponentes.add(mntmFechamento);

	}

	
public void ChamaTela(JInternalFrame internalFrame){
		
	painelPrincipal.removeAll();
	painelPrincipal.repaint(0, 0, 1000, 750);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame.getUI()).setNorthPane(null);
		
		int l1 = painelPrincipal.getWidth()/2;
		int h1 = painelPrincipal.getHeight()/2;
		int l2 = internalFrame.getSize().width/2;
		int h2 = internalFrame.getSize().height/2;
		painelPrincipal.add(internalFrame);
		internalFrame.setLocation(l1-l2, h1-h2);
		internalFrame.setVisible(true);
	}
	
	JDesktopPane painelPrincipal;
	private JMenuItem mntmEstoque;
	static void menu(Boolean i){
	mnPrincipal.setEnabled(i);
	mnOrdemDeServio.setEnabled(i);
	mnComponentes.setEnabled(i);
	}
	

}
