module Project_POO {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	
	opens com.br.api.Views to javafx.graphics, javafx.fxml;
	opens com.br.api.Controller to javafx.fxml;
}
