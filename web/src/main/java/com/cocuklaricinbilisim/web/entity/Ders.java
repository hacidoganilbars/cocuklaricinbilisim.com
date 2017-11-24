package com.cocuklaricinbilisim.web.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity(name = "ders")
public @Data class Ders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ders_id")
	private int dersId;

	@Column(name = "ders_adi")
	private String dersAdi;
	
	@ManyToMany(mappedBy="dersler")
	private List<Contact> contacts=new ArrayList<>();

	public Ders() {

	}

	public Ders(String dersAdi) {
		super();
		this.dersAdi = dersAdi;
	}

	public Ders(int dersId, String dersAdi) {
		super();
		this.dersId = dersId;
		this.dersAdi = dersAdi;
	}

	/*
	 * @ManyToMany private List<Contact> contacts=new ArrayList<>();
	 */

}
