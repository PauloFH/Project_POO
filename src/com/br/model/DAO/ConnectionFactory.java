package com.br.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static	Connection ConnectionBD() {
		try {
			return DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/","sql10526105","QA8b6k86SJ");
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}

	}
		}

