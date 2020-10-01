package com.backend.entity;



import javax.validation.Valid;





public class Gamer  {
	
	@Valid
	private Credentials credentials;
	
	@Valid
	private GamerProfile gamerProfile;
	
	
	public Gamer() {
		this.credentials=new Credentials();
		this.gamerProfile=new GamerProfile();
	}


	public Credentials getCredentials() {
		return credentials;
	}


	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}


	public GamerProfile getGamerProfile() {
		return gamerProfile;
	}


	public void setGamerProfile(GamerProfile gamerProfile) {
		this.gamerProfile = gamerProfile;
	}
	
	
	
	
}
