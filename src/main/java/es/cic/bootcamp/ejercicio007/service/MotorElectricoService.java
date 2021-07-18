package es.cic.bootcamp.ejercicio007.service;

import org.springframework.stereotype.Service;

@Service
public class MotorElectricoService {

	public int arrancar() {
		return (int) Math.floor(Math.random()*(40-5+1)+5);
	}
	
}
