module com.example.atm.o85jfy_beadando {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.atm.o85jfy_beadando to javafx.fxml;
    exports com.example.atm.o85jfy_beadando;
}