package com.br.model.DAO;
import javax.swing.JOptionPane;
public class testConnection {


	/**
	 *
	 * @author Catita_GS
	 */
	    
	     public static void main(String[] args) {
	       try {
	             
	             new BaseDAO().getConnection();
	             JOptionPane.showMessageDialog(null, "Conectado com sucesso!");             
	         } catch (Exception erro) {
	              JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: "  + erro);    
	         }
	         
	         
	     }
}
