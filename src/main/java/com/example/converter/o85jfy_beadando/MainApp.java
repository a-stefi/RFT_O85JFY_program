package com.example.atm.o85jfy_beadando;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // A valuta váltó nézet betöltése az FXML fájlból
        FXMLLoader currencyLoader = new FXMLLoader(getClass().getResource("currency_converter.fxml"));
        Parent currencyRoot = currencyLoader.load();

        // Hozzáférés a valuta váltó vezérlőjéhez
        CurrencyConverterController currencyConverterController = currencyLoader.getController();

        // Beállítások nézetének betöltése
        FXMLLoader settingsLoader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Parent settingsRoot = settingsLoader.load();

        // Hozzáférés a beállítások vezérlőjéhez
        SettingsController settingsController = settingsLoader.getController();

        // A beállítások vezérlőjének átadjuk a valuta váltó vezérlőt
        settingsController.setCurrencyConverterController(currencyConverterController);

        // Beállítások külön ablak megjelenítése
        Stage settingsStage = new Stage();
        settingsStage.setTitle("Beállítások");
        settingsStage.setScene(new Scene(settingsRoot));
        settingsStage.show();

        // Fő ablak konfigurálása a valuta váltóval
        primaryStage.setTitle("Valuta Váltó");
        primaryStage.setScene(new Scene(currencyRoot));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Az alkalmazás indítása
    }
}
