package es.cic.bootcamp.ejercicio007.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.bootcamp.ejercicio007.Exception.CocheException;

class CocheServiceTest {
	private CocheService cut;
	private MotorCombustionService dependencia1;
	private MotorElectricoService dependencia2;
	@BeforeEach
	void setUp() throws Exception {
		cut= new CocheService();
		this.dependencia1= mock(MotorCombustionService.class);
		this.dependencia2= mock(MotorElectricoService.class);
		cut.setMotorCombustionService(dependencia1);
		cut.setMotorElectricoService(dependencia2);
	}

	@Test
	void testArrancar() throws CocheException {
		when(dependencia2.arrancar()).thenReturn(20);
		int potencia= cut.arrancar();
		assertTrue(potencia >= 20, String.format("La potencia del motor debe ser al menos 20 pero era %d",potencia));
		verify(dependencia2, times(1)).arrancar();
	}

}
