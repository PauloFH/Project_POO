package com.br.model.DAO;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.api.DTO.VinylRecordDTO;
import com.br.model.entity.VinylRecord;
	public class VinylRecordDAO  extends BaseDAO<VinylRecord>{
		
		public boolean add(VinylRecord vinylRecord) {
			String sql = "INSERT INTO tb_vinylRecord (title, rentPrice, copiesAmount, bandsName, musicalStyle) VALUES(?, ?, ?, ?, ?);";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setString(1, vinylRecord.getTitle());
				pst.setDouble(2, vinylRecord.getRentPrice());
				pst.setInt(3, vinylRecord.getCopiesAmount());
				pst.setString(4, vinylRecord.getBandsName());
				pst.setString(5, vinylRecord.getMusicalStyle());
				pst.execute();
				
			} catch(SQLException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
			}
			return false;
		}
		
		public boolean del(VinylRecordDTO vinylRecord) {
			String sql = "DELETE FROM tb_vinylRecord WHERE id=?;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setInt(1, vinylRecord.getId());
				pst.execute();
				
				return true;
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		public boolean edit(VinylRecord vinylRecord) {
			String sql = "UPDATE tb_vinylRecord SET title=?, rentPrice=?, copiesAmount=?, bandsName=?, musicalStyle=? WHERE id=?";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setString(1, vinylRecord.getTitle());
				pst.setDouble(2, vinylRecord.getRentPrice());
				pst.setInt(3, vinylRecord.getCopiesAmount());
				pst.setString(4, vinylRecord.getBandsName());
				pst.setString(5, vinylRecord.getMusicalStyle());
				pst.setInt(6, vinylRecord.getId());
				pst.executeUpdate();
				return true;
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		}
		
		public VinylRecord findById(VinylRecord e) {
			String sql = "SELECT * FROM tb_vinylRecord WHERE id_vinylRecord=? ;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				pst.setInt(1, e.getId());
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					VinylRecord vinyl = new VinylRecord();
					vinyl.setTitle(rs.getString("title"));
					vinyl.setRentPrice(rs.getDouble("rentPrice"));
					vinyl.setCopiesAmount(rs.getInt("copiesAmount"));
					vinyl.setBandsName(rs.getString("bandsName"));
					vinyl.setMusicalStyle(rs.getString("musicalStyle"));
					vinyl.setId(e.getId());
					return vinyl;
				}
				else return null;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
		}
		
		@Override
		public ResultSet findAll(VinylRecord v) {
			String sql = "SELECT * FROM tb_vinylRecord;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				return rs;
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
		}
		
		public List<VinylRecord> findBySpecifiedField(VinylRecordDTO entity, String field) {
			String sql = "SELECT * FROM tb_vinylRecord WHERE " + field +"=? ;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				switch (field) {
				case "title":
					pst.setString(1, entity.getTitle());
					break;
					
				case "rentPrice":
					pst.setDouble(1, entity.getRentPrice());
					break;
					
				case "telefone":
					pst.setInt(1, entity.getCopiesAmount());
					break;
					
				case "endereco":
					pst.setString(1, entity.getBandsName());
					break;
					
				case "musicalStyle":
					pst.setString(1, entity.getMusicalStyle());
					break;
				
				default: 
					pst.setInt(1, entity.getId());
				}
				ResultSet rs =pst.executeQuery();
				List<VinylRecord> vrs = new ArrayList<VinylRecord>();
				
				while(rs.next()) {
					VinylRecord d = new VinylRecord();
					d.setTitle(rs.getString("title"));
					d.setId(rs.getInt("id"));
					d.setRentPrice(rs.getDouble("rentprice"));
					d.setCopiesAmount(rs.getInt("copiesAmount"));
					d.setBandsName(rs.getString("bandsName"));
					d.setMusicalStyle(rs.getString("musicalStyle"));
					vrs.add(d);
				}
					return vrs;
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "erro: "+ex);
				return null;
			}
			
		}

		
	}

