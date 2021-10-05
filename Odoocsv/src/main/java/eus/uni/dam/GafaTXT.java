package eus.uni.dam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class GafaTXT implements GafaDAO{
	String file="gafas.csv";

	
	public List<Gafa> gafas=new ArrayList<>();

	@Override
	public Collection<Gafa> getGafas() {
		// TODO Auto-generated method stub
		return gafas;
	}

	@PostConstruct
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
				"select product_template.default_code, product_template.name, product_template.list_price, sum(quantity - reserved_quantity) from stock_quant\r\n"
				+ "inner join product_template on product_template.id = stock_quant.product_id \r\n"
				+ "where location_id = 8\r\n"
				+ "group by product_template.name, product_template.list_price, product_id, product_template.default_code\r\n"
				+ "order by product_template.default_code;");

		while (rs.next()) {

			String id=rs.getString("default_code");
			String name=rs.getString("name");
			double precio=rs.getDouble("list_price");
			int stock=rs.getInt("sum");
			//List<String> tipo;
			//String material=rs.getString("");
			gafas.add(new Gafa(id,name,precio,stock));
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
			outputStream = new PrintWriter(new FileWriter("..\\NolanApp\\NolanAPK\\app\\src\\main\\res\\raw\\" +file));

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
