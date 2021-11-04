package nolan;

	import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	/**
	 * The persistent class for the res_partner database table.
	 * 
	 */
	@Entity
	@Table(name="res_partner")
	//@NamedQuery(name="ResPartner.findAll", query="SELECT r FROM ResPartner r")
	public class Partner implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		private Integer id;

		private String city;

		@Column(name="create_date", columnDefinition = "VARCHAR")
		private Timestamp createDate;

		private String name;

		private String type;

		@Column(name="signup_type")
		private String signupType;
		
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}


		public String getSignupType() {
			return signupType;
		}

		public void setSignupType(String signupType) {
			this.signupType = signupType;
		}

		@Override
		public int hashCode() {
			return Objects.hash(city, createDate, id, name, signupType, type);
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
					&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
					&& Objects.equals(signupType, other.signupType) && Objects.equals(type, other.type);
		}

		@Override
		public String toString() {
			return "Partner [id=" + id + ", city=" + city + ", createDate=" + createDate + ", name=" + name + ", type="
					+ type + ", signupType=" + signupType + "]";
		}
		

	}