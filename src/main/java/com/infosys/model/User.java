package com.infosys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private long uid;
	
	
	@Column(name="user_name",nullable = false)
	@NotEmpty
	@Size(min = 3,message = "Name should not be less than 3 charcters")
	private String uname;
	
	@NotEmpty
	@Size(min = 8,message = "Password should have atleast 8 Characters")
	@Column(name="user_password")
	private String upassword;
	
	
	@Column(name="user_email")
	@Email(message = "Please Enter valid Email")
	private String uemail;
	
		
	
	
}
