package com.github.sanchezih.domain.dto;

public class ResponseDTO {

	private Object resultado;

	private String mensaje;

	public ResponseDTO(Object resultado, String mensaje) {
		this.resultado = resultado;
		this.mensaje = mensaje;
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
