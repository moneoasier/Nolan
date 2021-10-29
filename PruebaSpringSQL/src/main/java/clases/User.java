package clases;

	import java.io.Serializable;
	import javax.persistence.*;
	import java.sql.Timestamp;
	import java.util.List;
import java.util.Objects;


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

		@Column(name="create_date")
		private Timestamp createDate;

		private String login;

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

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public Timestamp getWriteDate() {
			return writeDate;
		}

		public void setWriteDate(Timestamp writeDate) {
			this.writeDate = writeDate;
		}

		public List<Partner> getResPartners1() {
			return resPartners1;
		}

		public void setResPartners1(List<Partner> resPartners1) {
			this.resPartners1 = resPartners1;
		}

		public List<Partner> getResPartners2() {
			return resPartners2;
		}

		public void setResPartners2(List<Partner> resPartners2) {
			this.resPartners2 = resPartners2;
		}

		public List<Partner> getResPartners3() {
			return resPartners3;
		}

		public void setResPartners3(List<Partner> resPartners3) {
			this.resPartners3 = resPartners3;
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

		public List<User> getResUsers1() {
			return resUsers1;
		}

		public void setResUsers1(List<User> resUsers1) {
			this.resUsers1 = resUsers1;
		}

		public User getResUser2() {
			return resUser2;
		}

		public void setResUser2(User resUser2) {
			this.resUser2 = resUser2;
		}

		public List<User> getResUsers2() {
			return resUsers2;
		}

		public void setResUsers2(List<User> resUsers2) {
			this.resUsers2 = resUsers2;
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

		public List<OrderLine> getSaleOrderLines1() {
			return saleOrderLines1;
		}

		public void setSaleOrderLines1(List<OrderLine> saleOrderLines1) {
			this.saleOrderLines1 = saleOrderLines1;
		}

		public List<OrderLine> getSaleOrderLines2() {
			return saleOrderLines2;
		}

		public void setSaleOrderLines2(List<OrderLine> saleOrderLines2) {
			this.saleOrderLines2 = saleOrderLines2;
		}

		public List<OrderLine> getSaleOrderLines3() {
			return saleOrderLines3;
		}

		public void setSaleOrderLines3(List<OrderLine> saleOrderLines3) {
			this.saleOrderLines3 = saleOrderLines3;
		}

		@Override
		public int hashCode() {
			return Objects.hash(createDate, id, login, resPartner, resPartners1, resPartners2, resPartners3, resUser1,
					resUser2, resUsers1, resUsers2, saleOrderLines1, saleOrderLines2, saleOrderLines3, saleOrders1,
					saleOrders2, saleOrders3, writeDate);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(createDate, other.createDate) && Objects.equals(id, other.id)
					&& Objects.equals(login, other.login) && Objects.equals(resPartner, other.resPartner)
					&& Objects.equals(resPartners1, other.resPartners1)
					&& Objects.equals(resPartners2, other.resPartners2)
					&& Objects.equals(resPartners3, other.resPartners3) && Objects.equals(resUser1, other.resUser1)
					&& Objects.equals(resUser2, other.resUser2) && Objects.equals(resUsers1, other.resUsers1)
					&& Objects.equals(resUsers2, other.resUsers2)
					&& Objects.equals(saleOrderLines1, other.saleOrderLines1)
					&& Objects.equals(saleOrderLines2, other.saleOrderLines2)
					&& Objects.equals(saleOrderLines3, other.saleOrderLines3)
					&& Objects.equals(saleOrders1, other.saleOrders1) && Objects.equals(saleOrders2, other.saleOrders2)
					&& Objects.equals(saleOrders3, other.saleOrders3) && Objects.equals(writeDate, other.writeDate);
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", createDate=" + createDate + ", login=" + login + ", writeDate=" + writeDate
					+ ", resPartners1=" + resPartners1 + ", resPartners2=" + resPartners2 + ", resPartners3="
					+ resPartners3 + ", resPartner=" + resPartner + ", resUser1=" + resUser1 + ", resUsers1="
					+ resUsers1 + ", resUser2=" + resUser2 + ", resUsers2=" + resUsers2 + ", saleOrders1=" + saleOrders1
					+ ", saleOrders2=" + saleOrders2 + ", saleOrders3=" + saleOrders3 + ", saleOrderLines1="
					+ saleOrderLines1 + ", saleOrderLines2=" + saleOrderLines2 + ", saleOrderLines3=" + saleOrderLines3
					+ "]";
		}


}
