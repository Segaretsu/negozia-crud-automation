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

public class Reportes {
	@Keyword
	def generarReporte(String jsonDir, String repPath, String timeIni, String timeFin, titulo){
		Runtime rt = Runtime.getRuntime()
		//def commands = ["node","multi"]
		def String sSistemaOperativo = System.getProperty("os.name");
		def String vSistemaOperativo = System.getProperty("os.version");
		def command = "node multi" + ' ' + jsonDir + ' ' + repPath +' "' + timeIni + '" "'+ timeFin +'" ' + sSistemaOperativo +' ' + vSistemaOperativo +' "'+ titulo+'"'
		Process proc = rt.exec(command)
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()))
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream())) // read the output from the command
		println("Here is the standard output of the command:\n")
		def String s = null
		while ((s = stdInput.readLine()) != null) { System.out.println(s) } // read any errors from the attempted command
		println("Here is the standard error of the command (if any):\n")
		while ((s = stdError.readLine()) != null) { System.out.println(s) }
	}

}
