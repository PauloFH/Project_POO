package com.br.model.DAO;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.List;

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
		
		public boolean del(VinylRecord vinylRecord) {
			String sql = "DELETE FROM tb_vinylRecord WHERE id_vinylRecord=?;";
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
			String sql = "UPDATE tb_vinylRecord SET title=?, rentPrice=?, copiesAmount=?, bandsName=?, musicalStyle=? WHERE id_vinylRecord=?";
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
		public ResultSet findAll() {
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
		
		@Override
		public List<VinylRecord> findBySpecifiedField(VinylRecord e, String field) {
			String sql = "SELECT * FROM tb_aluno WHERE " + field +"=? ;";
			try {
				PreparedStatement pst = getConnection().prepareStatement(sql);
				switch (field) {
				case "title":
					pst.setString(1, e.getTitle());
					break;
					
				case "rentPrice":
					pst.setDouble(1, e.getRentPrice());
					break;
					
				case "telefone":
					pst.setInt(1, e.getCopiesAmount());
					break;
					
				case "endereco":
					pst.setString(1, e.getBandsName());
					break;
					
				case "musicalStyle":
					pst.setString(1, e.getMusicalStyle());
					break;
				
				default: 
					pst.setInt(1, e.getId());
				}
			
			
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				return null;
			}
			return null;
		}

		
	}

