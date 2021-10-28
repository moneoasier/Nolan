package clases;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the sale_order database table.
 * 
 */
@Entity
@Table(name="sale_order")
@NamedQuery(name="SaleOrder.findAll", query="SELECT s FROM SaleOrder s")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="amount_tax")
	private BigDecimal amountTax;

	@Column(name="amount_total")
	private BigDecimal amountTotal;

	@Column(name="date_order")
	private Timestamp dateOrder;

	private String name;

	@Column(name="procurement_group_id")
	private Integer procurementGroupId;

	private String state;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="partner_id")
	private Partner resPartner1;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="partner_invoice_id")
	private Partner resPartner2;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="partner_shipping_id")
	private Partner resPartner3;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="create_uid")
	private User resUser1;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private User resUser2;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="write_uid")
	private User resUser3;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="saleOrder")
	private List<OrderLine> saleOrderLines;

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
		return resPartner1;
	}

	public void setResPartner1(Partner resPartner1) {
		this.resPartner1 = resPartner1;
	}

	public Partner getResPartner2() {
		return resPartner2;
	}

	public void setResPartner2(Partner resPartner2) {
		this.resPartner2 = resPartner2;
	}

	public Partner getResPartner3() {
		return resPartner3;
	}

	public void setResPartner3(Partner resPartner3) {
		this.resPartner3 = resPartner3;
	}

	public User getResUser1() {
		return resUser1;
	}

	public void setResUser1(User resUser1) {
		this.resUser1 = resUser1;
	}

	public User getResUser2() {
		return resUser2;
	}

	public void setResUser2(User resUser2) {
		this.resUser2 = resUser2;
	}

	public User getResUser3() {
		return resUser3;
	}

	public void setResUser3(User resUser3) {
		this.resUser3 = resUser3;
	}

	public List<OrderLine> getSaleOrderLines() {
		return saleOrderLines;
	}

	public void setSaleOrderLines(List<OrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountTax, amountTotal, dateOrder, id, name, procurementGroupId, resPartner1, resPartner2,
				resPartner3, resUser1, resUser2, resUser3, saleOrderLines, state);
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
				&& Objects.equals(resPartner1, other.resPartner1) && Objects.equals(resPartner2, other.resPartner2)
				&& Objects.equals(resPartner3, other.resPartner3) && Objects.equals(resUser1, other.resUser1)
				&& Objects.equals(resUser2, other.resUser2) && Objects.equals(resUser3, other.resUser3)
				&& Objects.equals(saleOrderLines, other.saleOrderLines) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amountTax=" + amountTax + ", amountTotal=" + amountTotal + ", dateOrder="
				+ dateOrder + ", name=" + name + ", procurementGroupId=" + procurementGroupId + ", state=" + state
				+ ", resPartner1=" + resPartner1 + ", resPartner2=" + resPartner2 + ", resPartner3=" + resPartner3
				+ ", resUser1=" + resUser1 + ", resUser2=" + resUser2 + ", resUser3=" + resUser3 + ", saleOrderLines="
				+ saleOrderLines + "]";
	}
	
}
