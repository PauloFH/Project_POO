package com.br.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;

import com.br.model.entity.Rents;

public class RentsDAO extends BaseDAO<Rents>{
	
	public boolean add(Rents rent) {
		String sql = "INSERT INTO tb_rents (clientCPF, productName,rentData, price) VALUES (?, ?, ?, ?)";
		try {
			
			PreparedStatement pst = getConnection().prepareStatement(sql);
			Date data = new Date(rent.getRentDate().getTimeInMillis());
			pst.setString(1, rent.getClient().getCpf());
			pst.setString(2, rent.getProduct().getTitle());
			pst.setDate(3, data);
			pst.setDouble(4, rent.getRentPrice());
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
			Date data = new Date(rent.getDevolutionDate().getTimeInMillis());
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

