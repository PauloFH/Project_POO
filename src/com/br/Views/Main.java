package com.br.Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class Main extends Application {
		private static Stage stage;
		public static void main (String args[]) {
			launch();
		}
		private void setStage(Stage st) {
			stage =st;
		}
		@Override
		public void start(Stage arg0) throws Exception {
			// TODO Auto-generated method stub
			setStage(arg0);
			arg0.setTitle("Teste");
			telaCadastroAluno();
		}
		public static void telaCadastroAluno() {
			try {
				Parent root = FXMLLoader.load(Main.class.getResource("resources/javafx.fxml"));
				Scene scene = new Scene (root);
				stage.setScene(scene);
				stage.setTitle("Tela de Cadastro de Alunos");
				stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

}
