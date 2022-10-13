package com.br.model.DAO;

import java.sql.PreparedStatement;
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
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			return false;
		}
	}
		

	

}
