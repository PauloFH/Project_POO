package com.br.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.model.entity.Administrators;

public class AdministratorsDAO extends BaseDAO<Administrators> implements AdminInterDAO {
	public boolean add(Administrators admin) {
		String sql = "INSERT INTO tb_admin(name,user,password, acessCode) VALUES (?,?,?,?);";
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
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean del(Administrators admin) {
		String sql = "DELETE FROM tb_admin WHERE acessCode=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, admin.getAccessCode());
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean edit(Administrators admin) {
		String sql = "UPDATE tb_admin SET name=?,user=?,password=?,acessCode=? WHERE acessCode=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getUser());
			pst.setString(3, admin.getPassword());
			pst.setString(4, admin.getAccessCode());
			pst.setString(5, admin.getAccessCode());
			pst.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
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
			e.printStackTrace();
			
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
			e.printStackTrace();
			
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
			e.printStackTrace();;
			
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
			e.printStackTrace();
			
			return null;
		}
	}
}
