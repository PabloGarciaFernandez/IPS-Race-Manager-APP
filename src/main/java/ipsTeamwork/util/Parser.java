package ipsTeamwork.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ipsTeamwork.model.pago.Pago;

public class Parser {
	public static List<Pago> parsePaymentFile(File f, boolean debug) throws FileNotFoundException {
		List<Pago> ret = new ArrayList<Pago>();
		Scanner s = new Scanner(f);
		
		while(s.hasNextLine()) {
			String line = s.nextLine();
			
			if (line.charAt(0) == '#' || line.trim().strip().length() == 0) continue; //comments y strings vacias
			String[] tokens = line.split(" ");
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Pago p = new Pago(format.parse(tokens[0]), Double.parseDouble(tokens[1]), tokens[2]);
				ret.add(p);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}
		
		for (Iterator<Pago> iterator = ret.iterator(); iterator.hasNext();) {
			Pago pago = iterator.next();
			if (debug) System.out.println(pago.toString());
		}
		
		s.close();
		
		return ret;
	}
}
