package datos;

import java.sql.ResultSet;



import java.sql.SQLException;

import connection.ConnectionDB;
import entidades.Color;


public class CatalogoColores {

	public CatalogoColores()
	{
	}
	public static String getNombreColor(int id)
	{
		String sql="select nombre from colores where id_color=?";
		java.sql.PreparedStatement sentencia=null;
		ResultSet rs=null;
		String nombre = null;
		try {			
			sentencia= ConnectionDB.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, id);
			rs= sentencia.executeQuery();
			if(rs.next()){
			nombre = rs.getString("nombre");}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
		
	}
	public Color ComprobarColor(String nombre)
	{
		String sql="select id_color from colores where nombre=?";
		java.sql.PreparedStatement sentencia=null;
		ResultSet rs=null;
		Color c = new Color();
		try {			
			sentencia= ConnectionDB.getInstancia().getConn().prepareStatement(sql);
			sentencia.setString(1, nombre);
			rs= sentencia.executeQuery();
			if(rs.next()){
			c.setId(rs.getInt("id_color"));}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
}
