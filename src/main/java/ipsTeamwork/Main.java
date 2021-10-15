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
		
		
		System.out.println("Listado de carreras.");
		System.out.println();
		db.selectCarreras();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("Listado de atletas.");
		System.out.println();
		db.selectAtletas();
		System.out.println();
		System.out.println();
		System.out.println();
//
//		System.out.println("Listado de inscripciones.");
//		System.out.println();
//		db.selectInscripcion();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//
//		
//		System.out.println("Clasificacion general.");
//		System.out.println();
//		db.obtenerClasificacionGeneral();
//		System.out.println();
//		System.out.println();
//
//		System.out.println("Clasificacion general hombres.");
//		System.out.println();
//		db.obtenerClasificacionGeneralHombres();
//		System.out.println();
//		System.out.println();
//
//		System.out.println("Clasificacion general mujeres.");
//		System.out.println();
//		db.obtenerClasificacionGeneralMujeres();
		

		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}