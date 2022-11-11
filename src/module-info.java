module javafx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	
	opens com.br.api.Views to javafx.graphics, javafx.fxml;
}
