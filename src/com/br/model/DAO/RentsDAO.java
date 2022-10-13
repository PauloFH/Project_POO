package com.br.model.DAO;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.model.entity.Rents;

public class RentsDAO extends BaseDAO<Rents>{
	public boolean add(Rents rent) {
		String sql = "INSERT INTO tb_Rents(client,cpf, adress) VALUES (?,?,?,?);";
		try {
			
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Erro: "+e);
		}
	}
}
