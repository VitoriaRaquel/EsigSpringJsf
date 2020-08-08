package com.esig.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esig.domain.Registro;
import com.esig.repositories.RegistroRepository;

@Service
public class RegistroService {

	@Autowired
	private RegistroRepository repo;

	public Registro insert(Registro obj) {
		obj.setId(null);
		obj.setStatus(false);
		obj = repo.save(obj);
		return obj;
	}

	public List<Registro> findAll() {
		return repo.findAll();
	}

	
	public List<Registro> findAllByStatus(Boolean b) {
		return repo.findByStatus(b);
	}

	public void deleteById(Integer id) {
		repo.delete(id);
	}

	public void deleteAllStatusCompleted() {
		this.repo.deleteAllStatusCompleted();
	
	}
	
	public void updateStatus(Integer id) {
		Registro obj = repo.findOne(id);
		obj.setStatus((!obj.getStatus()) ? true : false);
		repo.save(obj);
	}

}
