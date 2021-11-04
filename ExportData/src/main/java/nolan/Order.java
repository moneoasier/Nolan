package nolan;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * The persistent class for the sale_order database table.
 * 
 */
@Entity
@Table(name="sale_order")
//@NamedQuery(name="SaleOrder.findAll", query="SELECT s FROM SaleOrder s")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="amount_tax")
	private BigDecimal amountTax;

	@Column(name="amount_total")
	private BigDecimal amountTotal;

	@Column(name="date_order",columnDefinition = "VARCHAR")
	private Timestamp dateOrder;

	private String name;

	@Column(name="procurement_group_id")
	private Integer procurementGroupId;

	private String state;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="partner_id")
	private Partner resPartner;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="create_uid")
	private User resUser;

	public Order() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmountTax() {
		return amountTax;
	}

	public void setAmountTax(BigDecimal amountTax) {
		this.amountTax = amountTax;
	}

	public BigDecimal getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(BigDecimal amountTotal) {
		this.amountTotal = amountTotal;
	}

	public Timestamp getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProcurementGroupId() {
		return procurementGroupId;
	}

	public void setProcurementGroupId(Integer procurementGroupId) {
		this.procurementGroupId = procurementGroupId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Partner getResPartner1() {
		return resPartner;
	}

	public void setResPartner1(Partner resPartner1) {
		this.resPartner = resPartner1;
	}

	public User getResUser1() {
		return resUser;
	}

	public void setResUser1(User resUser1) {
		this.resUser = resUser1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountTax, amountTotal, dateOrder, id, name, procurementGroupId, resPartner, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(amountTax, other.amountTax) && Objects.equals(amountTotal, other.amountTotal)
				&& Objects.equals(dateOrder, other.dateOrder) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(procurementGroupId, other.procurementGroupId)
				&& Objects.equals(resPartner, other.resPartner) 
				&& Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amountTax=" + amountTax + ", amountTotal=" + amountTotal + ", dateOrder="
				+ dateOrder + ", name=" + name + ", procurementGroupId=" + procurementGroupId + ", state=" + state
				+ ", resPartner1=" + resPartner + "]";
	}
	
}
