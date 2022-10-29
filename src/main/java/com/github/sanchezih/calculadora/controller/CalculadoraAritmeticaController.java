package com.github.sanchezih.calculadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.sanchezih.domain.dto.ResponseDTO;

@RestController
@RequestMapping("/aritmetica")
public class CalculadoraAritmeticaController {

	public CalculadoraAritmeticaController() {
	}

	@RequestMapping(value = "/suma", method = RequestMethod.GET, params = { "numero1",
			"numero2" }, produces = "application/json")
	public ResponseDTO sumar(@RequestParam("numero1") Integer numero1, @RequestParam("numero2") Integer numero2) {
		return new ResponseDTO(numero1 + numero2, "Ok");
	}

	@RequestMapping(value = "/resta", method = RequestMethod.GET, params = { "numero1",
			"numero2" }, produces = "application/json")
	public ResponseDTO restaR(@RequestParam("numero1") Integer numero1, @RequestParam("numero2") Integer numero2) {
		return new ResponseDTO(numero1 - numero2, "Ok");
	}

	@RequestMapping(value = "/multiplicacion", method = RequestMethod.GET, params = { "numero1",
			"numero2" }, produces = "application/json")
	public ResponseDTO multiplicar(@RequestParam("numero1") Integer numero1, @RequestParam("numero2") Integer numero2) {
		return new ResponseDTO(numero1 * numero2, "Ok");
	}

	@RequestMapping(value = "/division", method = RequestMethod.GET, params = { "numero1",
			"numero2" }, produces = "application/json")
	public ResponseDTO dividir(@RequestParam("numero1") Integer numero1, @RequestParam("numero2") Integer numero2)
			throws Exception {

		if (numero2 == 0) {
			return new ResponseDTO("E","Error, division por cero");
		}

		return new ResponseDTO(numero1 / numero2, "Ok");
	}

	@RequestMapping(value = "/potencia", method = RequestMethod.GET, params = { "exponente",
			"base" }, produces = "application/json")
	public ResponseDTO potencia(@RequestParam("exponente") Integer exponente, @RequestParam("base") Integer base) {
		return new ResponseDTO(potenciaFunc(base, exponente), "Ok");
	}

	@RequestMapping(value = "/raiz", method = RequestMethod.GET, params = { "indice",
			"radicando" }, produces = "application/json")
	public ResponseDTO raiz(@RequestParam("indice") Integer indice, @RequestParam("radicando") Integer radicando)
			throws Exception {

		if (indice % 2 == 0 && radicando < 0) {
			return new ResponseDTO(null, "Error, no existen raices cuando el indice es par y el radicando negativo");
		}

		return new ResponseDTO(potenciaFunc(radicando, (double) 1 / indice), "Ok");
	}

	@RequestMapping(value = "/factorial", method = RequestMethod.GET, params = {
			"operando" }, produces = "application/json")
	public ResponseDTO factorial(@RequestParam("operando") Integer n) {
		return new ResponseDTO(factorialFunc(n), "Ok");
	}

	private Integer potenciaFunc(Integer base, double exponente) {
		return (int) Math.pow(base, exponente);
	}

	private Integer factorialFunc(Integer n) {
		return n < 2 ? 1 : n * factorialFunc(n - 1);
	}
}
