package ipsTeamwork;


import javax.swing.UIManager;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (Exception e) {
			System.out.println("Algo malo paso: " + e.getMessage());
		}
		
		
		GestorDB db = new GestorDB();
		
		db.borrarTablas();
		db.crearTablas();
		db.poblarTablas();
		
		db.insertarAtleta();
		db.insertarCarrera();
		db.insertarInscripcion();
		db.insertarAtleta1();
		db.insertarInscripcion1();
		
		System.out.println("Listado de carreras.");
		System.out.println();
		db.selectCarrera();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("Listado de atletas.");
		System.out.println();
		db.selectAtletas();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("Listado de inscripciones.");
		System.out.println();
		db.selectInscripcion();
		System.out.println();
		System.out.println();
		System.out.println();

		
		System.out.println("Clasificación general.");
		System.out.println();
		db.obtenerClasificacionGeneral();
		System.out.println();
		System.out.println();

		System.out.println("Clasificación general hombres.");
		System.out.println();
		db.obtenerClasificacionGeneralHombres();
		System.out.println();
		System.out.println();

		System.out.println("Clasificación general mujeres.");
		System.out.println();
		db.obtenerClasificacionGeneralMujeres();
		

		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}
