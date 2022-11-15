package com.br.api.Views;

import javax.swing.JOptionPane;

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
}
