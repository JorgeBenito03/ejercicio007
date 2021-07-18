package es.cic.bootcamp.ejercicio007.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.cic.bootcamp.ejercicio007.Exception.CocheException;

@Service
public class CocheService {

	@Autowired
	private MotorCombustionService motorCombustionService;
	
	@Autowired
	private MotorElectricoService motorElectricoService;
	
	public int arrancar() throws CocheException {
		int potenciaFinal;
		potenciaFinal= motorElectricoService.arrancar();
		if(potenciaFinal< 20) {
			potenciaFinal+= motorCombustionService.arrancar();
		}
		if(potenciaFinal< 20) {
			throw new CocheException("El coche no arranco por que la potencia no llego a 20");
		}
		return potenciaFinal;
	}

	public void setMotorCombustionService(MotorCombustionService motorCombustionService) {
		this.motorCombustionService = motorCombustionService;
	}

	public void setMotorElectricoService(MotorElectricoService motorElectricoService) {
		this.motorElectricoService = motorElectricoService;
	}
	
	
	
}
