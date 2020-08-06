package com.esig.controller;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.esig.domain.Registro;
import com.esig.repositories.RegistroRepository;

@Named
@SessionScoped
public class RegistroController {

	@Autowired
	private RegistroRepository repo;

	private Registro registro = new Registro();
	private List<Registro> listaRegistro;

	public void insert() {
		if (registro.getDescricao() != null && registro.getDescricao().trim() != "") {
			if (registro.getId() == null) {
				registro.setStatus(false);
			}
			repo.save(registro);
		}

	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public List<Registro> getListaRegistro() {
		return listaRegistro;
	}

	public void setListaRegistro(List<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}
	
	

}
