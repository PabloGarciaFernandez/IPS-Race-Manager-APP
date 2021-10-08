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
		
		db.selectCarrera();

		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}
