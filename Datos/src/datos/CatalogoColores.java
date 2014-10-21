package datos;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entidades.Color;


public class CatalogoColores {

	private ArrayList<Color> colores = new ArrayList<Color>();
	public CatalogoColores()
	{
		setColores();
	}
	public ArrayList<Color> getColores()
	{
		return colores;
	}
	private void setColores()
	{
		String sql="select id_color, nombre from colores";
		Statement sentencia=null;
		ResultSet rs=null;
		try {			
			sentencia= ConnectionDB.getInstancia().getConn().createStatement();
			rs= sentencia.executeQuery(sql);
			
			while(rs.next()){
				entidades.Color c= new entidades.Color();
				c.setId(rs.getInt("id_color"));
				c.setNombreColor(rs.getString("nombre"));
				
				colores.add(c);
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){rs.close();}
				if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
				ConnectionDB.getInstancia().CloseConn();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
		
	}
}
