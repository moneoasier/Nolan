package nolan;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Menu {

	static ArrayList<String> useroptions = new ArrayList<>();
	static ArrayList<String> clases = new ArrayList<>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String choice = "holi";

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

		switch (option) {

		case "1":
			if (checkList("PRODUCTS")) {
				useroptions.add("PRODUCTS");
				clases.add("Producto");
			}

			break;

		case "2":

			if (checkList("CATEGORIES")) {
				useroptions.add("CATEGORIES");
				clases.add("Categoria");
			}
			break;

		case "3":
			if (checkList("EMPLOYEES")) {
				useroptions.add("EMPLOYEES");
				clases.add("Employee");
			}
			break;

		case "4":
			if (checkList("USERS")) {
				useroptions.add("USERS");
				clases.add("User");
			}
			break;

		case "5":
			if (checkList("SALES ORDERS|SALES ORDERLINES")) {
				useroptions.add("SALES ORDERS");
				clases.add("Order");
				useroptions.add("SALES ORDERLINES");
				clases.add("OrderLine");
			}
			break;

		case "6":
			if (checkList("PARTNERS")) {
				useroptions.add("PARTNERS");
				clases.add("Partner");
			}
			break;

		case "7":

			for (String o : useroptions) {
				System.out.println(o);
			}

			for (String c : clases) {
				System.out.println(c);
			}

			saveData();

			break;

		default:
			break;
		}

	}

	public static void saveData() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// root element
			Element rootElement = doc.createElement("data");
			doc.appendChild(rootElement);

			for (int i = 0; i < useroptions.size(); i++) {

				// options element
				Element options = doc.createElement("options");
				rootElement.appendChild(options);

				// option element
				Element option = doc.createElement("option");
				Attr attrType = doc.createAttribute("className");
				attrType.setValue(clases.get(i));
				option.setAttributeNode(attrType);
				option.appendChild(doc.createTextNode(useroptions.get(i)));
				options.appendChild(option);
			}

			// setting attribute to element
			// Attr attr = doc.createAttribute("company");
			// attr.setValue("Ferrari");
			// supercar.setAttributeNode(attr);
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("data.xml"));
			transformer.transform(source, result);

			System.out.println("Data saved correctly");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Data error");
		}

	}

	public static boolean checkList(String option) {

		boolean valid = false;
		if (useroptions.size() < 1) {
			
			valid = true;
		} else {
			for (String u : useroptions) {
				if (u.toString().equals(option)) {
					valid = true;
					break;
				}
			}
		}
		if(valid) {
			System.out.println("The option has been added");
		} else {
			System.out.println("The option has already been added");
		}
		return valid;
	}
}
