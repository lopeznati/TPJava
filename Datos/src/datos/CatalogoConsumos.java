package datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionDB;
import entidades.Consumo;

public class CatalogoConsumos {

	public CatalogoConsumos()
	{
	}
	public static String getConsumo(int id)
	{
		String sql="select letra from consumos where id_consumo=?";
		java.sql.PreparedStatement sentencia=null;
		ResultSet rs=null;
		String nombre = null;
		try {			
			sentencia= ConnectionDB.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, id);
			rs= sentencia.executeQuery();
			if(rs.next()){
			nombre = rs.getString("letra");}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
		
	}
	public Consumo ComprobarConsumo(String nombre)
	{
		String sql="select id_consumo from consumos where letra=?";
		java.sql.PreparedStatement sentencia=null;
		ResultSet rs=null;
		Consumo c = new Consumo();
		try {			
			sentencia= ConnectionDB.getInstancia().getConn().prepareStatement(sql);
			sentencia.setString(1, nombre);
			rs= sentencia.executeQuery();
			if(rs.next()){
			c.setId(rs.getInt("id_consumo"));}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
		
}