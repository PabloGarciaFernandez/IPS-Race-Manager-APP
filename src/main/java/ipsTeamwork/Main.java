package ipsTeamwork;


import java.sql.SQLException;

import javax.swing.UIManager;

import gestorDB.GestorDB;
import ipsTeamwork.gui.MainWindow;

public class Main {

	public static void main(String[] args) {
//		GestorDB db = new GestorDB();

//		db.crearTablas();
//		db.insertarAtleta();
//		db.deleteAtleta();
//		db.borrarTablas(false);
//		db.estadoInscripcion("5");


//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
//		} catch (Exception e) {
//			System.out.println("Algo malo paso: " + e.getMessage());
//		}
		
		
		GestorDB db = new GestorDB();
		
		db.borrarTablas();
		db.crearTablas();
		db.poblarTablas();
		
		db.selectCarrera();

//		MainWindow mw = new MainWindow();
//		mw.setVisible(true);
	}

}
