package ipsTeamwork.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ipsTeamwork.controller.GestorDB;
//import ipsTeamwork.model.atleta.crud.ExisteAtletaByEmail;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.inscripcion.InscripcionDto;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3073912408195015551L;

	private static final String PANEL_ATLETA = "panel_atleta";
	private static final String PANEL_INICIO = "panel_inicio";
	private static final String PANEL_ORGANIZADOR = "panel_organizador";
	private static final String PANEL_LISTA_CARRERAS = "panel_lista";
	private static final String PANEL_REGISTRO = "panel_registro";
	private static final String PANEL_INGRESO = "panel_ingreso";
	private static final String PANEL_VERCARRERAS = "panel_verCarreras";

	private JPanel contentPane;
	private JPanel pnInicio;
	private JButton btnAtleta;
	private JButton btnOrganiz;
	private JLabel lbImagen;
	private JPanel pnVistaAtleta;
	private JPanel pnVistaOrganizador;
	private JButton btnListaCarreras;
	private JButton btnMisCarreras;
	private JPanel pnListaCarrerasAtleta;
	private JPanel pnLista14473;
	private JPanel pnListaNorth;
	private JButton btnListaInscribirse;
	private JPanel pnListaSouth;
	private JButton btnListaAtras;
	private JPanel pnRegistro;
	private JPanel pnRegistroCenter;
	private JTextField textRegistroEmail;
	private JTextField textRegistroEdad;
	private JTextField textRegistroNombre;
	private JTextField textRegistroApellidos;
	private JLabel lblRegistroEmail;
	private JLabel lblRegistroRegistroEdad;
	private JLabel lblRegistroNombre;
	private JLabel lblRegistroApellidos;
	private JButton btnRegistroSiguiente;
	private JButton btnRegistroCancelar;
	private JLabel lblRegistro;
	private JLabel lblRegistroSexo;
	private JLabel lblRegistroDiscapacidad;
	private JLabel lblRegistroDNI;
	private JTextField textRegistroDNI;
	private JCheckBox chckbxRegistroDiscapacidad;
	private JComboBox comboRegistroSexo;
	private JPanel pnIngreso;
	private JPanel pnIngresoCenter;
	private JTextField textIngresoEmail;
	private JLabel lblIngesoEmail;
	private JLabel lblIngresoDeCuenta;
	private JButton btnIngresoCancelar;
	private JButton btnIngresoSiguiente;
	private JPanel pnOrganizadorCentro;
	private JButton btnOrganizadorCancelar;
	private JButton btnOrganizadorSiguiente;
	private JButton btnIngresoRegistro;
	private JPanel pnVerCarrerasOrganizador;
	private JPanel pnPrincipalVerCarrerasOrganizador;
	private JButton btVerVarrerasOrganizacion;
	private JScrollPane scVerCarreras;
	private JTable tbVerCarreras;
	private JButton btVerAtletasInscritosPorXCarrera;
	private JScrollPane scVerAtletasInscritosPorXCarrera;
	private JTextArea txaAtletasInscritosEnXCarrera;
	private DefaultTableModel tb;
	private GestorDB db;
	private JScrollPane scrollPaneListaCarrerasAtleta;
	private JTable tablaCarrerasParaAtleta;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		db = new GestorDB();
		tb = (DefaultTableModel) getTbVerCarreras().getModel();
		setResizable(false);
		setTitle("App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnInicio(), PANEL_INICIO);
		contentPane.add(getPnVistaAtleta(), PANEL_ATLETA);
		contentPane.add(getPnVistaOrganizador(), PANEL_ORGANIZADOR);
		contentPane.add(getPnListaCarrerasAtleta(), PANEL_LISTA_CARRERAS);
		contentPane.add(getPnRegistro(), PANEL_REGISTRO);
		contentPane.add(getPnIngreso(), PANEL_INGRESO);
		contentPane.add(getPnVerCarrerasOrganizador(), PANEL_VERCARRERAS);
		verCarrerasOrganizador();
	}

	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setLayout(null);
			pnInicio.add(getBtnAtleta());
			pnInicio.add(getBtnOrganiz());
			pnInicio.add(getLbImagen());
		}
		return pnInicio;
	}

	private JButton getBtnAtleta() {
		if (btnAtleta == null) {
			btnAtleta = new JButton("Soy atleta");
			btnAtleta.setFont(new Font("Arial", Font.PLAIN, 14));
			btnAtleta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INGRESO);
				}
			});
			btnAtleta.setBounds(217, 247, 146, 23);
		}
		return btnAtleta;
	}

	private JButton getBtnOrganiz() {
		if (btnOrganiz == null) {
			btnOrganiz = new JButton("Soy organizador");
			btnOrganiz.setFont(new Font("Arial", Font.PLAIN, 14));
			btnOrganiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_ORGANIZADOR);
				}
			});
			btnOrganiz.setBounds(217, 283, 146, 23);
		}
		return btnOrganiz;
	}

	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("lbImagen");
			lbImagen.setIcon(new ImageIcon(MainWindow.class.getResource("/ipsTeamwork/resources/icon.png")));
			lbImagen.setBounds(111, 60, 361, 140);
		}
		return lbImagen;
	}

	private JPanel getPnVistaAtleta() {
		if (pnVistaAtleta == null) {
			pnVistaAtleta = new JPanel();
			pnVistaAtleta.setLayout(null);
			pnVistaAtleta.add(getBtnListaCarreras());
			pnVistaAtleta.add(getBtnMisCarreras());
		}
		return pnVistaAtleta;
	}

	private JPanel getPnVistaOrganizador() {
		if (pnVistaOrganizador == null) {
			pnVistaOrganizador = new JPanel();
			pnVistaOrganizador.setLayout(new BorderLayout(0, 0));
			pnVistaOrganizador.add(getPnOrganizadorCentro(), BorderLayout.CENTER);
		}
		return pnVistaOrganizador;
	}

	private JButton getBtnListaCarreras() {
		if (btnListaCarreras == null) {
			btnListaCarreras = new JButton("Lista de competiciones");
			btnListaCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
			btnListaCarreras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_LISTA_CARRERAS);
				}
			});
			btnListaCarreras.setBounds(197, 205, 192, 23);
		}
		cargarTablaCarrerasAtleta();
		return btnListaCarreras;
	}

	private JButton getBtnMisCarreras() {
		if (btnMisCarreras == null) {
			btnMisCarreras = new JButton("Mis carreras");
			btnMisCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
			btnMisCarreras.setBounds(197, 239, 192, 23);
		}
		return btnMisCarreras;
	}

	private void showCard(String name) {
		CardLayout c1 = (CardLayout) contentPane.getLayout();
		c1.show(contentPane, name);
	}

	private JPanel getPnListaCarrerasAtleta() {

		if (pnListaCarrerasAtleta == null) {
			pnListaCarrerasAtleta = new JPanel();
			pnListaCarrerasAtleta.setLayout(new BorderLayout(0, 0));
			pnListaCarrerasAtleta.add(getScrollPaneListaCarrerasAtleta(), BorderLayout.CENTER);
			pnListaCarrerasAtleta.add(getPnListaNorth(), BorderLayout.NORTH);
			pnListaCarrerasAtleta.add(getPnListaSouth(), BorderLayout.SOUTH);
		}
		return pnListaCarrerasAtleta;
	}

	public DefaultTableModel cargarTablaCarrerasAtleta() {
		GestorDB db = new GestorDB();
		DefaultTableModel dtm = (DefaultTableModel) getTablaCarrerasParaAtleta().getModel();

		List<CarreraDto> carreras = db.listarCarreras();

		for (CarreraDto dto : carreras) {
			String[] carrerasTabla = { dto.getNombre(), dto.getFecha().toString(), dto.getTipo(),
					String.valueOf(dto.getDistancia()), String.valueOf(dto.getCuota()),
					String.valueOf(dto.getFechaFin()), String.valueOf(dto.getPlazasDisp()) };
			// "Nombre", "Fecha", "Tipo", "Distancia", "Cuota", "Fecha l\u00EDm. insc.",
			// "Plazas disponibles"
			dtm.addRow(carrerasTabla);
		}

		return dtm;
	}

	private JPanel getPnListaNorth() {
		if (pnListaNorth == null) {
			pnListaNorth = new JPanel();
			pnListaNorth.setBackground(Color.LIGHT_GRAY);
			pnListaNorth.add(getBtnListaInscribirse());
		}
		return pnListaNorth;
	}

	private JButton getBtnListaInscribirse() {
		if (btnListaInscribirse == null) {
			btnListaInscribirse = new JButton("Inscribirse");
			btnListaInscribirse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// if selected from table register person into race.
					// then printear justificante. CosasAMover.printJustificante(email);
				}
			});
			btnListaInscribirse.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnListaInscribirse;
	}

	private JPanel getPnListaSouth() {
		if (pnListaSouth == null) {
			pnListaSouth = new JPanel();
			pnListaSouth.setBackground(Color.LIGHT_GRAY);
			pnListaSouth.add(getBtnListaAtras());
		}
		return pnListaSouth;
	}

	private JButton getBtnListaAtras() {
		if (btnListaAtras == null) {
			btnListaAtras = new JButton("Atras");
			btnListaAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INICIO);
				}
			});
			btnListaAtras.setForeground(Color.BLACK);
			btnListaAtras.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnListaAtras;
	}

	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setLayout(new BorderLayout(0, 0));
			pnRegistro.add(getPnRegistroCenter(), BorderLayout.CENTER);
		}
		return pnRegistro;
	}

	private JPanel getPnRegistroCenter() {
		if (pnRegistroCenter == null) {
			pnRegistroCenter = new JPanel();
			pnRegistroCenter.setLayout(null);
			pnRegistroCenter.add(getTextRegistroEmail());
			pnRegistroCenter.add(getTextRegistroEdad());
			pnRegistroCenter.add(getTextRegistroNombre());
			pnRegistroCenter.add(getTextRegistroApellidos());
			pnRegistroCenter.add(getLblRegistroEmail());
			pnRegistroCenter.add(getLblRegistroRegistroEdad());
			pnRegistroCenter.add(getLblRegistroNombre());
			pnRegistroCenter.add(getLblRegistroApellidos());
			pnRegistroCenter.add(getBtnRegistroSiguiente());
			pnRegistroCenter.add(getBtnRegistroCancelar());
			pnRegistroCenter.add(getLblRegistro());
			pnRegistroCenter.add(getLblRegistroSexo());
			pnRegistroCenter.add(getLblRegistroDiscapacidad());
			pnRegistroCenter.add(getLblRegistroDNI());
			pnRegistroCenter.add(getTextRegistroDNI());
			pnRegistroCenter.add(getChckbxRegistroDiscapacidad());
			pnRegistroCenter.add(getComboRegistroSexo());
		}
		return pnRegistroCenter;
	}

	private JTextField getTextRegistroEmail() {
		if (textRegistroEmail == null) {
			textRegistroEmail = new JTextField();
			textRegistroEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroEmail.setColumns(10);
			textRegistroEmail.setBounds(169, 99, 370, 20);
		}
		return textRegistroEmail;
	}

	private JTextField getTextRegistroEdad() {
		if (textRegistroEdad == null) {
			textRegistroEdad = new JTextField();
			textRegistroEdad.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroEdad.setColumns(10);
			textRegistroEdad.setBounds(169, 161, 370, 20);
		}
		return textRegistroEdad;
	}

	private JTextField getTextRegistroNombre() {
		if (textRegistroNombre == null) {
			textRegistroNombre = new JTextField();
			textRegistroNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroNombre.setColumns(10);
			textRegistroNombre.setBounds(169, 192, 370, 20);
		}
		return textRegistroNombre;
	}

	private JTextField getTextRegistroApellidos() {
		if (textRegistroApellidos == null) {
			textRegistroApellidos = new JTextField();
			textRegistroApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroApellidos.setColumns(10);
			textRegistroApellidos.setBounds(169, 223, 370, 20);
		}
		return textRegistroApellidos;
	}

	private JLabel getLblRegistroEmail() {
		if (lblRegistroEmail == null) {
			lblRegistroEmail = new JLabel("Email:");
			lblRegistroEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroEmail.setBounds(46, 99, 80, 20);
		}
		return lblRegistroEmail;
	}

	private JLabel getLblRegistroRegistroEdad() {
		if (lblRegistroRegistroEdad == null) {
			lblRegistroRegistroEdad = new JLabel("Edad:");
			lblRegistroRegistroEdad.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroRegistroEdad.setBounds(46, 161, 80, 20);
		}
		return lblRegistroRegistroEdad;
	}

	private JLabel getLblRegistroNombre() {
		if (lblRegistroNombre == null) {
			lblRegistroNombre = new JLabel("Nombre:");
			lblRegistroNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroNombre.setBounds(46, 192, 80, 20);
		}
		return lblRegistroNombre;
	}

	private JLabel getLblRegistroApellidos() {
		if (lblRegistroApellidos == null) {
			lblRegistroApellidos = new JLabel("Apellidos:");
			lblRegistroApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroApellidos.setBounds(46, 223, 80, 20);
		}
		return lblRegistroApellidos;
	}

	private JButton getBtnRegistroSiguiente() {
		if (btnRegistroSiguiente == null) {
			btnRegistroSiguiente = new JButton("Siguiente");
			btnRegistroSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_ATLETA);
				}
			});
			btnRegistroSiguiente.setForeground(Color.BLACK);
			btnRegistroSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroSiguiente.setBounds(452, 348, 121, 23);
		}
		return btnRegistroSiguiente;
	}

	private JButton getBtnRegistroCancelar() {
		if (btnRegistroCancelar == null) {
			btnRegistroCancelar = new JButton("Cancelar");
			btnRegistroCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INICIO);
				}
			});
			btnRegistroCancelar.setForeground(Color.BLACK);
			btnRegistroCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroCancelar.setBounds(10, 348, 95, 23);
		}
		return btnRegistroCancelar;
	}

	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("REGISTRO DE CUENTA");
			lblRegistro.setFont(new Font("Arial", Font.BOLD, 25));
			lblRegistro.setBounds(37, 21, 691, 53);
		}
		return lblRegistro;
	}

	private JLabel getLblRegistroSexo() {
		if (lblRegistroSexo == null) {
			lblRegistroSexo = new JLabel("Sexo:");
			lblRegistroSexo.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroSexo.setBounds(46, 254, 80, 20);
		}
		return lblRegistroSexo;
	}

	private JLabel getLblRegistroDiscapacidad() {
		if (lblRegistroDiscapacidad == null) {
			lblRegistroDiscapacidad = new JLabel("Discapacidad:");
			lblRegistroDiscapacidad.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroDiscapacidad.setBounds(46, 285, 114, 20);
		}
		return lblRegistroDiscapacidad;
	}

	private JLabel getLblRegistroDNI() {
		if (lblRegistroDNI == null) {
			lblRegistroDNI = new JLabel("DNI:");
			lblRegistroDNI.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroDNI.setBounds(46, 130, 80, 20);
		}
		return lblRegistroDNI;
	}

	private JTextField getTextRegistroDNI() {
		if (textRegistroDNI == null) {
			textRegistroDNI = new JTextField();
			textRegistroDNI.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroDNI.setColumns(10);
			textRegistroDNI.setBounds(169, 130, 370, 20);
		}
		return textRegistroDNI;
	}

	private JCheckBox getChckbxRegistroDiscapacidad() {
		if (chckbxRegistroDiscapacidad == null) {
			chckbxRegistroDiscapacidad = new JCheckBox("");
			chckbxRegistroDiscapacidad.setBounds(169, 285, 177, 23);
		}
		return chckbxRegistroDiscapacidad;
	}

	private JComboBox getComboRegistroSexo() {
		if (comboRegistroSexo == null) {
			comboRegistroSexo = new JComboBox();
			comboRegistroSexo.addItem("Masculino");
			comboRegistroSexo.addItem("Femenino");
			comboRegistroSexo.addItem("Otro");
			comboRegistroSexo.setSelectedIndex(-1);
			comboRegistroSexo.setFont(new Font("Arial", Font.PLAIN, 14));
			comboRegistroSexo.setBounds(169, 254, 370, 22);
		}
		return comboRegistroSexo;
	}

	private JPanel getPnIngreso() {
		if (pnIngreso == null) {
			pnIngreso = new JPanel();
			pnIngreso.setLayout(new BorderLayout(0, 0));
			pnIngreso.add(getPnIngresoCenter(), BorderLayout.CENTER);
		}
		return pnIngreso;
	}

	private JPanel getPnIngresoCenter() {
		if (pnIngresoCenter == null) {
			pnIngresoCenter = new JPanel();
			pnIngresoCenter.setLayout(null);
			pnIngresoCenter.add(getTextIngresoEmail());
			pnIngresoCenter.add(getLblIngesoEmail());
			pnIngresoCenter.add(getLblIngresoDeCuenta());
			pnIngresoCenter.add(getBtnIngresoCancelar());
			pnIngresoCenter.add(getBtnIngresoSiguiente());
			pnIngresoCenter.add(getBtnIngresoRegistro());
		}
		return pnIngresoCenter;
	}

	private JTextField getTextIngresoEmail() {
		if (textIngresoEmail == null) {
			textIngresoEmail = new JTextField();
			textIngresoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			textIngresoEmail.setColumns(10);
			textIngresoEmail.setBounds(102, 188, 379, 20);
		}
		return textIngresoEmail;
	}

	private JLabel getLblIngesoEmail() {
		if (lblIngesoEmail == null) {
			lblIngesoEmail = new JLabel("Email:");
			lblIngesoEmail.setLabelFor(getTextIngresoEmail());
			lblIngesoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			lblIngesoEmail.setBounds(102, 162, 53, 20);
		}
		return lblIngesoEmail;
	}

	private JLabel getLblIngresoDeCuenta() {
		if (lblIngresoDeCuenta == null) {
			lblIngresoDeCuenta = new JLabel("Ingresar como atleta");
			lblIngresoDeCuenta.setFont(new Font("Arial", Font.BOLD, 25));
			lblIngresoDeCuenta.setBounds(37, 21, 355, 53);
		}
		return lblIngresoDeCuenta;
	}

	private JButton getBtnIngresoCancelar() {
		if (btnIngresoCancelar == null) {
			btnIngresoCancelar = new JButton("Cancelar");
			btnIngresoCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INICIO);
				}
			});
			btnIngresoCancelar.setForeground(Color.BLACK);
			btnIngresoCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnIngresoCancelar.setBounds(10, 348, 95, 23);
		}
		return btnIngresoCancelar;
	}

	private JButton getBtnIngresoSiguiente() {
		if (btnIngresoSiguiente == null) {
			btnIngresoSiguiente = new JButton("Siguiente");
			btnIngresoSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					if (new ExisteAtletaByEmail().execute(textIngresoEmail.getText()))
//						showCard(PANEL_LISTA_CARRERAS);
				}
			});
			btnIngresoSiguiente.setForeground(Color.BLACK);
			btnIngresoSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnIngresoSiguiente.setBounds(452, 348, 121, 23);
		}
		return btnIngresoSiguiente;
	}

	private JPanel getPnOrganizadorCentro() {
		if (pnOrganizadorCentro == null) {
			pnOrganizadorCentro = new JPanel();
			pnOrganizadorCentro.setLayout(null);
			pnOrganizadorCentro.add(getBtnOrganizadorCancelar());
			pnOrganizadorCentro.add(getBtnOrganizadorSiguiente());
			pnOrganizadorCentro.add(getBtVerVarrerasOrganizacion());
		}
		return pnOrganizadorCentro;
	}

	private JButton getBtnOrganizadorCancelar() {
		if (btnOrganizadorCancelar == null) {
			btnOrganizadorCancelar = new JButton("Cancelar");
			btnOrganizadorCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INICIO);
				}
			});
			btnOrganizadorCancelar.setBounds(10, 347, 95, 25);
			btnOrganizadorCancelar.setForeground(Color.BLACK);
			btnOrganizadorCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnOrganizadorCancelar;
	}

	private JButton getBtnOrganizadorSiguiente() {
		if (btnOrganizadorSiguiente == null) {
			btnOrganizadorSiguiente = new JButton("Siguiente");
			btnOrganizadorSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnOrganizadorSiguiente.setBounds(452, 348, 121, 23);
			btnOrganizadorSiguiente.setForeground(Color.BLACK);
			btnOrganizadorSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnOrganizadorSiguiente;
	}

	private JButton getBtnIngresoRegistro() {
		if (btnIngresoRegistro == null) {
			btnIngresoRegistro = new JButton("Registrarme");
			btnIngresoRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_REGISTRO);
				}
			});
			btnIngresoRegistro.setBounds(241, 236, 100, 23);
		}
		return btnIngresoRegistro;
	}

	private JPanel getPnVerCarrerasOrganizador() {
		if (pnVerCarrerasOrganizador == null) {
			pnVerCarrerasOrganizador = new JPanel();
			pnVerCarrerasOrganizador.setLayout(new BorderLayout(0, 0));
			pnVerCarrerasOrganizador.add(getPnPrincipalVerCarrerasOrganizador(), BorderLayout.CENTER);
		}
		return pnVerCarrerasOrganizador;
	}

	private JPanel getPnPrincipalVerCarrerasOrganizador() {
		if (pnPrincipalVerCarrerasOrganizador == null) {
			pnPrincipalVerCarrerasOrganizador = new JPanel();
			pnPrincipalVerCarrerasOrganizador.setLayout(null);
			pnPrincipalVerCarrerasOrganizador.add(getScVerCarreras());
			pnPrincipalVerCarrerasOrganizador.add(getBtVerAtletasInscritosPorXCarrera());
			pnPrincipalVerCarrerasOrganizador.add(getScVerAtletasInscritosPorXCarrera());
		}
		return pnPrincipalVerCarrerasOrganizador;
	}

	private JButton getBtVerVarrerasOrganizacion() {
		if (btVerVarrerasOrganizacion == null) {
			btVerVarrerasOrganizacion = new JButton("Ver Carreras");
			btVerVarrerasOrganizacion.setMnemonic('v');
			btVerVarrerasOrganizacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_VERCARRERAS);
				}
			});
			btVerVarrerasOrganizacion.setBounds(218, 129, 153, 42);
		}
		return btVerVarrerasOrganizacion;
	}

	private JScrollPane getScVerCarreras() {
		if (scVerCarreras == null) {
			scVerCarreras = new JScrollPane();
			scVerCarreras.setBounds(161, 27, 233, 149);
			scVerCarreras.setViewportView(getTbVerCarreras());
		}
		return scVerCarreras;
	}

	public JTable getTbVerCarreras() {
		if (tbVerCarreras == null) {
			tbVerCarreras = new JTable();
			tbVerCarreras
					.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Tipo", "Max plazas" }));

		}
		return tbVerCarreras;
	}

	/**
	 * Metodo para ver las Carreras en la tabla de organizador
	 */
	public void verCarrerasOrganizador() {
		GestorDB db = new GestorDB();

		ArrayList<CarreraDto> carreras = db.getArrayCarreras();

		for (CarreraDto carreraDto : carreras) {

			String[] carrerasTabla = { carreraDto.getId(), carreraDto.getTipo(),
					String.valueOf(carreraDto.getPlazasDisp()) };
			tb.addRow(carrerasTabla);
		}
	}

	/**
	 * Metodo cambiar
	 */
	private JButton getBtVerAtletasInscritosPorXCarrera() {
		if (btVerAtletasInscritosPorXCarrera == null) {
			btVerAtletasInscritosPorXCarrera = new JButton("Ver atletas inscritos de esa carrera");
			btVerAtletasInscritosPorXCarrera.setMnemonic('v');
			btVerAtletasInscritosPorXCarrera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String codigo = (String) tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0);

					ArrayList<InscripcionDto> atletas = db.estadoInscripcion(codigo);

					for (InscripcionDto inscripcionDto : atletas) {

						System.out.println(inscripcionDto.toString());

						getTxaAtletasInscritosEnXCarrera().setText(inscripcionDto.toStringVerAtletas());

					}

				}
			});
			btVerAtletasInscritosPorXCarrera.setBounds(161, 198, 233, 21);
		}
		return btVerAtletasInscritosPorXCarrera;
	}

	private JScrollPane getScVerAtletasInscritosPorXCarrera() {
		if (scVerAtletasInscritosPorXCarrera == null) {
			scVerAtletasInscritosPorXCarrera = new JScrollPane();
			scVerAtletasInscritosPorXCarrera.setBounds(161, 246, 238, 98);
			scVerAtletasInscritosPorXCarrera.setViewportView(getTxaAtletasInscritosEnXCarrera());
		}
		return scVerAtletasInscritosPorXCarrera;
	}

	private JTextArea getTxaAtletasInscritosEnXCarrera() {
		if (txaAtletasInscritosEnXCarrera == null) {
			txaAtletasInscritosEnXCarrera = new JTextArea();
			txaAtletasInscritosEnXCarrera.setEditable(false);

		}
		return txaAtletasInscritosEnXCarrera;
	}

	private JScrollPane getScrollPaneListaCarrerasAtleta() {
		if (scrollPaneListaCarrerasAtleta == null) {
			scrollPaneListaCarrerasAtleta = new JScrollPane();
			scrollPaneListaCarrerasAtleta.add(getTablaCarrerasParaAtleta());
		}
		return scrollPaneListaCarrerasAtleta;
	}

	private JTable getTablaCarrerasParaAtleta() {
		if (tablaCarrerasParaAtleta == null) {
			tablaCarrerasParaAtleta = new JTable();

			tablaCarrerasParaAtleta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Fecha",
					"Tipo", "Distancia", "Cuota", "Fecha l\u00EDm. insc.", "Plazas disponibles" }));
			tablaCarrerasParaAtleta.getColumnModel().getColumn(0).setPreferredWidth(57);
			tablaCarrerasParaAtleta.getColumnModel().getColumn(1).setPreferredWidth(48);
			tablaCarrerasParaAtleta.getColumnModel().getColumn(2).setPreferredWidth(37);
			tablaCarrerasParaAtleta.getColumnModel().getColumn(3).setPreferredWidth(55);
			tablaCarrerasParaAtleta.getColumnModel().getColumn(4).setPreferredWidth(53);
			tablaCarrerasParaAtleta.getColumnModel().getColumn(5).setPreferredWidth(85);
			tablaCarrerasParaAtleta.getColumnModel().getColumn(6).setPreferredWidth(100);

		}
		return tablaCarrerasParaAtleta;
	}
}
