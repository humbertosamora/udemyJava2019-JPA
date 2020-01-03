package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Seller")
@Table(name = "SELLER")
//@SQLInsert( sql = "INSERT INTO SELLER (NAME, EMAIL, BASESALARY, BIRTHDATE, DEPARTMENTID) VALUES (upper(?), upper(?), ?, ?, ?)")
//@SQLUpdate( sql = "UPDATE SELLER SET NAME = upper(?), EMAIL = upper(?), BASESALARY = ?, BIRTHDATE = ?, DEPARTMENTID = ? WHERE ID = ?")
//@SQLDelete( sql = "DELETE FROM SELLER WHERE ID = ?")
//@SQLDeleteAll( sql = "DELETE * FROM SELLER")
public class Seller implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="BASESALARY")
	private Double baseSalary;
	
	@Column(name="BIRTHDATE", columnDefinition="DATE NOT NULL")
	private LocalDate birthDate;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENTID", referencedColumnName="ID")
	private Department department;
	
	public Seller(){
		
	}
	
	public Seller(Integer id, String name, String email, Double baseSalary, LocalDate birthDate, Department department) {
		this.id = id;
		this.name = name.toUpperCase();
		this.email = email.toUpperCase();
		this.baseSalary = baseSalary;
		this.birthDate = birthDate;
		this.department = department;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name.toUpperCase();
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email.toUpperCase();
	}
	
	public LocalDate getBirthDate(){
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate){
		this.birthDate = birthDate;
	}
	
	public Department getDepartment(){
		return department;
	}
	
	public void setDepartment(Department department){
		this.department = department;
	}
	
	@Override
	public String toString(){
		return "Seller=[" + id + "," + name + ","
				+ email + "," + dtf.format(birthDate) + ","
				+ String.format("%.2f", baseSalary) + ","
				+ department + "]";
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(name, birthDate);
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == this) return true;
		if (obj == null) return false;
		if (!(obj instanceof Seller)) return false;
		
		Seller sl = (Seller) obj;
		
		return id.equals(sl.id) && name.equals(sl.name) && email.equals(sl.email)
				&& baseSalary.equals(sl.baseSalary) && birthDate.equals(sl.birthDate)
				&& department.equals(sl.department);
	}
	
}