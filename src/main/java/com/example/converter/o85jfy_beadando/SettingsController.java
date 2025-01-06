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
