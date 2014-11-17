package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entidades.Color;
import entidades.Consumo;
import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

public class CatalogoElectrodomesticos {

	private ArrayList<Electrodomestico> electrodomesticos;
	public CatalogoElectrodomesticos()
	{
		actualizarLista();
	}
	private void actualizarLista()
	{
		electrodomesticos= new ArrayList<Electrodomestico>();
		
		String sql="select id_electrodomesticos,tipo,id_color,id_consumo,"
				+ "peso,carga,precio,sintonizador,resolucion from electrodomesticos";
		Statement sentencia=null;
		ResultSet rs=null;
		
		
		try {			
			sentencia= ConnectionDB.getInstancia().getConn().createStatement();
			rs= sentencia.executeQuery(sql);
			
			while(rs.next()){
				double a = rs.getDouble("carga");
				Color _color = new Color();
				Consumo consumo=new Consumo();
				_color.setId(rs.getInt("id_color"));
				_color.setNombreColor(CatalogoColores.getNombreColor(_color.getId()));
			    consumo.setId(rs.getInt("id_consumo"));
			    consumo.setLetra(CatalogoConsumos.getConsumo(consumo.getId()));
				if(a>0)
				{	
					Lavarropas l = new Lavarropas(rs.getDouble("precio"), rs.getInt("peso"), 
							_color, consumo, rs.getDouble("carga"));
					l.setIndice(rs.getInt("id_electrodomesticos"));
					electrodomesticos.add(l);
				}
				else
				{
					Television t = new Television(rs.getDouble("precio"), rs.getInt("peso"), 
							_color, consumo, rs.getInt("resolucion"), rs.getBoolean("sintonizador"));
					t.setIndice(rs.getInt("id_electrodomesticos"));
					electrodomesticos.add(t);
				}
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
		actualizarLista();
	}
	public void remover(int id_electrodomestico)
	{
		String sql="delete from electrodomesticos where id_electrodomesticos=?";
		PreparedStatement sentencia=null;
		Connection conn=ConnectionDB.getInstancia().getConn();
		
		try {
			sentencia=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			sentencia.setInt(1, id_electrodomestico);
			ResultSet cps= sentencia.getGeneratedKeys();
			cps.next();
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
		actualizarLista();
	}
	public ArrayList<Electrodomestico> getElectrodomesticos()
	{
		
		return electrodomesticos;
	}
}

