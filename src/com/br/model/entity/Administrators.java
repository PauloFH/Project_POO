package com.br.model.entity;

import javax.swing.JOptionPane;

import com.br.api.DTO.AdministratorsDTO;


public class Administrators {
  // implements class attributes
  private String name;
  private String user;
  private String password;
  private String accessCode;
  private Long id;

  // implements GETTERS and SETTERS to ensure encapsulation of attributes
  
  public Long getId() {
	  return this.id;
  }
  
  public void setId(Long id) {
	  if (id > 0) {
		  this.id = id;
	  }
  }
  
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      System.out.println("name não pode ser vazio!");
    } else {
      this.name = name;
    }
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String user) {
    if (user == null || user.isEmpty()) {
      System.out.println("user não pode ser vazio!");
    } else {
      this.user = user;
    }
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    if (password.isEmpty()) {
      System.out.println("Senha não pode ser vazio!");
    } else {
      this.password = password;
    }
  }

  public String getAccessCode() {
    return this.accessCode;
  }

  public void setAccessCode(String code) {
    if (code == null || code.isEmpty()) {
      System.out.println("A chave de acesso não pode ser vazia!");
    } else {
      this.accessCode = code;
    }
  }
  public static Administrators converter(AdministratorsDTO dto) {
	  Administrators admin = new Administrators();
	  try {
		  admin.setName(dto.getName());
		  admin.setUser(dto.getUser());
		  admin.setPassword(dto.getPasswd());
		  admin.setAccessCode(dto.getAcsscode());
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Erro: "+e);
	}
		return admin;
	}
}