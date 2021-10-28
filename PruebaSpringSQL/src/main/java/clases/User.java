package clases;

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
	public class User implements Serializable {
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
		private List<Partner> resPartners1;

		//bi-directional many-to-one association to ResPartner
		@OneToMany(mappedBy="resUser2")
		private List<Partner> resPartners2;

		//bi-directional many-to-one association to ResPartner
		@OneToMany(mappedBy="resUser3")
		private List<Partner> resPartners3;

		//bi-directional many-to-one association to ResPartner
		@ManyToOne
		@JoinColumn(name="partner_id")
		private Partner resPartner;

		//bi-directional many-to-one association to ResUser
		@ManyToOne
		@JoinColumn(name="create_uid")
		private User resUser1;

		//bi-directional many-to-one association to ResUser
		@OneToMany(mappedBy="resUser1")
		private List<User> resUsers1;

		//bi-directional many-to-one association to ResUser
		@ManyToOne
		@JoinColumn(name="write_uid")
		private User resUser2;

		//bi-directional many-to-one association to ResUser
		@OneToMany(mappedBy="resUser2")
		private List<User> resUsers2;

		//bi-directional many-to-one association to SaleOrder
		@OneToMany(mappedBy="resUser1")
		private List<Order> saleOrders1;

		//bi-directional many-to-one association to SaleOrder
		@OneToMany(mappedBy="resUser2")
		private List<Order> saleOrders2;

		//bi-directional many-to-one association to SaleOrder
		@OneToMany(mappedBy="resUser3")
		private List<Order> saleOrders3;

		//bi-directional many-to-one association to SaleOrderLine
		@OneToMany(mappedBy="resUser1")
		private List<OrderLine> saleOrderLines1;

		//bi-directional many-to-one association to SaleOrderLine
		@OneToMany(mappedBy="resUser2")
		private List<OrderLine> saleOrderLines2;

		//bi-directional many-to-one association to SaleOrderLine
		@OneToMany(mappedBy="resUser3")
		private List<OrderLine> saleOrderLines3;

		public User() {
		}


}
