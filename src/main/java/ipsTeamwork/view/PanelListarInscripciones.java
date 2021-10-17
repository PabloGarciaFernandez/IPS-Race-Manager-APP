package ipsTeamwork.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;

public class PanelListarInscripciones extends JPanel {

	private static final long serialVersionUID = -2544604774053249097L;
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JScrollPane scrollPane;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private JButton btnAtras;
	private JTable tableInscripciones;

	/**
	 * Create the panel.
	 */
	public PanelListarInscripciones() {
		setBounds(100, 100, 599, 421);
		setLayout(new BorderLayout(0, 0));
		add(getPanelNorth(), BorderLayout.NORTH);
		add(getPanelSouth(), BorderLayout.SOUTH);
		add(getScrollPane(), BorderLayout.CENTER);
		add(getTableInscripciones(), BorderLayout.WEST);

	}
	private JPanel getPanelNorth() {
		if (panelNorth == null) {
			panelNorth = new JPanel();
			panelNorth.add(getVerticalStrut());
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
		}
		return btnAtras;
	}
	
	private JTable getTableInscripciones() {
		if (tableInscripciones == null) {
			tableInscripciones = new JTable();
		}
		return tableInscripciones;
	}
}
