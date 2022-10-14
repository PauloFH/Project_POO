package com.br.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.model.entity.Clients;


public class ClientsDAO extends BaseDAO<Clients>{
	public boolean add (Clients client) {
		String sql = "INSERT INTO tb_clients(name,cpf, adress) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setString(1, client.getName());
				pst.setString(2, client.getCpf());
				pst.setString(3, client.getAddress());
				pst.execute();
				return true;
		} catch (SQLException e) {
			
			return false;
		}
	}
		
	public boolean del (Clients client) {
		String sql = "DELETE FROM tb_clients WHERE cpf=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getCpf());
			pst.execute();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			return false;
		}
	}
	public boolean edit (Clients client) {
			String sql = "UPDATE tb_clients SET name=?,cpf=?,adress=? WHERE cpf=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, client.getName());
			pst.setString(2, client.getCpf());
			pst.setString(3, client.getAddress());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			return false;
		}
	}
		public Clients findById(Clients client) {
			String sql = "SELECT * FROM tb_clients WHERE id=?";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setInt(1, client.getId());
				ResultSet rs =pst.executeQuery();
				if(rs.next()){
					Clients newclient = new Clients();
					newclient.setCpf(rs.getString("name"));
					newclient.setCpf(rs.getString("cpf"));
					newclient.setCpf(rs.getString("adress"));
					newclient.setId(client.getId());
					return newclient;
				}else {
					return null;
				}} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
				return null;
			}
		}
		public ResultSet findAll() {
			String sql = "SELECT * FROM tb_clients;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				return rs;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
				return null;
			}
		}
		
		public ResultSet findBySpecifiedField(Clients client, String field) {
			String sql = "SELECT * FROM tb_clients WHERE " + field+ "=?";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				switch (field) {
				case "name":
					pst.setString(1, client.getName());
					break;
				case "cpf":
					pst.setString(1, client.getCpf());
					break;
				case "adress":
					pst.setString(1, client.getAddress());
					break;

				default:
					pst.setInt(1, client.getId());
					break;
				}
			
				ResultSet rs =pst.executeQuery();
				return rs;
				} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
				return null;
			}
		}
		
		
		
		
}
	
