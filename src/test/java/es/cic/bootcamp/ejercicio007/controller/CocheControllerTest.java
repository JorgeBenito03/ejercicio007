package es.cic.bootcamp.ejercicio007.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.bootcamp.ejercicio007.Exception.CocheException;
import es.cic.bootcamp.ejercicio007.service.CocheService;

class CocheControllerTest {
	private CocheController cut;
	private CocheService dependencia;
	@BeforeEach
	void setUp() throws Exception {
		cut= new CocheController();
		this.dependencia=mock(CocheService.class);
		cut.setCocheService(dependencia);
	}

	@Test
	void testEncender() throws CocheException {
		when(dependencia.arrancar()).thenReturn(20);
		int potencia= cut.encender();
		assertTrue(potencia >= 20, String.format("La potencia del motor debe ser al menos 20 pero era %d",potencia));
		verify(dependencia, times(1)).arrancar();
	}

}
