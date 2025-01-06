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
    exchangeRates.put("Amerikai dollár (USD)", 0.0026);
    exchangeRates.put("Angol font (GBP)", 0.0020);
    exchangeRates.put("Ausztrál dollár (AUD)", 0.0042);
    exchangeRates.put("Brazil real (BRL)", 0.014);
    exchangeRates.put("Cseh korona (CZK)", 0.062);
    exchangeRates.put("Dán korona (DKK)", 0.02);
    exchangeRates.put("Dél-afrikai rand (ZAR)", 0.052);
    exchangeRates.put("Euró (EUR)", 0.0024);
    exchangeRates.put("Fülöp-szigeteki peso (PHP)", 0.16);
    exchangeRates.put("Hongkongi dollár (HKD)", 0.022);
    exchangeRates.put("Indiai rúpia (INR)", 0.23);
    exchangeRates.put("Indonéz rúpia (IDR)", 43.21);
    exchangeRates.put("Izraeli új sékel (ILS)", 0.011);
    exchangeRates.put("Japán yen (JPY)", 0.42);
    exchangeRates.put("Kanadai dollár (CAD)", 0.0037);
    exchangeRates.put("Kínai jüan (CNY)", 0.021);
    exchangeRates.put("Koreai won (KRW)", 3.78);
    exchangeRates.put("Malajziai ringgit (MYR)", 0.013);
    exchangeRates.put("Magyar forint (HUF)", 1.0);
    exchangeRates.put("Mexikói peso (MXN)", 0.05);
    exchangeRates.put("Norvég korona (NOK)", 0.031);
    exchangeRates.put("Orosz rubel (RUB)", 0.27);
    exchangeRates.put("Svájci frank (CHF)", 0.0029);
    exchangeRates.put("Svéd korona (SEK)", 0.03);
    exchangeRates.put("Szingapúri dollár (SGD)", 0.003);
    exchangeRates.put("Thaiföldi baht (THB)", 0.099);
    exchangeRates.put("Török líra (TRY)", 0.077);
    exchangeRates.put("Új-zélandi dollár (NZD)", 0.0041);

    allCurrencies.addAll(exchangeRates.keySet());
}

    @FXML
    private void handleConvertButtonAction() {
        String fromCurrency = fromCurrencyComboBox.getValue();
        String toCurrency = toCurrencyComboBox.getValue();
        String amountText = inputAmount.getText();

        if (fromCurrency == null || toCurrency == null) {
            resultLabel.setText("Kérlek, válassz ki két pénznemet!");
            return;
        }

        Double fromRate = exchangeRates.get(fromCurrency);
        Double toRate = exchangeRates.get(toCurrency);

        if (fromRate == null || toRate == null) {
            resultLabel.setText("Érvénytelen valuta van kiválasztva.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);
            double convertedAmount = (amount / fromRate) * toRate;

            resultLabel.setText(String.format("%.2f %s átváltva:\n%.2f %s",
                    amount, fromCurrency, convertedAmount, toCurrency));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Érvénytelen összeg! Kérlek, adj meg egy számot.");
        }
    }


    @FXML
    private void handleSettingsButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
            Parent root = loader.load();

            SettingsController settingsController = loader.getController();

            settingsController.setCurrencyConverterController(this);

            Stage stage = new Stage();
            stage.setTitle("Beállítások");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFavoriteCurrencies(List<String> favorites) {
        favoriteCurrencies.clear();
        favoriteCurrencies.addAll(favorites);
        updateComboBoxes();
    }

    private void updateComboBoxes() {
        if (!favoriteCurrencies.isEmpty()) {
            fromCurrencyComboBox.getItems().clear();
            toCurrencyComboBox.getItems().clear();

            fromCurrencyComboBox.getItems().addAll(favoriteCurrencies);
            toCurrencyComboBox.getItems().addAll(favoriteCurrencies);
        } else {
            fromCurrencyComboBox.getItems().clear();
            toCurrencyComboBox.getItems().clear();

            fromCurrencyComboBox.getItems().addAll(allCurrencies);
            toCurrencyComboBox.getItems().addAll(allCurrencies);
        }
    }

    public void printFavoriteCurrencies() {
        System.out.println("Kedvenc valuták: " + favoriteCurrencies);
    }

}
