package nolan;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Objects;


/**
 * The persistent class for the hr_employee database table.
 * 
 */
@Entity
@Table(name="hr_employee")
//@NamedQuery(name="HrEmployee.findAll", query="SELECT h FROM HrEmployee h")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String barcode;
	
	@Column(name="department_id")
	private Integer departmentId;

	private String gender;

	private String name;

	@Column(name="work_email")
	private String workEmail;

	//bi-directional many-to-one association to ResUser
	@ManyToOne
	@JoinColumn(name="create_uid")
	private User resUser;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User resUser2;

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	
	public User getResUser() {
		return resUser;
	}

	public void setResUser(User resUser) {
		this.resUser = resUser;
	}

	public User getResUser2() {
		return resUser2;
	}

	public void setResUser2(User resUser2) {
		this.resUser2 = resUser2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barcode, departmentId, gender, id, name, resUser, resUser2, workEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(barcode, other.barcode) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(resUser, other.resUser)
				&& Objects.equals(resUser2, other.resUser2) && Objects.equals(workEmail, other.workEmail);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", barcode=" + barcode + ", departmentId=" + departmentId + ", gender=" + gender
				+ ", name=" + name + ", workEmail=" + workEmail + ", resUser=" + resUser + ", resUser2=" + resUser2
				+ "]";
	}
	
	
}