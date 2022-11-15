package com.br.api.DTO;

public class ClientsDTO {
	private String name;
	private String Cpf;
	private String address;
	private int id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return Cpf;
	}
	
	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
