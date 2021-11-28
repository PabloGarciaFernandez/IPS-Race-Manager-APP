package ipsTeamwork.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.carrera.crud.GetNombreById;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.model.inscripcion.crud.SelectAllInscripcionForAtleta;

public class PanelListarInscripciones extends JPanel {

	private static final long serialVersionUID = -2544604774053249097L;
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JScrollPane scrollPane;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private JButton btnAtras;
	private JTable tableInscripciones;
	private DefaultTableModel dtm;

	private AtletaDto atleta;
	private CarreraDto carreraActual;
	private GestorDB db;

	private MainWindow parent;
	private JButton btnCancelarInscripcion;
	private Component horizontalStrut;

	/**
	 * Create the panel.
	 */
	public PanelListarInscripciones(MainWindow parent, AtletaDto atleta) {
		setBounds(100, 100, 599, 421);
		setLayout(new BorderLayout(0, 0));
		add(getPanelNorth(), BorderLayout.NORTH);
		add(getPanelSouth(), BorderLayout.SOUTH);
		add(getScrollPane(), BorderLayout.CENTER);

		dtm = (DefaultTableModel) getTableInscripciones().getModel();

		this.atleta = atleta;
		this.parent = parent;
	}

	private JPanel getPanelNorth() {
		if (panelNorth == null) {
			panelNorth = new JPanel();
			panelNorth.add(getVerticalStrut());
			panelNorth.add(getHorizontalStrut());
			panelNorth.add(getBtnCancelarInscripcion());
		}
		return panelNorth;
	}

	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.add(getVerticalStrut_1());
			panelSouth.add(getBtnAtras());
		}
		return panelSouth;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableInscripciones());
		}
		return scrollPane;
	}

	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(40);
		}
		return verticalStrut;
	}

	private Component getVerticalStrut_1() {
		if (verticalStrut_1 == null) {
			verticalStrut_1 = Box.createVerticalStrut(40);
		}
		return verticalStrut_1;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atras();
				}
			});
		}
		return btnAtras;
	}

	private JTable getTableInscripciones() {
		if (tableInscripciones == null) {
			tableInscripciones = new JTable();
			tableInscripciones
					.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Estado", "Desde" }));
		}

		return tableInscripciones;
	}

	public void setAtleta(AtletaDto atletaActual) {
		this.atleta = atletaActual;
		cargarInscripcionesEnTabla();
	}

	public void cargarInscripcionesEnTabla() {
		if (dtm.getRowCount() > 0) {
			reset(dtm);
		}

		List<InscripcionDto> insc = new SelectAllInscripcionForAtleta(atleta.getIdAtleta()).execute();
		System.out.println("\n\n\nCargando inscripciones en tabla:\n");
		for (InscripcionDto dto : insc) {
			String[] inscRow = { new GetNombreById(dto.getIdCarrera()).execute(), dto.getEstadoInscripcion(),
					dto.getFechaInscripcion().toString() };

			System.out.println(inscRow);
			dtm.addRow(inscRow);
		}

		System.out.println("\n\n\nInscripciones en select:\n");
		new GestorDB().selectInscripcion();
		getTableInscripciones().setModel(dtm);
	}

	public void atras() {
		parent.showCard(MainWindow.PANEL_ATLETA);
		// this.setVisible(false);
	}

	private void reset(DefaultTableModel francisco) {
		francisco.setRowCount(0);
	}

	private JButton getBtnCancelarInscripcion() {
		if (btnCancelarInscripcion == null) {
			btnCancelarInscripcion = new JButton("Cancelar Inscripción");
			btnCancelarInscripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkCarreraRow()) {
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cancelar?");
						if (respuesta == JOptionPane.YES_OPTION) {
							int result = db.cancelarInscripcionEnCarrera(atleta, carreraActual);
							switch (result) {
							case -1:
								JOptionPane.showMessageDialog(null,
										"La carrera no dispone de una política de cancelación.");
								break;
							case 0:
								JOptionPane.showMessageDialog(null, "Inscripción cancelada.");
								break;
							}
						}
					}
				}
			});
			btnCancelarInscripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return btnCancelarInscripcion;
	}

	private Component getHorizontalStrut() {
		if (horizontalStrut == null) {
			horizontalStrut = Box.createHorizontalStrut(420);
		}
		return horizontalStrut;
	}

	private boolean checkCarreraRow() {
		try {
			Vector vector = dtm.getDataVector().elementAt(tableInscripciones.getSelectedRow());
			if (vector != null) {
				this.db = new GestorDB();
				carreraActual = db.selectCarrerasNombre((String) vector.get(0));
				return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna carrera");
		}
		return false;
	}
}
