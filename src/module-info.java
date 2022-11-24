module javafx {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	requires java.naming;
	requires itextpdf;
	
	opens com.br.api.Views to javafx.graphics, javafx.fxml;
	opens com.br.api.Controller to javafx.fxml;
	opens com.br.api.DTO to javafx.base, javafx.fxml;

}
