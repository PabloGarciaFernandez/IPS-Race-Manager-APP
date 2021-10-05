package ipsTeamwork;

import javax.swing.UnsupportedLookAndFeelException;

import gestorDB.GestorDB;
import ipsTeamwork.gui.MainWindow;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		GestorDB db = new GestorDB();
		System.out.println("borrando tablas antiguas");
		db.borrarTablas();
		
		System.out.println("\ncreando nuevas tablas");
		db.crearTablas();
		
		System.out.println("\npoblando tablas");
		db.poblarTablas();
		
		System.out.println("\n\n");
		db.selectCarreras();
		
		
		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}
