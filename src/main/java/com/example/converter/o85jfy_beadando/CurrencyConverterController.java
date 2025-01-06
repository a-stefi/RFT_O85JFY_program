package com.example.atm.o85jfy_beadando;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConverterController {

    @FXML
    private TextField inputAmount;

    @FXML
    private ComboBox<String> fromCurrencyComboBox;

    @FXML
    private ComboBox<String> toCurrencyComboBox;

    @FXML
    private Label resultLabel;

    private final Map<String, Double> exchangeRates = new HashMap<>();

    private static final List<String> allCurrencies = new ArrayList<>();

    private List<String> favoriteCurrencies = new ArrayList<>();

    @FXML
    public void initialize() {
        addCurrencies();
        updateComboBoxes();
    }

    private void addCurrencies() {
    }

    @FXML
    private void handleConvertButtonAction() {
    }

    @FXML
    private void handleSettingsButtonAction() {
    }

    public void setFavoriteCurrencies(List<String> favorites) {
    }

    private void updateComboBoxes() {
    }

    public void printFavoriteCurrencies() {
    }
}
