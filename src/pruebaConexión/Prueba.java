package pruebaConexión;

import java.sql.*;

public class Prueba {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con;
		Statement st;
		ResultSet rs;
		
		String url="jdbc:postgresql://localhost:5432/db_laura";
		String user="pepe";
		String password = "pepe"; // Ingrese aquí su contraseña de inicio de sesión
		Class.forName("org.postgresql.Driver");
 
 
		
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
		
		rs=st.executeQuery("SELECT 1 AS col_1");
		
		rs.next();
		System.out.println(rs.getInt("col_1"));
		
		rs.close();
		st.close();
		con.close();
	}
 
}
