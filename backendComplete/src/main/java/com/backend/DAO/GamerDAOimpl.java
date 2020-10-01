package com.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.backend.entity.Gamer;

@Repository
public class GamerDAOimpl implements GamerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveGamer(Gamer theGamer) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		String hashed_password="{bcrypt}"+hashPassword(theGamer.getCredentials().getPassword());
		
		theGamer.getCredentials().setPassword(hashed_password);
		
		currentSession.saveOrUpdate(theGamer.getGamerProfile());
		
		theGamer.getGamerProfile().addCredentials(theGamer.getCredentials());
		
		currentSession.saveOrUpdate(theGamer.getCredentials());
		
	}
	
	
	
	private String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(10);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return hashed_password;
	}

}
