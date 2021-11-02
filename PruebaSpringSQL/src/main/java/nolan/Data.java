package nolan;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="options")
public class Data {

	private List<Option> options;
	private Date date;

	@XmlElement(name="option")
	public List<Option> getOptions() {
		return options;
	}
	
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	public Date getDate() {
		return date;
	}
	
	@XmlAttribute
	public void setDate(Date date) {
		this.date = date;
	}

	public void writeXML(List<Option> options) {
		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Data.class);
		
			Marshaller mar=context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			this.setOptions(options);
			this.setDate(new Date());
			mar.marshal(this, new File("options.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
