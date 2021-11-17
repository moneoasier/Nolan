package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ExportConfig;
import config.ImportConfig;
import nolan.AppUser;
import nolan.Categoria;
import nolan.Employee;
import nolan.ManagementDAO;
import nolan.Order;
import nolan.OrderLine;
import nolan.Partner;
import nolan.Producto;
import nolan.User;

@SpringBootApplication
public class Menu {

	static List<Option> options = new ArrayList<>();
	static List<Export> exports = new ArrayList<>();
	static Data data = new Data();
	static Exports ex= new Exports();
	static File file = new File("options.xml");
	static File fileLog=new File("log.xml");
	static List<Producto> products;
	static List<Categoria> categories;
	static List<Partner> partners;
	static List<User> users;
	static List<Employee> employees;
	static List<Order> orders;
	static List<OrderLine> orderlines;
	static List<AppUser> appUsers;
	static ApplicationContext exportContext = new AnnotationConfigApplicationContext(ExportConfig.class);
	static ManagementDAO dout = exportContext.getBean(ManagementDAO.class);
	static ApplicationContext importContext = new AnnotationConfigApplicationContext(ImportConfig.class);
	static ManagementDAO dao = importContext.getBean(ManagementDAO.class);

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String choice = "holi";

		System.out.println("**DATA EXPORT PROGRAM**");
		if (file.isFile()) {

			while (!choice.toLowerCase().matches("yes|no")) {
				System.out.println("\nThere is a configuration file saved, do you want to charge it(YES/NO)?");
				choice = in.next();
			}

			if (choice.equalsIgnoreCase("yes")) {
				readXML();
			}
		}
		
		if(fileLog.isFile()) {
			readLog();
		}

		while (!choice.equals("10")) {
			choice = "0";
			menuStart();

			while (!choice.matches("1|2|3|4|5|6|7|8|9|10")) {
				System.out.println("Enter your choice:");
				choice = in.next();
			}

			insertChoice(choice);

		}

