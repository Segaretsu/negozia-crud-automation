package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Direcciones {
	public static String sistemaOperativo = System.getProperty("os.name").toLowerCase();

	@Keyword
	public static String getDireccionActual () {
		if(SOesWindows()){
			return System.getProperty("user.dir")
		} else if (SOesLinux()) {
			return "/" + System.getProperty("user.dir")
		} else {
			return System.getProperty("user.dir")
		}
	}

	@Keyword
	public static String getSlashOS(String direccion){
		try{
			if(SOesWindows()){
				//Sistema operativo Windows
				return direccion.replaceAll("/", File.separator);
			} else if (SOesLinux()){
				//Otro sistema operativo
				return direccion.replaceAll("\\\\", "/");
			} else {
				return direccion.replaceAll("/", File.separator);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Keyword
	public static String getDireccionReporteNodeJS(){
		String direccionReporteIncompleta = this.getSlashOS(this.getDireccionActual() + "/reportecucumber/cucumber.html");
		String direccionReporteCompleta = "file:///" + direccionReporteIncompleta;
		return direccionReporteCompleta;
	}

	@Keyword
	public static String getDireccionImagenDeEjemplo(){
		String direccionCompletaDeImagen = this.getSlashOS(this.getDireccionActual() + "\\Imagenes\\Fotocopia_cedula_ciudadania.jpg");
		return direccionCompletaDeImagen;
	}

	@Keyword
	public static String getDireccionPDF(){
		String direccionCompletaDeImagen = this.getSlashOS(this.getDireccionActual() + "\\Imagenes\\ARL.pdf");
		return direccionCompletaDeImagen;
	}

	/*TIPOS DE SISTEMAS OPERATIVOS*/

	public static boolean SOesWindows(){
		return sistemaOperativo.indexOf("win") >= 0;
	}

	public static boolean SOesLinux(){
		return (sistemaOperativo.indexOf("nix") >= 0 || sistemaOperativo.indexOf("nux") >= 0 || sistemaOperativo.indexOf("aix") > 0);
	}
}
