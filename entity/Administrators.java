package entity;

import java.util.ArrayList;
import java.util.List;

public class Administrators {
  // implements class attributes
  private String name;
  private String user;
  private String password;
  private String accessCode;

  // simulate a database
  public static List<Administrators> fakeBD = new ArrayList<Administrators>();

  // implement the constructors 
  public Administrators(
    String name, 
    String user, 
    String password, 
    String code
  ) {
    this.setName(name);
    this.setUser(user);
    this.setPassword(password);
    this.setAccessCode(code);
  }

  public Administrators() {}

  public boolean login(String user, String password) {
    // implements a fake login while not database yet and the tools that will be used
    if (user.isEmpty() || password.isEmpty()) {
      System.out.println("Dados vazios! Tente novamente");
      return false;
    }

    for (Administrators admin : fakeBD) {
      if (admin.getUser().equals(user) && admin.getPassword().equals(password)) {
        System.out.println("Logado com sucesso!");
        return true;
      }
    }

    System.out.println("Usuário ou Senha incorreto!");
    return false;
  }

  public void logout() {
    // implements a fake logout while not active login session
    System.out.println("Logout");
  }

  public void registerAdministrator(Administrators newAdmin) {
    // implements a fake register while not a database
    if (
      newAdmin.getName().isEmpty() || 
      newAdmin.getPassword().isEmpty() || 
      newAdmin.getAccessCode().isEmpty()
    ) {
      System.out.println("Dados não podem estarem vazios!");
      return;
    } 

    for (Administrators admin : fakeBD) {
      if (
        admin.getAccessCode().equals(newAdmin.getAccessCode()) ||
        admin.getUser().equals(newAdmin.getUser())
      ) {
        System.out.println("Código de acesso ou usuário já existente!");
        return;
      }
    }

    fakeBD.add(newAdmin);
  }

  // implements reporting functions
  // but the logic is still a little iffy
  public void generateRentsByCustomerReport() {}

  public void generateReportAllRented() {}

  public void generateMonthlyBillingReport() {

  }

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