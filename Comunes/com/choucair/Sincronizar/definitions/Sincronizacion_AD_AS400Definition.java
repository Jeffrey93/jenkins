package com.choucair.Sincronizar.definitions;

import org.junit.runner.RunWith;
import org.sikuli.script.FindFailed;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import com.choucair.Sincronizar.pageobjects.Sincronizacion_AD_AS400PageObject;

public class Sincronizacion_AD_AS400Definition  {

	@Steps
	Sincronizacion_AD_AS400PageObject sincronizacion_AD_AS400PageObject=new Sincronizacion_AD_AS400PageObject();
	
	@Given("^Cargar datos del usuario a crear$")
	public void cargar_datos_del_usuario_a_crear() throws InterruptedException, FindFailed{
		//Funcion que recibe las variables servidor, usuario y clave
		sincronizacion_AD_AS400PageObject.loginADPruebas("10.65.1.120", "omorale", "Choucair43");
	}

	@When("^Crear Nuevo Usuario$")
	public void crear_Nuevo_Usuario(){

	}

	@When("^Agregar a grupo AS$")
	public void agregar_a_grupo_AS()  {

	}

	@When("^Ingresar al AS$")
	public void ingresar_al_AS() {

	}

	@When("^Ejecutar Bacth Sincronizacion$")
	public void ejecutar_Bacth_Sincronizacion()
	{

	}

	@When("^Buscar Usuario Creado$")
	public void buscar_Usuario_Creado(){

	}

	@Then("^Visualizar Usuario Creado$")
	public void visualizar_Usuario_Creado() {
	
	}

}
