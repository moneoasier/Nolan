package nolan;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to ProductTemplate
	@OneToMany(mappedBy="productCategory")
	private List<Producto> productTemplates;

	public Categoria() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Producto> getProductTemplates() {
		return this.productTemplates;
	}

	public void setProductTemplates(List<Producto> productTemplates) {
		this.productTemplates = productTemplates;
	}

	public Producto addProductTemplate(Producto productTemplate) {
		getProductTemplates().add(productTemplate);
		productTemplate.setProductCategory(this);

		return productTemplate;
	}

	public Producto removeProductTemplate(Producto productTemplate) {
		getProductTemplates().remove(productTemplate);
		productTemplate.setProductCategory(null);

		return productTemplate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return name;
	}
	

}