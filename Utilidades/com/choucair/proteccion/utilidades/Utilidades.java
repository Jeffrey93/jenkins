package com.choucair.proteccion.utilidades;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.beust.jcommander.internal.Maps;
import com.google.common.collect.Lists;



public class Utilidades {
	/**
	 * 
	 * @return La direccion IP de mi equipo.
	 */
	public static String getIP(){
		String result = null;
		try {
			result = InetAddress.getLocalHost().getHostAddress();
			System.out.println("IP:"+result);
		}
		catch(Exception e){
			result = "localhost";
			System.out.println("Exepcion al consultar mi IP. "+e.getMessage());
		}
		return result;
	}
	/**
	 * Este metodo intenta convertir un String a un double.
	 * 
	 * @param valor Vadena a convertir en nÃºmero (double).
	 * @return Valor numerico si el casting fue exitoso delo contrario retorna -1.0.
	 */
	public static double getValorDouble(String valor){
		if(valor.isEmpty()){
			return 0.0;
		}
		
		valor = valor.replace('$', ' ').trim();
		NumberFormat nf = NumberFormat.getInstance();
		try {
			return nf.parse(valor).doubleValue();
		} catch (ParseException e) {
			System.err.println("Error en cast "+valor+" ParseException: "+e.getMessage());
			return -1.0;
		}
	}
	/**
	 * 
	 * @param fecha a formatear
	 * @return Fecha en formato dd/MM/yyyy HH:mm:ss
	 */
	public static String getFecha(Date fecha){
		if(fecha == null){
			return "";
		}
		
		LocalDateTime fec = LocalDateTime.ofInstant(new Date(fecha.getTime()).toInstant(), ZoneId.systemDefault());
//		if(fec.getDayOfMonth() < 10){
//			String fecResult = fec.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")); 
//			return fecResult.substring(1, fecResult.length());
//		}
		//TODO Eliminar esto luego de que desarrollo modifique el formato de la hora. 
		String result = fec.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		int hora = Integer.parseInt(result.substring(11,13));
		if(hora < 10){
			result = result.substring(0, 11)+result.substring(12); 
		}
		
		return result;
	}
	/**
	 * 
	 * @param fecha A formatear.
	 * @return Fecha en formato dd/MM/yyyy sin hora.
	 */
	public static String getFechaLocal(LocalDate fecha){
		return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	/**
	 * 
	 * @param fecha A formatear.
	 * @return Fecha en formato dd/MM/yyyy sin hora.
	 */
	public static String getFechaLocal(Date fecha){
		if(fecha == null){
			return "";
		}
		LocalDateTime fec = LocalDateTime.ofInstant(new Date(fecha.getTime()).toInstant(), ZoneId.systemDefault());
		return fec.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	/**
	 * 
	 * @param fecha A formatear. 
	 * @return FEcha en formato ISO_LOCAL_DATE_TIME (2017-10-18T18:25:43.511).
	 */
	public static String getFechaJson(Date fecha){
		if(fecha == null){
			return "";
		}
		
		LocalDateTime fec = LocalDateTime.ofInstant(new Date(fecha.getTime()).toInstant(), ZoneId.systemDefault());
		return fec.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	
	public static Date getFecha(LocalDateTime fecha){
		if(fecha == null){
			return null;
		}
		
	    Instant instant = fecha.atZone(ZoneId.systemDefault()).toInstant();
	    return Date.from(instant);		
	}
	/**
	 * @param pText texto obtenido del tag <P> del mensaje que contiene el numero de solicitud del canal obtenido
	 */
	public static String numberFromTextMessage(String pText) {
		String reqNumber = "";
		String pattern = "\\d+";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(pText);

		if (m.find()) {
			reqNumber = pText.substring(m.start(), m.end());
			System.out.println("Obtener numero de solicitud ejecutado con exito :" + reqNumber);
		}else{
			System.out.println("Obtener numero de solicitud ejecutado con fallo");
		}
		return reqNumber;
	}
	/**
	 * 
	 * @param fecha fecha inicial a buscar.
	 * @return Numero del token enviado al email.
	 */
	public static String getToken(LocalDateTime fecha) {
		String result = "";
		ReadMail readEmail = new ReadMail("imap.gmail.com", 993, "notificacionessgipro@gmail.com", "Colombia2017");
		System.out.println("Ingresar al correo al correo");
		
		try{
			List<Filtro> filtros = Lists.newArrayList();
			filtros.add(new Filtro("clientes@proteccion.com.co", Filtro.Tipo.MAIL));
			filtros.add(new Filtro("Protección S.A - Código de Seguridad", Filtro.Tipo.ASUNTO));
			filtros.add(new Filtro(fecha));
			
			List<Mensaje> msns = readEmail.findMail(filtros);
			System.out.println("Lista vacia: "+msns.isEmpty());
			for(Mensaje msn : msns){
				result = Utilidades.numberFromTextMessage(msn.getAsunto());
				System.out.println("Leer mensaje");
				System.out.println(msn.getContenidoMsn());
				System.out.println(result);
				
				
			}
		}
		catch(MessagingException | IOException e){
			System.err.println("Error en RetiroTerminaContratoM1.getToken"+e.getMessage());
		}
		
		return result;
	}
	
	public static Map<String, String> getCredentials(String separador) {
		
		File file = new File("gradle.properties");
		String ruta = file.getAbsolutePath();		
		
		Map<String, String> result = Maps.newHashMap();
		ArchivoLeer credenciales = new ArchivoLeer(ruta);
		
		try {
			List<String> campos = credenciales.leerValoresUnicos();
			if(!campos.isEmpty()){
				for(String param : campos){
					String [] valores = param.split(separador);
					result.put(valores[0], valores[1]);
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de credenciales. -> "+e.getMessage());
			e.printStackTrace();
		}
			
		return result;
	}
	
	public static List<String> getSolicutudes(String ruta, String archivo) {
		Path path = Paths.get(ruta, archivo);
		Charset charset = Charset.forName("ISO-8859-1");
		List<String> result = null;
		try {
			List<String> lines = Files.readAllLines(path, charset);	
			result = lines;
		} catch (IOException e) {
			System.out.println(e);			
		}
		
		return result;
	}
	
	public static int nuevaCuenta() {
    	Random objGenerator = new Random();        
        int randomNumber = 111111111 + objGenerator.nextInt(1000000000);
        return randomNumber;
}
	
	public static int numeroRandom(int minimo, int maximo) {
    	Random objGenerator = new Random();        
        int randomNumber = minimo + objGenerator.nextInt(maximo);
        return randomNumber;
}
	
}
