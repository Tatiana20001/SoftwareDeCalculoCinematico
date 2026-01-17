module ec.edu.espoch.softwaredecalculocinematico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espoch.softwaredecalculocinematico.controller.interfaces to javafx.fxml, javafx.base;
    
    exports ec.edu.espoch.softwaredecalculocinematico;
    exports ec.edu.espoch.softwaredecalculocinematico.controller.interfaces;
}