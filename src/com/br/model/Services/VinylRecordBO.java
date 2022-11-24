package com.br.model.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.model.DAO.VinylRecordDAO;
import com.br.api.DTO.VinylRecordDTO;
import com.br.model.entity.VinylRecord;

public class VinylRecordBO {
	VinylRecordDAO dao = new VinylRecordDAO();
	public boolean add(VinylRecord vinylRecord) {
		ResultSet rs = dao.findBySpecifiedField(vinylRecord, "cpf");
		try {
			if(rs==null || !(rs.next()) ) {
				if(dao.add(vinylRecord) == true)
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

	public void listAll(){
		
	}
	public List<VinylRecordDTO>findAll(){
		
		List<VinylRecordDTO> vinylRecords = new ArrayList<VinylRecordDTO>();
		VinylRecord v = new VinylRecord();
		ResultSet rs = dao.findAll(v);
		try {
			while(rs.next()) {
				VinylRecordDTO vinyl = new VinylRecordDTO();
				vinyl.setTitle(rs.getString("title"));
				vinyl.setRentPrice(rs.getDouble("rentPrice"));
				vinyl.setCopiesAmount(rs.getInt("copiesAmount"));
				vinyl.setBandsName(rs.getString("bandsName"));
				vinyl.setMusicalStyle(rs.getString("musicalStyle"));
				vinyl.setId(rs.getInt("id"));
				
				vinylRecords.add(vinyl);
			}
			return vinylRecords;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showInternalMessageDialog(null, e);
			return null;
		}
	}
	
	public boolean edit (VinylRecordDTO dto) {
		VinylRecord  vinylRecord = VinylRecord.conveter(dto);
		ResultSet rs = dao.findBySpecifiedField(vinylRecord, "id");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.edit(vinylRecord) == true)
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
	public boolean del (VinylRecordDTO vinylRecord){
		try {
			List<VinylRecord> rs = dao.findBySpecifiedField(vinylRecord, "id");
			if(rs.get(0) !=null) {
				if(dao.del(vinylRecord) == true)
					return true;
					else return false;
			}
			else return false;	
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
			
		
	}
}
