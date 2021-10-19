package ipsTeamwork.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.atleta.crud.ExisteAtletaByEmail;
import ipsTeamwork.model.atleta.crud.FindAtletaInCarrera;
import ipsTeamwork.model.atleta.crud.ReadAtletaByEmail;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.carrera.crud.MirarLimiteCarrera;
import ipsTeamwork.model.carrera.crud.SelectAllVistaAtleta;
import ipsTeamwork.model.carrera.crud.UpdateCarrera;
import ipsTeamwork.model.categoria.Categoria;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.model.inscripcion.crud.InscribirseAtleta;
import ipsTeamwork.model.inscripcion.crud.UpdateInscribirseAtleta;
import ipsTeamwork.util.DtoBuilder;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 3073912408195015551L;

	public static final String PANEL_ATLETA = "panel_atleta";
	private static final String PANEL_INICIO = "panel_inicio";
	private static final String PANEL_ORGANIZADOR = "panel_organizador";
	private static final String PANEL_LISTA_CARRERAS = "panel_lista_carreras_atleta";
	private static final String PANEL_REGISTRO = "panel_registro";
	private static final String PANEL_INGRESO = "panel_ingreso";
	private static final String PANEL_VERCARRERASORGANIZADOR = "panel_lista_carreras_organizador";
	private static final String PANEL_VERCLASIFICACIONESORGANIZADOR = "panel_lista_clasificaciones_organizador";

	private static final String PANEL_PAGARINSCRIPCION = "panel_PagarInscripcion";
	private static final String PANEL_LISTA_INSCRIPCIONES = "panel_lista_inscripciones_atleta";

	private static final String PANEL_PAGO_TARJETA = "panel_pago_tarjeta";

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
	private JPanel pnListaCarrerasOrganizador;

	private JPanel pnListaClasificacionesOrganizador;
	private JPanel pnListaClasificacionesOrganizadorHombres;
	private JPanel pnListaClasificacionesOrganizadorMujeres;

	private JPanel pnPrincipalVerCarrerasOrganizador;

	private JPanel pnPrincipalVerClasificacionesOrganizador;
	private JButton btVerVarrerasOrganizacion;
	private JScrollPane scVerCarreras;

	private JLabel lbClasificacionGeneral;
	private JScrollPane scVerClasificacionesHombres;
	private JScrollPane scVerClasificacionesMujeres;
	private JLabel lbClasificacionGeneralHombres;
	private JLabel lbClasificacionGeneralMujeres;
	private JScrollPane scVerClasificaciones;

	private JTable tbVerCarreras;
	private JTable tbVerClasificaciones;
	private JTable tbVerClasificacionesHombres;
	private JTable tbVerClasificacionesMujeres;
	private JButton btVerAtletasInscritosPorXCarrera;
	private JScrollPane scVerAtletasInscritosPorXCarrera;
	private JTable tbAtletasInscritosEnXCarrera;
	private DefaultTableModel tb;
	private DefaultTableModel tablaAtleta;
	private DefaultTableModel tablaAtletasInscritosX;

	private DefaultTableModel tablaClasificaciones;
	private DefaultTableModel tablaClasificacionesHombres;
	private DefaultTableModel tablaClasificacionesMujeres;

	private GestorDB db;
	private JScrollPane scrollPaneListaCarrerasAtleta;
	private JTable tablaCarrerasParaAtleta;
	private AtletaDto atletaActual = null; // Atleta que esta usando la app ya sea registrado o logeado.
	private CarreraDto carreraActual = null;
	private InscripcionDto inscripcion = null;
	private JButton btAtrasVerCarrerasOrganizador;
	private JPanel pnPagarInscripcion;

	private JPanel pnPrincipalPagarInscripcion;
	private JButton btPagarInscripcionTarjeta;
	private JButton btPagarInscripcionTransferencia;
	private JButton btPagarinscripcionAtras;
	private JButton btVistaAtletaAtras;
	private JPanel pnVistaInscripcionesAtleta;
	private JButton btVerClasificacionesOrganizacion;
	private JButton btListaClasificacionesAtras;

	private JPanel pnPagoTarjeta;
	private JPanel pnPagoTarjetaCenter;
	private JLabel lbPagoTarjeta;
	private JLabel lbPagoTarjetaNumero;
	private JLabel lbPagoTarjetaCódigoCVC;
	private JLabel lbPagoTarjetaFechaCaducidad;
	private JTextField txPagoTarjetaNumero;
	private JTextField txPagoTarjetaCódigoCVC;
	private JTextField txPagoTarjetaFechaCaducidad;
	private JButton btPagoTarjetaEnviar;
	private JLabel lbPagarInscripcion;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		db = new GestorDB();
		tb = (DefaultTableModel) getTbVerCarreras().getModel();
		tablaClasificaciones = (DefaultTableModel) getTbVerClasificaciones().getModel();
		tablaClasificacionesHombres = (DefaultTableModel) getTbVerClasificacionesHombres().getModel();
		tablaClasificacionesMujeres = (DefaultTableModel) getTbVerClasificacionesMujeres().getModel();
		tablaAtleta = (DefaultTableModel) getTablaCarrerasParaAtleta().getModel();
		tablaAtletasInscritosX = (DefaultTableModel) getTbAtletasInscritosEnXCarrera().getModel();
		pnVistaInscripcionesAtleta = new PanelListarInscripciones(this, atletaActual);
		setResizable(false);
		setTitle("Carreras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 538);
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
		contentPane.add(getPnListaCarrerasOrganizador(), PANEL_VERCARRERASORGANIZADOR);
		contentPane.add(getPnPagarInscripcion(), PANEL_PAGARINSCRIPCION);
		contentPane.add(pnVistaInscripcionesAtleta, PANEL_LISTA_INSCRIPCIONES);
		contentPane.add(getPnListaClasificacionesOrganizador(), PANEL_VERCLASIFICACIONESORGANIZADOR);
		contentPane.add(getPnPagoTarjeta(), PANEL_PAGO_TARJETA);

		cargarTablaCarrerasOrganizador();
		cargarTablaCarrerasAtleta();
		cargarTablaClasificacionesOrganizador();
	}

	public AtletaDto getAtletaActual() {
		return atletaActual;
	}

	public void setAtletaActual(AtletaDto atletaActual) {
		this.atletaActual = atletaActual;
		((PanelListarInscripciones) pnVistaInscripcionesAtleta).setAtleta(atletaActual);
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
			btnAtleta.setBounds(241, 345, 146, 23);
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
			btnOrganiz.setBounds(470, 345, 146, 23);
		}
		return btnOrganiz;
	}

	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("");
			lbImagen.setIcon(new ImageIcon(MainWindow.class.getResource("/ipsTeamwork/resources/icon.png")));
			lbImagen.setBounds(241, 42, 375, 276);
		}
		return lbImagen;
	}

	private JPanel getPnVistaAtleta() {
		if (pnVistaAtleta == null) {
			pnVistaAtleta = new JPanel();
			pnVistaAtleta.setLayout(null);
			pnVistaAtleta.add(getBtnListaCarreras());
			pnVistaAtleta.add(getBtnMisCarreras());
			pnVistaAtleta.add(getBtVistaAtletaAtras());
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
			btnListaCarreras.setBounds(210, 120, 435, 46);
		}
		return btnListaCarreras;
	}

	private JButton getBtnMisCarreras() {
		if (btnMisCarreras == null) {
			btnMisCarreras = new JButton("Mis carreras");
			btnMisCarreras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

//					DefaultTableModel tbVerAtletasMisCarreras = (DefaultTableModel) tb.getModel();
//
//					reset(tbVerAtletasMisCarreras);

					showCard(PANEL_LISTA_INSCRIPCIONES);
					((PanelListarInscripciones) pnVistaInscripcionesAtleta).cargarInscripcionesEnTabla();
				}
			});
			btnMisCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
			btnMisCarreras.setBounds(210, 247, 435, 46);
		}
		return btnMisCarreras;
	}

	public void showCard(String name) {
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

	public void cargarTablaCarrerasAtleta() {
		List<CarreraDto> carreras = new SelectAllVistaAtleta().execute();

		for (CarreraDto dto : carreras) {
			String[] carrerasTabla = { dto.getNombre(), dto.getFecha().toString(), dto.getTipo(),
					String.valueOf(dto.getDistancia()), String.valueOf(dto.getCuota()), dto.getFechaFin().toString(),
					String.valueOf(dto.getPlazasDisp()) };
			// "Nombre", "Fecha", "Tipo", "Distancia", "Cuota", "Fecha l\u00EDm. insc.",
			// "Plazas disponibles"
			tablaAtleta.addRow(carrerasTabla);
		}
	}

	public void cargarTablaCarrerasOrganizador() {
		GestorDB db = new GestorDB();

		ArrayList<CarreraDto> carreras = db.getArrayCarreras();

		for (CarreraDto carreraDto : carreras) {

			String[] carrerasTabla = { carreraDto.getIdCarrera(), carreraDto.getTipo(),
					String.valueOf(carreraDto.getPlazasDisp()) };
			tb.addRow(carrerasTabla);
		}
	}

	public void cargarTablaClasificacionesOrganizador() {
		GestorDB db = new GestorDB();

		ArrayList<InscripcionDto> inscripciones = db.getArrayClasificaciones();

		int posicion = 1;

		for (InscripcionDto inscripcionDto : inscripciones) {

			String[] clasificacionesTabla = { Integer.toString(posicion) + "º", inscripcionDto.getAtleta().getSexo(),
					inscripcionDto.getAtleta().getNombre(), inscripcionDto.getTiempoCorriendo() };
			tablaClasificaciones.addRow(clasificacionesTabla);
			posicion++;
		}

		ArrayList<InscripcionDto> inscripcionesHombres = db.getArrayClasificacionesHombres();

		posicion = 1;

		for (InscripcionDto inscripcionDto : inscripcionesHombres) {

			String[] clasificacionesTabla = { Integer.toString(posicion) + "º", inscripcionDto.getAtleta().getNombre(),
					inscripcionDto.getTiempoCorriendo() };
			tablaClasificacionesHombres.addRow(clasificacionesTabla);
			posicion++;
		}

		ArrayList<InscripcionDto> inscripcionesMujeres = db.getArrayClasificacionesMujeres();

		posicion = 1;

		for (InscripcionDto inscripcionDto : inscripcionesMujeres) {

			String[] clasificacionesTabla = { Integer.toString(posicion) + "º", inscripcionDto.getAtleta().getNombre(),
					inscripcionDto.getTiempoCorriendo() };
			tablaClasificacionesMujeres.addRow(clasificacionesTabla);
			posicion++;
		}

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
					inscribirAtleta();
				}
			});
			btnListaInscribirse.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnListaInscribirse;
	}

	/**
	 * Metodo para comprobar si cumple los requisitos el atleta como para participar
	 * en dicha carrera
	 * 
	 * @return boolean
	 */
	private boolean checkIfParticipable() {

		boolean res = false;

		if (checkValidDate()) {
			res = true;
		}
		if (new MirarLimiteCarrera().execute(carreraActual.getIdCarrera(), carreraActual.getMaxPlazas())) {
			res = true;
		} else {
			JOptionPane.showMessageDialog(null, "Error: La carrera actualmente no tiene mas plazas.");
			res = false;
		}

		return res;
	}

	private boolean checkValidDate() {
		// check si plazo abierto.
		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String limitDate = new SimpleDateFormat("yyyy-MM-dd").format(carreraActual.getFechaFin());
		if (limitDate.compareTo(todayDate) < 0) { // if limit date passed
			JOptionPane.showMessageDialog(null, "Error: La fecha de inscripcion a la carrera ya ha pasado.");
			return false;
		} else {
			return true;
		}
	}

	private boolean checkCarreraRow() {
		try {
			Vector vector = tablaAtleta.getDataVector().elementAt(tablaCarrerasParaAtleta.getSelectedRow());
			if (vector != null) {
				carreraActual = db.selectCarrerasNombre((String) vector.get(0));
				return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna carrera");
		}
		return false;
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
					showCard(PANEL_ATLETA);
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

	private JPanel getPnPagoTarjeta() {
		if (pnPagoTarjeta == null) {
			pnPagoTarjeta = new JPanel();
			pnPagoTarjeta.setLayout(new BorderLayout(0, 0));
			pnPagoTarjeta.add(getPnPagoTarjetaCenter(), BorderLayout.CENTER);
		}
		return pnPagoTarjeta;
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

	private JPanel getPnPagoTarjetaCenter() {
		if (pnPagoTarjetaCenter == null) {
			pnPagoTarjetaCenter = new JPanel();
			pnPagoTarjetaCenter.setLayout(null);
			pnPagoTarjetaCenter.add(getLbPagoTarjeta());
			pnPagoTarjetaCenter.add(getLbPagoTarjetaNumero());
			pnPagoTarjetaCenter.add(getLbPagoTarjetaCódigoCVC());
			pnPagoTarjetaCenter.add(getLbPagoTarjetaFechaCaducidad());
			pnPagoTarjetaCenter.add(getTxPagoTarjetaNumero());
			pnPagoTarjetaCenter.add(getTxPagoTarjetaCódigoCVC());
			pnPagoTarjetaCenter.add(getTxPagoTarjetaFechaCaducidad());
			pnPagoTarjetaCenter.add(getBtPagoTarjetaEnviar());

		}
		return pnPagoTarjetaCenter;
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
					if (checkFieldsRegisters()) {
						if (Integer.parseInt(textRegistroEdad.getText()) >= 18) {
							setAtletaActual(new AtletaDto(textRegistroDNI.getText(),
									textRegistroNombre.getText() + " " + textRegistroApellidos.getText(),
									Integer.parseInt(textRegistroEdad.getText()),
									("" + ((String) comboRegistroSexo.getSelectedItem()).charAt(0)),
									chckbxRegistroDiscapacidad.isSelected() ? 1 : 0, textRegistroEmail.getText()));

							String cate = Categoria.calculaCategoria(atletaActual.getEdad(), atletaActual.getSexo());
							atletaActual.setCategoria(cate);
							showCard(PANEL_ATLETA);
							cleanRegistro();
							JOptionPane.showMessageDialog(null, "Registro satisfactorio , bienvenido.");
						}
					}
				}
			});
			btnRegistroSiguiente.setForeground(Color.BLACK);
			btnRegistroSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroSiguiente.setBounds(452, 348, 121, 23);
		}
		return btnRegistroSiguiente;
	}

	private void cleanRegistro() {
		textRegistroDNI.setText("");
		textRegistroNombre.setText("");
		textRegistroApellidos.setText("");
		textRegistroEmail.setText("");
		textRegistroEdad.setText("");
		comboRegistroSexo.setSelectedIndex(-1);
		chckbxRegistroDiscapacidad.setSelected(false);
	}

	private boolean checkFieldsRegisters() {
		if (isEmptyRegister()) {
			JOptionPane.showMessageDialog(null, "Error: Algunos campos estan vacios.");
			return false;
		}
		return true;
	}

	private boolean comprobarDatosTarjeta() {
		if (camposVacíos()) {
			JOptionPane.showMessageDialog(null, "Error: Falta alguno de los datos.");
			return false;
		}
		return true;
	}

	private boolean camposVacíos() {
		return (txPagoTarjetaCódigoCVC.getText().isEmpty() || txPagoTarjetaCódigoCVC.getText().isBlank()
				|| txPagoTarjetaFechaCaducidad.getText().isEmpty() || txPagoTarjetaFechaCaducidad.getText().isBlank()
				|| txPagoTarjetaNumero.getText().isEmpty() || txPagoTarjetaNumero.getText().isBlank());
	}

	private boolean isEmptyRegister() { // modificar de cara a siguientes sprints.
		return (textRegistroDNI.getText().isEmpty() || textRegistroNombre.getText().isEmpty()
				|| textRegistroApellidos.getText().isEmpty() || textRegistroEmail.getText().isEmpty()
				|| textRegistroEdad.getText().isEmpty()); // esto no va a funcionar
															// comboRegistroSexo.getSelectedItem().equals(""));
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
		}
		return pnIngresoCenter;
	}

	private JTextField getTextIngresoEmail() {
		if (textIngresoEmail == null) {
			textIngresoEmail = new JTextField();
			textIngresoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			textIngresoEmail.setColumns(10);
			textIngresoEmail.setBounds(150, 188, 597, 53);
		}
		return textIngresoEmail;
	}

	private JLabel getLblIngesoEmail() {
		if (lblIngesoEmail == null) {
			lblIngesoEmail = new JLabel("Introduzca su correo electrónico:");
			lblIngesoEmail.setLabelFor(getTextIngresoEmail());
			lblIngesoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			lblIngesoEmail.setBounds(150, 148, 597, 34);
		}
		return lblIngesoEmail;
	}

	private JLabel getLblIngresoDeCuenta() {
		if (lblIngresoDeCuenta == null) {
			lblIngresoDeCuenta = new JLabel("INGRESAR COMO ATLETA");
			lblIngresoDeCuenta.setFont(new Font("Arial", Font.BOLD, 25));
			lblIngresoDeCuenta.setBounds(241, 21, 355, 53);
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
			btnIngresoCancelar.setBounds(30, 435, 136, 34);
		}
		return btnIngresoCancelar;
	}

	private JButton getBtnIngresoSiguiente() {
		if (btnIngresoSiguiente == null) {
			btnIngresoSiguiente = new JButton("Siguiente");
			btnIngresoSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ingresoAtleta(textIngresoEmail.getText());
				}
			});
			btnIngresoSiguiente.setForeground(Color.BLACK);
			btnIngresoSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnIngresoSiguiente.setBounds(741, 435, 136, 34);
		}
		return btnIngresoSiguiente;
	}

	private void inscribirAtleta() {
		if (checkCarreraRow() && checkIfParticipable()) {
			if (new FindAtletaInCarrera().execute(atletaActual.getIdAtleta(), carreraActual.getIdCarrera())) { // no va
				String otro = "Nombre del corredor: " + atletaActual.getNombre()
						+ "\nEstas apuntado a la carrera con nombre: " + carreraActual.getNombre()
						+ "\nEn la categoria: " + atletaActual.getCategoria() + "\nCon fecha de inscripcion: "
						+ new Date() + "\nTienes que pagar: " + carreraActual.getCuota();

				System.out.println(carreraActual.getIdCarrera());
				inscripcion = DtoBuilder.ParamsToInscripcionDto(atletaActual, carreraActual,
						UUID.randomUUID().toString().substring(0, 3), "Pre-Inscrito", new Date(), null);
				new UpdateCarrera().execute(carreraActual);
				JOptionPane.showConfirmDialog(btPagarInscripcionTransferencia, otro, "Justificante carrera",
						JOptionPane.DEFAULT_OPTION);
				showCard(PANEL_PAGARINSCRIPCION);
				textIngresoEmail.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Error: Ya estas en esta carrera.");
			}
		}
	}

	private void ingresoAtleta(String email) {
		if (email.trim().strip().isEmpty())
			JOptionPane.showMessageDialog(this, "Introduce tu email");
		else {
			if (new ExisteAtletaByEmail().execute(email)) {
				setAtletaActual(new ReadAtletaByEmail(email).execute());
				atletaActual.setCategoria(Categoria.calculaCategoria(atletaActual.getEdad(), atletaActual.getSexo()));
				System.out.println(atletaActual.getCategoria());

				showCard(PANEL_ATLETA);
			} else {
				JOptionPane.showMessageDialog(this, "No estás registrado.");
			}
		}
	}

	private JPanel getPnOrganizadorCentro() {
		if (pnOrganizadorCentro == null) {
			pnOrganizadorCentro = new JPanel();
			pnOrganizadorCentro.setLayout(null);
			pnOrganizadorCentro.add(getBtnOrganizadorCancelar());
			pnOrganizadorCentro.add(getBtnOrganizadorSiguiente());
			pnOrganizadorCentro.add(getBtVerVarrerasOrganizacion());
			pnOrganizadorCentro.add(getBtVerClasificacionesOrganizacion());
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
			btnOrganizadorCancelar.setBounds(30, 435, 136, 34);
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
			btnOrganizadorSiguiente.setBounds(741, 435, 136, 34);
			btnOrganizadorSiguiente.setForeground(Color.BLACK);
			btnOrganizadorSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnOrganizadorSiguiente;
	}

	private JPanel getPnListaCarrerasOrganizador() {
		if (pnListaCarrerasOrganizador == null) {
			pnListaCarrerasOrganizador = new JPanel();
			pnListaCarrerasOrganizador.setLayout(new BorderLayout(0, 0));
			pnListaCarrerasOrganizador.add(getPnPrincipalVerCarrerasOrganizador(), BorderLayout.CENTER);
		}
		return pnListaCarrerasOrganizador;
	}

	private JPanel getPnListaClasificacionesOrganizador() {
		if (pnListaClasificacionesOrganizador == null) {
			pnListaClasificacionesOrganizador = new JPanel();
			pnListaClasificacionesOrganizador.setLayout(new BorderLayout(0, 0));
			pnListaClasificacionesOrganizador.add(getPnPrincipalVerClasificacionesOrganizador(), BorderLayout.CENTER);
		}
		return pnListaClasificacionesOrganizador;
	}

	private JPanel getPnListaClasificacionesOrganizadorHombres() {
		if (pnListaClasificacionesOrganizadorHombres == null) {
			pnListaClasificacionesOrganizadorHombres = new JPanel();
			pnListaClasificacionesOrganizadorHombres.setLayout(new BorderLayout(0, 0));
			pnListaClasificacionesOrganizadorHombres.add(getPnPrincipalVerClasificacionesOrganizador(),
					BorderLayout.CENTER);
		}
		return pnListaClasificacionesOrganizadorHombres;
	}

	private JPanel getPnListaClasificacionesOrganizadorMujeres() {
		if (pnListaClasificacionesOrganizadorMujeres == null) {
			pnListaClasificacionesOrganizadorMujeres = new JPanel();
			pnListaClasificacionesOrganizadorMujeres.setLayout(new BorderLayout(0, 0));
			pnListaClasificacionesOrganizadorMujeres.add(getPnPrincipalVerClasificacionesOrganizador(),
					BorderLayout.CENTER);
		}
		return pnListaClasificacionesOrganizadorMujeres;
	}

	private Component getPnPrincipalVerClasificacionesOrganizador() {
		if (pnPrincipalVerClasificacionesOrganizador == null) {
			pnPrincipalVerClasificacionesOrganizador = new JPanel();
			pnPrincipalVerClasificacionesOrganizador.setLayout(null);
			pnPrincipalVerClasificacionesOrganizador.add(getScVerClasificaciones());
			pnPrincipalVerClasificacionesOrganizador.add(getLbClasificacionGeneral());
			pnPrincipalVerClasificacionesOrganizador.add(getScVerClasificacionesHombres());
			pnPrincipalVerClasificacionesOrganizador.add(getScVerClasificacionesMujeres());
			pnPrincipalVerClasificacionesOrganizador.add(getLbClasificacionGeneralHombres());
			pnPrincipalVerClasificacionesOrganizador.add(getLbClasificacionGeneralMujeres());
			pnPrincipalVerClasificacionesOrganizador.add(getBtListaClasificacionesAtras());

			// pnPrincipalVerClasificacionesOrganizador.add(getBtAtrasVerCarrerasOrganizador());
		}
		return pnPrincipalVerClasificacionesOrganizador;
	}

	private JPanel getPnPrincipalVerCarrerasOrganizador() {
		if (pnPrincipalVerCarrerasOrganizador == null) {
			pnPrincipalVerCarrerasOrganizador = new JPanel();
			pnPrincipalVerCarrerasOrganizador.setLayout(null);
			pnPrincipalVerCarrerasOrganizador.add(getScVerCarreras());
			pnPrincipalVerCarrerasOrganizador.add(getBtVerAtletasInscritosPorXCarrera());
			pnPrincipalVerCarrerasOrganizador.add(getScVerAtletasInscritosPorXCarrera());
			pnPrincipalVerCarrerasOrganizador.add(getBtAtrasVerCarrerasOrganizador());
		}
		return pnPrincipalVerCarrerasOrganizador;
	}

	private JButton getBtVerVarrerasOrganizacion() {
		if (btVerVarrerasOrganizacion == null) {
			btVerVarrerasOrganizacion = new JButton("Ver Carreras");
			btVerVarrerasOrganizacion.setFont(new Font("Arial", Font.PLAIN, 14));
			btVerVarrerasOrganizacion.setMnemonic('v');
			btVerVarrerasOrganizacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_VERCARRERASORGANIZADOR);
				}
			});
			btVerVarrerasOrganizacion.setBounds(210, 120, 435, 46);
		}
		return btVerVarrerasOrganizacion;
	}

	private JScrollPane getScVerCarreras() {
		if (scVerCarreras == null) {
			scVerCarreras = new JScrollPane();
			scVerCarreras.setBounds(161, 27, 596, 161);
			scVerCarreras.setViewportView(getTbVerCarreras());
		}
		return scVerCarreras;
	}

	private JScrollPane getScVerClasificaciones() {
		if (scVerClasificaciones == null) {
			scVerClasificaciones = new JScrollPane();
			scVerClasificaciones.setBounds(43, 56, 252, 369);
			scVerClasificaciones.setViewportView(getTbVerClasificaciones());
		}
		return scVerClasificaciones;
	}

	private JLabel getLbClasificacionGeneral() {
		if (lbClasificacionGeneral == null) {
			lbClasificacionGeneral = new JLabel("Clasificación General");
			lbClasificacionGeneral.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbClasificacionGeneral.setHorizontalAlignment(SwingConstants.CENTER);
			lbClasificacionGeneral.setBounds(43, 25, 252, 22);
		}
		return lbClasificacionGeneral;
	}

	private JScrollPane getScVerClasificacionesHombres() {
		if (scVerClasificacionesHombres == null) {
			scVerClasificacionesHombres = new JScrollPane();
			scVerClasificacionesHombres.setBounds(322, 56, 252, 369);
			scVerClasificacionesHombres.setViewportView(getTbVerClasificacionesHombres());
		}
		return scVerClasificacionesHombres;
	}

	private JScrollPane getScVerClasificacionesMujeres() {
		if (scVerClasificacionesMujeres == null) {
			scVerClasificacionesMujeres = new JScrollPane();
			scVerClasificacionesMujeres.setBounds(603, 56, 252, 369);
			scVerClasificacionesMujeres.setViewportView(getTbVerClasificacionesMujeres());
		}
		return scVerClasificacionesMujeres;
	}

	private JLabel getLbClasificacionGeneralHombres() {
		if (lbClasificacionGeneralHombres == null) {
			lbClasificacionGeneralHombres = new JLabel("Clasificación General Hombres");
			lbClasificacionGeneralHombres.setHorizontalAlignment(SwingConstants.CENTER);
			lbClasificacionGeneralHombres.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbClasificacionGeneralHombres.setBounds(322, 25, 252, 22);
		}
		return lbClasificacionGeneralHombres;
	}

	private JLabel getLbClasificacionGeneralMujeres() {
		if (lbClasificacionGeneralMujeres == null) {
			lbClasificacionGeneralMujeres = new JLabel("Clasificación General Mujeres");
			lbClasificacionGeneralMujeres.setHorizontalAlignment(SwingConstants.CENTER);
			lbClasificacionGeneralMujeres.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbClasificacionGeneralMujeres.setBounds(603, 25, 252, 22);
		}
		return lbClasificacionGeneralMujeres;
	}

	public JTable getTbVerCarreras() {
		if (tbVerCarreras == null) {
			tbVerCarreras = new JTable();
			tbVerCarreras
					.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Tipo", "Max plazas" }));

			tbVerCarreras.setDefaultEditor(Object.class, null);

		}
		return tbVerCarreras;
	}

	public JTable getTbVerClasificaciones() {
		if (tbVerClasificaciones == null) {
			tbVerClasificaciones = new JTable();
			tbVerClasificaciones.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Posición", "Género", "Nombre", "Tiempo" }));

			tbVerClasificaciones.setDefaultEditor(Object.class, null);

		}
		return tbVerClasificaciones;
	}

	public JTable getTbVerClasificacionesHombres() {
		if (tbVerClasificacionesHombres == null) {
			tbVerClasificacionesHombres = new JTable();
			tbVerClasificacionesHombres.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Posición", "Nombre", "Tiempo" }));

			tbVerClasificacionesHombres.setDefaultEditor(Object.class, null);

		}
		return tbVerClasificacionesHombres;
	}

	public JTable getTbVerClasificacionesMujeres() {
		if (tbVerClasificacionesMujeres == null) {
			tbVerClasificacionesMujeres = new JTable();
			tbVerClasificacionesMujeres.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Posición", "Nombre", "Tiempo" }));

			tbVerClasificacionesMujeres.setDefaultEditor(Object.class, null);

		}
		return tbVerClasificacionesMujeres;
	}

	/**
	 * Metodo cambiar
	 */
	private JButton getBtVerAtletasInscritosPorXCarrera() {
		if (btVerAtletasInscritosPorXCarrera == null) {
			btVerAtletasInscritosPorXCarrera = new JButton("Ver atletas inscritos de esa carrera");
			btVerAtletasInscritosPorXCarrera.setFont(new Font("Arial", Font.PLAIN, 14));
			btVerAtletasInscritosPorXCarrera.setMnemonic('v');
			btVerAtletasInscritosPorXCarrera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					DefaultTableModel tbVerAtletasInscritosPorXCarreraDefault = (DefaultTableModel) tbAtletasInscritosEnXCarrera
							.getModel();

					reset(tbVerAtletasInscritosPorXCarreraDefault);
					mirarParticipantes();

				}

			});
			btVerAtletasInscritosPorXCarrera.setBounds(161, 198, 596, 38);
		}
		return btVerAtletasInscritosPorXCarrera;
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo que añade los atletas inscritos a un Jtable
	 * 
	 */
	private void mirarParticipantes() {
		String codigo = (String) tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0);

		ArrayList<InscripcionDto> atletas = db.estadoInscripcion(codigo);

		for (InscripcionDto inscripcionDto : atletas) {

			String[] alluneedislove = { inscripcionDto.getAtleta().getDNI(), inscripcionDto.getAtleta().getNombre(),
					Categoria.calculaCategoria(inscripcionDto.getAtleta().getEdad(),
							inscripcionDto.getAtleta().getSexo()),
					String.valueOf(inscripcionDto.getFechaInscripcion()), inscripcionDto.getEstadoInscripcion() };

			tablaAtletasInscritosX.addRow(alluneedislove);

		}
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo que reseta una JTable
	 */
	void reset(DefaultTableModel Juanin) {
		Juanin.setRowCount(0);
	}

	private JScrollPane getScVerAtletasInscritosPorXCarrera() {
		if (scVerAtletasInscritosPorXCarrera == null) {
			scVerAtletasInscritosPorXCarrera = new JScrollPane();
			scVerAtletasInscritosPorXCarrera.setBounds(161, 246, 596, 161);
			scVerAtletasInscritosPorXCarrera.setViewportView(getTbAtletasInscritosEnXCarrera());
		}
		return scVerAtletasInscritosPorXCarrera;
	}

	/**
	 * 
	 * @author Sergio Arroni
	 * 
	 *         Tabla con DNI, Nombre, Categoría, Fecha de Inscripción y Estado de
	 *         Inscripción
	 * 
	 * @return
	 */

	private JTable getTbAtletasInscritosEnXCarrera() {
		if (tbAtletasInscritosEnXCarrera == null) {
			tbAtletasInscritosEnXCarrera = new JTable();
			tbAtletasInscritosEnXCarrera.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "DNI", "Nombre", "Categoría", "Fecha de Inscripción", "Estado de Inscripción" }));

			tbAtletasInscritosEnXCarrera.setDefaultEditor(Object.class, null);

		}
		return tbAtletasInscritosEnXCarrera;
	}

	private JScrollPane getScrollPaneListaCarrerasAtleta() {
		if (scrollPaneListaCarrerasAtleta == null) {
			scrollPaneListaCarrerasAtleta = new JScrollPane();
			scrollPaneListaCarrerasAtleta.setViewportView(getTablaCarrerasParaAtleta());
		}
		return scrollPaneListaCarrerasAtleta;
	}

	private JTable getTablaCarrerasParaAtleta() {
		if (tablaCarrerasParaAtleta == null) {
			tablaCarrerasParaAtleta = new JTable();
			tablaCarrerasParaAtleta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Fecha",
					"Tipo", "Distancia", "Cuota", "Fecha lim. insc.", "Plazas disponibles" }));

			tablaCarrerasParaAtleta.setDefaultEditor(Object.class, null);

		}
		return tablaCarrerasParaAtleta;
	}

	private JButton getBtAtrasVerCarrerasOrganizador() {
		if (btAtrasVerCarrerasOrganizador == null) {
			btAtrasVerCarrerasOrganizador = new JButton("Atras");
			btAtrasVerCarrerasOrganizador.setFont(new Font("Arial", Font.PLAIN, 14));
			btAtrasVerCarrerasOrganizador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_ORGANIZADOR);
//					showCard(PANEL_PAGARINSCRIPCION);
				}
			});
			btAtrasVerCarrerasOrganizador.setBounds(30, 435, 136, 34);
		}
		return btAtrasVerCarrerasOrganizador;
	}

	private JPanel getPnPagarInscripcion() {
		if (pnPagarInscripcion == null) {
			pnPagarInscripcion = new JPanel();
			pnPagarInscripcion.setLayout(new BorderLayout(0, 0));
			pnPagarInscripcion.add(getPnPrincipalPagarInscripcion(), BorderLayout.CENTER);
		}
		return pnPagarInscripcion;
	}

	private JPanel getPnPrincipalPagarInscripcion() {
		if (pnPrincipalPagarInscripcion == null) {
			pnPrincipalPagarInscripcion = new JPanel();
			pnPrincipalPagarInscripcion.setLayout(null);
			pnPrincipalPagarInscripcion.add(getBtPagarInscripcionTarjeta());
			pnPrincipalPagarInscripcion.add(getBtPagarInscripcionTransferencia());
			pnPrincipalPagarInscripcion.add(getBtPagarinscripcionAtras());
			pnPrincipalPagarInscripcion.add(getLbPagarInscripcion());
		}
		return pnPrincipalPagarInscripcion;
	}

	private JButton getBtPagarInscripcionTarjeta() {
		if (btPagarInscripcionTarjeta == null) {
			btPagarInscripcionTarjeta = new JButton("Tarjeta");
			btPagarInscripcionTarjeta.setFont(new Font("Arial", Font.PLAIN, 18));
			btPagarInscripcionTarjeta.setBounds(201, 210, 134, 55);
			btPagarInscripcionTarjeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pagarTarjeta();
				}

			});
		}
		return btPagarInscripcionTarjeta;
	}

	private JButton getBtPagarInscripcionTransferencia() {
		if (btPagarInscripcionTransferencia == null) {
			btPagarInscripcionTransferencia = new JButton("Transferencia");
			btPagarInscripcionTransferencia.setFont(new Font("Arial", Font.PLAIN, 18));
			btPagarInscripcionTransferencia.setBounds(573, 210, 143, 55);
			btPagarInscripcionTransferencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pagarTransferencia();
				}

			});
		}
		return btPagarInscripcionTransferencia;
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo que realiza todo lo referido a pagar Transferencias
	 * 
	 */
	private void pagarTransferencia() {
		UpdateInscribirseAtleta.execute2(inscripcion, "Transaccion");

		String nombre = String.valueOf(tablaAtleta.getValueAt(getTablaCarrerasParaAtleta().getSelectedRow(), 0));

		CarreraDto carreras = db.selectCarrerasNombre(nombre);

		String todo = "La carrera se efectuara el " + carreras.getFecha() + "\nDel tipo " + carreras.getTipo()
				+ "\nCon una distancia real de " + carreras.getDistancia() + "km\nLa cual tiene un coste de "
				+ carreras.getCuota() + "\nDebe pagar a esta cuenta bancaria: ES6000491500051234567892"
				+ ".\nDispone de 48 horas para efectuar el pago. Muchas gracias :)";


		UpdateInscribirseAtleta.execute2(inscripcion, "Transaccion");

		JOptionPane.showConfirmDialog(btPagarInscripcionTransferencia, todo,
				"Este es tu justifcante de pago por Transacción", JOptionPane.DEFAULT_OPTION);

		System.out.println(inscripcion.toString());

		new InscribirseAtleta().execute(inscripcion);

		db.selectInscripcion();

		int pagaste;

		pagaste = JOptionPane.showConfirmDialog(btPagarInscripcionTransferencia, "¿Ya pagaste?",
				"Muchas gracias por inscribirse", JOptionPane.YES_NO_OPTION);
		if (JOptionPane.YES_OPTION == pagaste) {
			UpdateInscribirseAtleta.execute(inscripcion, "Inscrito");

			JOptionPane.showConfirmDialog(btPagarInscripcionTransferencia,
					"Muchas gracias por realizar el pago de la cuota. Disfrute de la carrera "
							+ inscripcion.getAtleta().getNombre(),
					"Gracias :)", JOptionPane.DEFAULT_OPTION);

		}
		if (JOptionPane.NO_OPTION == pagaste) {
			JOptionPane.showConfirmDialog(btPagarInscripcionTransferencia,
					"Tiene 48 horas para realizar el pago despues de ese tiempo perdera la plaza y tendra que volver a inscribirse en esta carrera",
					"Moroso", JOptionPane.DEFAULT_OPTION);
			UpdateInscribirseAtleta.execute(inscripcion, "Pendiente de Pago");
		}
		showCard(PANEL_LISTA_CARRERAS);
	}

	private void pagarTarjeta() {

		showCard(PANEL_PAGO_TARJETA);

	}

	private JButton getBtPagarinscripcionAtras() {
		if (btPagarinscripcionAtras == null) {
			btPagarinscripcionAtras = new JButton("Atras");
			btPagarinscripcionAtras.setFont(new Font("Arial", Font.PLAIN, 14));
			btPagarinscripcionAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INGRESO);
				}
			});
			btPagarinscripcionAtras.setBounds(30, 435, 136, 34);
		}
		return btPagarinscripcionAtras;
	}

	private JButton getBtVistaAtletaAtras() {
		if (btVistaAtletaAtras == null) {
			btVistaAtletaAtras = new JButton("Atras");
			btVistaAtletaAtras.setFont(new Font("Arial", Font.PLAIN, 14));
			btVistaAtletaAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INICIO);
				}
			});
			btVistaAtletaAtras.setBounds(30, 435, 136, 34);
		}
		return btVistaAtletaAtras;
	}

	private JButton getBtVerClasificacionesOrganizacion() {
		if (btVerClasificacionesOrganizacion == null) {
			btVerClasificacionesOrganizacion = new JButton("Ver Clasificaciones");
			btVerClasificacionesOrganizacion.setFont(new Font("Arial", Font.PLAIN, 14));
			btVerClasificacionesOrganizacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_VERCLASIFICACIONESORGANIZADOR);
				}
			});
			btVerClasificacionesOrganizacion.setMnemonic('c');
			btVerClasificacionesOrganizacion.setBounds(210, 247, 435, 46);
		}
		return btVerClasificacionesOrganizacion;
	}

	private JButton getBtListaClasificacionesAtras() {
		if (btListaClasificacionesAtras == null) {
			btListaClasificacionesAtras = new JButton("Atras");
			btListaClasificacionesAtras.setFont(new Font("Arial", Font.PLAIN, 14));
			btListaClasificacionesAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_ORGANIZADOR);
				}
			});
			btListaClasificacionesAtras.setBounds(30, 435, 136, 34);
		}
		return btListaClasificacionesAtras;
	}

	private JLabel getLbPagoTarjeta() {
		if (lbPagoTarjeta == null) {
			lbPagoTarjeta = new JLabel(
					"Introduzca los datos de su tarjeta para finalizar su inscripción en la carrera.");
			lbPagoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbPagoTarjeta.setBounds(57, 60, 669, 61);
		}
		return lbPagoTarjeta;
	}

	private JLabel getLbPagoTarjetaNumero() {
		if (lbPagoTarjetaNumero == null) {
			lbPagoTarjetaNumero = new JLabel("Número de la tarjeta: ");
			lbPagoTarjetaNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPagoTarjetaNumero.setBounds(60, 157, 187, 35);
		}
		return lbPagoTarjetaNumero;
	}

	private JLabel getLbPagoTarjetaCódigoCVC() {
		if (lbPagoTarjetaCódigoCVC == null) {
			lbPagoTarjetaCódigoCVC = new JLabel("Código CVC: ");
			lbPagoTarjetaCódigoCVC.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPagoTarjetaCódigoCVC.setBounds(60, 234, 187, 35);
		}
		return lbPagoTarjetaCódigoCVC;
	}

	private JLabel getLbPagoTarjetaFechaCaducidad() {
		if (lbPagoTarjetaFechaCaducidad == null) {
			lbPagoTarjetaFechaCaducidad = new JLabel("Fecha de caducidad: ");
			lbPagoTarjetaFechaCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPagoTarjetaFechaCaducidad.setBounds(60, 314, 187, 35);
		}
		return lbPagoTarjetaFechaCaducidad;
	}

	private JTextField getTxPagoTarjetaNumero() {
		if (txPagoTarjetaNumero == null) {
			txPagoTarjetaNumero = new JTextField();
			txPagoTarjetaNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txPagoTarjetaNumero.setBounds(346, 157, 268, 35);
			txPagoTarjetaNumero.setColumns(10);
		}
		return txPagoTarjetaNumero;
	}

	private JTextField getTxPagoTarjetaCódigoCVC() {
		if (txPagoTarjetaCódigoCVC == null) {
			txPagoTarjetaCódigoCVC = new JTextField();
			txPagoTarjetaCódigoCVC.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txPagoTarjetaCódigoCVC.setColumns(10);
			txPagoTarjetaCódigoCVC.setBounds(346, 234, 268, 35);
		}
		return txPagoTarjetaCódigoCVC;
	}

	private JTextField getTxPagoTarjetaFechaCaducidad() {
		if (txPagoTarjetaFechaCaducidad == null) {
			txPagoTarjetaFechaCaducidad = new JTextField();
			txPagoTarjetaFechaCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txPagoTarjetaFechaCaducidad.setColumns(10);
			txPagoTarjetaFechaCaducidad.setBounds(346, 314, 268, 35);
		}
		return txPagoTarjetaFechaCaducidad;
	}

	private JButton getBtPagoTarjetaEnviar() {
		if (btPagoTarjetaEnviar == null) {
			btPagoTarjetaEnviar = new JButton("Enviar");
			btPagoTarjetaEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					accionPagoTarjetaEnviar();
				}
			});
			btPagoTarjetaEnviar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btPagoTarjetaEnviar.setBounds(529, 400, 85, 35);
		}
		return btPagoTarjetaEnviar;
	}

	protected void accionPagoTarjetaEnviar() {
		if (comprobarDatosTarjeta()) {

			UpdateInscribirseAtleta.execute2(inscripcion, "Tarjeta");

			String nombre = String.valueOf(tablaAtleta.getValueAt(getTablaCarrerasParaAtleta().getSelectedRow(), 0));

			CarreraDto carreras = db.selectCarrerasNombre(nombre);

			String todo = "Atleta : " + atletaActual.getNombre() + "\nCarrera : " + carreraActual.getNombre()
					+ "\nPrecio : " + carreraActual.getCuota() + "\nFecha pago : " + inscripcion.getFechaInscripcion();

			vaciarPanelPagoTarjeta();
			JOptionPane.showMessageDialog(null, "Ha sido inscrito con éxito en la carrera.");

			UpdateInscribirseAtleta.execute(inscripcion, "Inscrito");
			UpdateInscribirseAtleta.execute2(inscripcion, "Tarjeta");

			JOptionPane.showConfirmDialog(this, todo, "Este es tu justificante de pago.", JOptionPane.DEFAULT_OPTION);

			System.out.println(inscripcion.toString());

			new InscribirseAtleta().execute(inscripcion);

			db.selectInscripcion();

			UpdateInscribirseAtleta.execute(inscripcion, "Inscrito");

			JOptionPane.showConfirmDialog(btPagarInscripcionTransferencia,
					"Muchas gracias por realizar el pago de la cuota. Disfrute de la carrera "
							+ inscripcion.getAtleta().getNombre(),
					"Gracias :)", JOptionPane.DEFAULT_OPTION);

			showCard(PANEL_INICIO);
		}

	}

	private void vaciarPanelPagoTarjeta() {
		txPagoTarjetaCódigoCVC.setText("");
		txPagoTarjetaFechaCaducidad.setText("");
		txPagoTarjetaNumero.setText("");
	}

	private JLabel getLbPagarInscripcion() {
		if (lbPagarInscripcion == null) {
			lbPagarInscripcion = new JLabel("Eliga su método de pago:");
			lbPagarInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lbPagarInscripcion.setFont(new Font("Arial", Font.PLAIN, 20));
			lbPagarInscripcion.setBounds(163, 113, 584, 55);
		}
		return lbPagarInscripcion;
	}
}
