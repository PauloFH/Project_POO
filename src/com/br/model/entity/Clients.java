package com.br.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

<<<<<<< HEAD
import com.br.api.DTO.ClientsDTO;

=======
>>>>>>> 74516812bba18665df02bc597ef1c829bb497aa8
public class Clients{
    // implements Book
    protected static int numbClients;
    private int id;
    private String name;
    private String address;
    private String cpf;

    static List<Clients> bd = new ArrayList<Clients>();



        /*Métodos Set  e Get */
    public void setAddress(String address) {
        if(address != null&& !address.isEmpty()){
        this.address = address;
        }
    }
    

    public void setCpf(String cpf) {
        if(cpf != null && !cpf.isEmpty()){
        this.cpf = cpf;
        }
    }
    public void setName(String name) {
        if(name != null && !name.isEmpty()){
        this.name = name;
        }
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public String getCpf() {
        return cpf;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public static Clients converter(ClientsDTO dto) {
    	Clients client = new Clients();
    	try {
  		  client.setName(dto.getName());
  		client.setCpf(dto.getCpf());
  		client.setAddress(dto.getAddress());
  	} catch (Exception e) {
  		JOptionPane.showMessageDialog(null,"Erro: "+e);
  	}
  		return client;
	}
  		
  	}