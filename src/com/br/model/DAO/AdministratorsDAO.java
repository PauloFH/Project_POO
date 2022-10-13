package com.br.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.model.entity.Administrators;

public class AdministratorsDAO extends BaseDAO<Administrators> {
	public boolean add(Administrators admin) {
		String sql = "INSERT INTO tb_Admin(name, user, password, accesscode) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getUser());
			pst.setString(3, admin.getPassword());
			pst.setString(4, admin.getAccessCode());
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro: "+e);
			
			return false;
		}
	}
	
	public boolean del(Administrators admin) {
		String sql = "DELETE FROM tb_Admin WHERE accesscode=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, admin.getAccessCode());
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro: "+e);
			
			return false;
		}
	}
	
	public boolean edit(Administrators admin) {
		String sql = "UPDATE tb_Admin SET name=?,user=?,password=? WHERE accesscode=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getUser());
			pst.setString(3, admin.getPassword());
			pst.setString(4, admin.getAccessCode());
			pst.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro: "+e);
			
			return false;
		}
	}
	

	public Administrators findById(Administrators admin) {
		String sql = "SELECT * FROM tb_Admin WHERE id=?";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setLong(1, admin.getId());
			ResultSet rs =pst.executeQuery();
			if(rs.next()){
				Administrators newAdmin = new Administrators();
				newAdmin.setName(rs.getString("name"));
				newAdmin.setUser(rs.getString("user"));
				newAdmin.setPassword(rs.getString("password"));
				newAdmin.setAccessCode(rs.getString("accesscode"));
				newAdmin.setId(admin.getId());
				
				return newAdmin;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			
			return null;
		}
	}
	
	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_Admin;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			
			return null;
		}
	}
	
	public ResultSet findBySpecifiedField(Administrators admin, String field) {
		String sql = "SELECT * FROM tb_Admin WHERE " + field+ "=?";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "name":
				pst.setString(1, admin.getName());
				break;
			case "user":
				pst.setString(1, admin.getUser());
				break;
			case "accesscode":
				pst.setString(1, admin.getAccessCode());
				break;

			default:
				pst.setLong(1, admin.getId());
				break;
			}
		
			ResultSet rs = pst.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			
			return null;
		}
	}
}
