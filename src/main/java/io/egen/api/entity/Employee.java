package io.egen.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name="Employee.findAll" ,query="Select e from Employee e"),
		@NamedQuery(name="Employee.findByEmail" ,query="Select e from Employee e where e.email = :pEmail")		
		})
public class Employee {

		@Id
		private String id;
		private String name;
		private String city;
		private int salary;
		
		@Column(unique=true)
		private String email;
		
		public Employee()
		{
			this.id = UUID.randomUUID().toString();
		}
		
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		
	
	
}
