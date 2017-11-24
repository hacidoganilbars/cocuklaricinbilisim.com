package com.cocuklaricinbilisim.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cocuklaricinbilisim.web.entity.Contact;
import com.cocuklaricinbilisim.web.entity.Ders;
import com.cocuklaricinbilisim.web.entity.YasGrubu;
import com.cocuklaricinbilisim.web.repository.IContactRepository;

@Service
public class ContactService {
	@Autowired
	IContactRepository repository;
	
	public void contactEkle(Contact contact) {
		repository.save(contact);	
	}
	
	public void contactDers(int id,Contact contact) {
		id=contact.getContactId();	
		repository.save(contact);
	}

	

}
