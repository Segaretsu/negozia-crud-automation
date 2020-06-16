package frontend
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webservice.verification.WSResponseManager
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import io.cucumber.datatable.DataTable
import models.UsuarioEntity
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.es.Y
import cucumber.api.java.es.Dado
import cucumber.api.java.es.Cuando
import cucumber.api.java.es.Entonces


class CrearUsuario {
	
	public static UsuarioEntity usuario;

	public static abrirNavegador(String url) {
		WebUI.openBrowser(url);
		WebUI.maximizeWindow();
		WebUI.waitForPageLoad(GlobalVariable.timeOut);
	}
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Dado("que diligencio el formulario con mi información personal")
	def diligencio_el_formulario(DataTable table) {
		this.abrirNavegador(GlobalVariable.url);
		this.dataTableToUsuarioEntity(table);
		WebUI.waitForElementVisible(findTestObject('frontend/usuarios/creacion/input_firstName'), GlobalVariable.timeOut);
		WebUI.setText(findTestObject('frontend/usuarios/creacion/input_firstName'), this.usuario.getNombres());
		WebUI.setText(findTestObject('frontend/usuarios/creacion/input_lastName'), this.usuario.getApellidos());
		WebUI.click(findTestObject('frontend/usuarios/creacion/radio_sexos', ['sex' : this.usuario.getSexo()]), FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.setText(findTestObject('frontend/usuarios/creacion/input_phone'), "" + this.usuario.getTelefono());
		WebUI.selectOptionByValue(findTestObject('frontend/usuarios/creacion/select_typePhone'), this.usuario.getTipoTelefono(), false);
		WebUI.setText(findTestObject('frontend/usuarios/creacion/input_mail'), this.usuario.getCorreo());
	}

	@Cuando("termino de diligenciar mi información doy clic en el botón guardar")
	def doy_clic_en_el_boton_guardar() {
		WebUI.waitForElementVisible(findTestObject('frontend/usuarios/creacion/button_save'), GlobalVariable.timeOut);
		WebUI.waitForElementClickable(findTestObject('frontend/usuarios/creacion/button_save'), GlobalVariable.timeOut);
		WebUI.click(findTestObject('frontend/usuarios/creacion/button_save'));
		WebUI.delay(GlobalVariable.delay);
	}

	@Entonces("verifico que mi usuario se haya guardado exitosamente")
	def verifico_que_mi_usuario_se_haya_guardado_exitosamente() {
		String nombreYApellido = this.usuario.getNombres() + " " + this.usuario.getApellidos();
		WebUI.verifyElementPresent(findTestObject("frontend/usuarios/verificacion/input_opciones", ['nombres': nombreYApellido]),GlobalVariable.timeOut, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject("frontend/usuarios/verificacion/input_opciones", ['nombres': nombreYApellido]), FailureHandling.STOP_ON_FAILURE);
		WebUI.waitForElementVisible(findTestObject("frontend/usuarios/verificacion/span_operaciones", ['nombres': nombreYApellido,'operacion': "edit"]), GlobalVariable.timeOut, FailureHandling.STOP_ON_FAILURE);
		WebUI.click(findTestObject("frontend/usuarios/verificacion/span_operaciones", ['nombres': nombreYApellido,'operacion': "edit"]));
		
		String _id = WebUI.getText(findTestObject("frontend/usuarios/creacion/input_id"));
		boolean wsF = WS.sendRequestAndVerify(findTestObject('Object Repository/backend/usuarios/getUsuarioById', ['_id': _id]));
		WebUI.delay(GlobalVariable.delay);
	}
	
	public static dataTableToUsuarioEntity (DataTable table) {
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		this.usuario = new UsuarioEntity();
		this.usuario.setNombres(data[0].nombres);
		this.usuario.setApellidos(data[0].apellidos);
		this.usuario.setSexo(data[0].sexo);
		this.usuario.setTelefono(Integer.parseInt(data[0].telefono));
		this.usuario.setTipoTelefono(data[0].tipoTelefono);
		this.usuario.setCorreo(data[0].correo);
	}
}