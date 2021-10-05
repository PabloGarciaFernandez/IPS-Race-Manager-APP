package ipsTeamwork.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3073912408195015551L;
	private JPanel contentPane;
	private JPanel pnInicio;
	private JButton btnAtleta;
	private JButton btnOrganiz;
	private JLabel lbImagen;
	private JPanel pnAtleta;
	private JPanel pnOrganizador;
	private JButton btnRegistro;
	private JButton btnListaCarreras;
	private JButton btnMisCarreras;
	private JPanel pnLista;
	private JPanel pnLista14473;
	private JPanel pnListaNorth;
	private JButton btnListaIngresar;
	private JButton btnListaRegistrarse;
	private JPanel pnListaSouth;
	private JButton btnListaCancel;
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
	private JButton btnRegistroCancelar_1;
	private JButton btnRegistroSiguiente_1;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		setTitle("App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnInicio(), "panel_inicio");
		contentPane.add(getPnAtleta(), "panel_atleta");
		contentPane.add(getPnOrganizador(), "panel_organizador");
		contentPane.add(getPnLista(), "panel_lista");
		contentPane.add(getPnRegistro(), "name_338442641229100");
		contentPane.add(getPnIngreso(), "name_338949480805700");
	}

	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setLayout(null);
			pnInicio.add(getBtnAtleta());
			pnInicio.add(getBtnOrganiz());
			pnInicio.add(getLbImagen());
			pnInicio.add(getBtnRegistro());
		}
		return pnInicio;
	}

	private JButton getBtnAtleta() {
		if (btnAtleta == null) {
			btnAtleta = new JButton("Soy atleta");
			btnAtleta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard("panel_atleta");
				}
			});
			btnAtleta.setBounds(236, 194, 111, 23);
		}
		return btnAtleta;
	}

	private JButton getBtnOrganiz() {
		if (btnOrganiz == null) {
			btnOrganiz = new JButton("Soy organizador");
			btnOrganiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard("panel_organizador");
				}
			});
			btnOrganiz.setBounds(236, 230, 111, 23);
		}
		return btnOrganiz;
	}

	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("lbImagen");
			lbImagen.setIcon(new ImageIcon(MainWindow.class.getResource("/main/resources/icon/icon.png")));
			lbImagen.setBounds(111, 40, 361, 140);
		}
		return lbImagen;
	}

	private JPanel getPnAtleta() {
		if (pnAtleta == null) {
			pnAtleta = new JPanel();
			pnAtleta.setLayout(null);
			pnAtleta.add(getBtnListaCarreras());
			pnAtleta.add(getBtnMisCarreras());
		}
		return pnAtleta;
	}

	private JPanel getPnOrganizador() {
		if (pnOrganizador == null) {
			pnOrganizador = new JPanel();
		}
		return pnOrganizador;
	}

	private JButton getBtnRegistro() {
		if (btnRegistro == null) {
			btnRegistro = new JButton("Registrarme");
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard("panel_registro");
				}
			});
			btnRegistro.setBounds(236, 264, 111, 23);
		}
		return btnRegistro;
	}

	private JButton getBtnListaCarreras() {
		if (btnListaCarreras == null) {
			btnListaCarreras = new JButton("Lista de competiciones");
			btnListaCarreras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showCard("panel_lista");
				}
			});
			btnListaCarreras.setBounds(222, 205, 139, 23);
		}
		return btnListaCarreras;
	}

	private JButton getBtnMisCarreras() {
		if (btnMisCarreras == null) {
			btnMisCarreras = new JButton("Mis carreras");
			btnMisCarreras.setBounds(222, 239, 139, 23);
		}
		return btnMisCarreras;
	}

	private void showCard(String name) {
		CardLayout c1 = (CardLayout) contentPane.getLayout();
		c1.show(contentPane, name);
	}
	
	private JPanel getPnLista() {
		if (pnLista == null) {
			pnLista = new JPanel();
			pnLista.setLayout(new BorderLayout(0, 0));
			pnLista.add(getPnLista14473(), BorderLayout.CENTER);
			pnLista.add(getPnListaNorth(), BorderLayout.NORTH);
			pnLista.add(getPnListaSouth(), BorderLayout.SOUTH);
		}
		return pnLista;
	}
	
	private JPanel getPnLista14473() {
		if (pnLista14473 == null) {
			pnLista14473 = new JPanel();
			pnLista14473.setBackground(Color.DARK_GRAY);
			pnLista14473.setLayout(new GridLayout(1, 0, 0, 0));
		}
		return pnLista14473;
	}
	private JPanel getPnListaNorth() {
		if (pnListaNorth == null) {
			pnListaNorth = new JPanel();
			pnListaNorth.setBackground(Color.LIGHT_GRAY);
			pnListaNorth.add(getBtnListaIngresar());
			pnListaNorth.add(getBtnListaRegistrarse());
		}
		return pnListaNorth;
	}
	private JButton getBtnListaIngresar() {
		if (btnListaIngresar == null) {
			btnListaIngresar = new JButton("Ingresar");
			btnListaIngresar.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnListaIngresar;
	}
	private JButton getBtnListaRegistrarse() {
		if (btnListaRegistrarse == null) {
			btnListaRegistrarse = new JButton("Registrarse");
			btnListaRegistrarse.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnListaRegistrarse;
	}
	private JPanel getPnListaSouth() {
		if (pnListaSouth == null) {
			pnListaSouth = new JPanel();
			pnListaSouth.setBackground(Color.LIGHT_GRAY);
			pnListaSouth.add(getBtnListaCancel());
		}
		return pnListaSouth;
	}
	private JButton getBtnListaCancel() {
		if (btnListaCancel == null) {
			btnListaCancel = new JButton("Cancelar");
			btnListaCancel.setForeground(Color.RED);
			btnListaCancel.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return btnListaCancel;
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
			btnRegistroSiguiente.setForeground(Color.GREEN);
			btnRegistroSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroSiguiente.setBounds(452, 348, 121, 23);
		}
		return btnRegistroSiguiente;
	}
	private JButton getBtnRegistroCancelar() {
		if (btnRegistroCancelar == null) {
			btnRegistroCancelar = new JButton("Cancelar");
			btnRegistroCancelar.setForeground(Color.RED);
			btnRegistroCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroCancelar.setBounds(319, 348, 89, 23);
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
			pnIngresoCenter.add(getBtnRegistroCancelar_1());
			pnIngresoCenter.add(getBtnRegistroSiguiente_1());
		}
		return pnIngresoCenter;
	}
	private JTextField getTextIngresoEmail() {
		if (textIngresoEmail == null) {
			textIngresoEmail = new JTextField();
			textIngresoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			textIngresoEmail.setColumns(10);
			textIngresoEmail.setBounds(160, 188, 370, 20);
		}
		return textIngresoEmail;
	}
	private JLabel getLblIngesoEmail() {
		if (lblIngesoEmail == null) {
			lblIngesoEmail = new JLabel("Email:");
			lblIngesoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
			lblIngesoEmail.setBounds(37, 188, 80, 20);
		}
		return lblIngesoEmail;
	}
	private JLabel getLblIngresoDeCuenta() {
		if (lblIngresoDeCuenta == null) {
			lblIngresoDeCuenta = new JLabel("INGRESO DE CUENTA");
			lblIngresoDeCuenta.setFont(new Font("Arial", Font.BOLD, 25));
			lblIngresoDeCuenta.setBounds(37, 21, 691, 53);
		}
		return lblIngresoDeCuenta;
	}
	private JButton getBtnRegistroCancelar_1() {
		if (btnRegistroCancelar_1 == null) {
			btnRegistroCancelar_1 = new JButton("Cancelar");
			btnRegistroCancelar_1.setForeground(Color.RED);
			btnRegistroCancelar_1.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroCancelar_1.setBounds(319, 348, 89, 23);
		}
		return btnRegistroCancelar_1;
	}
	private JButton getBtnRegistroSiguiente_1() {
		if (btnRegistroSiguiente_1 == null) {
			btnRegistroSiguiente_1 = new JButton("Siguiente");
			btnRegistroSiguiente_1.setForeground(Color.GREEN);
			btnRegistroSiguiente_1.setFont(new Font("Arial", Font.PLAIN, 14));
			btnRegistroSiguiente_1.setBounds(452, 348, 121, 23);
		}
		return btnRegistroSiguiente_1;
	}
}
