package com.br.model.Services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.model.DAO.BaseInterDAO;
import com.br.model.DAO.BooksDAO;
import com.br.model.entity.Books;

public class BooksBO {
    BaseInterDAO<Books> dao = new BooksDAO();

    public boolean registerBooks(Books book) {
        ResultSet q = dao.findBySpecifiedField(book, "title");
        try {
            if (q == null || !q.next()) {
                if (dao.add(book) == true)
                    return true;
                else
                    return false;
            } else
                return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }
    }

    public boolean editBooks(Books book) {
        ResultSet rs = dao.findBySpecifiedField(book, "title");
        try {
            if (rs != null && rs.next()) {
                if (dao.edit(book) == true)
                    return true;
                else
                    return false;
            } else
                return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }

    }

    public boolean deleteBooks(Books book) {
        ResultSet rs = dao.findBySpecifiedField(book, "title");
        try {
            if (rs != null && rs.next()) {
                if (dao.del(book) == true)
                    return true;
                else
                    return false;
            } else
                return false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }
    }

    public List<Books> getByTitle(String title) {
        Books book = new Books();
        book.setTitle(title);
        ResultSet rs = dao.findBySpecifiedField(book, "title");
        List<Books> list = new ArrayList<Books>();
        try {
            while (rs.next()) {
                Books bk = new Books();
                bk.setTitle(rs.getString("title"));
                bk.setGender(rs.getString("gender"));
                bk.setAuthor(rs.getString("author"));
                bk.setReleaseDate(rs.getInt("releaseDate"));
                bk.setPagesAmount(rs.getInt("pagesAmount"));
                bk.setCopiesAmount(rs.getInt("copiesAmount"));
                bk.setRentPrice(rs.getDouble("rentPrice"));
                list.add(bk);
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Books> getByGender(String gender) {
        Books book = new Books();
        book.setGender(gender);
        ResultSet rs = dao.findBySpecifiedField(book, "gender");
        List<Books> list = new ArrayList<Books>();
        try {
            while (rs.next()) {
                Books bk = new Books();
                bk.setTitle(rs.getString("title"));
                bk.setGender(rs.getString("gender"));
                bk.setAuthor(rs.getString("author"));
                bk.setReleaseDate(rs.getInt("releaseDate"));
                bk.setPagesAmount(rs.getInt("pagesAmount"));
                bk.setCopiesAmount(rs.getInt("copiesAmount"));
                bk.setRentPrice(rs.getDouble("rentPrice"));
                list.add(bk);
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Books> getByAuthor(String author) {
        Books book = new Books();
        book.setAuthor(author);
        ResultSet rs = dao.findBySpecifiedField(book, "author");
        List<Books> list = new ArrayList<Books>();
        try {
            while (rs.next()) {
                Books bk = new Books();
                bk.setTitle(rs.getString("title"));
                bk.setGender(rs.getString("gender"));
                bk.setAuthor(rs.getString("author"));
                bk.setReleaseDate(rs.getInt("releaseDate"));
                bk.setPagesAmount(rs.getInt("pagesAmount"));
                bk.setCopiesAmount(rs.getInt("copiesAmount"));
                bk.setRentPrice(rs.getDouble("rentPrice"));
                list.add(bk);
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Books> getByReleaseDate(String releaseDate) {
        Books book = new Books();
        book.setReleaseDate(releaseDate);
        ResultSet rs = dao.findBySpecifiedField(book, "releaseDate");
        List<Books> list = new ArrayList<Books>();
        try {
            while (rs.next()) {
                Books bk = new Books();
                bk.setTitle(rs.getString("title"));
                bk.setGender(rs.getString("gender"));
                bk.setAuthor(rs.getString("author"));
                bk.setReleaseDate(rs.getInt("releaseDate"));
                bk.setPagesAmount(rs.getInt("pagesAmount"));
                bk.setCopiesAmount(rs.getInt("copiesAmount"));
                bk.setRentPrice(rs.getDouble("rentPrice"));
                list.add(bk);
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public List<Books> listAll() {
        ResultSet rs = dao.findAll();
        List<Books> list = new ArrayList<Books>();

        try {
            while (rs.next()) {
                Books bk = new Books();
                bk.setTitle(rs.getString("title"));
                bk.setGender(rs.getString("gender"));
                bk.setAuthor(rs.getString("author"));
                bk.setReleaseDate(rs.getInt("releaseDate"));
                bk.setPagesAmount(rs.getInt("pagesAmount"));
                bk.setCopiesAmount(rs.getInt("copiesAmount"));
                bk.setRentPrice(rs.getDouble("rentPrice"));
                list.add(bk);
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
}
