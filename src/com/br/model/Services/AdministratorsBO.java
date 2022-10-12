package com.br.model.Services;

import com.br.model.entity.Administrators;

public class AdministratorsBO {
	public boolean login(String user, String password) {
	    // implements a fake login while not database yet and the tools that will be used
	  }

	  public void logout() {
	    // implements a fake logout while not active login session
	    System.out.println("Logout");
	  }

	  public void registerAdministrator(Administrators newAdmin) {
	    // implements a fake register while not a database
	    
	  }
	  
	// implements reporting functions
	  // but the logic is still a little iffy
	  public void generateRentsByCustomerReport() {}

	  public void generateReportAllRented() {}

	  public void generateMonthlyBillingReport() {

	  }

}
