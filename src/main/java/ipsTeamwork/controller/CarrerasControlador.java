/**
 * 
 */
package ipsTeamwork.controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.view.MainWindow;

/**
 * @author Sergio Arroni Clase que aplica la logia de las carreras
 */
public class CarrerasControlador {

	public void VerCarreras() {

		MainWindow mn = new MainWindow();
		DefaultTableModel tb = (DefaultTableModel) mn.getTbVerCarreras().getModel();

		GestorDB db = new GestorDB();

		ArrayList<CarreraDto> carreras = db.selectCarrera();

		for (CarreraDto carreraDto : carreras) {

			String[] carrerasTabla = { carreraDto.getId(), carreraDto.getTipo(),
					String.valueOf(carreraDto.getPlazasDisp()) };

//			tb.addRow(carrerasTabla);

			System.out.println(carreraDto.toString());

		}

	}

}
