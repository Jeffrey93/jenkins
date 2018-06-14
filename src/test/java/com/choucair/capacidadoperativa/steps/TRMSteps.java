package com.choucair.capacidadoperativa.steps;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.choucair.capacidadoperativa.pageobjects.TRMpage;

import net.thucydides.core.annotations.Step;


public class TRMSteps {

	TRMpage TRmPage;
	
	@Step
	public void trm() throws ParseException, IOException, SQLException {
		TRmPage.open();
		TRmPage.imprimir();
	}
}
