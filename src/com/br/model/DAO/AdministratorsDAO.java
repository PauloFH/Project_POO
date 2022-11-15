package com.br.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.model.entity.Administrators;

public class AdministratorsDAO extends BaseDAO<Administrators>{
	
	private Connection con;
	
	synchronized public Connection getConnection() {
		if(con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/","sql10526105","QA8b6k86SJ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
			
		}else return con;

	}
	public boolean add(Administrators admin) {
		String sql = "UPDATE tb_admin SET name=?,user=?,password=? WHERE acessCode=?";
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
			JOptionPane.showMessageDialog(null,"Erro no add Administrators: "+e);
			
			return false;
		}
	}
	
	public boolean del(Administrators admin) {
		String sql = "DELETE FROM tb_admin WHERE user=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, admin.getAccessCode());
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Erro no del Administrators: "+e);
			
			return false;
		}
	}
	
	public boolean edit(Administrators admin) {
		String sql = "UPDATE tb_admin SET name=?,user=?,password=? WHERE user=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getUser());
			pst.setString(3, admin.getPassword());
			pst.setString(4, admin.getUser());
			pst.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Erro no edit Administrators: "+e);
			
			return false;
		}
	}
	

	public Administrators findById(Administrators admin) {
		String sql = "SELECT * FROM tb_admin WHERE id=?";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setLong(1, admin.getId());
			ResultSet rs =pst.executeQuery();
			if(rs.next()){
				Administrators newAdmin = new Administrators();
				newAdmin.setName(rs.getString("name"));
				newAdmin.setUser(rs.getString("user"));
				newAdmin.setPassword(rs.getString("password"));
				newAdmin.setAccessCode(rs.getString("acessCode"));
				newAdmin.setId(admin.getId());
				
				return newAdmin;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no findbyid Administrators: "+e);
			
			return null;
		}
	}
	
	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_admin;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no findall Administrators: "+e);
			
			return null;
		}
	}
	
	public ResultSet findBySpecifiedField(Administrators admin, String field) {
		String sql = "SELECT * FROM tb_admin WHERE " + field+ "=?";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "name":
				pst.setString(1, admin.getName());
				break;
			case "user":
				pst.setString(1, admin.getUser());
				break;
			case "acessCode":
				pst.setString(1, admin.getAccessCode());
				break;

			default:
				pst.setLong(1, admin.getId());
				break;
			}
		
			ResultSet rs = pst.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no findSfield Administrators: "+e);
			
			return null;
		}
	}
	
	public ResultSet findByUserAndPassword(String user, String password) {
		String sql = "SELECT * FROM tb_admin WHERE user=? AND password=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Erro no login Administrators: "+e);
			
			return null;
		}
	}
}
