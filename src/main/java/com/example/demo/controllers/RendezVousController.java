package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.RendezVous;
import com.example.demo.services.ServiceRendezVous;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RendezVousController {

	private final ServiceRendezVous serviceRendezVous;

	public RendezVousController(ServiceRendezVous serviceRendezVous) {
		this.serviceRendezVous = serviceRendezVous;
	}
	
	@GetMapping("/rvs")
	public ResponseEntity<List<RendezVous>> getAllRvs(){
		List<RendezVous> rvs = serviceRendezVous.getAllRvs();
		return new ResponseEntity<List<RendezVous>>(rvs, HttpStatus.OK);
	}
	
	@GetMapping("/rechercher/{id}")
	public ResponseEntity<RendezVous> rechercherRv(@PathVariable("id") Long id){
		RendezVous rv = (RendezVous) serviceRendezVous.trouverRvParId(id);
		return new ResponseEntity<RendezVous>(rv, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<RendezVous> supprimerRv(@PathVariable("id") Long id){
		serviceRendezVous.supprimerUnRv(id);
		return new ResponseEntity<RendezVous>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<RendezVous> ajouterRv(@RequestBody RendezVous rv){
		RendezVous  newRv = serviceRendezVous.ajouterRV(rv);
		return new  ResponseEntity<RendezVous>(newRv, HttpStatus.CREATED);
	}
	
	@PutMapping("/modifier")
	public ResponseEntity<RendezVous> miseajourRv(@RequestBody RendezVous rv){
		RendezVous updateRv = serviceRendezVous.updateRV(rv);
		return new ResponseEntity<RendezVous>(updateRv, HttpStatus.OK);
	}
	
}
