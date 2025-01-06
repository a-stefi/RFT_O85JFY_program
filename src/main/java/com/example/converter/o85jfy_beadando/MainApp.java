package com.example.atm.o85jfy_beadando;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader currencyLoader = new FXMLLoader(getClass().getResource("currency_converter.fxml"));
        Parent currencyRoot = currencyLoader.load();

        CurrencyConverterController currencyConverterController = currencyLoader.getController();

        FXMLLoader settingsLoader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Parent settingsRoot = settingsLoader.load();

        SettingsController settingsController = settingsLoader.getController();

        settingsController.setCurrencyConverterController(currencyConverterController);

        Stage settingsStage = new Stage();
        settingsStage.setTitle("Beállítások");
        settingsStage.setScene(new Scene(settingsRoot));
        settingsStage.show();

        primaryStage.setTitle("Valuta Váltó");
        primaryStage.setScene(new Scene(currencyRoot));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
