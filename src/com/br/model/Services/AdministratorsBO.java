package com.br.model.Services;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.model.DAO.AdminInterDAO;
import com.br.model.DAO.AdministratorsDAO;
import com.br.model.entity.Administrators;

public class AdministratorsBO {
	AdminInterDAO adminDAO = new AdministratorsDAO();
	
		public boolean login(String user, String password) {
			ResultSet response = adminDAO.findByUserAndPassword(user, password);
			try {
				if (response.next()) {
					System.out.println("Logado com sucesso!");
					
					return true;
				} else {
					System.out.println("Por favor, verifique seu usuário e senha!");
					
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				return false;
			}
		}

	  public void logout() {
	    // implements a fake logout while not active login session
	    System.out.println("Logout");
	  }

	  public boolean registerAdministrator(Administrators newAdmin) {
		 ResultSet response = adminDAO.findBySpecifiedField(newAdmin, "accesscode");
		 try {
			if (response == null || !response.next()) {
				if (adminDAO.add(newAdmin) == true) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return false;
		}
	  }
	  

	  
}
