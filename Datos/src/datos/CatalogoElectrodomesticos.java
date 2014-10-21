package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

public class CatalogoElectrodomesticos {

	private ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
	
	public void nuevoElectrodomestico(Electrodomestico e)
	{
		String sql="insert into electrodomesticos(tipo,id_color,id_consumo,"
				+ "peso,carga,precio,sintonizador,resolucion) values (?,?,?,?,?,?,?,?)";
		PreparedStatement sentencia=null;
		Connection conn=ConnectionDB.getInstancia().getConn();
		
		try {
			sentencia=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, e.getDesc());
			sentencia.setInt(2, e.getColor().getId());
			sentencia.setInt(3, e.getConsumo().getId());
			sentencia.setDouble(4, e.getPeso());
			if(e.getDesc()=="Lavarropas"){
				Lavarropas l = (Lavarropas) e;
				sentencia.setDouble(5, l.getCarga());
			}else
				sentencia.setDouble(5, 0);
			sentencia.setDouble(6, e.getPreciobase());
			if(e.getDesc()=="Television"){
				Television s = (Television) e;
				sentencia.setBoolean(7,s.isSintonizador());
				sentencia.setInt(8, s.getResolucion());
			}else
			{
				sentencia.setBoolean(7,false);
				sentencia.setInt(8,0);
			}
			ResultSet cps= sentencia.getGeneratedKeys();
			if(cps.next()){
				int id=cps.getInt(1);
				e.setIndice(id);
			}
			sentencia.executeUpdate();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally{
			try{
				if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
				ConnectionDB.getInstancia().CloseConn();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
	}
	public ArrayList<Electrodomestico> getElectrodomesticos()
	{
		return electrodomesticos;
	}
}

