package com.cocuklaricinbilisim.web.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "contact")
public @Data class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private int contactId;

	@Column(name = "isim")
	private String isim;

	@Column(name = "soy_isim")
	private String soyIsim;

	@Column(name = "tel_no")
	private String telNo;

	@Column(name = "e_posta")
	private String ePosta;

	@ManyToMany
	@JoinTable(name = "contact_ders", joinColumns = { @JoinColumn(name = "contact_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ders_id") })
	private List<Ders> dersler = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "yas_grubu_id")
	private YasGrubu yasgrup;
	
	
	

	public Contact() {

	}

	public Contact(String isim, String soyIsim, String telNo, String ePosta) {
		super();
		this.isim = isim;
		this.soyIsim = soyIsim;
		this.telNo = telNo;
		this.ePosta = ePosta;

	}

	public Contact(int contactId, String isim, String soyIsim, String telNo, String ePosta) {
		super();
		this.contactId = contactId;
		this.isim = isim;
		this.soyIsim = soyIsim;
		this.telNo = telNo;
		this.ePosta = ePosta;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contactId != other.contactId)
			return false;
		if (dersler == null) {
			if (other.dersler != null)
				return false;
		} else if (!dersler.equals(other.dersler))
			return false;
		if (ePosta == null) {
			if (other.ePosta != null)
				return false;
		} else if (!ePosta.equals(other.ePosta))
			return false;
		if (isim == null) {
			if (other.isim != null)
				return false;
		} else if (!isim.equals(other.isim))
			return false;
		if (soyIsim == null) {
			if (other.soyIsim != null)
				return false;
		} else if (!soyIsim.equals(other.soyIsim))
			return false;
		if (telNo == null) {
			if (other.telNo != null)
				return false;
		} else if (!telNo.equals(other.telNo))
			return false;
		if (yasgrup == null) {
			if (other.yasgrup != null)
				return false;
		} else if (!yasgrup.equals(other.yasgrup))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contactId;
		result = prime * result + ((dersler == null) ? 0 : dersler.hashCode());
		result = prime * result + ((ePosta == null) ? 0 : ePosta.hashCode());
		result = prime * result + ((isim == null) ? 0 : isim.hashCode());
		result = prime * result + ((soyIsim == null) ? 0 : soyIsim.hashCode());
		result = prime * result + ((telNo == null) ? 0 : telNo.hashCode());
		result = prime * result + ((yasgrup == null) ? 0 : yasgrup.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", isim=" + isim + ", soyIsim=" + soyIsim + ", telNo=" + telNo
				+ ", ePosta=" + ePosta + ", dersler=" + dersler + ", yasgrup=" + yasgrup + "]";
	}

	public String getePosta() {
		return ePosta;
	}

	public void setePosta(String ePosta) {
		this.ePosta = ePosta;
	}

}
