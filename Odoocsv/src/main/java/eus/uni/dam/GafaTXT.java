package eus.uni.dam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

@Repository
public class GafaTXT implements GafaDAO {
	String file = "gafas.csv";

	public List<String> anteriorGafas = new ArrayList<>();
	public List<Gafa> actualGafas = new ArrayList<>();

	@Override
	public Collection<Gafa> getGafas() {
		// TODO Auto-generated method stub
		return actualGafas;
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

		initPreviousList();

		con = DriverManager.getConnection(url, user, password);

		st = con.createStatement();

		rs = st.executeQuery(
				"select product_template.default_code, product_template.name, product_template.list_price, sum(quantity - reserved_quantity), product_category.name as category from stock_quant "
						+ "inner join product_template on product_template.id = stock_quant.product_id "
						+ "inner join product_category on product_category.id = product_template.categ_id "
						+ "where location_id = 8 "
						+ "group by product_template.name, product_template.list_price, product_id, product_template.default_code, product_category.name "
						+ "order by product_template.default_code ");

		while (rs.next()) {
			
			String id = rs.getString("default_code");
			String name = rs.getString("name");
			double precio = rs.getDouble("list_price");
			int stock = rs.getInt("sum");
			String category = rs.getString("category");
			
			if(!erregistroBerria(id)) {
				writeTxt(id);
			}
			actualGafas.add(new Gafa(id, name, precio, stock, category));
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

		PrintWriter gafasRaw = null;
		PrintWriter gafasTarget = null;

		try {
			gafasRaw = new PrintWriter(new FileWriter("..\\NolanApp\\NolanAPK\\app\\src\\main\\res\\raw\\" + file));
			gafasTarget = new PrintWriter(new FileWriter("..\\Odoocsv\\target\\" + file));

			for (Gafa g : actualGafas) {
				gafasRaw.println(g.toString());
				gafasTarget.println(g.getId());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (gafasRaw != null) {
				gafasRaw.close();
				gafasTarget.close();
				System.out.println("Datuak gorde dira " + file + " fitxategian.");
			}
		}

	}

	public void writeTxt(String id) throws IOException {

		FileWriter txt = null;
		LocalDate date=LocalDate.now();
		try {
			File file=new File("..\\Odoocsv\\target\\record.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			txt = new FileWriter(file.getAbsoluteFile(), true);
			txt.append(date.toString()+": "+id+" erregistratu da.\n");
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (txt != null) {
				txt.close();
				System.out.println("Datuak gorde dira record.txt fitxategian.");
			}
		}
	}

	public void initPreviousList() {
		InputStream data;
		try {
			data = new FileInputStream("..\\Odoocsv\\target\\" + file);
			BufferedReader rd = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
			String linea;
			String[] gafa;
			while ((linea = rd.readLine()) != null) {
				anteriorGafas.add(linea);
			}
			rd.close();
			data.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}

	}
	
	public boolean erregistroBerria(String id) {
		
		for(String anteriorGafa:anteriorGafas) {
			if(anteriorGafa.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
