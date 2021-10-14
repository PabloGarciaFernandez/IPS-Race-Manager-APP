package ipsTeamwork.model.carrera;

import java.util.List;

import ipsTeamwork.controller.GestorDB;

public class ListCarreras {

	public String[] execute() {
		String[] ret;

		GestorDB gdb = new GestorDB();
		List<CarreraDto> listDto = gdb.listarCarreras();

		ret = new String[listDto.size()];

		for (int i = 0; i < listDto.size(); i++) {
			ret[i] = (listDto.get(i).toString());
		}

		return ret;
	}
}
