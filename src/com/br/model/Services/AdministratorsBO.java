package com.br.model.Services;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import com.br.api.DTO.AdministratorsDTO;
import com.br.exception.AutenticationException;
import com.br.exception.RegisterRentException;
import com.br.model.DAO.AdministratorsDAO;
import com.br.model.DAO.BaseInterDAO;
import com.br.model.entity.Administrators;

public class AdministratorsBO {
	BaseInterDAO<Administrators> adminDAO = new AdministratorsDAO();
	
		public boolean login(AdministratorsDTO dto) throws AutenticationException, SQLException{
		 Administrators admin = Administrators.converter(dto);
			String user = admin.getUser();
			String password = admin.getPassword();
			ResultSet response = ((AdministratorsDAO) adminDAO).findByUserAndPassword(user, password);
			
				if (response.next()) {
					
					return true;
				} else {
					
					throw new AutenticationException();
				}
		
		}

	  public boolean logout() {
	    // implements a fake logout while not active login session
		  return true;
	  }

	  public boolean registerAdministrator(AdministratorsDTO newAdmin) throws RegisterRentException {
		  Administrators admin = Administrators.converter(newAdmin);
		 ResultSet response = adminDAO.findBySpecifiedField(admin, "acessCode");
		 try {
			if (response.next()) {
				if (adminDAO.add(admin) == true) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Erro no registerAdminstrators: "+e);
			
			return false;
		}
	  }
	  

	  
}
