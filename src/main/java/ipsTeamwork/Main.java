package ipsTeamwork;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ipsTeamwork.gui.MainWindow;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		GestorDB db = new GestorDB();
//		db.borrarTablas(true);
//		db.crearTablas();
//		db.insertarCarrera();
//		db.deleteCarrera();
//		db.borrarTablas(true);
//		db.estadoInscripcion("ACR");
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}
