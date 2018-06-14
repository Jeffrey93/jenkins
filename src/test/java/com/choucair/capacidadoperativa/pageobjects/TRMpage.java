package com.choucair.capacidadoperativa.pageobjects;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://dolar.wilkinsonpc.com.co/widgets/oanda-convertidor-divisas-300x250-pub.php")
public class TRMpage extends PageObject{
	static Connection cnn;
	@FindBy(xpath = "//select[@id='base']")  
	public WebElementFacade base;	
	
	@FindBy(xpath = "//input[@id='quote_amount']")  
	public WebElementFacade val;

	public String trm(String Moneda) throws ParseException {
		waitFor(500).milliseconds();
		base.selectByValue(Moneda);
		waitFor(500).milliseconds();
		String trm=val.getTextValue();
		return(trm.replaceAll(",", ""));
	}

	public void imprimir() throws ParseException, IOException, SQLException {
//		System.out.println(trm("USD"));
//		System.out.println(trm("PEN"));
		String trsusd=trm("USD");
		String trspen=trm("PEN");
	 	Properties p = new Properties();
	 	p.load(new FileReader("src/test/resources/config.properties"));
	 	setConnection(p.getProperty("servidor"),p.getProperty("basededatos"),p.getProperty("usuario"),p.getProperty("password"));
	 	Inserta(cnn,trsusd,"USD","Dolar estadounidense");
	 	Inserta(cnn,trspen,"PEN","Nuevo Sol Peruano");
	 	closeConection();
	}
	public void setConnection(String strServidor, String strDatabase, String strUsuario, String strContrasena) {
		try {
			if(cnn==null)
			{	
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setUser(strUsuario);
				ds.setPassword(strContrasena);
				ds.setServerName(strServidor);
				ds.setPortNumber(1433);
				ds.setDatabaseName(strDatabase);
				cnn = ds.getConnection();
			}
		} catch (Exception e) {
			System.out.println("ERROR en setConnection: " + e.getMessage());
		}
	}	
	public void closeConection() throws SQLException{
		cnn.close();
	}
	public void Inserta(Connection cnn,String trm,String moneda,String comentario) {
		StringBuilder consulta = new StringBuilder();
		consulta.append("insert into Gen_TRM(FechaCaptura,CodigoDivisa,Moneda,Valor)\r\n" + 
				"values(GETDATE(),'"+moneda+"','"+comentario+"',"+trm+") ");
		try {
			cnn.createStatement().executeQuery(consulta.toString());
			System.out.println("Se realiza efectiva la consulta");
		} catch (SQLException e) {
			
			System.out.println("ERROR en LeerDatosRegistro: " + e.getMessage()+" -- "+consulta.toString());
			e.printStackTrace();
		}
	}
}