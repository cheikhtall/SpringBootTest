package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RvNotFoundException;
import com.example.demo.models.RendezVous;
import com.example.demo.repo.RendezVousRepo;

@Service
@Transactional
public class ServiceRendezVous {
	private  final RendezVousRepo rendezVousRepo;
	
	@Autowired
	public ServiceRendezVous(RendezVousRepo rendezVousRepo) {
		this.rendezVousRepo=rendezVousRepo;
	}
	
	public RendezVous ajouterRV(RendezVous rv) {
		rv.setCodeRV(UUID.randomUUID().toString());
		return rendezVousRepo.save(rv);
	}
	
	public RendezVous updateRV(RendezVous rv) {
		return rendezVousRepo.save(rv);
	}
	
	public List<RendezVous> getAllRvs(){
		return rendezVousRepo.findAll();
	}
	
	public void supprimerUnRv(Long id) {
		rendezVousRepo.deleteById(id);
	}
	
	public RendezVous trouverRvParId(Long id) {
		return rendezVousRepo.findById(id)
		.orElseThrow(()-> new RvNotFoundException("RV avec id "+ id +" non touvé"));
	}
	
	
	
}