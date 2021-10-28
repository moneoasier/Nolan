package clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

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

	@Column(name="create_date", columnDefinition = "VARCHAR")
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
		return Objects.hash(createDate, defaultCode, id, listPrice, name, productCategory);
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
		return Objects.equals(createDate, other.createDate)
				&& Objects.equals(defaultCode, other.defaultCode) && Objects.equals(id, other.id)
				&& Objects.equals(listPrice, other.listPrice) && Objects.equals(name, other.name)
				&& Objects.equals(productCategory, other.productCategory);
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", createDate=" + createDate + ", listPrice=" + listPrice
				+ ", defaultCode=" + defaultCode + ", name=" + name + ", productCategory=" + productCategory + "]";
	}


	


}