package ipsTeamwork.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigCancelacion extends JDialog {
	private JTextField txtPocentaje;
	private JTextField txtFechaLimite;
	private JButton btnCancelar;
	private JButton btnAñadir;
	private Date dateLimit;
	private Date dateADevolver;
	private int porcentaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigCancelacion dialog = new ConfigCancelacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigCancelacion() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		{
			JPanel pnConfigCancel = new JPanel();
			getContentPane().add(pnConfigCancel, BorderLayout.CENTER);
			pnConfigCancel.setLayout(null);
			{
				JLabel lblConfigCancelacion = new JLabel("CONFIGURACION DE CANCELACION");
				lblConfigCancelacion.setFont(new Font("Arial", Font.BOLD, 20));
				lblConfigCancelacion.setBounds(10, 11, 414, 53);
				pnConfigCancel.add(lblConfigCancelacion);
			}
			{
				JLabel lblDevolucion = new JLabel("Porcentaje de devolucion:");
				lblDevolucion.setFont(new Font("Arial", Font.PLAIN, 14));
				lblDevolucion.setBounds(21, 90, 164, 17);
				pnConfigCancel.add(lblDevolucion);
			}
			{
				JLabel lblFechaLimite = new JLabel("Fecha límite:");
				lblFechaLimite.setFont(new Font("Arial", Font.PLAIN, 14));
				lblFechaLimite.setBounds(21, 140, 91, 17);
				pnConfigCancel.add(lblFechaLimite);
			}
			pnConfigCancel.add(getTxtPocentaje());
			pnConfigCancel.add(getTxtFechaLimite());
			pnConfigCancel.add(getBtnCancelar());
			pnConfigCancel.add(getBtnAñadir());
		}
	}
	
	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	private JTextField getTxtPocentaje() {
		if (txtPocentaje == null) {
			txtPocentaje = new JTextField();
			txtPocentaje.setFont(new Font("Arial", Font.PLAIN, 14));
			txtPocentaje.setBounds(212, 89, 144, 20);
			txtPocentaje.setColumns(10);
		}
		return txtPocentaje;
	}
	private JTextField getTxtFechaLimite() {
		if (txtFechaLimite == null) {
			txtFechaLimite = new JTextField();
			txtFechaLimite.setFont(new Font("Arial", Font.PLAIN, 14));
			txtFechaLimite.setColumns(10);
			txtFechaLimite.setBounds(212, 139, 144, 20);
		}
		return txtFechaLimite;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnCancelar.setBounds(10, 227, 102, 23);
		}
		return btnCancelar;
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("Añadir");
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(check()) {
						porcentaje = Integer.parseInt(getTxtPocentaje().getText());
						setVisible(false);
					}
				}
			});
			btnAñadir.setFont(new Font("Arial", Font.PLAIN, 14));
			btnAñadir.setBounds(322, 228, 102, 23);
		}
		return btnAñadir;
	}
	
	private boolean check() {
		if(getTxtPocentaje().getText().isEmpty() || getTxtFechaLimite().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"No puedes dejar ningun campo vacio","Campos vacios",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(getTxtFechaLimite().getText().length() != 10) {
			JOptionPane.showMessageDialog(null,"Formato incorrecto","Error fecha",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		else {
			try {
				dateADevolver = new SimpleDateFormat("yyyy-MM-dd").parse(getTxtFechaLimite().getText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(dateADevolver.after(dateLimit)) {
			JOptionPane.showMessageDialog(null,"La carrera empieza antes de que puedas cancelar","Error fecha",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	public Date getDateADevolver() {
		return dateADevolver;
	}

	public int getPorcentaje() {
		return porcentaje;
	}
	
	
}
