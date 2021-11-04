package xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="option")
//@XmlType(propOrder= {"date","tipo","choice"})
public class Option {

	private String tipo;
	private String choice;
	
	@XmlAttribute
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	@XmlElement(name="choice")
	public void setChoice(String option) {
		this.choice = option;
	}
	
	
	public String getChoice() {
		return choice;
	}

	
	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return choice;
	}
	
}
