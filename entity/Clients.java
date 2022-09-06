package entity;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Clients {
    // implements Book
    private static int numbClients;
    private int id;
    private String name;
    private String address;
    private String cpf;

    static List<Clients> bd = new ArrayList<>();

    public void registerClients (String name, String address, String cpf){
        try{
            if (name != null && !name.isEmpty() &&
                address != null && !address.isEmpty() &&
                cpf != null && !cpf.isEmpty()) {

                  Clients client = new Clients();
                   client.cpf = cpf;
                   client.address = address;
                   client.name = name;
                   client.id = numbClients+1;
                   Clients.numbClients += 1;

                    bd.add(client);
                }
            }   catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro: "+e);
            }
        }

    public void editClients(int id,String name, String address, String cpf){
        try {
            
        if(id > 0 && id < Clients.numbClients ){
            Clients client = new Clients();
            client.cpf = cpf;
            client.address = address;
            client.name = name;
            bd.set(id, client);
        }    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Erro: "+e);
    }

    }
    public void deleteClients(Clients client){
        try {
            bd.remove(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
    }
    public Clients searchcpf(String cpf){
            try {
                for(Clients client: bd){
                    if(client.cpf.equals(cpf)){
                        System.out.println("id: "+client.id);
                        System.out.println("name: "+client.name);
                        System.out.println("cpf: "+client.cpf);
                        System.out.println("address: "+client.address);
                        return client;
                    } 
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro: "+e);
            }  
            return null;         
    }
    public Clients searchname(String name){
        try {
            for(Clients client: bd){
                if(client.name.equals(name)){
                    System.out.println("id: "+client.id);
                    System.out.println("name: "+client.name);
                    System.out.println("cpf: "+client.cpf);
                    System.out.println("address: "+client.address);
                    return client;
                } 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }  
        return null;         
}

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
        if(id > numbClients)
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
  }