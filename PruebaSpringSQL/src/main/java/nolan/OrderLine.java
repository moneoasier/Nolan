package nolan;

	import java.io.Serializable;
	import javax.persistence.*;
	import java.math.BigDecimal;
	import java.sql.Timestamp;
	import java.util.Objects;


	/**
	 * The persistent class for the sale_order_line database table.
	 * 
	 */
	@Entity
	@Table(name="sale_order_line")
	//@NamedQuery(name="SaleOrderLine.findAll", query="SELECT s FROM SaleOrderLine s")
	public class OrderLine implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		private Integer id;

		@Column(name="create_date", columnDefinition = "VARCHAR")
		private Timestamp createDate;

		private String name;

		@Column(name="price_total")
		private BigDecimal priceTotal;

		@Column(name="price_unit")
		private BigDecimal priceUnit;

		private String state;

		//bi-directional many-to-one association to ResPartner
		@ManyToOne
		@JoinColumn(name="order_partner_id")
		private Partner resPartner;

		//bi-directional many-to-one association to ResUser
		@ManyToOne
		@JoinColumn(name="create_uid")
		private User resUser;

		//bi-directional many-to-one association to SaleOrder
		@ManyToOne
		@JoinColumn(name="order_id")
		private Order saleOrder;

		public OrderLine() {
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getPriceTotal() {
			return priceTotal;
		}

		public void setPriceTotal(BigDecimal priceTotal) {
			this.priceTotal = priceTotal;
		}

		public BigDecimal getPriceUnit() {
			return priceUnit;
		}

		public void setPriceUnit(BigDecimal priceUnit) {
			this.priceUnit = priceUnit;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Partner getResPartner() {
			return resPartner;
		}

		public void setResPartner(Partner resPartner) {
			this.resPartner = resPartner;
		}

		public User getResUser1() {
			return resUser;
		}

		public void setResUser1(User resUser1) {
			this.resUser = resUser1;
		}

		public Order getSaleOrder() {
			return saleOrder;
		}

		public void setSaleOrder(Order saleOrder) {
			this.saleOrder = saleOrder;
		}


		@Override
		public int hashCode() {
			return Objects.hash(createDate, id, name, priceTotal, priceUnit, resPartner, resUser, saleOrder, state);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderLine other = (OrderLine) obj;
			return Objects.equals(createDate, other.createDate) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name) && Objects.equals(priceTotal, other.priceTotal)
					&& Objects.equals(priceUnit, other.priceUnit) && Objects.equals(resPartner, other.resPartner)
					&& Objects.equals(resUser, other.resUser) && Objects.equals(saleOrder, other.saleOrder)
					&& Objects.equals(state, other.state);
		}

		@Override
		public String toString() {
			return "OrderLine [id=" + id + ", createDate=" + createDate + ", name=" + name + ", priceTotal="
					+ priceTotal + ", priceUnit=" + priceUnit + ", state=" + state + ", resPartner=" + resPartner
					+ ", resUser=" + resUser + ", saleOrder=" + saleOrder + "]";
		}

		
	}
