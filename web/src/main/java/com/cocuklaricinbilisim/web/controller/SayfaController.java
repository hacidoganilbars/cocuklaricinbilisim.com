package com.cocuklaricinbilisim.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cocuklaricinbilisim.web.entity.Contact;
import com.cocuklaricinbilisim.web.entity.Ders;
import com.cocuklaricinbilisim.web.entity.YasGrubu;
import com.cocuklaricinbilisim.web.service.ContactService;
import com.cocuklaricinbilisim.web.service.DersService;
import com.cocuklaricinbilisim.web.service.YasGrubuService;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.Gson;

@Controller
public class SayfaController {

	@Autowired
	ContactService contactService;
	
	@Autowired
	YasGrubuService yasGrubuService;
	
	@Autowired
	DersService dersService;

	@RequestMapping(path = "/contactekle")
	@ResponseBody
	public String contactEkle(String isim, String soyIsim, String telefon, String ePosta) {
		isim = "Muammer";
		soyIsim = "Akbaba";
		telefon = "054332221";
		ePosta = "makba@hotmail.com";

		Contact contact = new Contact(isim, soyIsim, telefon, ePosta);
		contactService.contactEkle(contact);
		return "başarılı";
	}
	
	@RequestMapping(path = "/grupekle")
	@ResponseBody
	public String yasGrubuEkle(String yasGrubu) {
		yasGrubu="20-30";
	YasGrubu yasGrubu2=new YasGrubu(yasGrubu);
	yasGrubuService.yasGrubuEkle(yasGrubu2);
		return "başarılı";
	}
	
	@RequestMapping(path = "/dersekle")
	@ResponseBody
	public String dersEkle(String dersAdi) {
		dersAdi="Müzik";
	Ders ders=new Ders(dersAdi);
	dersService.dersEkle(ders);
		return "başarılı";
	}

//	@GetMapping(path = "/yasgrubuekle.json")
//	@ResponseBody
//	public String yasGrubuEkleJson(@ModelAttribute YasGrubu yasGrubu) {
//		yasGrubuService.yasGrubuEkle(yasGrubu);
//		Gson gson = new Gson();
//		return gson.toJson("Yaş Grubu eklendi");
//}
	
//	@GetMapping(path = "/dersekle.json")
//	@ResponseBody
//	public String yasGrubuEkleJson(@ModelAttribute Ders ders) {
//		dersService.dersEkle(ders);
//		Gson gson = new Gson();
//		return gson.toJson("Ders eklendi");
//}

	
	
	@GetMapping(path = "/contactekle.json")
	@ResponseBody
	public String contactEkleJson(@ModelAttribute Contact contact) {
		Gson gson = new Gson();
		//gson.toJson(contact);
		contactService.contactEkle(contact);
		return gson.toJson("Contact Ekleme Başarılı");
}
	
	@GetMapping(path = "/contactders.json")
	@ResponseBody
	@Query("select c from Contact c Where contact_id: id")
	public String contactDersSec( int id, @ModelAttribute Contact contact,@ModelAttribute List<Ders>dersler) {
		contact.getDersler().add((Ders) dersler);
		Gson gson = new Gson();
		//gson.toJson(contact);
	    id=contact.getContactId();
	    contactService.contactDers(id, contact);
		return gson.toJson("Dersler Ekleme Başarılı");
}
	
	@GetMapping(path = "/index.haci")
	public String index(Model model) {
		return "index";
	}
	@GetMapping(path = "/student.haci")
	public String student(Model model) {
		return "student";
	}
	@GetMapping(path = "/contact.haci")
	public String contact(Model model) {
		return "contact";
	}
	@GetMapping(path = "/course.haci")
	public String course(Model model) {
		return "course";
	}
	@GetMapping(path = "/event.haci")
	public String event(Model model) {
		return "event";
	}
	@GetMapping(path = "/dersliste.haci")
	public String dersliste(Model model) {
		return "dersliste";
	}
	@GetMapping(path = "/contact2.haci")
	public String contact2(Model model) {
		return "contact2";
	}
	
	

}
