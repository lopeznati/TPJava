package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entidades.Consumo;

public class CatalogoConsumos {

	private ArrayList<Consumo> consumos = new ArrayList<Consumo>();

	public CatalogoConsumos()
	{
		 setConsumos();
	}
	public ArrayList<Consumo> getConsumos()
	{
		return consumos;
	}
	public void  setConsumos()
	{
			String sql="select id_consumo, letra, precio from consumos";
			Statement sentencia=null;
			ResultSet rs=null;
			try {			
				sentencia= ConnectionDB.getInstancia().getConn().createStatement();
				rs= sentencia.executeQuery(sql);
				
				while(rs.next()){
					entidades.Consumo c= new entidades.Consumo();
					c.setId(rs.getInt("id_consumo"));
					c.setLetra(rs.getString("letra"));
					c.setPrecio(rs.getInt("precio"));
					
					consumos.add(c);
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