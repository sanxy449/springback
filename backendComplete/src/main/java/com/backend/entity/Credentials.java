package com.backend.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name="credentials")
public class Credentials {
	
	
	@NotNull(message="It is required")
	@Size(min=1,max=20,message="Limit is 20 characters")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="Enter a valid username")
	@Id
	@Column(name="username")
	private String username;
	
	@NotNull(message="It is required")
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private int enabled=1;
	
	@ManyToMany(mappedBy="credentials")
	private List<GamerProfile> gamerProfile;
	
	public Credentials() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;//"{bcrypt}"+hashPassword(password);//ayto prepei na paei sto DAO giati edw yparxei problima
		/*try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			String encryptedPass = new String(messageDigest.digest());
			this.password="{sha256}"+encryptedPass;
		}
		catch (NoSuchAlgorithmException e) {
			System.out.println("no such algorithm exists!!");
		}*/
		
	}
	
	

	public List<GamerProfile> getGamerProfile() {
		return gamerProfile;
	}

	public void setGamerProfile(List<GamerProfile> gamerProfile) {
		this.gamerProfile = gamerProfile;
	}

	public void addGamerProfile(GamerProfile theProfile) {
		if(gamerProfile==null) {
			gamerProfile=new ArrayList<>();
		}
		gamerProfile.add(theProfile);
	}
	
	
}
