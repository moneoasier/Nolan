package Conexión;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;

public class ConnectDB {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con;
		Statement st;
		ResultSet rs;
		
		File archivo=new File("productos.txt");
		FileWriter escribir=new FileWriter(archivo);

		String url = "jdbc:postgresql://192.168.65.2:5432/Nolan";
		String user = "admin";
		String password = "Admin123"; // Ingrese aquí su contraseña de inicio de sesión
		Class.forName("org.postgresql.Driver");

		con = DriverManager.getConnection(url, user, password);
		st = con.createStatement();

		rs = st.executeQuery(
				"SELECT * FROM product_product INNER JOIN product_template ON product_product.default_code=product_template.default_code ORDER BY product_product.default_code");

		while (rs.next()) {
			/*System.out.println(rs.getString("default_code") + " " + rs.getString("name") + " "
					+ rs.getString("list_price") + " €");*/
			escribir.write(rs.getString("default_code") + " " + rs.getString("name") + " "
					+ rs.getString("list_price") + " €\n");
			
		}
		System.out.println("Finalizado.");
		escribir.close();
		rs.close();
		st.close();
		con.close();
	}

}
