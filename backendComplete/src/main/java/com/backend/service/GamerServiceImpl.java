package com.backend.service;

import com.backend.entity.Gamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.DAO.GamerDAO;

@Service
public class GamerServiceImpl implements GamerService {

	
	@Autowired
	private GamerDAO gamerDAO;
	
	
	
	
	
	@Override
	@Transactional
	public void saveGamer(Gamer theGamer) {
		
		gamerDAO.saveGamer(theGamer);
		
	}

}
