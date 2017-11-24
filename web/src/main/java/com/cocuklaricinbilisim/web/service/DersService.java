package com.cocuklaricinbilisim.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cocuklaricinbilisim.web.entity.Ders;
import com.cocuklaricinbilisim.web.repository.IDersRepository;

@Service
public class DersService {
	
	@Autowired
	IDersRepository repository;
	
	public void dersEkle(Ders ders) {
		repository.save(ders);
	}


}
