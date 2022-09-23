package com.github.sanchezih.calculadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aritmetica")
public class CalculadoraAritmeticaController {

	public CalculadoraAritmeticaController() {
	}

	@RequestMapping(value = "/sumar", method = RequestMethod.GET, params = { "operando1", "operando2" })
	public Integer sumar(@RequestParam("operando1") Integer operando1, @RequestParam("operando2") Integer operando2) {
		return operando1 + operando2;
	}

	@RequestMapping(value = "/multiplicar", method = RequestMethod.GET, params = { "operando1", "operando2" })
	public Integer multiplicar(@RequestParam("operando1") Integer operando1,
			@RequestParam("operando2") Integer operando2) {
		return operando1 * operando2;
	}
}