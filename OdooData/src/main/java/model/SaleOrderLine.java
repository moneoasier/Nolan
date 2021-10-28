package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sale_order_line database table.
 * 
 */
@Entity
@Table(name="sale_order_line")
@NamedQuery(name="SaleOrderLine.findAll", query="SELECT s FROM SaleOrderLine s")
public class SaleOrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="currency_id")
	private Integer currencyId;

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

	@Column(name="untaxed_amount_invoiced")
	private BigDecimal untaxedAmountInvoiced;

	@Column(name="untaxed_amount_to_invoice")
	private BigDecimal untaxedAmountToInvoice;

	@Column(name="warning_stock")
	private String warningStock;

	@Column(name="write_date")
	private Timestamp writeDate;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="order_partner_id")
	private ResPartner resPartner;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="create_uid")
	private ResUser resUser1;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="salesman_id")
	private ResUser resUser2;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="write_uid")
	private ResUser resUser3;

	//bi-directional many-to-one association to SaleOrder
	@ManyToOne
	@JoinColumn(name="order_id")
	private SaleOrder saleOrder;

	//bi-directional many-to-one association to SaleOrderLine
	@ManyToOne
	@JoinColumn(name="linked_line_id")
	private SaleOrderLine saleOrderLine;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="saleOrderLine")
	private List<SaleOrderLine> saleOrderLines;

	public SaleOrderLine() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public double getCustomerLead() {
		return this.customerLead;
	}

	public void setCustomerLead(double customerLead) {
		this.customerLead = customerLead;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getDisplayType() {
		return this.displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Boolean getIsDownpayment() {
		return this.isDownpayment;
	}

	public void setIsDownpayment(Boolean isDownpayment) {
		this.isDownpayment = isDownpayment;
	}

	public Boolean getIsExpense() {
		return this.isExpense;
	}

	public void setIsExpense(Boolean isExpense) {
		this.isExpense = isExpense;
	}

	public Boolean getIsRewardLine() {
		return this.isRewardLine;
	}

	public void setIsRewardLine(Boolean isRewardLine) {
		this.isRewardLine = isRewardLine;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPriceReduce() {
		return this.priceReduce;
	}

	public void setPriceReduce(BigDecimal priceReduce) {
		this.priceReduce = priceReduce;
	}

	public BigDecimal getPriceReduceTaxexcl() {
		return this.priceReduceTaxexcl;
	}

	public void setPriceReduceTaxexcl(BigDecimal priceReduceTaxexcl) {
		this.priceReduceTaxexcl = priceReduceTaxexcl;
	}

	public BigDecimal getPriceReduceTaxinc() {
		return this.priceReduceTaxinc;
	}

	public void setPriceReduceTaxinc(BigDecimal priceReduceTaxinc) {
		this.priceReduceTaxinc = priceReduceTaxinc;
	}

	public BigDecimal getPriceSubtotal() {
		return this.priceSubtotal;
	}

	public void setPriceSubtotal(BigDecimal priceSubtotal) {
		this.priceSubtotal = priceSubtotal;
	}

	public double getPriceTax() {
		return this.priceTax;
	}

	public void setPriceTax(double priceTax) {
		this.priceTax = priceTax;
	}

	public BigDecimal getPriceTotal() {
		return this.priceTotal;
	}

	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}

	public BigDecimal getPriceUnit() {
		return this.priceUnit;
	}

	public void setPriceUnit(BigDecimal priceUnit) {
		this.priceUnit = priceUnit;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductPackaging() {
		return this.productPackaging;
	}

	public void setProductPackaging(Integer productPackaging) {
		this.productPackaging = productPackaging;
	}

	public Integer getProductUom() {
		return this.productUom;
	}

	public void setProductUom(Integer productUom) {
		this.productUom = productUom;
	}

	public BigDecimal getProductUomQty() {
		return this.productUomQty;
	}

	public void setProductUomQty(BigDecimal productUomQty) {
		this.productUomQty = productUomQty;
	}

	public BigDecimal getQtyDelivered() {
		return this.qtyDelivered;
	}

	public void setQtyDelivered(BigDecimal qtyDelivered) {
		this.qtyDelivered = qtyDelivered;
	}

	public BigDecimal getQtyDeliveredManual() {
		return this.qtyDeliveredManual;
	}

	public void setQtyDeliveredManual(BigDecimal qtyDeliveredManual) {
		this.qtyDeliveredManual = qtyDeliveredManual;
	}

	public String getQtyDeliveredMethod() {
		return this.qtyDeliveredMethod;
	}

	public void setQtyDeliveredMethod(String qtyDeliveredMethod) {
		this.qtyDeliveredMethod = qtyDeliveredMethod;
	}

	public BigDecimal getQtyInvoiced() {
		return this.qtyInvoiced;
	}

	public void setQtyInvoiced(BigDecimal qtyInvoiced) {
		this.qtyInvoiced = qtyInvoiced;
	}

	public BigDecimal getQtyToInvoice() {
		return this.qtyToInvoice;
	}

	public void setQtyToInvoice(BigDecimal qtyToInvoice) {
		this.qtyToInvoice = qtyToInvoice;
	}

	public Integer getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getSequence() {
		return this.sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getUntaxedAmountInvoiced() {
		return this.untaxedAmountInvoiced;
	}

	public void setUntaxedAmountInvoiced(BigDecimal untaxedAmountInvoiced) {
		this.untaxedAmountInvoiced = untaxedAmountInvoiced;
	}

	public BigDecimal getUntaxedAmountToInvoice() {
		return this.untaxedAmountToInvoice;
	}

	public void setUntaxedAmountToInvoice(BigDecimal untaxedAmountToInvoice) {
		this.untaxedAmountToInvoice = untaxedAmountToInvoice;
	}

	public String getWarningStock() {
		return this.warningStock;
	}

	public void setWarningStock(String warningStock) {
		this.warningStock = warningStock;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public ResPartner getResPartner() {
		return this.resPartner;
	}

	public void setResPartner(ResPartner resPartner) {
		this.resPartner = resPartner;
	}

	public ResUser getResUser1() {
		return this.resUser1;
	}

	public void setResUser1(ResUser resUser1) {
		this.resUser1 = resUser1;
	}

	public ResUser getResUser2() {
		return this.resUser2;
	}

	public void setResUser2(ResUser resUser2) {
		this.resUser2 = resUser2;
	}

	public ResUser getResUser3() {
		return this.resUser3;
	}

	public void setResUser3(ResUser resUser3) {
		this.resUser3 = resUser3;
	}

	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public SaleOrderLine getSaleOrderLine() {
		return this.saleOrderLine;
	}

	public void setSaleOrderLine(SaleOrderLine saleOrderLine) {
		this.saleOrderLine = saleOrderLine;
	}

	public List<SaleOrderLine> getSaleOrderLines() {
		return this.saleOrderLines;
	}

	public void setSaleOrderLines(List<SaleOrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	public SaleOrderLine addSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().add(saleOrderLine);
		saleOrderLine.setSaleOrderLine(this);

		return saleOrderLine;
	}

	public SaleOrderLine removeSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().remove(saleOrderLine);
		saleOrderLine.setSaleOrderLine(null);

		return saleOrderLine;
	}

}