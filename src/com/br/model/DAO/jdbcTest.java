package com.br.model.DAO;

import javax.swing.JOptionPane;

public class jdbcTest {
	public static void main(String[] args) {
		try {
			new ConnectionFactory();
			ConnectionFactory.ConnectionBD();
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, " erro: "  + e);
		}
	}
}

