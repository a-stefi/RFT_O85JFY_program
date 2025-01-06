package com.example.atm.o85jfy_beadando;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class SettingsController {

    @FXML
    private ListView<String> currencyListView;

    private List<String> availableCurrencies = new ArrayList<>();
    private List<String> selectedCurrencies = new ArrayList<>();

    private CurrencyConverterController currencyConverterController;

    public void setCurrencyConverterController(CurrencyConverterController controller) {
        this.currencyConverterController = controller;
    }

    @FXML
    public void initialize() {
        availableCurrencies.add("Amerikai dollár (USD)");
        availableCurrencies.add("Angol font (GBP)");
        availableCurrencies.add("Ausztrál dollár (AUD)");
        availableCurrencies.add("Brazil real (BRL)");
        availableCurrencies.add("Cseh korona (CZK)");
        availableCurrencies.add("Dán korona (DKK)");
        availableCurrencies.add("Dél-afrikai rand (ZAR)");
        availableCurrencies.add("Euró (EUR)");
        availableCurrencies.add("Fülöp-szigeteki peso (PHP)");
        availableCurrencies.add("Hongkongi dollár (HKD)");
        availableCurrencies.add("Indiai rúpia (INR)");
        availableCurrencies.add("Indonéz rúpia (IDR)");
        availableCurrencies.add("Izraeli új sékel (ILS)");
        availableCurrencies.add("Japán yen (JPY)");
        availableCurrencies.add("Kanadai dollár (CAD)");
        availableCurrencies.add("Kínai jüan (CNY)");
        availableCurrencies.add("Koreai won (KRW)");
        availableCurrencies.add("Malajziai ringgit (MYR)");
        availableCurrencies.add("Magyar forint (HUF)");
        availableCurrencies.add("Mexikói peso (MXN)");
        availableCurrencies.add("Norvég korona (NOK)");
        availableCurrencies.add("Orosz rubel (RUB)");
        availableCurrencies.add("Svájci frank (CHF)");
        availableCurrencies.add("Svéd korona (SEK)");
        availableCurrencies.add("Szingapúri dollár (SGD)");
        availableCurrencies.add("Thaiföldi baht (THB)");
        availableCurrencies.add("Török líra (TRY)");
        availableCurrencies.add("Új-zélandi dollár (NZD)");

        currencyListView.getItems().addAll(availableCurrencies);

        currencyListView.setCellFactory(lv -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    CheckBox checkBox = new CheckBox(item);
                    checkBox.setSelected(selectedCurrencies.contains(item));
                    checkBox.setOnAction(e -> handleCurrencySelection(checkBox, item));

                    HBox hBox = new HBox(checkBox);
                    setGraphic(hBox);
                }
            }
        });
    }
    private void handleCurrencySelection(CheckBox checkBox, String item) {
        if (checkBox.isSelected()) {
            selectedCurrencies.add(item);
        } else {
            selectedCurrencies.remove(item);
        }
    }

    @FXML
    private void handleSaveButtonAction() {
        if (currencyConverterController == null) {
            System.out.println("currencyConverterController referencia NULL!");
        } else {
            System.out.println("currencyConverterController referencia OK!");
        }

        if (currencyConverterController != null) {
            currencyConverterController.setFavoriteCurrencies(selectedCurrencies);
        } else {
            System.out.println("CurrencyConverterController referencia hiányzik!");
        }
    }

}
