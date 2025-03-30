package me.silvernine.tutorial.service;


import org.springframework.stereotype.Service;

import me.silvernine.tutorial.dto.response.EjemploResponse;


@Service
public class EjemploService {


	public EjemploResponse get(String datos) {
		EjemploResponse response = new EjemploResponse();
		response.setTexto(datos);
		return response;
	}


	public EjemploResponse get() {
		EjemploResponse response = new EjemploResponse();
		response.setTexto("Response");
		return response;
	}


	public EjemploResponse put(String name) {
		EjemploResponse response = new EjemploResponse();
		response.setTexto(name);
		return response;
	}

}