		System.out.println("EXITING PROGRAM");
		in.close();
		((AnnotationConfigApplicationContext) exportContext).close();
		((AnnotationConfigApplicationContext) importContext).close();
		System.out.println("BYE");
	}

	public static void menuStart() {
		String ops = "\n| ";
		if (options.size() > 0) {
			for (Option o : options) {
				ops += o.getChoice() + " | ";
			}
		} else {
			ops = "NO OPTIONS SELECTED";
		}
		System.out.println(ops);
		System.out.println();
		System.out.println("Introduce the numbers of the data you want to export to the server");
		System.out.println();
		System.out.println("*1-- PRODUCTS");
		System.out.println("*2-- CATEGORIES");
		System.out.println("*3-- EMPLOYEES");
		System.out.println("*4-- USERS");
		System.out.println("*5-- SALES ORDERS");
		System.out.println("*6-- PARTNERS");
		System.out.println("*7-- EXPORT ALL DATA");
		System.out.println("*8-- EXPORT DATA");
		System.out.println("*9-- REMOVE OPTIONS");
		System.out.println("*10-- EXIT");
		System.out.println();
	}

	public static void insertChoice(String option) {

		Option o = new Option();
		Export e= new Export();
		switch (option) {

		case "1":
			if (checkList("PRODUCTS")) {
				o.setChoice("PRODUCTS");
				o.setTipo("Producto");
				options.add(o);
				
				e.setName("PRODUCTS");
				exports.add(e);
			}

			break;

		case "2":

			if (checkList("CATEGORIES")) {

				o.setChoice("CATEGORIES");
				o.setTipo("Categoria");
				options.add(o);
				
				e.setName("CATEGORIES");
				exports.add(e);
			}
			break;

		case "3":
			if (checkList("EMPLOYEES")) {

				o.setChoice("EMPLOYEES");
				o.setTipo("Employee");
				options.add(o);
				
				e.setName("EMPLOYEES");
				exports.add(e);
			}
			break;

		case "4":
			if (checkList("USERS")) {

				o.setChoice("USERS");
				o.setTipo("User");
				options.add(o);
				
				e.setName("USERS");
				exports.add(e);

			}
			break;

		case "5":
			if (checkList("SALES ORDERS") && checkList("SALES ORDERLINES")) {

				o.setChoice("SALES ORDERS");
				o.setTipo("Order");
				options.add(o);

				Option o2 = new Option();

				o2.setChoice("SALES ORDERLINES");
				o2.setTipo("OrderLine");
				options.add(o2);
				
				e.setName("SALES");
				exports.add(e);

			}
			break;

		case "6":
			if (checkList("PARTNERS")) {

				o.setChoice("PARTNERS");
				o.setTipo("Partner");
				options.add(o);
				
				e.setName("PARTNERS");
				exports.add(e);

			}
			break;

		case "7":

			if (checkList("PRODUCTS")) {
				Option o1 = new Option();
				o1.setChoice("PRODUCTS");
				o1.setTipo("Producto");
				options.add(o1);
				
				Export e1 = new Export();
				e1.setName("PRODUCTS");
				exports.add(e1);
			}

			if (checkList("CATEGORIES")) {
				Option o2 = new Option();
				o2.setChoice("CATEGORIES");
				o2.setTipo("Categoria");
				options.add(o2);
				
				Export e2 = new Export();
				e2.setName("CATEGORIES");
				exports.add(e2);
			}

			if (checkList("EMPLOYEES")) {
				Option o3 = new Option();
				o3.setChoice("EMPLOYEES");
				o3.setTipo("Employee");
				options.add(o3);
				
				Export e3 = new Export();
				e3.setName("EMPLOYEES");
				exports.add(e3);
			}

			if (checkList("USERS")) {
				Option o4 = new Option();
				o4.setChoice("USERS");
				o4.setTipo("User");
				options.add(o4);
				
				Export e4 = new Export();
				e4.setName("USERS");
				exports.add(e4);
			}

			if (checkList("SALES ORDERS") && checkList("SALES ORDERLINES")) {
				Option o5 = new Option();
				o5.setChoice("SALES ORDERS");
				o5.setTipo("Order");
				options.add(o5);

				Option o6 = new Option();
				o6.setChoice("SALES ORDERLINES");
				o6.setTipo("OrderLine");
				options.add(o6);
				
				Export e5 = new Export();
				e5.setName("SALES");
				exports.add(e5);
			}

			if (checkList("PARTNERS")) {
				Option o7 = new Option();
				o7.setChoice("PARTNERS");
				o7.setTipo("Partner");
				options.add(o7);
				
				Export e6 = new Export();
				e6.setName("PARTNERS");
				exports.add(e6);
			}

			data.writeXML(options);
			ex.writelogXML(exports);
			readAll();
			insertAll();
			if(fileLog.isFile()) {
				readLog();
			}
			System.out.println("ALL DATA HAS BEEN UPDATED IN SQL SERVER");

			break;

		case "8":
			if (options.size() > 0) {
				readDataSelected();
				insertDataSelected();
				data.writeXML(options);
				ex.writelogXML(exports);
				if(fileLog.isFile()) {
					readLog();
				}
			} else {
				System.out.println("There are no export options selected");
			}

			break;

		case "9":
			if (options.size() > 0) {
				options.clear();
				System.out.println("OPTIONS REMOVED");
			} else {
				System.out.println("There are no export options selected");
			}
			break;

		default:
			break;
		}

	}

	public static boolean checkList(String option) {

		boolean valid = false;
		if (options.size() < 1) {

			valid = true;
		} else {
			for (Option u : options) {
				if (u.getChoice().equals(option)) {
					valid = false;
					break;
				}
				valid = true;
			}
		}
		if (valid) {
			System.out.println(option + " has been added");
		} else {
			System.out.println(option + " has already been added");
		}
		return valid;
	}

	public static void readXML() {

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Data.class);

			Unmarshaller unmar = context.createUnmarshaller();

			data = (Data) unmar.unmarshal(file);
			options = data.getOptions();

			for(Option o: options) {
				Export e= new Export();
				e.setName(o.getChoice());
				exports.add(e);
				
			}
			System.out.println("DATA CHARGED");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readLog() {
		
		JAXBContext context;
		File f=new File("log.xml");
		exports.clear();
		try {
			context = JAXBContext.newInstance(Exports.class);
			Unmarshaller unmar = context.createUnmarshaller();
			ex= (Exports) unmar.unmarshal(f);
			
			exports=ex.getExports();	
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readDataSelected() {
		
		if (!checkList("CATEGORIES")) {
			categories = dao.getCategories();
		}
		
		if (!checkList("PRODUCTS")) {
			products = dao.getProducts();
		}

		if (!checkList("EMPLOYEES")) {
			employees = dao.getEmployees();
		}

		if (!checkList("USERS")) {
			users = dao.getUsers();
			appUsers=dao.getAppUsers();
		}
		
		if (!checkList("PARTNERS")) {
			partners = dao.getPartners();
		}

		if (!checkList("SALES ORDERS") && !checkList("SALES ORDERLINES")) {
			orders = dao.getOrders();
			orderlines = dao.getOrderlines();
		}


	}

	public static void readAll() {

		products = dao.getProducts();
		categories = dao.getCategories();
		partners = dao.getPartners();
		users = dao.getUsers();
		appUsers=dao.getAppUsers();
		employees = dao.getEmployees();
		orders = dao.getOrders();
		orderlines = dao.getOrderlines();

	}

	public static void insertDataSelected() {

		if (!checkList("PRODUCTS")) {
			for (Producto p : products) {
				dout.update(p);
				
			}
		}

		if (!checkList("CATEGORIES")) {
			for (Categoria c : categories) {
				dout.update(c);
			}
		}

		if (!checkList("EMPLOYEES")) {
			for (Employee e : employees) {
				dout.update(e);
			}
		}

		if (!checkList("USERS")) {
			for (User u : users) {
				dout.update(u);
			}
			
			for(AppUser au:appUsers) {
				dout.update(au);
			}
		}

		if (!checkList("SALES ORDERS") && !checkList("SALES ORDERLINES")) {
			for (Order o : orders) {
				dout.update(o);
			}
			for (OrderLine ol : orderlines) {
				dout.update(ol);
			}
		}

		if (!checkList("PARTNERS")) {
			for (Partner p : partners) {
				dout.update(p);
			}
		}

		System.out.println("THE DATA HAS BEEN UPDATED IN SQL SERVER");

	}

	public static void insertAll() {

		for (Categoria c : categories) {
			dout.update(c);
		}
		
		for (Producto p : products) {
			dout.update(p);
		}
		
		for (Partner p : partners) {
			dout.update(p);
		}
		
		for (User u : users) {
			dout.update(u);
		}
		
		for (AppUser au:appUsers) {
			dout.update(au);
		}
		
		for (Employee e : employees) {
			dout.update(e);
		}
		
		for (Order o : orders) {
			dout.update(o);
		}
		
		for (OrderLine ol : orderlines) {
			dout.update(ol);
		}

	}
	
}
