package ipsTeamwork;

import gestorDB.GestorDB;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world");

		GestorDB db = new GestorDB();
//		db.crearTablas();
//		db.insertarCarrera();
//		db.deleteCarrera();
		db.carrerasCortas();

	}

}
