package com.br.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.model.entity.Clients;
import com.br.model.entity.RentsProducts;

public class RentsProductsDAO extends BaseDAO<RentsProducts>{
	
	public boolean add(RentsProducts p) {
		String sql = "INSERT INTO tb_rentsProducts(id_rent, id_product, qt, rent_price)VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, p.getRent().getId());
			pst.setInt(2, p.getProduct().getId());
			pst.setInt(3, p.getQt());
			pst.setDouble(4, p.getRent_Price());
			pst.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro: "+e);
			return false;
		}
	}
	
	public ResultSet findBySpecifiedField(RentsProducts p, String field) {
		String sql = "SELECT * FROM  tb_rentsProducts WHERE " + field+ "=?";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "rent":
				pst.setInt(1, p.getRent().getId());
				break;
			case "product":
				pst.setInt(1, p.getProduct().getId());
				break;
			default:
				pst.setInt(1, p.getId());
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
