package entity;

import java.util.List;

public class Rents {
  private int id;
  private Clients client;
  private List<Product> products;
  private String date;

  public int getId() {
    return this.id;
  }
 
  public void setId(int id) {
    if (id < 0) {
      System.out.println("Digite um valor válido");
    } else {
      this.id = id;
    }
  }

  public Clients getClient() {
    return this.client;
  }

  public void setClient(Clients client) {
    if (client == null) {
      System.out.println("Por favor, digite o nome do cliente");
    } else {
      this.client = client;
    }
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public void setProducts(Product product) {
    if (product == null) {
      System.out.println("Por favor, coloque um produto");
    } else {
      this.products.add(product);
    }
  }
}
