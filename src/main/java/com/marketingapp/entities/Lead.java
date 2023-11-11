package com.marketingapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leads") //database table name  //class name and database table name not same beacuse of extra @Table annotation
public class Lead {
	@Id  //beacuse id is primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // beacuse, of auto increment
private long id;
@Column(name="first_name",length=45,nullable=false)	
//column name and variable name should not same. nullable beacuse -it's cann't be empty.
private String firstName;
@Column(name="last_name",length=45,nullable=false)
private String lastName;
@Column(name="email",length=128,nullable=false,unique = true)
//unique act as primary key
private String email;
@Column(name="mobile",length=15,nullable=false,unique=true)
private String mobile;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}


}
