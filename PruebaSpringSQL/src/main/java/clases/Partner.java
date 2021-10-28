package clases;

	import java.io.Serializable;
	import javax.persistence.*;
	import java.math.BigDecimal;
	import java.util.Date;
	import java.sql.Timestamp;
	import java.util.List;


	/**
	 * The persistent class for the res_partner database table.
	 * 
	 */
	@Entity
	@Table(name="res_partner")
	@NamedQuery(name="ResPartner.findAll", query="SELECT r FROM ResPartner r")
	public class Partner implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		private Integer id;

		private Boolean active;

		@Column(name="additional_info")
		private String additionalInfo;

		@Column(name="calendar_last_notif_ack")
		private Timestamp calendarLastNotifAck;

		private String city;

		private Integer color;

		private String comment;

		@Column(name="commercial_company_name")
		private String commercialCompanyName;

		@Column(name="company_id")
		private Integer companyId;

		@Column(name="company_name")
		private String companyName;

		@Column(name="country_id")
		private Integer countryId;

		@Column(name="create_date")
		private Timestamp createDate;

		@Column(name="credit_limit")
		private double creditLimit;

		@Column(name="customer_rank")
		private Integer customerRank;

		@Temporal(TemporalType.DATE)
		private Date date;

		@Column(name="debit_limit")
		private BigDecimal debitLimit;

		@Column(name="display_name")
		private String displayName;

		private String email;

		@Column(name="email_normalized")
		private String emailNormalized;

		private Boolean employee;

		private String function;

		@Column(name="industry_id")
		private Integer industryId;

		@Column(name="invoice_warn")
		private String invoiceWarn;

		@Column(name="invoice_warn_msg")
		private String invoiceWarnMsg;

		@Column(name="is_company")
		private Boolean isCompany;

		@Column(name="is_published")
		private Boolean isPublished;

		private String lang;

		@Column(name="last_time_entries_checked")
		private Timestamp lastTimeEntriesChecked;

		@Column(name="message_bounce")
		private Integer messageBounce;

		@Column(name="message_main_attachment_id")
		private Integer messageMainAttachmentId;

		private String mobile;

		private String name;

		@Column(name="partner_gid")
		private Integer partnerGid;

		@Column(name="partner_latitude")
		private BigDecimal partnerLatitude;

		@Column(name="partner_longitude")
		private BigDecimal partnerLongitude;

		@Column(name="partner_share")
		private Boolean partnerShare;

		private String phone;

		@Column(name="phone_sanitized")
		private String phoneSanitized;

		@Column(name="picking_warn")
		private String pickingWarn;

		@Column(name="picking_warn_msg")
		private String pickingWarnMsg;

		@Column(name="purchase_warn")
		private String purchaseWarn;

		@Column(name="purchase_warn_msg")
		private String purchaseWarnMsg;

		private String ref;

		@Column(name="sale_warn")
		private String saleWarn;

		@Column(name="sale_warn_msg")
		private String saleWarnMsg;

		@Column(name="signup_expiration")
		private Timestamp signupExpiration;

		@Column(name="signup_token")
		private String signupToken;

		@Column(name="signup_type")
		private String signupType;

		@Column(name="state_id")
		private Integer stateId;

		private String street;

		private String street2;

		@Column(name="supplier_rank")
		private Integer supplierRank;

		@Column(name="team_id")
		private Integer teamId;

		private Integer title;

		private String type;

		private String tz;

		private String vat;

		private String website;

		@Column(name="website_id")
		private Integer websiteId;

		@Column(name="write_date")
		private Timestamp writeDate;

		private String zip;

		//bi-directional many-to-one association to ResPartner
		@ManyToOne
		@JoinColumn(name="commercial_partner_id")
		private Partner resPartner1;

		//bi-directional many-to-one association to ResPartner
		@OneToMany(mappedBy="resPartner1")
		private List<Partner> resPartners1;

		//bi-directional many-to-one association to ResPartner
		@ManyToOne
		@JoinColumn(name="parent_id")
		private Partner resPartner2;

		//bi-directional many-to-one association to ResPartner
		@OneToMany(mappedBy="resPartner2")
		private List<Partner> resPartners2;

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

		//bi-directional many-to-one association to ResUser
		@OneToMany(mappedBy="resPartner")
		private List<User> resUsers;

		//bi-directional many-to-one association to SaleOrder
		@OneToMany(mappedBy="resPartner1")
		private List<Order> saleOrders1;

		//bi-directional many-to-one association to SaleOrder
		@OneToMany(mappedBy="resPartner2")
		private List<Order> saleOrders2;

		//bi-directional many-to-one association to SaleOrder
		@OneToMany(mappedBy="resPartner3")
		private List<Order> saleOrders3;

		//bi-directional many-to-one association to SaleOrderLine
		@OneToMany(mappedBy="resPartner")
		private List<OrderLine> saleOrderLines;

		//bi-directional many-to-one association to HrEmployee
		@OneToMany(mappedBy="resPartner1")
		private List<Employee> hrEmployees1;

		//bi-directional many-to-one association to HrEmployee
		@OneToMany(mappedBy="resPartner2")
		private List<Employee> hrEmployees2;

		public Partner() {
		}

	}