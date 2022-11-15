package com.br.api.Views;

import javax.swing.JOptionPane;
<<<<<<< HEAD
import javax.swing.Popup;

import com.br.api.Controller.CadBooksController;

=======
>>>>>>> 6bd7b347933b48fd7aa7b5001a3a85a7a86294c1
import javafx.application.Application;
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
				e.printStackTrace();
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
				e.printStackTrace();
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
				e.printStackTrace();
			}
		}

		public static void telamenu(){
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/telabase.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("telamenu");
				stage.show();
				
			}catch(Exception e) {

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

				Popup popup = new Popup();
				CadBooksController controller = new CadBooksController();
				FXMLLoader loader;
				try {
					loader = new FXMLLoader(getClass().getResource("resources/cadastrarBooksTela.fxml"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				loader.setController(controller);
				popup.getContent().add((Parent)loader.load());
			
		}
}
