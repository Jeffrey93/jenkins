package com.choucair.capacidadoperativa.steps;

import java.awt.AWTException;
import java.io.IOException;

import com.choucair.capacidadoperativa.pageobjects.ContaiPage;

import net.thucydides.core.annotations.Step;

public class ContaiSteps {

	ContaiPage contaiPage;
	@Step
	public void AbrirAplicativo() throws IOException, AWTException {
	 contaiPage.abrirprograma();
	}
}
