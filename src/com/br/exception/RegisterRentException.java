package com.br.exception;

public class RegisterRentException extends Exception{
	private static final long serialVersionUID = 1L;
	public RegisterRentException() {
		super("Quantidade indisponível");
	}
}
