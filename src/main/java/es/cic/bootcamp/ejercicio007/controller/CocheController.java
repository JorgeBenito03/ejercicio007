package es.cic.bootcamp.ejercicio007.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.bootcamp.ejercicio007.Exception.CocheException;
import es.cic.bootcamp.ejercicio007.service.CocheService;

@RestController
public class CocheController {

	@Autowired
	private CocheService cocheService;
	
	public void setCocheService(CocheService cocheService) {
		this.cocheService = cocheService;
	}

	@GetMapping("/encender")
	public int encender() throws CocheException {
		try {
			int potencia= cocheService.arrancar();
			return potencia;
		}catch(CocheException e) {
			throw new CocheException("El coche no arranca porque no llega a la potencia minima",e);
		}
	
	}
	
}
