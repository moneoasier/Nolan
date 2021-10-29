package clases;

	import java.io.Serializable;
	import javax.persistence.*;
	import java.util.Date;
	import java.sql.Timestamp;
	import java.util.List;
import java.util.Objects;


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

		private String city;

		@Column(name="create_date")
		private Timestamp createDate;

		@Temporal(TemporalType.DATE)
		private Date date;


		private String name;

		@Column(name="signup_type")
		private String signupType;

		private String type;


		



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

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Timestamp getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Timestamp createDate) {
			this.createDate = createDate;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSignupType() {
			return signupType;
		}

		public void setSignupType(String signupType) {
			this.signupType = signupType;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Partner getResPartner1() {
			return resPartner1;
		}

		public void setResPartner1(Partner resPartner1) {
			this.resPartner1 = resPartner1;
		}

		public List<Partner> getResPartners1() {
			return resPartners1;
		}

		public void setResPartners1(List<Partner> resPartners1) {
			this.resPartners1 = resPartners1;
		}

		public Partner getResPartner2() {
			return resPartner2;
		}

		public void setResPartner2(Partner resPartner2) {
			this.resPartner2 = resPartner2;
		}

		public List<Partner> getResPartners2() {
			return resPartners2;
		}

		public void setResPartners2(List<Partner> resPartners2) {
			this.resPartners2 = resPartners2;
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

		public List<User> getResUsers() {
			return resUsers;
		}

		public void setResUsers(List<User> resUsers) {
			this.resUsers = resUsers;
		}

		public List<Order> getSaleOrders1() {
			return saleOrders1;
		}

		public void setSaleOrders1(List<Order> saleOrders1) {
			this.saleOrders1 = saleOrders1;
		}

		public List<Order> getSaleOrders2() {
			return saleOrders2;
		}

		public void setSaleOrders2(List<Order> saleOrders2) {
			this.saleOrders2 = saleOrders2;
		}

		public List<Order> getSaleOrders3() {
			return saleOrders3;
		}

		public void setSaleOrders3(List<Order> saleOrders3) {
			this.saleOrders3 = saleOrders3;
		}

		public List<OrderLine> getSaleOrderLines() {
			return saleOrderLines;
		}

		public void setSaleOrderLines(List<OrderLine> saleOrderLines) {
			this.saleOrderLines = saleOrderLines;
		}

		public List<Employee> getHrEmployees1() {
			return hrEmployees1;
		}

		public void setHrEmployees1(List<Employee> hrEmployees1) {
			this.hrEmployees1 = hrEmployees1;
		}

		public List<Employee> getHrEmployees2() {
			return hrEmployees2;
		}

		public void setHrEmployees2(List<Employee> hrEmployees2) {
			this.hrEmployees2 = hrEmployees2;
		}

		@Override
		public int hashCode() {
			return Objects.hash(city, createDate, date, hrEmployees1, hrEmployees2, id, name, resPartner1, resPartner2,
					resPartners1, resPartners2, resUser1, resUser2, resUser3, resUsers, saleOrderLines, saleOrders1,
					saleOrders2, saleOrders3, signupType, type);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Partner other = (Partner) obj;
			return Objects.equals(city, other.city) && Objects.equals(createDate, other.createDate)
					&& Objects.equals(date, other.date) && Objects.equals(hrEmployees1, other.hrEmployees1)
					&& Objects.equals(hrEmployees2, other.hrEmployees2) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name) && Objects.equals(resPartner1, other.resPartner1)
					&& Objects.equals(resPartner2, other.resPartner2)
					&& Objects.equals(resPartners1, other.resPartners1)
					&& Objects.equals(resPartners2, other.resPartners2) && Objects.equals(resUser1, other.resUser1)
					&& Objects.equals(resUser2, other.resUser2) && Objects.equals(resUser3, other.resUser3)
					&& Objects.equals(resUsers, other.resUsers) && Objects.equals(saleOrderLines, other.saleOrderLines)
					&& Objects.equals(saleOrders1, other.saleOrders1) && Objects.equals(saleOrders2, other.saleOrders2)
					&& Objects.equals(saleOrders3, other.saleOrders3) && Objects.equals(signupType, other.signupType)
					&& Objects.equals(type, other.type);
		}

		@Override
		public String toString() {
			return "Partner [id=" + id + ", city=" + city + ", createDate=" + createDate + ", date=" + date + ", name="
					+ name + ", signupType=" + signupType + ", type=" + type + ", resPartner1=" + resPartner1
					+ ", resPartners1=" + resPartners1 + ", resPartner2=" + resPartner2 + ", resPartners2="
					+ resPartners2 + ", resUser1=" + resUser1 + ", resUser2=" + resUser2 + ", resUser3=" + resUser3
					+ ", resUsers=" + resUsers + ", saleOrders1=" + saleOrders1 + ", saleOrders2=" + saleOrders2
					+ ", saleOrders3=" + saleOrders3 + ", saleOrderLines=" + saleOrderLines + ", hrEmployees1="
					+ hrEmployees1 + ", hrEmployees2=" + hrEmployees2 + "]";
		}
		
		

	}