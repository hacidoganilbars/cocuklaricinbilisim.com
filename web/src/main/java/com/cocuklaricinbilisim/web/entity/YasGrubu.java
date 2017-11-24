package com.cocuklaricinbilisim.web.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "yas_grubu")
public @Data class YasGrubu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "yas_grubu_id")
	private int yasGrubuId;

	@Column(name = "yas_grubu")
	private String yasGrubu;

	@OneToMany(mappedBy="yasgrup",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Contact> contacts = new ArrayList<>();

	public YasGrubu() {

	}

	public YasGrubu(String yasGrubu) {
		super();
		this.yasGrubu = yasGrubu;
	}

	public YasGrubu(int yasGrubuId, String yasGrubu) {
		super();
		this.yasGrubuId = yasGrubuId;
		this.yasGrubu = yasGrubu;
	}

	public YasGrubu(int yasGrubuId) {
		super();
		this.yasGrubuId = yasGrubuId;
	}

	@Override
	public String toString() {
		return "YasGrubu [yasGrubuId=" + yasGrubuId + ", yasGrubu=" + yasGrubu + "]";
	}


}
