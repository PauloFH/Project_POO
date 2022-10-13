package com.br.model.entity;

public class Administrators {
  // implements class attributes
  private String name;
  private String user;
  private String password;
  private String accessCode;

  // implements GETTERS and SETTERS to ensure encapsulation of attributes
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
}