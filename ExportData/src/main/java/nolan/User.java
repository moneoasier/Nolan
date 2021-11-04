package nolan;

	import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	/**
	 * The persistent class for the res_users database table.
	 * 
	 */
	@Entity
	@Table(name="res_users")
	//@NamedQuery(name="ResUser.findAll", query="SELECT r FROM res_users r")
	public class User implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		private Integer id;

		@Column(name="create_date", columnDefinition = "VARCHAR")
		private Timestamp createDate;

		private String login;

		@Column(name="write_date", columnDefinition = "VARCHAR")
		private Timestamp writeDate;

		//bi-directional many-to-one association to ResPartner
		@ManyToOne
		@JoinColumn(name="partner_id")
		private Partner resPartner;

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
		
		public Partner getResPartner() {
			return resPartner;
		}

		public void setResPartner(Partner resPartner) {
			this.resPartner = resPartner;
		}

		
		@Override
		public int hashCode() {
			return Objects.hash(createDate, id, login, resPartner, writeDate);
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
					&& Objects.equals(writeDate, other.writeDate);
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", createDate=" + createDate + ", login=" + login + ", writeDate=" + writeDate
					+ ", resPartner=" + resPartner + "]";
		}

		


}
