package com.br.model.Services;

import javax.swing.JOptionPane;

import com.br.model.DAO.ClientsDAO;
import com.br.model.DAO.Inter_Client;
import com.br.model.entity.Clients;

public class ClientsBO extends Clients{
		Inter_Client<Clients> dao = new ClientsDAO();
        public boolean registerClients (String name, String address, String cpf){
        try{
            if (name != null && !name.isEmpty() &&
                address != null && !address.isEmpty() &&
                cpf != null && !cpf.isEmpty()) {

                  Clients client = new Clients();
                   client.setCpf(cpf);
                   client.setAddress(address);
                   client.setName(name);
                   client.id = numbClients+1;
                   Clients.numbClients += 1;

                    bd.add(client);
                    return true;
                }
            }   catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro: "+e);
                return false;
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
}
