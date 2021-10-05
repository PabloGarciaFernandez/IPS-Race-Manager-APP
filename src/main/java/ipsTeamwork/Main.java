package ipsTeamwork;


import ipsTeamwork.gui.MainWindow;

public class Main {

	public static void main(String[] args) {
//		GestorDB db = new GestorDB();

//		db.crearTablas();
//		db.insertarAtleta();
//		db.deleteAtleta();
//		db.borrarTablas(false);
//		db.estadoInscripcion("5");

//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
//		} catch (Exception e) {
//			System.out.println("Algo malo paso: " + e.getMessage());
//		}

		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}
