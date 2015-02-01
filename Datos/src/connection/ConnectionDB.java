package connection;

import java.sql.*;

public class ConnectionDB {

	private static ConnectionDB instancia;
	public static ConnectionDB getInstancia(){
		if(instancia==null){
			instancia=new ConnectionDB();
		}
		return instancia;
	}
	
	private static String dbUrl="jdbc:mysql://localhost:3306/ElectrodomesticosDB";
	private static String dbUser="root";
	private static String dbPassword="1234";
	
	
	private ConnectionDB(){}
	
	private Connection conn;
	
	public Connection getConn(){
		try {
			if(conn==null || !conn.isValid(3)){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);	
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public void CloseConn(){
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
