package com.br.api.Views;

import java.io.IOException;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
		private static Stage stage;
		
		public static Stage getStage() {
			return stage;
		}
		private void setStage(Stage st) {
			stage =st;
		}
		public static void main (String args[]) {
			try {
				launch();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
				}

		}
		@Override
		public void start(Stage arg0) throws Exception {
			try {
				setStage(arg0);
				arg0.setTitle("Login");
				telalogin();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}

		}
		public static void telalogin() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/login.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("telalogin");
				stage.show();
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}
		
		public static void telaControleDiscos() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/controleDisco.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		

		public static void telaControleClientes() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/controleClientes.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}
		
		public static void telaControleLivro() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/controleLivros.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}

		public static void telaControleDevolucao() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/returnTitles.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: " + e);
			}
		}

		public static void telamenu(){
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/alugar.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("telamenu");
				stage.show();
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}
		public static void telacadastroadmin() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/cadadmin.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("Telacadastro");
				stage.show();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}
		
		public static void telaCadastroBooks() {

			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/cadastrarBooksTela.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("TelaCadastroLivros");
				stage.show();
			} catch (Exception e) {
				//JOptionPane.showMessageDialog(null,"Erro: "+e);
				e.printStackTrace();
			}
		}
		
		public static void telaCadastroVinyl() {

			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/cadastrarVinylTela.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("TelaCadastroDiscos");
				stage.show();
			} catch (Exception e) {
				//JOptionPane.showMessageDialog(null,"Erro de tela: "+e);
				e.printStackTrace();
			}
		}
		
		public static void telaCadastroCliente() {

			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/cadastrarClienteTela.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("TelaCadastroCliente");
				stage.show();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}
		
    
		public static void telaEditarDisco() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/discoEdit.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("Tela Editar Disco");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}

		public static void telaEditarLivro() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/livroEdit.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("Tela Editar Disco");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: "+e);
			}
		}

		public static void telaEditarCliente() {
			Parent root;
			try {
				root = FXMLLoader.load(Main.class.getResource("resources/clientEdit.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("Tela Editar Disco");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}		
			public static void telarelatorio() {
			Parent root;
			try {
				root = FXMLLoader.load(Main.class.getResource("resources/generateReport.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("Tela Editar Disco");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		

}
