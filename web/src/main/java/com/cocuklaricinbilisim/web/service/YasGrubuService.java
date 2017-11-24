package com.cocuklaricinbilisim.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cocuklaricinbilisim.web.entity.YasGrubu;
import com.cocuklaricinbilisim.web.repository.IYasGrubuRepository;

@Service
public class YasGrubuService {

	@Autowired
	IYasGrubuRepository repository;

	public void yasGrubuEkle(YasGrubu yasGrubu) {
		repository.save(yasGrubu);
	}

}
