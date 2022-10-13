package com.br.model.Services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.model.DAO.BaseInterDAO;
import com.br.model.DAO.ClientsDAO;
import com.br.model.entity.Clients;

public class ClientsBO{
		BaseInterDAO<Clients> dao = new ClientsDAO();
		
        public boolean registerClients (Clients client){
        ResultSet q = dao.findBySpecifiedField(client, "cpf");
        try{
            if (q== null || !q.next()){
            	if(dao.add(client) == true)
            		return true;
            	else return false;
               }else return false;
            	}catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro: "+e);
                return false;
            }
        }

    public boolean editClients(Clients client){
    		ResultSet rs = dao.findBySpecifiedField(client, "cpf");
    	try { if(rs!=null && rs.next()) {
    			if(dao.edit(client) == true)
    				return true;
    			else return false;
    			
        }else return false;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Erro: "+e);
        return false;
    }
    	
    }
    
    public boolean deleteClients(Clients client){
		ResultSet rs = dao.findBySpecifiedField(client, "cpf");
    	try {
    		if(rs !=null && rs.next()) {
    			if(dao.del(client) == true)
    			return true;
    			else return false;
    		}else return false;
    		
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e);
            return false;
        }
    }
    
    public List<Clients> searchcpf(String cpf){
    		Clients client = new Clients();
    		client.setCpf(cpf);
    		ResultSet rs = dao.findBySpecifiedField(client, "cpf");
    		List<Clients> rslist = new ArrayList<Clients>();
            try {
            	while(rs.next()) {
            		Clients cl = new Clients();            		
            		cl.setId(rs.getInt("id"));
            		cl.setName(rs.getString("name"));
            		cl.setCpf(rs.getString("cpf"));
            		cl.setAddress(rs.getString("adress"));
            		
            		rslist.add(cl);
            	}
        	return rslist;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro: "+e);
                return null;         
            }  
            
    }
    
    public List<Clients> searchname(String name){
		Clients client = new Clients();
		client.setCpf(name);
		ResultSet rs = dao.findBySpecifiedField(client, "name");
		List<Clients> rslist = new ArrayList<Clients>();
        try {
        	while(rs.next()) {
        		Clients cl = new Clients();            		
        		cl.setId(rs.getInt("id"));
        		cl.setName(rs.getString("name"));
        		cl.setCpf(rs.getString("cpf"));
        		cl.setAddress(rs.getString("adress"));
        		
        		rslist.add(cl);
        	}
    	return rslist;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e);
            return null;    
        }  
             
}
    public List<Clients> listAll(){
    		ResultSet rs = dao.findAll();
    		List<Clients> rslist = new ArrayList<Clients>();
    		
    	try {
        		while(rs.next()) {
        			Clients cl = new Clients();            		
        			cl.setId(rs.getInt("id"));
        			cl.setName(rs.getString("name"));
        			cl.setCpf(rs.getString("cpf"));
        			cl.setAddress(rs.getString("adress"));
        		
        			rslist.add(cl);
        		}
    		return rslist;
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"Erro: "+e);
			 return null;
		}
    	
    	

    }
}
