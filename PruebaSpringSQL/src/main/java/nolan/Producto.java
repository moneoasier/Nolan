package nolan;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * The persistent class for the product_template database table.
 * 
 */
@Entity
@Table(name="product_template")
@NamedQuery(name="ProductTemplate.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean active;

	@Column(name="categ_id")
	private Integer categId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="default_code")
	private String defaultCode;

	@Column(name="list_price")
	private BigDecimal listPrice;

	private String name;

	public Producto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getCategId() {
		return this.categId;
	}

	public void setCategId(Integer categId) {
		this.categId = categId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDefaultCode() {
		return this.defaultCode;
	}

	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}

	public BigDecimal getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, categId, createDate, id, listPrice, name);
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
		return Objects.equals(active, other.active) && Objects.equals(categId, other.categId)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(id, other.id) 
				&& Objects.equals(listPrice, other.listPrice) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", active=" + active + ", categId=" + categId + ", createDate=" + createDate
				+ ", listPrice=" + listPrice + ", name=" + name + "]";
	}



}