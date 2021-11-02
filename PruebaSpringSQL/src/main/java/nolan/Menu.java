package nolan;

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

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String choice = "holi";
		readXML();
		while (!choice.equals("8")) {
			choice = "0";
			menuStart();

			while (!choice.matches("1|2|3|4|5|6|7|8")) {
				System.out.println("Enter your choice:");
				choice = in.next();
			}

			insertChoice(choice);

		}

		System.out.println("EXITING PROGRAM");
		in.close();

	}

	public static void menuStart() {
		System.out.println("**DATA EXPORT PROGRAM**");
		System.out.println("Introduce the numbers of the data you want to export to the server");
		System.out.println("*1-- PRODUCTS");
		System.out.println("*2-- CATEGORIES");
		System.out.println("*3-- EMPLOYEES");
		System.out.println("*4-- USERS");
		System.out.println("*5-- SALES ORDERS");
		System.out.println("*6-- PARTNERS");
		System.out.println("*7-- EXPORT DATA");
		System.out.println("*8-- EXIT");

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

			for (Option op : options) {
				System.out.println(op);
			}

			data.writeXML(options);
			//saveData();
			
						
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
			System.out.println("The option has been added");
		} else {
			System.out.println("The option has already been added");
		}
		return valid;
	}
	
	public static void readXML() {

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Data.class);
		
			Unmarshaller unmar=context.createUnmarshaller();
			
			data=(Data)unmar.unmarshal(new File("options.xml"));
			options=data.getOptions();
			
			for(Option o:options) {
				System.out.println(o);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
