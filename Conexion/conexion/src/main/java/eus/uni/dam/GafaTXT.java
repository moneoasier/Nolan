package eus.uni.dam;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class GafaTXT implements GafaDAO{
	
	String file="src\\main\\resources\\InventarioGafas.csv";
	public List<Gafa> gafas=new ArrayList<>();

	public GafaTXT(String file, List<Gafa> gafas) {
		super();
		this.file = file;
		this.gafas = gafas;
	}

	public GafaTXT() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Gafa> getGafas() {
		// TODO Auto-generated method stub
		return gafas;
	}

	@Override
	public void init() throws IOException, ClassNotFoundException, SQLException {
		Connection con;
		Statement st;
		ResultSet rs;
		
		String url = "jdbc:postgresql://192.168.65.2:5432/Nolan";
		String user = "admin";
		String password = "Admin123"; 
		Class.forName("org.postgresql.Driver");

		con = DriverManager.getConnection(url, user, password);
		st = con.createStatement();

		rs = st.executeQuery(
				"SELECT * FROM product_product INNER JOIN product_template ON product_product.default_code=product_template.default_code ORDER BY product_product.default_code");

		while (rs.next()) {
			/*System.out.println(rs.getString("default_code") + " " + rs.getString("name") + " "
					+ rs.getString("list_price") + " €");*/
			String id=rs.getString("default_code");
			String name=rs.getString("name");
			int precio=rs.getInt("list_price");
			//List<String> tipo;
			//String material=rs.getString("");
			gafas.add(new Gafa(id,name,precio));
		}
		System.out.println("Finalizado.");
		
		rs.close();
		st.close();
		con.close();
		
	}

	@Override
	public Collection<Gafa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Gafa gafa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Gafa gafa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@PreDestroy
	public void destroy() {

		PrintWriter outputStream = null;

		try {
			outputStream = new PrintWriter(new FileWriter(file));

			for (Gafa g : gafas) {
				outputStream.println(g.toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (outputStream != null) {
				outputStream.close();
				System.out.println("Datuak gorde dira " + file +" fitxategian.");
			}
		}
	}

}
