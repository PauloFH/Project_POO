module javafx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens com.br.Views to javafx.graphics, javafx.fxml;
}
