package model.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Department")
@Table(name = "DEPARTMENT")
//@SQLInsert( sql = "INSERT INTO DEPARTMENT (NAME) VALUES(upper(?))")
//@SQLUpdate( sql = "UPDATE DEPARTMENT SET NAME = upper(?) WHERE ID = ?")
//@SQLDelete( sql = "DELETE FROM DEPARTMENT WHERE ID = ?")
//@SQLDeleteAll( sql = "DELETE * FROM DEPARTMENT")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
//	@OneToMany(fetch=FetchType.LAZY)
//	private List<Seller> sellers = new ArrayList<>();
	
	public Department(){
		
	}
	
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name.toUpperCase();
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
	
//	public List<Seller> getSellers(){
//		return sellers;
//	}
	
	@Override
	public String toString(){
		return "Department=[" + id + "," + name + "]";
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == this) return true;
		if (obj == null) return false;
		if (!(obj instanceof Department)) return false;
		
		Department dp = (Department) obj;
		
		return id.equals(dp.id) && name.equals(dp.name);
	}
	
}