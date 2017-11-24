package com.cocuklaricinbilisim.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cocuklaricinbilisim.web.entity.Contact;
import com.cocuklaricinbilisim.web.entity.YasGrubu;

public interface IContactRepository extends JpaRepository<Contact, Integer> {

	


}
