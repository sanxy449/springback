package com.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.backend.validation.BirthdayConstraints;

@Entity
@Table(name="person")
public class GamerProfile {

	
	@ManyToMany
	@JoinTable(
			name="credentials_person",
			joinColumns=@JoinColumn(name="email"),
			inverseJoinColumns=@JoinColumn(name="username")
	)
	private List<Credentials> credentials;//=new ArrayList<Credentials>();
	
	@Id
	@Column(name="email")
	private String email;
	
	@NotNull(message="It is required")
	@Column(name="birthday")
	@BirthdayConstraints(message="Enter a valid date")
	private String birthday;
	
	@NotNull(message="It is required")
	@Pattern(regexp="^[a-zA-Z]*$",message="Enter a valid name")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="It is required")
	@Pattern(regexp="^[a-zA-Z]*$",message="Enter a valid name")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="It is required")
	@Transient
	private String password2;
	
	@Pattern(regexp="^[0-9]*$",message="Please enter a valid number")
	@NotNull(message="It is required")
	@Size(min=10,max=10,message="Please enter a valid number")
	@Column(name="phone")
	private String phone;
	
	public GamerProfile() {
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
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


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Credentials> getCredentials() {
		return credentials;
	}


	public void setCredentials(List<Credentials> credentials) {
		this.credentials = credentials;
	}
	
	public void addCredentials(Credentials theCredential) {
		if(credentials==null) {
			credentials=new ArrayList<>();
		}
		credentials.add(theCredential);
	}
	
}
