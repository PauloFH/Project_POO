module javafx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	
	opens com.br.api.Views to javafx.graphics, javafx.fxml;
	opens com.br.api.Controler to javafx.fxml;
}
