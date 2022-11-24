package com.br.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;

import com.br.model.entity.Rents;

public class RentsDAO extends BaseDAO<Rents>{
	
	public boolean add(Rents rent) {
		String sql = "INSERT INTO tb_rents (client_id,rentData, price) VALUES (?, ?, ?, ?)";
		try {
			Calendar cal = Calendar.getInstance();
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, rent.getClient().getId());
			pst.setDate(3, new java.sql.Date());
			pst.setDouble(4, rent.getPrice());
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			
			return false;
		}
	}
	
	public boolean devolution(Rents rent) {
		String sql = "UPDATE tb_rents SET devolution=? devolutionDate=? WHERE id=? ";
		try {
			
			PreparedStatement pst = getConnection().prepareStatement(sql);
			Date data = new Date(rent.getDevolutionDate().getTime());
			pst.setBoolean(1, true);
			pst.setDate(2, data);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			return false;
			
		}
	}
	
		public ResultSet search(Calendar rent, Calendar devolution ) {
			String sql = "SELECT * FROM tb_Clients WHERE rentsDate=? AND devolutionDate =?";
			try {
				Date rentdate = new Date(rent.getTimeInMillis());
				Date devolutiondate = new Date(rent.getTimeInMillis());
				PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setDate(1, rentdate);
			
				pst.setDate(2, devolutiondate);
				ResultSet result = pst.executeQuery();
				return result ;
			} catch (Exception e) {
				
				return null;
			}
		}
	
	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_rents;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			return null;
		}
	}
}

