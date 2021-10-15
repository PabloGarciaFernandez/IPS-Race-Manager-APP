/**
 * 
 */
package ipsTeamwork.model.categoria;

import javax.management.RuntimeErrorException;

/**
 * @author Sergio Arroni
 *
 */
public class Categoria {

	public static String calculaCategoria(int edad, String sexo) {
		if (edad >= 18 && edad <= 20) {
			return "18-20/" + sexo;
		} else if (edad > 20 && edad <= 30) {
			return "21-30/" + sexo;
		} else if (edad > 30 && edad <= 40) {
			return "31-40/" + sexo;
		} else if (edad > 40 && edad <= 50) {
			return "41-50/" + sexo;
		} else if (edad > 50 && edad <= 60) {
			return "51-60/" + sexo;
		} else if (edad > 50 && edad <= 70) {
			return "61-70/" + sexo;
		} else if (edad > 70 && edad <= 80) {
			return "71-80/" + sexo;
		} else if (edad > 80 && edad <= 90) {
			return "81-90/" + sexo;
		} else if (edad > 90 && edad <= 100) {
			return "91-100/" + sexo;
		} else if (edad > 100) {
			return ">100/" + sexo;
		}
		throw new RuntimeErrorException(new Error(), "Algo malo paso con la categoria");
	}

}
