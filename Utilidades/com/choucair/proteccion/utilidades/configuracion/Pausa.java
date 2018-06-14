package com.choucair.proteccion.utilidades.configuracion;

import org.junit.Test;

public class Pausa {
	
	@Test
	public void PausarProceso(){
		try {
			// Se espera 5 Minutos, dando espera que sea procesado el registro GPM.
			System.out.println("---------------------------------------------------------");
			System.out.println("Esperando 5 minutos por procesos previos.");
//			Thread.sleep(300000);
			Thread.sleep(300);
			System.out.println("---------------------------------------------------------");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
