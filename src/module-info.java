module Project_POO {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens com.br.Views to javafx.graphics, javafx.fxml;
}
