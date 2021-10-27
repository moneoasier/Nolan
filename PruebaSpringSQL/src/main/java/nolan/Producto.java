package nolan;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * The persistent class for the product_template database table.
 * 
 */
@Entity
@Table(name="product_template")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean active;

	@Column(name="create_date")
	private Timestamp createDate;
	
	@Column(name="list_price")
	private BigDecimal listPrice;

	@Column(name="default_code")
	private String defaultCode;

	private String name;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name="categ_id")
	private Categoria productCategory;

	public Producto() {
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}


	public String getDefaultCode() {
		return defaultCode;
	}


	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Categoria getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(Categoria productCategory) {
		this.productCategory = productCategory;
	}


	public BigDecimal getListPrice() {
		return listPrice;
	}


	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}


	@Override
	public int hashCode() {
		return Objects.hash(active, createDate, listPrice, defaultCode, id, name, productCategory);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(active, other.active) && Objects.equals(createDate, other.createDate)
				&& Objects.equals(defaultCode, other.defaultCode) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(productCategory, other.productCategory)
				&& Objects.equals(listPrice, other.listPrice);
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", active=" + active + ", listPrice= " + listPrice+", createDate=" + createDate + ", defaultCode="
				+ defaultCode + ", name=" + name + ", productCategory=" + productCategory + "]";
	}


}