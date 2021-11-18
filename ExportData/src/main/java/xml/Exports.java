package xml;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="log")
public class Exports {
	private List<Export> exports;
	
	
	@XmlElementWrapper(name = "exports")
	@XmlElement(name="export")
	public List<Export> getExports() {
		return exports;
	}

	public void setExports(List<Export> exports) {
		this.exports = exports;
	}
	
	/*
	 * Lista bat hartzen du, eta barruan dituen datuak xml-an idazten ditu marshal bitartez
	 */

	public void writelogXML(List<Export> newExports) {
		
		JAXBContext context;
		File file = new File("log.xml");

		try {
			context = JAXBContext.newInstance(Exports.class);
			Marshaller mar=context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			this.setExports(newExports);
			for(Export e:newExports) {
				e.setDate(new Date());
			}
			
			mar.marshal(this,file);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}


