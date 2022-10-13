package com.br.model.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.model.DAO.VinylRecordDAO;
import com.br.model.DAO.BaseInterDAO;
import com.br.model.entity.VinylRecord;

public class VinylRecordBO {
	BaseInterDAO<VinylRecord> dao = new VinylRecordDAO();
	public boolean adicionar(VinylRecord vinylRecord) {
		ResultSet rs = dao.findBySpecifiedField(vinylRecord, "cpf");
		try {
			if(rs==null || !(rs.next()) ) {
				if(dao.inserir(vinylRecord) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	public List<VinylRecord> listar(){
		List<VinylRecord> vinylRecords = new ArrayList<VinylRecord>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				VinylRecord vinyl = new VinylRecord();
				vinyl.setTitle(rs.getString("title"));
				vinyl.setRentPrice(rs.getDouble("rentPrice"));
				vinyl.setCopiesAmount(rs.getInt("copiesAmount"));
				vinyl.setBandsName(rs.getString("bandsName"));
				vinyl.setMusicalStyle(rs.getString("musicalStyle"));
				vinyl.setId(rs.getInt(0));
				
				vinylRecords.add(vinyl);
			}
			return vinylRecords;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean atualizar (VinylRecord vinylRecord) {
		
		ResultSet rs = dao.findBySpecifiedField(vinylRecord, "id_vinylRecord");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.alterar(vinylRecord) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	public boolean apagar (VinylRecord vinylRecord) {
		ResultSet rs = dao.findBySpecifiedField(vinylRecord, "id_vinylRecord");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.deletar(vinylRecord) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
}
