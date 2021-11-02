package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Menu {

	static List<Option> options= new ArrayList<>();
	static Data data=new Data();
	static File file = new File("options.xml");

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String choice = "holi";
		
		System.out.println("**DATA EXPORT PROGRAM**");
		if(file.isFile()) {
			
			while (!choice.toLowerCase().matches("yes|no")) {
				System.out.println("\nThere is a configuration file saved, do you want to charge it(YES/NO)?");
				choice= in.next();
			}
			
			if(choice.equalsIgnoreCase("yes")) {
				readXML();
			} 
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

	}

	public static void menuStart() {
		String ops="\n";
		if(options.size()>0) {
			for(Option o:options) {
				ops+= o.getChoice()+" | ";
			}
		} else {
			ops="NO OPTIONS SELECTED";
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
		
		Option o=new Option();
		switch (option) {

		case "1":
			if (checkList("PRODUCTS")) {
				o.setChoice("PRODUCTS");
				o.setTipo("Producto");
				options.add(o);
			}

			break;

		case "2":

			if (checkList("CATEGORIES")) {

				o.setChoice("CATEGORIES");
				o.setTipo("Categoria");
				options.add(o);
			}
			break;

		case "3":
			if (checkList("EMPLOYEES")) {
				
				o.setChoice("EMPLOYEES");
				o.setTipo("Employee");
				options.add(o);

			}
			break;

		case "4":
			if (checkList("USERS")) {
				
				o.setChoice("USERS");
				o.setTipo("User");
				options.add(o);
				
			}
			break;

		case "5":
			if (checkList("SALES ORDERS") && checkList("SALES ORDERLINES")) {
				
				o.setChoice("SALES ORDERS");
				o.setTipo("Order");
				options.add(o);
				
				Option o2=new Option();
				
				o2.setChoice("SALES ORDERLINES");
				o2.setTipo("OrderLine");
				options.add(o2);
	
			}
			break;

		case "6":
			if (checkList("PARTNERS")) {
				
				o.setChoice("PARTNERS");
				o.setTipo("Partner");
				options.add(o);

			}
			break;
			
		case "7":
			
			if (checkList("PRODUCTS")) {
				Option o1=new Option();
				o1.setChoice("PRODUCTS");
				o1.setTipo("Producto");
				options.add(o1);
			}
			
			if (checkList("CATEGORIES")) {
				Option o2=new Option();
				o2.setChoice("CATEGORIES");
				o2.setTipo("Categoria");
				options.add(o2);
			}
			
			if (checkList("EMPLOYEES")) {
				Option o3=new Option();
				o3.setChoice("EMPLOYEES");
				o3.setTipo("Employee");
				options.add(o3);
			}
			
			if (checkList("USERS")) {
				Option o4=new Option();
				o4.setChoice("USERS");
				o4.setTipo("User");
				options.add(o4);
			}
			
			if (checkList("SALES ORDERS") && checkList("SALES ORDERLINES")) {
				Option o5=new Option();
				o5.setChoice("SALES ORDERS");
				o5.setTipo("Order");
				options.add(o5);
				
				Option o6=new Option();
				o6.setChoice("SALES ORDERLINES");
				o6.setTipo("OrderLine");
				options.add(o6);
			}
			
			
			if (checkList("PARTNERS")) {
				Option o7=new Option();
				o7.setChoice("PARTNERS");
				o7.setTipo("Partner");
				options.add(o7);
			}           
				
			data.writeXML(options);
			
			break;

		case "8":

			for (Option op : options) {
				System.out.println(op);
			}

			data.writeXML(options);
			//saveData();
			
						
			break;
			
		case "9":
			options.clear();
			System.out.println("OPTIONS REMOVED");
			
			break;

		default:
			break;
		}

	}

	/*
	 * public static void saveData() { try { DocumentBuilderFactory dbFactory =
	 * DocumentBuilderFactory.newInstance(); DocumentBuilder dBuilder =
	 * dbFactory.newDocumentBuilder(); Document doc = dBuilder.newDocument(); //
	 * root element Element rootElement = doc.createElement("data");
	 * doc.appendChild(rootElement);
	 * 
	 * for (int i = 0; i < useroptions.size(); i++) {
	 * 
	 * // options element Element options = doc.createElement("options");
	 * rootElement.appendChild(options);
	 * 
	 * // option element Element option = doc.createElement("option"); Attr attrType
	 * = doc.createAttribute("className"); attrType.setValue(clases.get(i));
	 * option.setAttributeNode(attrType);
	 * option.appendChild(doc.createTextNode(useroptions.get(i)));
	 * options.appendChild(option); }
	 * 
	 * // setting attribute to element // Attr attr =
	 * doc.createAttribute("company"); // attr.setValue("Ferrari"); //
	 * supercar.setAttributeNode(attr); // write the content into xml file
	 * TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 * Transformer transformer = transformerFactory.newTransformer(); DOMSource
	 * source = new DOMSource(doc); StreamResult result = new StreamResult(new
	 * File("data.xml")); transformer.transform(source, result);
	 * 
	 * System.out.println("Data saved correctly"); } catch (Exception e) {
	 * e.printStackTrace(); System.out.println("Data error"); }
	 * 
	 * }
	 */
	

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
				valid=true;
			}
		}
		if(valid) {
			System.out.println(option +" has been added");
		} else {
			System.out.println(option+" has already been added");
		}
		return valid;
	}
	
	public static void readXML() {
		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Data.class);
		
			Unmarshaller unmar=context.createUnmarshaller();
			
			data=(Data)unmar.unmarshal(file);
			options=data.getOptions();
			
			System.out.println("DATA CHARGED");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
