$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/frontend/usuarios/CreacionUsuario.feature");
formatter.feature({
  "name": "Creación de usuarios",
  "description": "  Prueba automatizada de creación de usuario básico",
  "keyword": "Característica",
  "tags": [
    {
      "name": "@CreacionDeUsuarios"
    }
  ]
});
formatter.scenario({
  "name": "Creación de usuarios en un mundo ideal, donde el usuario ingresa todo bien.",
  "description": "",
  "keyword": "Escenario",
  "tags": [
    {
      "name": "@CreacionDeUsuarios"
    },
    {
      "name": "@Correcto"
    }
  ]
});
formatter.step({
  "name": "que diligencio el formulario con mi información personal",
  "rows": [
    {
      "cells": [
        "nombres",
        "apellidos",
        "sexo",
        "telefono",
        "tipoTelefono",
        "correo"
      ]
    },
    {
      "cells": [
        "katalon S",
        "Automation test",
        "M",
        "4321678",
        "Home",
        "Katalon@prueba.com"
      ]
    }
  ],
  "keyword": "Dado "
});
formatter.match({
  "location": "CrearUsuario.diligencio_el_formulario(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "termino de diligenciar mi información doy clic en el botón guardar",
  "keyword": "Cuando "
});
formatter.match({
  "location": "CrearUsuario.doy_clic_en_el_boton_guardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verifico que mi usuario se haya guardado exitosamente",
  "keyword": "Entonces "
});
formatter.match({
  "location": "CrearUsuario.verifico_que_mi_usuario_se_haya_guardado_exitosamente()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Escenario Exitoso");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});