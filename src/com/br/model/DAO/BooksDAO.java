package com.br.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.model.entity.Books;

public class BooksDAO extends BaseDAO<Books> {
    public boolean add(Books book) {
        String sql = "INSERT INTO tb_books(title, gender, author, release_date, pages_amount, copies_amount, rent_price) VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getGender());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getReleaseDate());
            stmt.setInt(5, book.getPagesAmount());
            stmt.setInt(6, book.getCopiesAmount());
            stmt.setDouble(7, book.getRentPrice());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }
    }

    public boolean delete(Books book) {
        String sql = "DELETE FROM tb_books WHERE id=?;";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, book.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }
    }

    public boolean edit(Books book) {
        String sql = "UPDATE tb_books SET title=?,gender=?,author=?,release_date=?,pages_amount=?,copies_amount=?,rent_price=?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getGender());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getReleaseDate());
            stmt.setInt(5, book.getPagesAmount());
            stmt.setInt(6, book.getCopiesAmount());
            stmt.setDouble(7, book.getRentPrice());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }
    }

    public Books findById(Books book) {
        String sql = "SELECT * FROM tb_books WHERE id=?;";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, book.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Books bk = new Books();
                bk.setId(book.getId());
                bk.setTitle(rs.getString("title"));
                bk.setGender(rs.getString("gender"));
                bk.setAuthor(rs.getString("author"));
                bk.setReleaseDate(rs.getString("release_date"));
                bk.setPagesAmount(rs.getInt("pages_amount"));
                bk.setCopiesAmount(rs.getInt("copies_amount"));
                bk.setRentPrice(rs.getDouble("rent_price"));
                return bk;
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public ResultSet findAll(Books book) {
        String sql = "SELECT * FROM tb_books;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e);
            return null;
        }
    }

    public ResultSet findBySpecifiedField(Books book, String field) {
        String sql = "SELECT * FROM tb_books WHERE " + field + "=?;";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            switch (field) {
                case "title":
                    stmt.setString(1, book.getTitle());
                    break;
                case "gender":
                    stmt.setString(1, book.getGender());
                    break;
                case "author":
                    stmt.setString(1, book.getAuthor());
                    break;
                case "release_date":
                    stmt.setString(1, book.getReleaseDate());
                    break;
                default:
                    stmt.setInt(1, book.getId());
                    break;
            
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
		return null;
    }
}
