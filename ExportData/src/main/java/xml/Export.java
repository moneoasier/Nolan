package xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="export")
public class Export {
	private String name;
	private Date date;
	
	@XmlElement(name="name")
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Export getExport() {
		return this;
	}
	
	@XmlAttribute
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
