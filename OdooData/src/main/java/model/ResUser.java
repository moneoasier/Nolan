package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the res_users database table.
 * 
 */
@Entity
@Table(name="res_users")
@NamedQuery(name="ResUser.findAll", query="SELECT r FROM ResUser r")
public class ResUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="action_id")
	private Integer actionId;

	private Boolean active;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="create_date")
	private Timestamp createDate;

	private String login;

	@Column(name="notification_type")
	private String notificationType;

	@Column(name="odoobot_failed")
	private Boolean odoobotFailed;

	@Column(name="odoobot_state")
	private String odoobotState;

	private String password;

	@Column(name="sale_team_id")
	private Integer saleTeamId;

	private Boolean share;

	private String signature;

	@Column(name="target_sales_done")
	private Integer targetSalesDone;

	@Column(name="target_sales_invoiced")
	private Integer targetSalesInvoiced;

	@Column(name="target_sales_won")
	private Integer targetSalesWon;

	@Column(name="totp_secret")
	private String totpSecret;

	@Column(name="website_id")
	private Integer websiteId;

	@Column(name="write_date")
	private Timestamp writeDate;

	//bi-directional many-to-one association to ResPartner
	@OneToMany(mappedBy="resUser1")
	private List<ResPartner> resPartners1;

	//bi-directional many-to-one association to ResPartner
	@OneToMany(mappedBy="resUser2")
	private List<ResPartner> resPartners2;

	//bi-directional many-to-one association to ResPartner
	@OneToMany(mappedBy="resUser3")
	private List<ResPartner> resPartners3;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="partner_id")
	private ResPartner resPartner;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="create_uid")
	private ResUser resUser1;

	//bi-directional many-to-one association to ResUser
	@OneToMany(mappedBy="resUser1")
	private List<ResUser> resUsers1;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="write_uid")
	private ResUser resUser2;

	//bi-directional many-to-one association to ResUser
	@OneToMany(mappedBy="resUser2")
	private List<ResUser> resUsers2;

	//bi-directional many-to-one association to SaleOrder
	@OneToMany(mappedBy="resUser1")
	private List<SaleOrder> saleOrders1;

	//bi-directional many-to-one association to SaleOrder
	@OneToMany(mappedBy="resUser2")
	private List<SaleOrder> saleOrders2;

	//bi-directional many-to-one association to SaleOrder
	@OneToMany(mappedBy="resUser3")
	private List<SaleOrder> saleOrders3;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="resUser1")
	private List<SaleOrderLine> saleOrderLines1;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="resUser2")
	private List<SaleOrderLine> saleOrderLines2;

	//bi-directional many-to-one association to SaleOrderLine
	@OneToMany(mappedBy="resUser3")
	private List<SaleOrderLine> saleOrderLines3;

	public ResUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActionId() {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNotificationType() {
		return this.notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public Boolean getOdoobotFailed() {
		return this.odoobotFailed;
	}

	public void setOdoobotFailed(Boolean odoobotFailed) {
		this.odoobotFailed = odoobotFailed;
	}

	public String getOdoobotState() {
		return this.odoobotState;
	}

	public void setOdoobotState(String odoobotState) {
		this.odoobotState = odoobotState;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSaleTeamId() {
		return this.saleTeamId;
	}

	public void setSaleTeamId(Integer saleTeamId) {
		this.saleTeamId = saleTeamId;
	}

	public Boolean getShare() {
		return this.share;
	}

	public void setShare(Boolean share) {
		this.share = share;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getTargetSalesDone() {
		return this.targetSalesDone;
	}

	public void setTargetSalesDone(Integer targetSalesDone) {
		this.targetSalesDone = targetSalesDone;
	}

	public Integer getTargetSalesInvoiced() {
		return this.targetSalesInvoiced;
	}

	public void setTargetSalesInvoiced(Integer targetSalesInvoiced) {
		this.targetSalesInvoiced = targetSalesInvoiced;
	}

	public Integer getTargetSalesWon() {
		return this.targetSalesWon;
	}

	public void setTargetSalesWon(Integer targetSalesWon) {
		this.targetSalesWon = targetSalesWon;
	}

	public String getTotpSecret() {
		return this.totpSecret;
	}

	public void setTotpSecret(String totpSecret) {
		this.totpSecret = totpSecret;
	}

	public Integer getWebsiteId() {
		return this.websiteId;
	}

	public void setWebsiteId(Integer websiteId) {
		this.websiteId = websiteId;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public List<ResPartner> getResPartners1() {
		return this.resPartners1;
	}

	public void setResPartners1(List<ResPartner> resPartners1) {
		this.resPartners1 = resPartners1;
	}

	public ResPartner addResPartners1(ResPartner resPartners1) {
		getResPartners1().add(resPartners1);
		resPartners1.setResUser1(this);

		return resPartners1;
	}

	public ResPartner removeResPartners1(ResPartner resPartners1) {
		getResPartners1().remove(resPartners1);
		resPartners1.setResUser1(null);

		return resPartners1;
	}

	public List<ResPartner> getResPartners2() {
		return this.resPartners2;
	}

	public void setResPartners2(List<ResPartner> resPartners2) {
		this.resPartners2 = resPartners2;
	}

	public ResPartner addResPartners2(ResPartner resPartners2) {
		getResPartners2().add(resPartners2);
		resPartners2.setResUser2(this);

		return resPartners2;
	}

	public ResPartner removeResPartners2(ResPartner resPartners2) {
		getResPartners2().remove(resPartners2);
		resPartners2.setResUser2(null);

		return resPartners2;
	}

	public List<ResPartner> getResPartners3() {
		return this.resPartners3;
	}

	public void setResPartners3(List<ResPartner> resPartners3) {
		this.resPartners3 = resPartners3;
	}

	public ResPartner addResPartners3(ResPartner resPartners3) {
		getResPartners3().add(resPartners3);
		resPartners3.setResUser3(this);

		return resPartners3;
	}

	public ResPartner removeResPartners3(ResPartner resPartners3) {
		getResPartners3().remove(resPartners3);
		resPartners3.setResUser3(null);

		return resPartners3;
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

	public List<ResUser> getResUsers1() {
		return this.resUsers1;
	}

	public void setResUsers1(List<ResUser> resUsers1) {
		this.resUsers1 = resUsers1;
	}

	public ResUser addResUsers1(ResUser resUsers1) {
		getResUsers1().add(resUsers1);
		resUsers1.setResUser1(this);

		return resUsers1;
	}

	public ResUser removeResUsers1(ResUser resUsers1) {
		getResUsers1().remove(resUsers1);
		resUsers1.setResUser1(null);

		return resUsers1;
	}

	public ResUser getResUser2() {
		return this.resUser2;
	}

	public void setResUser2(ResUser resUser2) {
		this.resUser2 = resUser2;
	}

	public List<ResUser> getResUsers2() {
		return this.resUsers2;
	}

	public void setResUsers2(List<ResUser> resUsers2) {
		this.resUsers2 = resUsers2;
	}

	public ResUser addResUsers2(ResUser resUsers2) {
		getResUsers2().add(resUsers2);
		resUsers2.setResUser2(this);

		return resUsers2;
	}

	public ResUser removeResUsers2(ResUser resUsers2) {
		getResUsers2().remove(resUsers2);
		resUsers2.setResUser2(null);

		return resUsers2;
	}

	public List<SaleOrder> getSaleOrders1() {
		return this.saleOrders1;
	}

	public void setSaleOrders1(List<SaleOrder> saleOrders1) {
		this.saleOrders1 = saleOrders1;
	}

	public SaleOrder addSaleOrders1(SaleOrder saleOrders1) {
		getSaleOrders1().add(saleOrders1);
		saleOrders1.setResUser1(this);

		return saleOrders1;
	}

	public SaleOrder removeSaleOrders1(SaleOrder saleOrders1) {
		getSaleOrders1().remove(saleOrders1);
		saleOrders1.setResUser1(null);

		return saleOrders1;
	}

	public List<SaleOrder> getSaleOrders2() {
		return this.saleOrders2;
	}

	public void setSaleOrders2(List<SaleOrder> saleOrders2) {
		this.saleOrders2 = saleOrders2;
	}

	public SaleOrder addSaleOrders2(SaleOrder saleOrders2) {
		getSaleOrders2().add(saleOrders2);
		saleOrders2.setResUser2(this);

		return saleOrders2;
	}

	public SaleOrder removeSaleOrders2(SaleOrder saleOrders2) {
		getSaleOrders2().remove(saleOrders2);
		saleOrders2.setResUser2(null);

		return saleOrders2;
	}

	public List<SaleOrder> getSaleOrders3() {
		return this.saleOrders3;
	}

	public void setSaleOrders3(List<SaleOrder> saleOrders3) {
		this.saleOrders3 = saleOrders3;
	}

	public SaleOrder addSaleOrders3(SaleOrder saleOrders3) {
		getSaleOrders3().add(saleOrders3);
		saleOrders3.setResUser3(this);

		return saleOrders3;
	}

	public SaleOrder removeSaleOrders3(SaleOrder saleOrders3) {
		getSaleOrders3().remove(saleOrders3);
		saleOrders3.setResUser3(null);

		return saleOrders3;
	}

	public List<SaleOrderLine> getSaleOrderLines1() {
		return this.saleOrderLines1;
	}

	public void setSaleOrderLines1(List<SaleOrderLine> saleOrderLines1) {
		this.saleOrderLines1 = saleOrderLines1;
	}

	public SaleOrderLine addSaleOrderLines1(SaleOrderLine saleOrderLines1) {
		getSaleOrderLines1().add(saleOrderLines1);
		saleOrderLines1.setResUser1(this);

		return saleOrderLines1;
	}

	public SaleOrderLine removeSaleOrderLines1(SaleOrderLine saleOrderLines1) {
		getSaleOrderLines1().remove(saleOrderLines1);
		saleOrderLines1.setResUser1(null);

		return saleOrderLines1;
	}

	public List<SaleOrderLine> getSaleOrderLines2() {
		return this.saleOrderLines2;
	}

	public void setSaleOrderLines2(List<SaleOrderLine> saleOrderLines2) {
		this.saleOrderLines2 = saleOrderLines2;
	}

	public SaleOrderLine addSaleOrderLines2(SaleOrderLine saleOrderLines2) {
		getSaleOrderLines2().add(saleOrderLines2);
		saleOrderLines2.setResUser2(this);

		return saleOrderLines2;
	}

	public SaleOrderLine removeSaleOrderLines2(SaleOrderLine saleOrderLines2) {
		getSaleOrderLines2().remove(saleOrderLines2);
		saleOrderLines2.setResUser2(null);

		return saleOrderLines2;
	}

	public List<SaleOrderLine> getSaleOrderLines3() {
		return this.saleOrderLines3;
	}

	public void setSaleOrderLines3(List<SaleOrderLine> saleOrderLines3) {
		this.saleOrderLines3 = saleOrderLines3;
	}

	public SaleOrderLine addSaleOrderLines3(SaleOrderLine saleOrderLines3) {
		getSaleOrderLines3().add(saleOrderLines3);
		saleOrderLines3.setResUser3(this);

		return saleOrderLines3;
	}

	public SaleOrderLine removeSaleOrderLines3(SaleOrderLine saleOrderLines3) {
		getSaleOrderLines3().remove(saleOrderLines3);
		saleOrderLines3.setResUser3(null);

		return saleOrderLines3;
	}

}