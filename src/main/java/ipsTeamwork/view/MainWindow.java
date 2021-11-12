package ipsTeamwork.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import ipsTeamwork.model.atleta.crud.AddAtleta;
import ipsTeamwork.model.atleta.crud.ExisteAtletaByEmail;
import ipsTeamwork.model.atleta.crud.FindAtletaInCarrera;
import ipsTeamwork.model.atleta.crud.ReadAtletaByEmail;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.carrera.crud.MirarLimiteCarrera;
import ipsTeamwork.model.carrera.crud.SelectAllVistaAtleta;
import ipsTeamwork.model.carrera.crud.UpdateCarrera;
import ipsTeamwork.model.categoria.Categoria;
import ipsTeamwork.model.categoria.CategoriaDto;
import ipsTeamwork.model.categoria.crud.AddCategoria;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.model.inscripcion.crud.InscribirseAtleta;
import ipsTeamwork.model.inscripcion.crud.UpdateInscribirseAtleta;
import ipsTeamwork.model.inscripcion.crud.UpdateInscribirseAtletaDorsal;
import ipsTeamwork.model.pago.PagoDto;
import ipsTeamwork.util.DtoBuilder;
import ipsTeamwork.util.FileUtil;
import ipsTeamwork.util.Parser;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 3073912408195015551L;

	public static final String PANEL_ATLETA = "panel_atleta";
	private static final String PANEL_INICIO = "panel_inicio";
	private static final String PANEL_ORGANIZADOR = "panel_organizador";
	private static final String PANEL_LISTA_CARRERAS = "panel_lista_carreras_atleta";
	private static final String PANEL_REGISTRO = "panel_registro";
	private static final String PANEL_INGRESO = "panel_ingreso";
	private static final String PANEL_VER_CARRERAS_ORGANIZADOR = "panel_lista_carreras_organizador";
	private static final String PANEL_VERCLASIFICACIONESORGANIZADOR = "panel_lista_clasificaciones_organizador";
	private static final String PANEL_PAGARINSCRIPCION = "panel_PagarInscripcion";
	private static final String PANEL_LISTA_INSCRIPCIONES = "panel_lista_inscripciones_atleta";
	private static final String PANEL_CONFIGURAR_PLAZOS = "panel_configuracion_plazos";
	private static final String PANEL_PAGO_TARJETA = "panel_pago_tarjeta";
	private static final String PANEL_CREACION_CARRERAS = "panel_creacion_carreras";
	private static final String PANEL_GENERAL_DORSALES = "panel_generar_dorsales";

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
	private JTextField textRegistroEdad;
	private JTextField textRegistroNombre;
	private JTextField textRegistroApellidos;
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
	private JPanel pnListaCarrerasOrganizador;

	private JPanel pnListaClasificacionesOrganizador;

	private JPanel pnPrincipalVerCarrerasOrganizador;

	private JPanel pnPrincipalVerClasificacionesOrganizador;
	private JButton btVerVarrerasOrganizacion;
	private JScrollPane scVerCarreras;

	private JLabel lbClasificacionGeneral;
	private JScrollPane scVerClasificaciones;

	private JTable tbVerCarreras;
	private JTable tbVerClasificaciones;
	private JButton btVerAtletasInscritosPorXCarrera;
	private JScrollPane scVerAtletasInscritosPorXCarrera;
	private JTable tbAtletasInscritosEnXCarrera;
	private DefaultTableModel tb;
	private DefaultTableModel tablaAtleta;
	private DefaultTableModel tablaCategorias;
	private DefaultTableModel tablaAtletasInscritosX;
	private DefaultTableModel tablaPlazosInscripciones;
	private DefaultTableModel tablaGenerarDorsales;

	private DefaultTableModel tablaClasificaciones;

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
	private JButton btListaClasificacionesAtras;

	private JPanel pnPagoTarjeta;
	private JPanel pnPagoTarjetaCenter;
	private JLabel lbPagoTarjeta;
	private JLabel lbPagoTarjetaNumero;
	private JLabel lbPagoTarjetaCodigoCVC;
	private JLabel lbPagoTarjetaFechaCaducidad;
	private JTextField txPagoTarjetaNumero;
	private JTextField txPagoTarjetaCodigoCVC;
	private JTextField txPagoTarjetaFechaCaducidad;
	private JButton btPagoTarjetaEnviar;
	private JLabel lbPagarInscripcion;

	private JPanel pnCreacionCarrera;
	private JLabel lblCreacionDeCarreras;
	private JLabel lblCreacionCarreraNombre;
	private JLabel lblCreacionCarrerasDescripcion;
	private JLabel lblCreacionCarrerasFechaEjecucion;
	private JLabel lblCreacionCarrerasTipo;
	private JButton btnCreacionCarrerasAtras;
	private JButton btnCreacionCarrerasSiguiente;
	private JTextField txtDescripcion;
	private JTextField txtNombreCarrera;
	private JComboBox cmbTipoCarrera;
	private JLabel lblCreacionCarrerasKm;
	private JTextField txtFechaEjecucion;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblCreacionCarreraNombreCat;
	private JTextField txtNombreCat;
	private JLabel lblCreacionCarreraEdadMin;
	private JTextField txtEdadMin;
	private JLabel lblCreacionCarreraEdadMax;
	private JTextField txtEdadMax;
	private JButton btnAadirCategoria;
	private JButton btnBorrarCategoria;
	private JTextField txtKm;
	private JLabel lblParametros;

	private CarreraDto creacionCarrera = null;
	private JLabel lblCreacionCarrerasPlazas;
	private JTextField txtPlazas;
	private JScrollPane scrollPaneCategorias;
	private JTable tableCategorias;

	private List<CategoriaDto> categoriasCreacion = null;
	private List<CategoriaDto> categoriasFiltrado = null;

	private JButton btImportarTiemposCarrera;

	private JButton btVerClasificacionesOrganizacion;
	private JPanel pnConfiguracionPlazos;
	private JPanel pnPrincipalConfiguracionPlazos;
	private JLabel lbConfiguracionPlazos;
	private JButton btAtrasConfiguracionPlazos;
	private JButton btCreacionCarreraConfiguracionPlazos;
	private JButton btADDConfiguracionPlazos;
	private JLabel lbCuotaConfiguracionPlazos;
	private JTextField txCuotaConfiguracionPlazos;
	private JLabel lbFechaInicioConfiguracionPlazos;
	private JTextField txFechaInicioConfiguracionPlazos;
	private JLabel lblFechaFinConfiguracionPlazos;
	private JTextField txFechaFinConfiguracionPlazos;
	private JScrollPane scConfiguracionPlazos;
	private JTable tbConfiguracionPlazos;
	private JPanel pnGeneralDorsales;
	private JPanel pnGenerarDorsalesPrincipal;
	private JLabel lbGenerarDorsales;
	private JScrollPane scGeneralDorsales;
	private JTable tbGeneralDorsales;
	private JButton btAtrasGeneralDorsales;
	private JButton btGeneralDorsales;
	private JLabel lbVIPSGeneralDorsales;
	private JTextField txVipsGeneralDorsales;

	private String fechaIni;

	private String fechaFin;

	private String cuota;
	private JTextField txDatosCarreraConfiguracionPlazos;

	private boolean primera;
	private JTextField txdatosCarreraGeneralDorsales;
	private JButton btnGenerarDorsalesVistaOrganizador;

	private Map<String, String> diccionarioPlazos = new HashMap<String, String>();

	private int numeroGenteInscritaEnLaCarreraActual;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		db = new GestorDB();
		tb = (DefaultTableModel) getTbVerCarreras().getModel();
		tablaClasificaciones = (DefaultTableModel) getTbVerClasificaciones().getModel();
		tablaGenerarDorsales = (DefaultTableModel) getTbGeneralDorsales().getModel();
		tablaAtleta = (DefaultTableModel) getTablaCarrerasParaAtleta().getModel();
		tablaCategorias = (DefaultTableModel) getTableCategorias().getModel();
		tablaAtletasInscritosX = (DefaultTableModel) getTbAtletasInscritosEnXCarrera().getModel();
		tablaPlazosInscripciones = (DefaultTableModel) getTbConfiguracionPlazos().getModel();
		pnVistaInscripcionesAtleta = new PanelListarInscripciones(this, atletaActual);
		// booleano para la historia 15297 :)
		primera = true;
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
		contentPane.add(getPnListaCarrerasOrganizador(), PANEL_VER_CARRERAS_ORGANIZADOR);
		contentPane.add(getPnPagarInscripcion(), PANEL_PAGARINSCRIPCION);
		contentPane.add(pnVistaInscripcionesAtleta, PANEL_LISTA_INSCRIPCIONES);
		contentPane.add(getPnListaClasificacionesOrganizador(), PANEL_VERCLASIFICACIONESORGANIZADOR);
		contentPane.add(getPnPagoTarjeta(), PANEL_PAGO_TARJETA);
		contentPane.add(getPnCreacionCarrera(), PANEL_CREACION_CARRERAS);
		contentPane.add(getPnConfiguracionPlazos(), PANEL_CONFIGURAR_PLAZOS);
		contentPane.add(getPnGeneralDorsales(), PANEL_GENERAL_DORSALES);
		// Hardcode del texto, que aparecia siempre con un tab
		getTxFechaInicioConfiguracionPlazos().setText("");
		cargarTablaCarrerasOrganizador();
		cargarTablaCarrerasAtleta();
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
					showCard(PANEL_ATLETA);
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
					misCarrerasMeth();

				}
			});
			btnMisCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
			btnMisCarreras.setBounds(210, 247, 435, 46);
		}
		return btnMisCarreras;
	}

	private void misCarrerasMeth() {
		if (atletaActual != null) {
			setAtletaActual(atletaActual);
			((PanelListarInscripciones) pnVistaInscripcionesAtleta).cargarInscripcionesEnTabla();
			showCard(PANEL_LISTA_INSCRIPCIONES);
		} else {
			String name = JOptionPane.showInputDialog("Introduce el correo de atleta: ");
			if (!name.trim().equals("")) {
				atletaActual = new ReadAtletaByEmail(name).execute();
				setAtletaActual(atletaActual);
				if (atletaActual != null) {
					((PanelListarInscripciones) pnVistaInscripcionesAtleta).cargarInscripcionesEnTabla();
					showCard(PANEL_LISTA_INSCRIPCIONES);
				} else {
					JOptionPane.showMessageDialog(null, "Error: Atleta no existente");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Introduce un email");
			}
		}
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

		List<CarreraDto> carreras = db.listarCarreras();

		for (CarreraDto carreraDto : carreras) {

			String[] carrerasTabla = { carreraDto.getNombre(), carreraDto.getFecha().toString(), carreraDto.getTipo(),
					String.valueOf(carreraDto.getDistancia()), String.valueOf(carreraDto.getCuota()),
					carreraDto.getFechaFin().toString(), String.valueOf(carreraDto.getPlazasDisp()) };
			tb.addRow(carrerasTabla);
		}
	}

	public String stringFromNumberToDate(String numero) {

		if (numero.equals("NF") || numero.equals("NP")) {
			return numero;
		}

		int numeroInt = Integer.parseInt(numero);

		int horas = numeroInt / 60;
		int minutos = numeroInt - horas * 60;

		return horas + ":" + minutos + "h";

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
		if (new MirarLimiteCarrera().execute(carreraActual.getIdCarrera())) {
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
			pnRegistroCenter.add(getTextRegistroEdad());
			pnRegistroCenter.add(getTextRegistroNombre());
			pnRegistroCenter.add(getTextRegistroApellidos());
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

	private JTextField getTextRegistroEdad() {
		if (textRegistroEdad == null) {
			textRegistroEdad = new JTextField();
			textRegistroEdad.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroEdad.setColumns(10);
			textRegistroEdad.setBounds(169, 223, 370, 20);
		}
		return textRegistroEdad;
	}

	private JTextField getTextRegistroNombre() {
		if (textRegistroNombre == null) {
			textRegistroNombre = new JTextField();
			textRegistroNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroNombre.setColumns(10);
			textRegistroNombre.setBounds(169, 130, 370, 20);
		}
		return textRegistroNombre;
	}

	private JTextField getTextRegistroApellidos() {
		if (textRegistroApellidos == null) {
			textRegistroApellidos = new JTextField();
			textRegistroApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroApellidos.setColumns(10);
			textRegistroApellidos.setBounds(169, 161, 370, 20);
		}
		return textRegistroApellidos;
	}

	private JLabel getLblRegistroRegistroEdad() {
		if (lblRegistroRegistroEdad == null) {
			lblRegistroRegistroEdad = new JLabel("Edad:");
			lblRegistroRegistroEdad.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroRegistroEdad.setBounds(46, 223, 80, 20);
		}
		return lblRegistroRegistroEdad;
	}

	private JLabel getLblRegistroNombre() {
		if (lblRegistroNombre == null) {
			lblRegistroNombre = new JLabel("Nombre:");
			lblRegistroNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroNombre.setBounds(46, 130, 80, 20);
		}
		return lblRegistroNombre;
	}

	private JLabel getLblRegistroApellidos() {
		if (lblRegistroApellidos == null) {
			lblRegistroApellidos = new JLabel("Apellidos:");
			lblRegistroApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
			lblRegistroApellidos.setBounds(46, 161, 80, 20);
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
									chckbxRegistroDiscapacidad.isSelected() ? 1 : 0, textIngresoEmail.getText()));

							String cate = Categoria.calculaCategoria(atletaActual, carreraActual);

							atletaActual.setIdAtleta(UUID.randomUUID().toString());
							new AddAtleta(atletaActual).execute();
							setAtletaActual(new ReadAtletaByEmail(textIngresoEmail.getText()).execute());
							dbIngresoAtleta();
							cleanRegistro();
						} else {
							JOptionPane.showMessageDialog(null, "No puedes participar siendo menor de edad");
						}
					}
				}
			});
			btnRegistroSiguiente.setForeground(Color.BLACK);
			btnRegistroSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroSiguiente.setBounds(742, 438, 132, 35);
		}
		return btnRegistroSiguiente;
	}

	private void cleanRegistro() {
		textRegistroDNI.setText("");
		textRegistroNombre.setText("");
		textRegistroApellidos.setText("");
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
		if (camposVacios()) {
			JOptionPane.showMessageDialog(null, "Error: Falta alguno de los datos.");
			return false;
		}
		return true;
	}

	private boolean camposVacios() {
		return (txPagoTarjetaCodigoCVC.getText().isEmpty() || txPagoTarjetaCodigoCVC.getText().isBlank()
				|| txPagoTarjetaFechaCaducidad.getText().isEmpty() || txPagoTarjetaFechaCaducidad.getText().isBlank()
				|| txPagoTarjetaNumero.getText().isEmpty() || txPagoTarjetaNumero.getText().isBlank());
	}

	private boolean isEmptyRegister() {
		return (textRegistroDNI.getText().isEmpty() || textRegistroNombre.getText().isEmpty()
				|| textRegistroApellidos.getText().isEmpty() || textRegistroEdad.getText().isEmpty());
	}

	private JButton getBtnRegistroCancelar() {
		if (btnRegistroCancelar == null) {
			btnRegistroCancelar = new JButton("Cancelar");
			btnRegistroCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_INGRESO);
				}
			});
			btnRegistroCancelar.setForeground(Color.BLACK);
			btnRegistroCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroCancelar.setBounds(32, 437, 134, 36);
		}
		return btnRegistroCancelar;
	}

	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("REGISTRO DE ATLETA");
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
			lblRegistroDNI.setBounds(46, 192, 80, 20);
		}
		return lblRegistroDNI;
	}

	private JTextField getTextRegistroDNI() {
		if (textRegistroDNI == null) {
			textRegistroDNI = new JTextField();
			textRegistroDNI.setFont(new Font("Arial", Font.PLAIN, 14));
			textRegistroDNI.setColumns(10);
			textRegistroDNI.setBounds(169, 192, 370, 20);
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
					showCard(PANEL_LISTA_CARRERAS);
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
			showCard(PANEL_INGRESO);
		}
	}

	private void dbIngresoAtleta() {
		if (new FindAtletaInCarrera().execute(atletaActual.getIdAtleta(), carreraActual.getIdCarrera())) {
			String otro = "Nombre del corredor: " + atletaActual.getNombre()
					+ "\nEstas apuntado a la carrera con nombre: " + carreraActual.getNombre() + "\nEn la categoria: "
					+ Categoria.calculaCategoria(atletaActual, carreraActual) + "\nCon fecha de inscripcion: "
					+ new Date() + "\nTienes que pagar: " + carreraActual.getCuota();

			System.out.println(carreraActual.getIdCarrera());
			inscripcion = DtoBuilder.ParamsToInscripcionDto(atletaActual, carreraActual,
					UUID.randomUUID().toString().substring(0, 3), "Pre-Inscrito", new Date(), null);

			carreraActual.setPlazasDisp(carreraActual.getPlazasDisp() - 1);
			new UpdateCarrera().execute(carreraActual);

			JOptionPane.showConfirmDialog(btPagarInscripcionTransferencia, otro, "Justificante carrera",
					JOptionPane.DEFAULT_OPTION);
			showCard(PANEL_PAGARINSCRIPCION);
			textIngresoEmail.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Error: Ya estas en esta carrera.");
		}

	}

	private void ingresoAtleta(String email) {
		if (email.trim().strip().isEmpty())
			JOptionPane.showMessageDialog(this, "Introduce tu email");
		else {
			if (new ExisteAtletaByEmail().execute(email)) {
				setAtletaActual(new ReadAtletaByEmail(email).execute());
				System.out.println(Categoria.calculaCategoria(atletaActual, carreraActual));

				dbIngresoAtleta();
			} else {
				showCard(PANEL_REGISTRO);
			}
		}
	}

	private JPanel getPnOrganizadorCentro() {
		if (pnOrganizadorCentro == null) {
			pnOrganizadorCentro = new JPanel();
			pnOrganizadorCentro.setLayout(null);
			pnOrganizadorCentro.add(getBtnOrganizadorCancelar());
			pnOrganizadorCentro.add(getBtVerVarrerasOrganizacion());

			// pnOrganizadorCentro.add(getBtVerClasificacionesOrganizacion());

			JButton btnCrearCarreras = new JButton("Crear Carreras");
			btnCrearCarreras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					categoriasCreacion = new ArrayList<CategoriaDto>();
					categoriasFiltrado = new ArrayList<CategoriaDto>();
					cleanCreacion();
					showCard(PANEL_CREACION_CARRERAS);
				}
			});
			btnCrearCarreras.setMnemonic('c');
			btnCrearCarreras.setFont(new Font("Arial", Font.PLAIN, 14));
			btnCrearCarreras.setBounds(210, 330, 435, 46);
			pnOrganizadorCentro.add(btnCrearCarreras);
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

	private Component getPnPrincipalVerClasificacionesOrganizador() {
		if (pnPrincipalVerClasificacionesOrganizador == null) {
			pnPrincipalVerClasificacionesOrganizador = new JPanel();
			pnPrincipalVerClasificacionesOrganizador.setLayout(null);
			pnPrincipalVerClasificacionesOrganizador.add(getScVerClasificaciones());
			pnPrincipalVerClasificacionesOrganizador.add(getLbClasificacionGeneral());
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

			pnPrincipalVerCarrerasOrganizador.add(getBtImportarTiemposCarrera());
//			pnPrincipalVerCarrerasOrganizador.add(getBtVerClasificacionesOrganizacion_1());

			pnPrincipalVerCarrerasOrganizador.add(getBtVerClasificacionesOrganizacion());

			JButton btnCargarTransacciones = new JButton("Cargar pagos");
			btnCargarTransacciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarPagos();
				}
			});
			btnCargarTransacciones.setBounds(767, 130, 97, 23);
			pnPrincipalVerCarrerasOrganizador.add(btnCargarTransacciones);
			pnPrincipalVerCarrerasOrganizador.add(getBtnGenerarDorsalesVistaOrganizador());

		}
		return pnPrincipalVerCarrerasOrganizador;
	}

	private void cargarPagos() {
		String nombre = "";

		List<PagoDto> pagos = null;

		try {
			nombre = String.valueOf(tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("No hay ninguna carrera seleccionada.");
			return;
		}

		CarreraDto carrera = db.selectCarrerasNombre(nombre);

		File file = null;

		JFileChooser jfk = new JFileChooser();
		int retVal = jfk.showOpenDialog(this);

		if (retVal == JFileChooser.APPROVE_OPTION) {
			file = jfk.getSelectedFile();
		} else {
			JOptionPane.showMessageDialog(this, "No se seleccionó ningún archivo.");
			return;
		}

		try {
			pagos = Parser.parsePaymentFile(file, false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (Iterator<PagoDto> iterator = pagos.iterator(); iterator.hasNext();) {
			PagoDto pago = iterator.next();

			pago.setIdCarrera(carrera.getIdCarrera());
			pago.autoInsert();
		}

		computarEfectosPagos(carrera, pagos);

	}

	private void computarEfectosPagos(CarreraDto para, List<PagoDto> pagos) {
		List<InscripcionDto> inscripcionesParaCarrera = db.todasLasInscripcionesCarrera(para.getIdCarrera());
		List<String> errores = new ArrayList<String>();

		for (PagoDto p : pagos) {
			boolean carreraCorrecta = false;
			for (InscripcionDto idto : inscripcionesParaCarrera) {
				AtletaDto atletaDeInscripcion = new GestorDB().findAtletaByIdNull(idto.getIdAtleta());

				if (atletaDeInscripcion == null)
					continue;

				if (p.dni.equals(atletaDeInscripcion.getDNI())) {
					carreraCorrecta = true;
					if (p.date.after(para.getFechaFin())) {
						GestorDB.escribirIncidencia(idto, "Pago fuera de plazo. Devolver " + p.importe + "€");
					}
					if (p.importe < para.getCuota()) {
						GestorDB.escribirIncidencia(idto, "Pago insuficiente. Devolver " + p.importe + "€");
					}
					if (p.importe > para.getCuota()) {
						GestorDB.escribirIncidencia(idto,
								"Pago excede la cuota. Devolver " + (p.importe - para.getCuota()) + "€");
						UpdateInscribirseAtleta.execute(idto, "INSCRITO");
					} else {
						UpdateInscribirseAtleta.execute(idto, "INSCRITO");
					}
				}
			}
			if (!carreraCorrecta) {
				errores.add("Error: Dni " + p.dni + " ha hecho una transferencia de " + p.importe
						+ "€ a una carrera en la que no está inscrito.");
			}
		}

		JOptionPane.showMessageDialog(this, errores.toArray());
	}

	private JButton getBtVerVarrerasOrganizacion() {
		if (btVerVarrerasOrganizacion == null) {
			btVerVarrerasOrganizacion = new JButton("Ver Carreras");
			btVerVarrerasOrganizacion.setFont(new Font("Arial", Font.PLAIN, 14));
			btVerVarrerasOrganizacion.setMnemonic('v');
			btVerVarrerasOrganizacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_VER_CARRERAS_ORGANIZADOR);
				}
			});
			btVerVarrerasOrganizacion.setBounds(210, 102, 435, 46);
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
			scVerClasificaciones.setBounds(43, 56, 713, 369);
			scVerClasificaciones.setViewportView(getTbVerClasificaciones());
		}
		return scVerClasificaciones;
	}

	private JLabel getLbClasificacionGeneral() {
		if (lbClasificacionGeneral == null) {
			lbClasificacionGeneral = new JLabel("Clasificación General");
			lbClasificacionGeneral.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbClasificacionGeneral.setHorizontalAlignment(SwingConstants.CENTER);
			lbClasificacionGeneral.setBounds(43, 25, 713, 22);
		}
		return lbClasificacionGeneral;
	}

	public JTable getTbVerCarreras() {
		if (tbVerCarreras == null) {
			tbVerCarreras = new JTable();
			tbVerCarreras.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Fecha", "Tipo",
					"Distancia", "Cuota", "Fecha lim. insc.", "Plazas disponibles" }));

			tbVerCarreras.setDefaultEditor(Object.class, null);

		}
		return tbVerCarreras;
	}

	public JTable getTbVerClasificaciones() {
		if (tbVerClasificaciones == null) {
			tbVerClasificaciones = new JTable();
			tbVerClasificaciones.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Posición", "Dorsal", "Categoría", "Género", "Nombre", "Tiempo" }));

			tbVerClasificaciones.setDefaultEditor(Object.class, null);

		}
		return tbVerClasificaciones;
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo Rellena la tabla de carreras PoW Organizador
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
			btVerAtletasInscritosPorXCarrera.setBounds(161, 198, 298, 38);
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
		if (getTbVerCarreras().getSelectedRow() != -1) {

			String nombre = String.valueOf(tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0));

			CarreraDto carreras = db.selectCarrerasNombre(nombre);

			List<InscripcionDto> inscripciones = db.estadoInscripcion(carreras.getIdCarrera());

			for (InscripcionDto inscripcionDto : inscripciones) {

				String[] alluneedislove = { inscripcionDto.getAtleta().getDNI(), inscripcionDto.getAtleta().getNombre(),
						Categoria.calculaCategoria(inscripcionDto.getAtleta(), inscripcionDto.getCarrera()),
						String.valueOf(inscripcionDto.getFechaInscripcion()), inscripcionDto.getEstadoInscripcion() };

				tablaAtletasInscritosX.addRow(alluneedislove);

			}
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una carrera");
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

	private JTable getTablaCategoriasParaCarrera() {
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
			btAtrasVerCarrerasOrganizador.setBounds(27, 430, 116, 34);
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

		CarreraDto carrera = db.selectCarrerasNombre(nombre);

		String todo = "Nombre del corredor: " + atletaActual.getNombre() + "\nEstas apuntado a la carrera con nombre: "
				+ carreraActual.getNombre() + "\nEn la categoria: " + Categoria.calculaCategoria(atletaActual, carrera)
				+ "\nCon fecha de inscripcion: " + new Date() + "\nLa carrera se efectuara el " + carrera.getFecha()
				+ "\nDel tipo " + carrera.getTipo() + "\nCon una distancia real de " + carrera.getDistancia()
				+ "km\nLa cual tiene un coste de " + carrera.getCuota()
				+ "\nDebe pagar a esta cuenta bancaria: ES6000491500051234567892"
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

		reset(tablaAtleta);
		cargarTablaCarrerasAtleta();
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
					reset(tablaClasificaciones);
					accionClasificaciones();

				}
			});
			btVerClasificacionesOrganizacion.setMnemonic('c');

			btVerClasificacionesOrganizacion.setBounds(215, 424, 435, 46);

		}
		return btVerClasificacionesOrganizacion;
	}

	private JButton getBtListaClasificacionesAtras() {
		if (btListaClasificacionesAtras == null) {
			btListaClasificacionesAtras = new JButton("Atras");
			btListaClasificacionesAtras.setFont(new Font("Arial", Font.PLAIN, 14));
			btListaClasificacionesAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_VER_CARRERAS_ORGANIZADOR);
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
		if (lbPagoTarjetaCodigoCVC == null) {
			lbPagoTarjetaCodigoCVC = new JLabel("Código CVC: ");
			lbPagoTarjetaCodigoCVC.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPagoTarjetaCodigoCVC.setBounds(60, 234, 187, 35);
		}
		return lbPagoTarjetaCodigoCVC;
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
		if (txPagoTarjetaCodigoCVC == null) {
			txPagoTarjetaCodigoCVC = new JTextField();
			txPagoTarjetaCodigoCVC.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txPagoTarjetaCodigoCVC.setColumns(10);
			txPagoTarjetaCodigoCVC.setBounds(346, 234, 268, 35);
		}
		return txPagoTarjetaCodigoCVC;
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
					reset(tablaAtleta);
					cargarTablaCarrerasAtleta();
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
		txPagoTarjetaCodigoCVC.setText("");
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

	private JPanel getPnCreacionCarrera() {
		if (pnCreacionCarrera == null) {
			pnCreacionCarrera = new JPanel();
			pnCreacionCarrera.setLayout(null);
			pnCreacionCarrera.add(getLblCreacionDeCarreras());
			pnCreacionCarrera.add(getLblCreacionCarreraNombre());
			pnCreacionCarrera.add(getLblCreacionCarrerasDescripcion());
			pnCreacionCarrera.add(getLblCreacionCarrerasFechaEjecucion());
			pnCreacionCarrera.add(getLblCreacionCarrerasTipo_1());
			pnCreacionCarrera.add(getBtnCreacionCarrerasAtras());
			pnCreacionCarrera.add(getBtnCreacionCarrerasSiguiente());
			pnCreacionCarrera.add(getTxtDescripcion());
			pnCreacionCarrera.add(getTxtNombreCarrera());
			pnCreacionCarrera.add(getCmbTipoCarrera());
			pnCreacionCarrera.add(getLblCreacionCarrerasKm_1());
			pnCreacionCarrera.add(getTxtFechaEjecucion());
			pnCreacionCarrera.add(getTextField_3());
			pnCreacionCarrera.add(getLblNewLabel());
			pnCreacionCarrera.add(getLblCreacionCarreraNombreCat());
			pnCreacionCarrera.add(getTxtNombreCat());
			pnCreacionCarrera.add(getLblCreacionCarreraEdadMin());
			pnCreacionCarrera.add(getTxtEdadMin());
			pnCreacionCarrera.add(getLblCreacionCarreraEdadMax());
			pnCreacionCarrera.add(getTxtEdadMax());
			pnCreacionCarrera.add(getBtnAadirCategoria());
			pnCreacionCarrera.add(getBtnBorrarCategoria());
			pnCreacionCarrera.add(getTxtKm());
			pnCreacionCarrera.add(getLblParametros());
			pnCreacionCarrera.add(getLblCreacionCarrerasKm_1_1());
			pnCreacionCarrera.add(getTxtPlazas());
			pnCreacionCarrera.add(getScrollPaneCategorias());
		}
		return pnCreacionCarrera;
	}

	private boolean checkeoCreacionCarreras() {
		if (checkeoCarreraCampos()) {
			JOptionPane.showMessageDialog(this, "Error: Al crear la carrera no puedes dejar valores vacios.");
			return false;
		}
		if (checkeoCantidadCategorías()) {
			JOptionPane.showMessageDialog(this, "Error: No puedes crear una carrera sin categorías");
			return false;
		}
		if (checkFecha()) {
			JOptionPane.showMessageDialog(this, "La fecha debe tener el formato yyyy-mm-dd");
			return false;
		}
		return true;
	}

	private boolean checkFecha() {
		String da = "yyyy-MM-dd";
		return txtFechaEjecucion.getText().length() != da.length();
	}

	private boolean checkeoCantidadCategorías() {
		return (tablaCategorias.getRowCount() == 0);
	}

	private boolean checkeoCategoriaCampos() {
		return (txtNombreCat.getText().isEmpty() || txtEdadMax.getText().isEmpty() || txtEdadMin.getText().isEmpty());
	}

	private boolean checkeoCarreraCampos() {
		return (txtNombreCarrera.getText().isEmpty() || txtDescripcion.getText().isEmpty()
				|| txtFechaEjecucion.getText().isEmpty() || txtKm.getText().isEmpty()
				|| cmbTipoCarrera.getSelectedIndex() == -1) || txtPlazas.getText().isEmpty();
	}

	private void cleanCreacion() {
		reset(tablaCategorias);
		txtNombreCarrera.setText("");
		txtDescripcion.setText("");
		txtFechaEjecucion.setText("");
		txtKm.setText("");
		cmbTipoCarrera.setSelectedIndex(-1);
		txtPlazas.setText("");
		txtNombreCat.setText("");
		txtEdadMax.setText("");
		txtEdadMin.setText("");
	}

	private JLabel getLblCreacionDeCarreras() {
		if (lblCreacionDeCarreras == null) {
			lblCreacionDeCarreras = new JLabel("CREACIÓN DE CARRERAS");
			lblCreacionDeCarreras.setFont(new Font("Arial", Font.BOLD, 25));
			lblCreacionDeCarreras.setBounds(280, 26, 555, 60);
		}
		return lblCreacionDeCarreras;
	}

	private JLabel getLblCreacionCarreraNombre() {
		if (lblCreacionCarreraNombre == null) {
			lblCreacionCarreraNombre = new JLabel("Nombre:");
			lblCreacionCarreraNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarreraNombre.setBounds(49, 192, 60, 17);
		}
		return lblCreacionCarreraNombre;
	}

	private JLabel getLblCreacionCarrerasDescripcion() {
		if (lblCreacionCarrerasDescripcion == null) {
			lblCreacionCarrerasDescripcion = new JLabel("Descripción:");
			lblCreacionCarrerasDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarrerasDescripcion.setBounds(49, 233, 92, 14);
		}
		return lblCreacionCarrerasDescripcion;
	}

	private JLabel getLblCreacionCarrerasFechaEjecucion() {
		if (lblCreacionCarrerasFechaEjecucion == null) {
			lblCreacionCarrerasFechaEjecucion = new JLabel("Fecha Ejecución:");
			lblCreacionCarrerasFechaEjecucion.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarrerasFechaEjecucion.setBounds(49, 275, 121, 14);
		}
		return lblCreacionCarrerasFechaEjecucion;
	}

	private JLabel getLblCreacionCarrerasTipo_1() {
		if (lblCreacionCarrerasTipo == null) {
			lblCreacionCarrerasTipo = new JLabel("Tipo:");
			lblCreacionCarrerasTipo.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarrerasTipo.setBounds(49, 314, 46, 14);
		}
		return lblCreacionCarrerasTipo;
	}

	private JButton getBtnCreacionCarrerasAtras() {
		if (btnCreacionCarrerasAtras == null) {
			btnCreacionCarrerasAtras = new JButton("Atras");
			btnCreacionCarrerasAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cleanCreacion();
					showCard(PANEL_ORGANIZADOR);
				}
			});
			btnCreacionCarrerasAtras.setFont(new Font("Arial", Font.PLAIN, 14));
			btnCreacionCarrerasAtras.setBounds(21, 465, 89, 23);
		}
		return btnCreacionCarrerasAtras;
	}

	private JButton getBtnCreacionCarrerasSiguiente() {
		if (btnCreacionCarrerasSiguiente == null) {
			btnCreacionCarrerasSiguiente = new JButton("Siguiente");
			btnCreacionCarrerasSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkeoCreacionCarreras()) {
						assignacionValoresCarrera();
						showCard(PANEL_CONFIGURAR_PLAZOS);
						printLabelPlazos();
					}
				}
			});
			btnCreacionCarrerasSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnCreacionCarrerasSiguiente.setBounds(786, 465, 110, 23);
		}
		return btnCreacionCarrerasSiguiente;
	}

	private void assignacionValoresCarrera() {
		creacionCarrera = new CarreraDto();
		try {
			creacionCarrera.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaEjecucion.getText()));
			creacionCarrera.setDistancia(Integer.parseInt(txtKm.getText()));
			creacionCarrera.setMaxPlazas(Integer.parseInt(txtPlazas.getText()));
			creacionCarrera.setPlazasDisp(Integer.parseInt(txtPlazas.getText()));
			creacionCarrera.setIdCarrera(UUID.randomUUID().toString());
			creacionCarrera.setTipo(cmbTipoCarrera.getSelectedItem().toString());
			creacionCarrera.setNombre(txtNombreCarrera.getText());
			creacionCarrera.setDescripcion(txtDescripcion.getText());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	private JTextField getTxtDescripcion() {
		if (txtDescripcion == null) {
			txtDescripcion = new JTextField();
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(170, 231, 172, 20);
		}
		return txtDescripcion;
	}

	private JTextField getTxtNombreCarrera() {
		if (txtNombreCarrera == null) {
			txtNombreCarrera = new JTextField();
			txtNombreCarrera.setColumns(10);
			txtNombreCarrera.setBounds(170, 191, 172, 20);
		}
		return txtNombreCarrera;
	}

	private JComboBox getCmbTipoCarrera() {
		if (cmbTipoCarrera == null) {
			cmbTipoCarrera = new JComboBox();
			cmbTipoCarrera.addItem("Asfalto");
			cmbTipoCarrera.addItem("Montaña");
			cmbTipoCarrera.setSelectedIndex(-1);
			cmbTipoCarrera.setBounds(170, 311, 172, 22);
		}
		return cmbTipoCarrera;
	}

	private JLabel getLblCreacionCarrerasKm_1() {
		if (lblCreacionCarrerasKm == null) {
			lblCreacionCarrerasKm = new JLabel("Kilometros:");
			lblCreacionCarrerasKm.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarrerasKm.setBounds(49, 360, 92, 14);
		}
		return lblCreacionCarrerasKm;
	}

	private JTextField getTxtFechaEjecucion() {
		if (txtFechaEjecucion == null) {
			txtFechaEjecucion = new JTextField();
			txtFechaEjecucion.setColumns(10);
			txtFechaEjecucion.setBounds(170, 273, 172, 20);
		}
		return txtFechaEjecucion;
	}

	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setEnabled(false);
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setBounds(431, 116, 8, 337);
		}
		return textField_3;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Categorias");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			lblNewLabel.setBounds(612, 116, 142, 29);
		}
		return lblNewLabel;
	}

	private JLabel getLblCreacionCarreraNombreCat() {
		if (lblCreacionCarreraNombreCat == null) {
			lblCreacionCarreraNombreCat = new JLabel("Nombre:");
			lblCreacionCarreraNombreCat.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarreraNombreCat.setBounds(512, 337, 100, 17);
		}
		return lblCreacionCarreraNombreCat;
	}

	private JTextField getTxtNombreCat() {
		if (txtNombreCat == null) {
			txtNombreCat = new JTextField();
			txtNombreCat.setColumns(10);
			txtNombreCat.setBounds(587, 336, 132, 20);
		}
		return txtNombreCat;
	}

	private JLabel getLblCreacionCarreraEdadMin() {
		if (lblCreacionCarreraEdadMin == null) {
			lblCreacionCarreraEdadMin = new JLabel("Edad Min:");
			lblCreacionCarreraEdadMin.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarreraEdadMin.setBounds(512, 373, 100, 17);
		}
		return lblCreacionCarreraEdadMin;
	}

	private JTextField getTxtEdadMin() {
		if (txtEdadMin == null) {
			txtEdadMin = new JTextField();
			txtEdadMin.setColumns(10);
			txtEdadMin.setBounds(587, 372, 132, 20);
		}
		return txtEdadMin;
	}

	private JLabel getLblCreacionCarreraEdadMax() {
		if (lblCreacionCarreraEdadMax == null) {
			lblCreacionCarreraEdadMax = new JLabel("Edad Max:");
			lblCreacionCarreraEdadMax.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarreraEdadMax.setBounds(512, 407, 100, 17);
		}
		return lblCreacionCarreraEdadMax;
	}

	private JTextField getTxtEdadMax() {
		if (txtEdadMax == null) {
			txtEdadMax = new JTextField();
			txtEdadMax.setColumns(10);
			txtEdadMax.setBounds(587, 406, 132, 20);
		}
		return txtEdadMax;
	}

	private JButton getBtnAadirCategoria() {
		if (btnAadirCategoria == null) {
			btnAadirCategoria = new JButton("Añadir");
			btnAadirCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirCategoriaPorCarrera();
				}
			});
			btnAadirCategoria.setFont(new Font("Arial", Font.PLAIN, 14));
			btnAadirCategoria.setBounds(746, 351, 89, 23);
		}
		return btnAadirCategoria;
	}

	private boolean existeEseRangoDeEdad(int init, int fin) {
		if (categoriasCreacion.isEmpty()) {
			return true;
		}
		for (CategoriaDto cat : categoriasCreacion) {
			if (init >= cat.edadInic && fin <= cat.edadFin)
				return false;
		}
		return true;
	}

	private void añadirCategoriaPorCarrera() {
		if (checkeoCategoriaCampos()) {
			JOptionPane.showMessageDialog(null, "Error: Al crear las categorías no puedes dejar valores vacios.");
		} else {
			CategoriaDto cat = new CategoriaDto();
//			cat.carrera_id = creacionCarrera.getIdCarrera();
			cat.nombre = txtNombreCat.getText();
			cat.edadInic = Integer.parseInt(txtEdadMin.getText());
			cat.edadFin = Integer.parseInt(txtEdadMax.getText());
			if (existeEseRangoDeEdad(cat.edadInic, cat.edadFin)) {
				categoriasFiltrado = new ArrayList<CategoriaDto>();
				categoriasCreacion.add(cat);
				categoriasFiltrado.add(cat);
				cargarTablaCategoria();
			} else {
				JOptionPane.showMessageDialog(null, "Error: Al crear la categoría no puedes repetir edades.");
			}

		}
	}

	public void cargarTablaCategoria() {
		for (CategoriaDto dto : categoriasFiltrado) {
			String[] categoriasTabla = { dto.nombre, String.valueOf(dto.edadInic), String.valueOf(dto.edadFin) };
			tablaCategorias.addRow(categoriasTabla);
		}
	}

	public void cargarTablaCategoriaPostDelete() {
		for (CategoriaDto dto : categoriasCreacion) {
			String[] categoriasTabla = { dto.nombre, String.valueOf(dto.edadInic), String.valueOf(dto.edadFin) };
			tablaCategorias.addRow(categoriasTabla);
		}
	}

	private JButton getBtnBorrarCategoria() {
		if (btnBorrarCategoria == null) {
			btnBorrarCategoria = new JButton("Borrar");
			btnBorrarCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkIfSelectedCategory()) {
						reset(tablaCategorias);
						cargarTablaCategoriaPostDelete();
					}
				}
			});
			btnBorrarCategoria.setFont(new Font("Arial", Font.PLAIN, 14));
			btnBorrarCategoria.setBounds(746, 385, 89, 23);
		}
		return btnBorrarCategoria;
	}

	private boolean checkIfSelectedCategory() {
		try {
			Vector vector = tablaCategorias.getDataVector().elementAt(tableCategorias.getSelectedRow());
			if (vector != null) {
				CategoriaDto cat = new CategoriaDto();
				cat.nombre = (String) vector.get(0);
				categoriasCreacion.remove(cat);
				return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna categoria");
		}
		return false;
	}

	private JTextField getTxtKm() {
		if (txtKm == null) {
			txtKm = new JTextField();
			txtKm.setColumns(10);
			txtKm.setBounds(170, 358, 172, 20);
		}
		return txtKm;
	}

	private JLabel getLblParametros() {
		if (lblParametros == null) {
			lblParametros = new JLabel("Parametros");
			lblParametros.setFont(new Font("Arial", Font.PLAIN, 20));
			lblParametros.setBounds(131, 116, 142, 29);
		}
		return lblParametros;
	}

	private JLabel getLblCreacionCarrerasKm_1_1() {
		if (lblCreacionCarrerasPlazas == null) {
			lblCreacionCarrerasPlazas = new JLabel("Plazas:");
			lblCreacionCarrerasPlazas.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCreacionCarrerasPlazas.setBounds(49, 406, 92, 14);
		}
		return lblCreacionCarrerasPlazas;
	}

	private JTextField getTxtPlazas() {
		if (txtPlazas == null) {
			txtPlazas = new JTextField();
			txtPlazas.setColumns(10);
			txtPlazas.setBounds(170, 404, 172, 20);
		}
		return txtPlazas;
	}

	private JScrollPane getScrollPaneCategorias() {
		if (scrollPaneCategorias == null) {
			scrollPaneCategorias = new JScrollPane();
			scrollPaneCategorias.setBounds(512, 156, 323, 158);
			scrollPaneCategorias.setViewportView(getTableCategorias());
		}
		return scrollPaneCategorias;
	}

	private JTable getTableCategorias() {
		if (tableCategorias == null) {
			tableCategorias = new JTable();
			tableCategorias.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Edad Inicio", "Edad Fin" }) {
						Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
		}
		return tableCategorias;
	}

	private JButton getBtImportarTiemposCarrera() {
		if (btImportarTiemposCarrera == null) {
			btImportarTiemposCarrera = new JButton("Importar tiempos de carrera seleccionada");
			btImportarTiemposCarrera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					importarTiemposCarreraDada();
				}
			});
			btImportarTiemposCarrera.setMnemonic('T');
			btImportarTiemposCarrera.setFont(new Font("Arial", Font.PLAIN, 14));
			btImportarTiemposCarrera.setBounds(459, 198, 298, 38);
		}
		return btImportarTiemposCarrera;
	}

	protected void importarTiemposCarreraDada() {

		if (getTbVerCarreras().getSelectedRow() != -1) {

			String nombreCarrera = String.valueOf(tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0)); // nombreCarrera

			System.out.println(nombreCarrera);

			CarreraDto carrera = db.selectCarrerasNombre(nombreCarrera);// idCarrera

			System.out.println(carrera.getIdCarrera() + "    " + carrera.getNombre());

			Map<String, String> fichero = FileUtil.cargarTiempos(nombreCarrera);

			int numeroTiemposImportados = 0;
			for (Map.Entry<String, String> dorsalTiempo : fichero.entrySet()) {
				System.out.println(dorsalTiempo.getKey() + "/" + dorsalTiempo.getValue());
				numeroTiemposImportados++;
			}

			// hasta aquí todo bien, ya tengo el nombre de la carrera, el dorsal del atleta
			// y el tiempo, que si es 0 será NF (no finaliza).

			// Ahora toca recorrer ese diccionario, e insertar en la tabla inscripciones

			int contadorActualizaciones = UpdateInscribirseAtleta
					.updateInscripcionTiempoByDorsalAndIdCarrera(carrera.getIdCarrera(), fichero);

			System.out.println("Número de tiempos importados:   " + numeroTiemposImportados);

			System.out.println("Número de tiempos registrados con éxito:   " + contadorActualizaciones);

			db.selectInscripcion();

			// Categoria.calculaCategoria(inscripcionDto.getAtleta().getEdad(),
			// inscripcionDto.getAtleta().getSexo()),

			JOptionPane.showConfirmDialog(this,
					"La operación ha sido completada. \nEl número de tiempos importados es: " + numeroTiemposImportados
							+ "\nEl número de tiempos registrados con éxito es: " + contadorActualizaciones,
					"Importar tiempos carrera " + nombreCarrera, JOptionPane.DEFAULT_OPTION);
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una carrera");
		}
	}

	protected void accionClasificaciones() {
		if (getTbVerCarreras().getSelectedRow() != -1) {
			reset(tablaClasificaciones);

			System.out.println("cosa del debug");

			String nombreCarrera = String.valueOf(tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0)); // nombreCarrera

			System.out.println(nombreCarrera);

			CarreraDto carrera = db.selectCarrerasNombre(nombreCarrera);// idCarrera

			System.out.println(carrera.getIdCarrera() + "    " + carrera.getNombre());

			// ahora necesito una lista de inscripciones
			// tengo el id de la carrera
			// he de sacar todas las inscipciones con ese idCarrera
			// Teniendo ya eso, qe me da la categoria, y demas es trabajar con esa lista de
			// inscripciones

			ArrayList<InscripcionDto> inscripciones = db.getArrayClasificaciones(carrera.getIdCarrera());
			if (inscripciones.size() == 0) {
				System.err.println("inscripciones vacias");
			}

			for (InscripcionDto inscripcionDto : inscripciones) {
				System.out.println(inscripcionDto.getCategoria() + "             " + carrera.getNombre()
						+ "            " + inscripcionDto.getAtleta().getSexo() + "          "
						+ inscripcionDto.getAtleta().getNombre() + "               "
						+ stringFromNumberToDate(inscripcionDto.getTiempoCorriendo()));
			}

			int posicion = 1;
			String categoria = "";

			for (InscripcionDto inscripcionDto : inscripciones) {
				AtletaDto atleta = new AtletaDto();

				if (inscripcionDto.getCategoria() == null) {
					inscripcionDto.setCategoria("SIN CATEGORIA");
					System.err.println("\"SIN CATEGORIA\" por accionClasificaciones() - MainWindow linea 2156");
				}
				if (inscripcionDto.getCategoria().equals(categoria)) {
					System.err.println("hasta aqui bien");
					String[] clasificacionesTabla = { Integer.toString(posicion) + "º", inscripcionDto.getDorsal(),
							inscripcionDto.getCategoria(), inscripcionDto.getAtleta().getSexo(),
							inscripcionDto.getAtleta().getNombre(),
							stringFromNumberToDate(inscripcionDto.getTiempoCorriendo()) };
					tablaClasificaciones.addRow(clasificacionesTabla);
					posicion++;

				} else {
					categoria = inscripcionDto.getCategoria();

					System.err.println("hasta aqui bien");

					posicion = 1;
					String[] clasificacionesTabla = { Integer.toString(posicion) + "º", inscripcionDto.getDorsal(),
							inscripcionDto.getCategoria(), inscripcionDto.getAtleta().getSexo(),
							inscripcionDto.getAtleta().getNombre(),
							stringFromNumberToDate(inscripcionDto.getTiempoCorriendo()) };
					tablaClasificaciones.addRow(clasificacionesTabla);
					posicion++;
				}
			}

			showCard(PANEL_VERCLASIFICACIONESORGANIZADOR);
		} else {
			JOptionPane.showMessageDialog(this, "Selecciona una carrera");
		}

	}

	private JPanel getPnConfiguracionPlazos() {
		if (pnConfiguracionPlazos == null) {
			pnConfiguracionPlazos = new JPanel();
			pnConfiguracionPlazos.setLayout(new BorderLayout(0, 0));
			pnConfiguracionPlazos.add(getPnPrincipalConfiguracionPlazos(), BorderLayout.CENTER);
		}
		return pnConfiguracionPlazos;
	}

	private JPanel getPnPrincipalConfiguracionPlazos() {
		if (pnPrincipalConfiguracionPlazos == null) {
			pnPrincipalConfiguracionPlazos = new JPanel();
			pnPrincipalConfiguracionPlazos.setLayout(null);
			pnPrincipalConfiguracionPlazos.add(getLbConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getBtAtrasConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getBtCreacionCarreraConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getBtADDConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getLbCuotaConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getTxCuotaConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getLbFechaInicioConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getTxFechaInicioConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getLblFechaFinConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getTxFechaFinConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getScConfiguracionPlazos());
			pnPrincipalConfiguracionPlazos.add(getTxDatosCarreraConfiguracionPlazos());
		}
		return pnPrincipalConfiguracionPlazos;
	}

	private JLabel getLbConfiguracionPlazos() {
		if (lbConfiguracionPlazos == null) {
			lbConfiguracionPlazos = new JLabel("Configuración de los Plazos de Inscripción");
			lbConfiguracionPlazos.setFont(new Font("Arial", Font.BOLD, 25));
			lbConfiguracionPlazos.setBounds(135, 56, 527, 58);
		}
		return lbConfiguracionPlazos;
	}

	private JButton getBtAtrasConfiguracionPlazos() {
		if (btAtrasConfiguracionPlazos == null) {
			btAtrasConfiguracionPlazos = new JButton("Atras");
			btAtrasConfiguracionPlazos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_CREACION_CARRERAS);
				}
			});
			btAtrasConfiguracionPlazos.setFont(new Font("Arial", Font.BOLD, 20));
			btAtrasConfiguracionPlazos.setMnemonic('a');
			btAtrasConfiguracionPlazos.setBounds(45, 401, 153, 45);
		}
		return btAtrasConfiguracionPlazos;
	}

	private JButton getBtCreacionCarreraConfiguracionPlazos() {
		if (btCreacionCarreraConfiguracionPlazos == null) {
			btCreacionCarreraConfiguracionPlazos = new JButton("Crear Carrera");
			btCreacionCarreraConfiguracionPlazos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					db.insertarCarreraNueva(creacionCarrera);
					for (CategoriaDto c : categoriasCreacion) {
						c.carrera_id = creacionCarrera.getIdCarrera();
						new AddCategoria(c).execute();

					}
					showCard(PANEL_ORGANIZADOR);
					db.selectCarreras();
					reset(tb);
					reset(tablaAtleta);
					cargarTablaCarrerasAtleta();
					cargarTablaCarrerasOrganizador();
				}
			});
			btCreacionCarreraConfiguracionPlazos.setFont(new Font("Arial", Font.BOLD, 20));
			btCreacionCarreraConfiguracionPlazos.setMnemonic('r');
			btCreacionCarreraConfiguracionPlazos.setBounds(630, 401, 205, 45);
		}
		return btCreacionCarreraConfiguracionPlazos;
	}

	private JButton getBtADDConfiguracionPlazos() {
		if (btADDConfiguracionPlazos == null) {
			btADDConfiguracionPlazos = new JButton("Add");
			btADDConfiguracionPlazos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						addPlazo();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

				}
			});
			btADDConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 20));
			btADDConfiguracionPlazos.setMnemonic('d');
			btADDConfiguracionPlazos.setBounds(373, 405, 126, 37);
		}
		return btADDConfiguracionPlazos;
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Añade un nuevo plazo de inscripcion a una carrera
	 * @throws ParseException
	 * 
	 */
	private void addPlazo() throws ParseException {
		fechaIni = getTxFechaInicioConfiguracionPlazos().getText();
		fechaFin = getTxFechaFinConfiguracionPlazos().getText();
		cuota = getTxCuotaConfiguracionPlazos().getText();

		if (tablaPlazosInscripciones.getRowCount() > 3) {
			JOptionPane.showConfirmDialog(btADDConfiguracionPlazos, "Ya no puedes añadir mas plazos", "Error",
					JOptionPane.DEFAULT_OPTION);
		} else if (fechaIni.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFin.matches("\\d{4}-\\d{2}-\\d{2}")
				&& cuota.matches("[+-]?\\d*(\\.\\d+)?")) {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedIni = format.parse(fechaIni);
			Date parsedFin = format.parse(fechaFin);
			java.sql.Date fechaIniDate = new java.sql.Date(parsedIni.getTime());
			java.sql.Date fechaFinDate = new java.sql.Date(parsedFin.getTime());
			if (fechaIniDate.before(fechaFinDate) && fechaFinDate.before(creacionCarrera.getFecha())
					&& fechaIniDate.before(creacionCarrera.getFecha())) {

				tablaPlazosInscripciones.addRow(new String[] { fechaIni, fechaFin, cuota });

				if (primera) {
					creacionCarrera.setFechaInicioIns(fechaIniDate);
					creacionCarrera.setFechaFin(fechaFinDate);
					creacionCarrera.setCuota(Integer.parseInt(cuota));
					primera = false;
				}

				String toDo = fechaIni + "," + fechaFin + "," + cuota;

				diccionarioPlazos.put(creacionCarrera.getNombre(), toDo);

				getTxFechaInicioConfiguracionPlazos().setText(fechaFin);
				getTxFechaInicioConfiguracionPlazos().setEditable(false);
			} else {
				JOptionPane.showConfirmDialog(btADDConfiguracionPlazos,
						"La fecha Final tiene que ser posterior a la fecha Inicio", "Error",
						JOptionPane.DEFAULT_OPTION);
			}

		} else {
			JOptionPane.showConfirmDialog(btADDConfiguracionPlazos,
					"Has insertado mal los datos en los campos, revisa que las fechas estan en formato ISO y la cuota es solo numeros",
					"Error", JOptionPane.DEFAULT_OPTION);
		}
	}

	private JLabel getLbCuotaConfiguracionPlazos() {
		if (lbCuotaConfiguracionPlazos == null) {
			lbCuotaConfiguracionPlazos = new JLabel("Cuota");
			lbCuotaConfiguracionPlazos.setDisplayedMnemonic('c');
			lbCuotaConfiguracionPlazos.setLabelFor(getTxCuotaConfiguracionPlazos());
			lbCuotaConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 20));
			lbCuotaConfiguracionPlazos.setBounds(537, 302, 83, 37);
		}
		return lbCuotaConfiguracionPlazos;
	}

	private JTextField getTxCuotaConfiguracionPlazos() {
		if (txCuotaConfiguracionPlazos == null) {
			txCuotaConfiguracionPlazos = new JTextField();
			txCuotaConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 20));
			txCuotaConfiguracionPlazos.setBounds(630, 302, 96, 37);
			txCuotaConfiguracionPlazos.setColumns(10);
		}
		return txCuotaConfiguracionPlazos;
	}

	private JLabel getLbFechaInicioConfiguracionPlazos() {
		if (lbFechaInicioConfiguracionPlazos == null) {
			lbFechaInicioConfiguracionPlazos = new JLabel("Fecha Inicio");
			lbFechaInicioConfiguracionPlazos.setLabelFor(getTxFechaInicioConfiguracionPlazos());
			lbFechaInicioConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 20));
			lbFechaInicioConfiguracionPlazos.setDisplayedMnemonic('i');
			lbFechaInicioConfiguracionPlazos.setBounds(42, 302, 109, 37);
		}
		return lbFechaInicioConfiguracionPlazos;
	}

	private JTextField getTxFechaInicioConfiguracionPlazos() {
		if (txFechaInicioConfiguracionPlazos == null) {
			txFechaInicioConfiguracionPlazos = new JTextField();
			txFechaInicioConfiguracionPlazos.setText("       ");
			txFechaInicioConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 20));
			txFechaInicioConfiguracionPlazos.setColumns(10);
			txFechaInicioConfiguracionPlazos.setBounds(161, 302, 96, 37);
		}
		return txFechaInicioConfiguracionPlazos;
	}

	private JLabel getLblFechaFinConfiguracionPlazos() {
		if (lblFechaFinConfiguracionPlazos == null) {
			lblFechaFinConfiguracionPlazos = new JLabel("Fecha Fin");
			lblFechaFinConfiguracionPlazos.setLabelFor(getTxFechaFinConfiguracionPlazos());
			lblFechaFinConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFechaFinConfiguracionPlazos.setDisplayedMnemonic('f');
			lblFechaFinConfiguracionPlazos.setBounds(289, 302, 109, 37);
		}
		return lblFechaFinConfiguracionPlazos;
	}

	private JTextField getTxFechaFinConfiguracionPlazos() {
		if (txFechaFinConfiguracionPlazos == null) {
			txFechaFinConfiguracionPlazos = new JTextField();
			txFechaFinConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 20));
			txFechaFinConfiguracionPlazos.setColumns(10);
			txFechaFinConfiguracionPlazos.setBounds(403, 302, 96, 37);
		}
		return txFechaFinConfiguracionPlazos;
	}

	private JScrollPane getScConfiguracionPlazos() {
		if (scConfiguracionPlazos == null) {
			scConfiguracionPlazos = new JScrollPane();
			scConfiguracionPlazos.setBounds(145, 107, 516, 170);
			scConfiguracionPlazos.setViewportView(getTbConfiguracionPlazos());
		}
		return scConfiguracionPlazos;
	}

	private JTable getTbConfiguracionPlazos() {
		if (tbConfiguracionPlazos == null) {
			tbConfiguracionPlazos = new JTable();
			tbConfiguracionPlazos.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Fecha Inicio", "Fecha Fin", "Cuota" }));

			tbConfiguracionPlazos.setDefaultEditor(Object.class, null);
		}
		return tbConfiguracionPlazos;
	}

	private JPanel getPnGeneralDorsales() {
		if (pnGeneralDorsales == null) {
			pnGeneralDorsales = new JPanel();
			pnGeneralDorsales.setLayout(new BorderLayout(0, 0));
			pnGeneralDorsales.add(getPnGenerarDorsalesPrincipal(), BorderLayout.CENTER);
		}
		return pnGeneralDorsales;
	}

	private JPanel getPnGenerarDorsalesPrincipal() {
		if (pnGenerarDorsalesPrincipal == null) {
			pnGenerarDorsalesPrincipal = new JPanel();
			pnGenerarDorsalesPrincipal.setLayout(null);
			pnGenerarDorsalesPrincipal.add(getLbGenerarDorsales());
			pnGenerarDorsalesPrincipal.add(getScGeneralDorsales());
			pnGenerarDorsalesPrincipal.add(getBtAtrasGeneralDorsales());
			pnGenerarDorsalesPrincipal.add(getBtGeneralDorsales());
			pnGenerarDorsalesPrincipal.add(getLbVIPSGeneralDorsales());
			pnGenerarDorsalesPrincipal.add(getTxVipsGeneralDorsales());
			pnGenerarDorsalesPrincipal.add(getTxdatosCarreraGeneralDorsales());
		}
		return pnGenerarDorsalesPrincipal;
	}

	private JLabel getLbGenerarDorsales() {
		if (lbGenerarDorsales == null) {
			lbGenerarDorsales = new JLabel("Generar Dorsales");
			lbGenerarDorsales.setFont(new Font("Arial", Font.BOLD, 25));
			lbGenerarDorsales.setBounds(325, 62, 213, 40);
		}
		return lbGenerarDorsales;
	}

	private JScrollPane getScGeneralDorsales() {
		if (scGeneralDorsales == null) {
			scGeneralDorsales = new JScrollPane();
			scGeneralDorsales.setBounds(164, 137, 539, 188);
			scGeneralDorsales.setViewportView(getTbGeneralDorsales());
		}
		return scGeneralDorsales;
	}

	private JTable getTbGeneralDorsales() {
		if (tbGeneralDorsales == null) {
			tbGeneralDorsales = new JTable();
			tbGeneralDorsales
					.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Dorsal", "DNI", "Nombre" }));

			tbGeneralDorsales.setDefaultEditor(Object.class, null);
		}
		return tbGeneralDorsales;
	}

	private JButton getBtAtrasGeneralDorsales() {
		if (btAtrasGeneralDorsales == null) {
			btAtrasGeneralDorsales = new JButton("Atras");
			btAtrasGeneralDorsales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_VER_CARRERAS_ORGANIZADOR);
				}
			});
			btAtrasGeneralDorsales.setFont(new Font("Arial", Font.PLAIN, 20));
			btAtrasGeneralDorsales.setMnemonic('a');
			btAtrasGeneralDorsales.setBounds(10, 419, 163, 40);
		}
		return btAtrasGeneralDorsales;
	}

	private JButton getBtGeneralDorsales() {
		if (btGeneralDorsales == null) {
			btGeneralDorsales = new JButton("General Dorsales");
			btGeneralDorsales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					GenerarDorsales();

				}

			});
			btGeneralDorsales.setFont(new Font("Arial", Font.PLAIN, 20));
			btGeneralDorsales.setMnemonic('g');
			btGeneralDorsales.setBounds(325, 424, 213, 30);
		}
		return btGeneralDorsales;
	}

	private void GenerarDorsales() {

		reset(tablaGenerarDorsales);

		int vips;
		if (txVipsGeneralDorsales.getText().equals("")) {
			vips = 0;
		} else {
			vips = Integer.parseInt(txVipsGeneralDorsales.getText());
		}

		String nombre = String.valueOf(tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0));

		CarreraDto aux = db.selectCarrerasNombre(nombre);

		String id = aux.getIdCarrera();

		List<AtletaDto> atletas = db.listaAtletasOrdenadorPorFechaIns(id);

		for (int i = 0; i < numeroGenteInscritaEnLaCarreraActual; i++) {

			String dorsal = String.valueOf(i + vips + 1);

			String[] pizza = { dorsal, atletas.get(i).getDNI(), atletas.get(i).getNombre() };

			UpdateInscribirseAtletaDorsal.execute(id, atletas.get(i).getIdAtleta(), dorsal);

			tablaGenerarDorsales.addRow(pizza);

		}
	}

	private JLabel getLbVIPSGeneralDorsales() {
		if (lbVIPSGeneralDorsales == null) {
			lbVIPSGeneralDorsales = new JLabel("¿Cuantos Vips quieres reservar?");
			lbVIPSGeneralDorsales.setDisplayedMnemonic('V');
			lbVIPSGeneralDorsales.setLabelFor(getTxVipsGeneralDorsales());
			lbVIPSGeneralDorsales.setFont(new Font("Arial", Font.PLAIN, 20));
			lbVIPSGeneralDorsales.setBounds(36, 366, 294, 19);
		}
		return lbVIPSGeneralDorsales;
	}

	private JTextField getTxVipsGeneralDorsales() {
		if (txVipsGeneralDorsales == null) {
			txVipsGeneralDorsales = new JTextField();
			txVipsGeneralDorsales.setFont(new Font("Arial", Font.PLAIN, 20));
			txVipsGeneralDorsales.setBounds(340, 366, 43, 22);
			txVipsGeneralDorsales.setColumns(10);
		}
		return txVipsGeneralDorsales;
	}

	private JTextField getTxDatosCarreraConfiguracionPlazos() {

		if (txDatosCarreraConfiguracionPlazos == null) {
			txDatosCarreraConfiguracionPlazos = new JTextField();
			txDatosCarreraConfiguracionPlazos.setFont(new Font("Arial", Font.PLAIN, 15));
			txDatosCarreraConfiguracionPlazos.setEditable(false);
			txDatosCarreraConfiguracionPlazos.setBounds(45, 10, 793, 31);
			txDatosCarreraConfiguracionPlazos.setColumns(10);

		}
		return txDatosCarreraConfiguracionPlazos;
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo que imprime la label del panel de Plazos con info de la
	 *         carrera. Esa info esta guardada en dos String los cuales hay que
	 *         modificar en algun momento o siempre valdran null
	 * 
	 */
	private void printLabelPlazos() {

		txDatosCarreraConfiguracionPlazos.setText("Configurando los plazos de inscripcion de la carrera: "
				+ creacionCarrera.getNombre() + ", con fecha de inicio de la carrera: " + creacionCarrera.getFecha());

	}

	/**
	 * 
	 * @return
	 */
	private JTextField getTxdatosCarreraGeneralDorsales() {

		if (txdatosCarreraGeneralDorsales == null) {
			txdatosCarreraGeneralDorsales = new JTextField();
			txdatosCarreraGeneralDorsales.setEditable(false);
			txdatosCarreraGeneralDorsales.setFont(new Font("Arial", Font.PLAIN, 13));
			txdatosCarreraGeneralDorsales.setBounds(10, 10, 847, 30);
			txdatosCarreraGeneralDorsales.setColumns(10);

		}
		return txdatosCarreraGeneralDorsales;
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo que imprime la etiqueta de los dorsales con info de la carrera
	 */
	private void printLabelDorsales() {

		String nombre = String.valueOf(tb.getValueAt(getTbVerCarreras().getSelectedRow(), 0));

		CarreraDto aux = db.selectCarrerasNombre(nombre);

		String id = aux.getIdCarrera();

		numeroGenteInscritaEnLaCarreraActual = db.numInscritosxCarrera(id);

		txdatosCarreraGeneralDorsales.setText(
				"Carrera con nombre: " + nombre + ",  con num de inscritos: " + numeroGenteInscritaEnLaCarreraActual);
	}

	private JButton getBtnGenerarDorsalesVistaOrganizador() {
		if (btnGenerarDorsalesVistaOrganizador == null) {
			btnGenerarDorsalesVistaOrganizador = new JButton("Generar dorsales");
			btnGenerarDorsalesVistaOrganizador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard(PANEL_GENERAL_DORSALES);

					printLabelDorsales();
				}
			});

			btnGenerarDorsalesVistaOrganizador.setBounds(767, 155, 121, 34);

		}
		return btnGenerarDorsalesVistaOrganizador;
	}
}
