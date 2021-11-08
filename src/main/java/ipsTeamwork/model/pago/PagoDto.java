package ipsTeamwork.model.pago;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import ipsTeamwork.controller.GestorDB;

public class PagoDto {
	private String INSERT = "insert into pago(idPago, idCarrera, dniAtleta, fecha, importe) values (?, ?, ?, ?, ?)";
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format( date );
		return "Pago [" + dateString + ", importe=" + importe + ", DNI " + dni + "]";
	}

	public String id;
	public Date date;
	public double importe;
	public String dni;
	public String idCarrera;
	
	public PagoDto(Date d, double importe, String dni) {
		this.id = UUID.randomUUID().toString();
		this.date = d;
		this.importe = importe;
		this.dni = dni;
	}
	
	public PagoDto() {}

	public void setIdCarrera(String id) {
		this.idCarrera = id;
	}
	
	public void autoInsert() {
		if (idCarrera == null) throw new RuntimeException("idCarrera not set");
		
		try {
			GestorDB gdb = new GestorDB();
			PreparedStatement pst = gdb.getConnection().prepareStatement(INSERT);
			
			pst.setString(1, id);
			pst.setString(2, idCarrera);
			pst.setString(3, dni);
			pst.setDate(4, new java.sql.Date(date.getTime()));
			pst.setDouble(5, importe);
			
			pst.executeUpdate();
			
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
