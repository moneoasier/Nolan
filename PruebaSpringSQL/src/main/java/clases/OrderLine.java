package clases;

	import java.io.Serializable;
	import javax.persistence.*;
	import java.math.BigDecimal;
	import java.sql.Timestamp;
	import java.util.List;
import java.util.Objects;


	/**
	 * The persistent class for the sale_order_line database table.
	 * 
	 */
	@Entity
	@Table(name="sale_order_line")
	@NamedQuery(name="SaleOrderLine.findAll", query="SELECT s FROM SaleOrderLine s")
	public class OrderLine implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		private Integer id;


		@Column(name="create_date")
		private Timestamp createDate;

		@Column(name="customer_lead")
		private double customerLead;

		private BigDecimal discount;

		@Column(name="display_type")
		private String displayType;

		@Column(name="invoice_status")
		private String invoiceStatus;

		@Column(name="is_downpayment")
		private Boolean isDownpayment;

		@Column(name="is_expense")
		private Boolean isExpense;

		@Column(name="is_reward_line")
		private Boolean isRewardLine;

		private String name;

		@Column(name="price_reduce")
		private BigDecimal priceReduce;

		@Column(name="price_reduce_taxexcl")
		private BigDecimal priceReduceTaxexcl;

		@Column(name="price_reduce_taxinc")
		private BigDecimal priceReduceTaxinc;

		@Column(name="price_subtotal")
		private BigDecimal priceSubtotal;

		@Column(name="price_tax")
		private double priceTax;

		@Column(name="price_total")
		private BigDecimal priceTotal;

		@Column(name="price_unit")
		private BigDecimal priceUnit;

		@Column(name="product_id")
		private Integer productId;

		@Column(name="product_packaging")
		private Integer productPackaging;

		@Column(name="product_uom")
		private Integer productUom;

		@Column(name="product_uom_qty")
		private BigDecimal productUomQty;

		@Column(name="qty_delivered")
		private BigDecimal qtyDelivered;

		@Column(name="qty_delivered_manual")
		private BigDecimal qtyDeliveredManual;

		@Column(name="qty_delivered_method")
		private String qtyDeliveredMethod;

		@Column(name="qty_invoiced")
		private BigDecimal qtyInvoiced;

		@Column(name="qty_to_invoice")
		private BigDecimal qtyToInvoice;

		@Column(name="route_id")
		private Integer routeId;

		private Integer sequence;

		private String state;

		//bi-directional many-to-one association to ResPartner
		@ManyToOne
		@JoinColumn(name="order_partner_id")
		private Partner resPartner;

		//bi-directional many-to-one association to ResUser
		@ManyToOne
		@JoinColumn(name="create_uid")
		private User resUser1;

		//bi-directional many-to-one association to ResUser
		@ManyToOne
		@JoinColumn(name="salesman_id")
		private User resUser2;

		//bi-directional many-to-one association to ResUser
		@ManyToOne
		@JoinColumn(name="write_uid")
		private User resUser3;

		//bi-directional many-to-one association to SaleOrder
		@ManyToOne
		@JoinColumn(name="order_id")
		private Order saleOrder;

		//bi-directional many-to-one association to SaleOrderLine
		@ManyToOne
		@JoinColumn(name="linked_line_id")
		private OrderLine saleOrderLine;

		//bi-directional many-to-one association to SaleOrderLine
		@OneToMany(mappedBy="saleOrderLine")
		private List<OrderLine> saleOrderLines;

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

		public double getCustomerLead() {
			return customerLead;
		}

		public void setCustomerLead(double customerLead) {
			this.customerLead = customerLead;
		}

		public BigDecimal getDiscount() {
			return discount;
		}

		public void setDiscount(BigDecimal discount) {
			this.discount = discount;
		}

		public String getDisplayType() {
			return displayType;
		}

		public void setDisplayType(String displayType) {
			this.displayType = displayType;
		}

		public String getInvoiceStatus() {
			return invoiceStatus;
		}

		public void setInvoiceStatus(String invoiceStatus) {
			this.invoiceStatus = invoiceStatus;
		}

		public Boolean getIsDownpayment() {
			return isDownpayment;
		}

		public void setIsDownpayment(Boolean isDownpayment) {
			this.isDownpayment = isDownpayment;
		}

		public Boolean getIsExpense() {
			return isExpense;
		}

		public void setIsExpense(Boolean isExpense) {
			this.isExpense = isExpense;
		}

		public Boolean getIsRewardLine() {
			return isRewardLine;
		}

		public void setIsRewardLine(Boolean isRewardLine) {
			this.isRewardLine = isRewardLine;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getPriceReduce() {
			return priceReduce;
		}

		public void setPriceReduce(BigDecimal priceReduce) {
			this.priceReduce = priceReduce;
		}

		public BigDecimal getPriceReduceTaxexcl() {
			return priceReduceTaxexcl;
		}

		public void setPriceReduceTaxexcl(BigDecimal priceReduceTaxexcl) {
			this.priceReduceTaxexcl = priceReduceTaxexcl;
		}

		public BigDecimal getPriceReduceTaxinc() {
			return priceReduceTaxinc;
		}

		public void setPriceReduceTaxinc(BigDecimal priceReduceTaxinc) {
			this.priceReduceTaxinc = priceReduceTaxinc;
		}

		public BigDecimal getPriceSubtotal() {
			return priceSubtotal;
		}

		public void setPriceSubtotal(BigDecimal priceSubtotal) {
			this.priceSubtotal = priceSubtotal;
		}

		public double getPriceTax() {
			return priceTax;
		}

		public void setPriceTax(double priceTax) {
			this.priceTax = priceTax;
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

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}

		public Integer getProductPackaging() {
			return productPackaging;
		}

		public void setProductPackaging(Integer productPackaging) {
			this.productPackaging = productPackaging;
		}

		public Integer getProductUom() {
			return productUom;
		}

		public void setProductUom(Integer productUom) {
			this.productUom = productUom;
		}

		public BigDecimal getProductUomQty() {
			return productUomQty;
		}

		public void setProductUomQty(BigDecimal productUomQty) {
			this.productUomQty = productUomQty;
		}

		public BigDecimal getQtyDelivered() {
			return qtyDelivered;
		}

		public void setQtyDelivered(BigDecimal qtyDelivered) {
			this.qtyDelivered = qtyDelivered;
		}

		public BigDecimal getQtyDeliveredManual() {
			return qtyDeliveredManual;
		}

		public void setQtyDeliveredManual(BigDecimal qtyDeliveredManual) {
			this.qtyDeliveredManual = qtyDeliveredManual;
		}

		public String getQtyDeliveredMethod() {
			return qtyDeliveredMethod;
		}

		public void setQtyDeliveredMethod(String qtyDeliveredMethod) {
			this.qtyDeliveredMethod = qtyDeliveredMethod;
		}

		public BigDecimal getQtyInvoiced() {
			return qtyInvoiced;
		}

		public void setQtyInvoiced(BigDecimal qtyInvoiced) {
			this.qtyInvoiced = qtyInvoiced;
		}

		public BigDecimal getQtyToInvoice() {
			return qtyToInvoice;
		}

		public void setQtyToInvoice(BigDecimal qtyToInvoice) {
			this.qtyToInvoice = qtyToInvoice;
		}

		public Integer getRouteId() {
			return routeId;
		}

		public void setRouteId(Integer routeId) {
			this.routeId = routeId;
		}

		public Integer getSequence() {
			return sequence;
		}

		public void setSequence(Integer sequence) {
			this.sequence = sequence;
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

		public Order getSaleOrder() {
			return saleOrder;
		}

		public void setSaleOrder(Order saleOrder) {
			this.saleOrder = saleOrder;
		}

		public OrderLine getSaleOrderLine() {
			return saleOrderLine;
		}

		public void setSaleOrderLine(OrderLine saleOrderLine) {
			this.saleOrderLine = saleOrderLine;
		}

		public List<OrderLine> getSaleOrderLines() {
			return saleOrderLines;
		}

		public void setSaleOrderLines(List<OrderLine> saleOrderLines) {
			this.saleOrderLines = saleOrderLines;
		}

		@Override
		public int hashCode() {
			return Objects.hash(createDate, customerLead, discount, displayType, id, invoiceStatus, isDownpayment,
					isExpense, isRewardLine, name, priceReduce, priceReduceTaxexcl, priceReduceTaxinc, priceSubtotal,
					priceTax, priceTotal, priceUnit, productId, productPackaging, productUom, productUomQty,
					qtyDelivered, qtyDeliveredManual, qtyDeliveredMethod, qtyInvoiced, qtyToInvoice, resPartner,
					resUser1, resUser2, resUser3, routeId, saleOrder, saleOrderLine, saleOrderLines, sequence, state);
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
			return Objects.equals(createDate, other.createDate)
					&& Double.doubleToLongBits(customerLead) == Double.doubleToLongBits(other.customerLead)
					&& Objects.equals(discount, other.discount) && Objects.equals(displayType, other.displayType)
					&& Objects.equals(id, other.id) && Objects.equals(invoiceStatus, other.invoiceStatus)
					&& Objects.equals(isDownpayment, other.isDownpayment) && Objects.equals(isExpense, other.isExpense)
					&& Objects.equals(isRewardLine, other.isRewardLine) && Objects.equals(name, other.name)
					&& Objects.equals(priceReduce, other.priceReduce)
					&& Objects.equals(priceReduceTaxexcl, other.priceReduceTaxexcl)
					&& Objects.equals(priceReduceTaxinc, other.priceReduceTaxinc)
					&& Objects.equals(priceSubtotal, other.priceSubtotal)
					&& Double.doubleToLongBits(priceTax) == Double.doubleToLongBits(other.priceTax)
					&& Objects.equals(priceTotal, other.priceTotal) && Objects.equals(priceUnit, other.priceUnit)
					&& Objects.equals(productId, other.productId)
					&& Objects.equals(productPackaging, other.productPackaging)
					&& Objects.equals(productUom, other.productUom)
					&& Objects.equals(productUomQty, other.productUomQty)
					&& Objects.equals(qtyDelivered, other.qtyDelivered)
					&& Objects.equals(qtyDeliveredManual, other.qtyDeliveredManual)
					&& Objects.equals(qtyDeliveredMethod, other.qtyDeliveredMethod)
					&& Objects.equals(qtyInvoiced, other.qtyInvoiced)
					&& Objects.equals(qtyToInvoice, other.qtyToInvoice) && Objects.equals(resPartner, other.resPartner)
					&& Objects.equals(resUser1, other.resUser1) && Objects.equals(resUser2, other.resUser2)
					&& Objects.equals(resUser3, other.resUser3) && Objects.equals(routeId, other.routeId)
					&& Objects.equals(saleOrder, other.saleOrder) && Objects.equals(saleOrderLine, other.saleOrderLine)
					&& Objects.equals(saleOrderLines, other.saleOrderLines) && Objects.equals(sequence, other.sequence)
					&& Objects.equals(state, other.state);
		}

		@Override
		public String toString() {
			return "OrderLine [id=" + id + ", createDate=" + createDate + ", customerLead=" + customerLead
					+ ", discount=" + discount + ", displayType=" + displayType + ", invoiceStatus=" + invoiceStatus
					+ ", isDownpayment=" + isDownpayment + ", isExpense=" + isExpense + ", isRewardLine=" + isRewardLine
					+ ", name=" + name + ", priceReduce=" + priceReduce + ", priceReduceTaxexcl=" + priceReduceTaxexcl
					+ ", priceReduceTaxinc=" + priceReduceTaxinc + ", priceSubtotal=" + priceSubtotal + ", priceTax="
					+ priceTax + ", priceTotal=" + priceTotal + ", priceUnit=" + priceUnit + ", productId=" + productId
					+ ", productPackaging=" + productPackaging + ", productUom=" + productUom + ", productUomQty="
					+ productUomQty + ", qtyDelivered=" + qtyDelivered + ", qtyDeliveredManual=" + qtyDeliveredManual
					+ ", qtyDeliveredMethod=" + qtyDeliveredMethod + ", qtyInvoiced=" + qtyInvoiced + ", qtyToInvoice="
					+ qtyToInvoice + ", routeId=" + routeId + ", sequence=" + sequence + ", state=" + state
					+ ", resPartner=" + resPartner + ", resUser1=" + resUser1 + ", resUser2=" + resUser2 + ", resUser3="
					+ resUser3 + ", saleOrder=" + saleOrder + ", saleOrderLine=" + saleOrderLine + ", saleOrderLines="
					+ saleOrderLines + "]";
		}
		
		
	}
