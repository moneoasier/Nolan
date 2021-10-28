package clases;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the hr_employee database table.
 * 
 */
@Entity
@Table(name="hr_employee")
@NamedQuery(name="HrEmployee.findAll", query="SELECT h FROM HrEmployee h")
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


	//bi-directional many-to-one association to HrEmployee
	@ManyToOne
	@JoinColumn(name="coach_id")
	private Employee hrEmployee1;

	//bi-directional many-to-one association to HrEmployee
	@OneToMany(mappedBy="hrEmployee1")
	private List<Employee> hrEmployees1;

	//bi-directional many-to-one association to HrEmployee
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Employee hrEmployee2;

	//bi-directional many-to-one association to HrEmployee
	@OneToMany(mappedBy="hrEmployee2")
	private List<Employee> hrEmployees2;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="address_home_id")
	private Partner resPartner1;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="address_id")
	private Partner resPartner2;

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

	public Employee getHrEmployee1() {
		return hrEmployee1;
	}

	public void setHrEmployee1(Employee hrEmployee1) {
		this.hrEmployee1 = hrEmployee1;
	}

	public List<Employee> getHrEmployees1() {
		return hrEmployees1;
	}

	public void setHrEmployees1(List<Employee> hrEmployees1) {
		this.hrEmployees1 = hrEmployees1;
	}

	public Employee getHrEmployee2() {
		return hrEmployee2;
	}

	public void setHrEmployee2(Employee hrEmployee2) {
		this.hrEmployee2 = hrEmployee2;
	}

	public List<Employee> getHrEmployees2() {
		return hrEmployees2;
	}

	public void setHrEmployees2(List<Employee> hrEmployees2) {
		this.hrEmployees2 = hrEmployees2;
	}

	public Partner getResPartner1() {
		return resPartner1;
	}

	public void setResPartner1(Partner resPartner1) {
		this.resPartner1 = resPartner1;
	}

	public Partner getResPartner2() {
		return resPartner2;
	}

	public void setResPartner2(Partner resPartner2) {
		this.resPartner2 = resPartner2;
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

	@Override
	public int hashCode() {
		return Objects.hash(barcode, departmentId, gender, hrEmployee1, hrEmployee2, hrEmployees1, hrEmployees2, id,
				name, resPartner1, resPartner2, resUser1, resUser2, resUser3, workEmail);
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
				&& Objects.equals(gender, other.gender) && Objects.equals(hrEmployee1, other.hrEmployee1)
				&& Objects.equals(hrEmployee2, other.hrEmployee2) && Objects.equals(hrEmployees1, other.hrEmployees1)
				&& Objects.equals(hrEmployees2, other.hrEmployees2) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(resPartner1, other.resPartner1)
				&& Objects.equals(resPartner2, other.resPartner2) && Objects.equals(resUser1, other.resUser1)
				&& Objects.equals(resUser2, other.resUser2) && Objects.equals(resUser3, other.resUser3)
				&& Objects.equals(workEmail, other.workEmail);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", barcode=" + barcode + ", departmentId=" + departmentId + ", gender=" + gender
				+ ", name=" + name + ", workEmail=" + workEmail + ", hrEmployee1=" + hrEmployee1 + ", hrEmployees1="
				+ hrEmployees1 + ", hrEmployee2=" + hrEmployee2 + ", hrEmployees2=" + hrEmployees2 + ", resPartner1="
				+ resPartner1 + ", resPartner2=" + resPartner2 + ", resUser1=" + resUser1 + ", resUser2=" + resUser2
				+ ", resUser3=" + resUser3 + "]";
	}
	
	
}