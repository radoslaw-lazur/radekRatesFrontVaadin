package com.radekrates.front.mainview;

import com.radekrates.front.domain.iban.Iban;
import com.radekrates.front.domain.iban.IbanForm;
import com.radekrates.front.domain.iban.IbanToDeleteForm;
import com.radekrates.front.domain.iban.IbanToUpdateForm;
import com.radekrates.front.domain.transaction.Transaction;
import com.radekrates.front.domain.transaction.TransactionForm;
import com.radekrates.front.domain.user.UserLogInDto;
import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "main")
public class MainView extends VerticalLayout {
    private Grid<Iban> ibanDtoGrid = new Grid<>(Iban.class);
    private Grid<Transaction> transactionGrid = new Grid<>(Transaction.class);
    private TextField filterCurrencyCode = new TextField();
    private TextField filterIbanNumber = new TextField();
    private TextField filterPairTransaction = new TextField();
    private Label instructionIban = new Label("Please, provide the Iban number as shown in following example:" +
            " EExxxxxxxxxxxxxxxxxx where E - letter (country code), x - numeric case. x quantity is 18.");
    private Label instuctionTransaction = new Label("After saving the Transaction the Email regarding order is sent. " +
            "Please check this Email. Thank You :)");
    private Image logo = new Image();
    private Button logOut = new Button("Log out :(");
    private Button checkGitHubButton = new Button("Check my project on GitHub :)");
    private Button checkLinkedInButton = new Button("Check my profil on LinkedIn :)");

    public MainView(@Autowired DataTransfer dataTransfer) {
        logo.setSrc("https://zapodaj.net/images/9700ac87f542a.jpg");
        logOut.addClickListener(event -> UI.getCurrent().navigate(""));
        logOut.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        UserLogInDto userOnTheTable = dataTransfer.getUserToMain();
        filterCurrencyCode.setPlaceholder("Filter by Currency Code");
        filterCurrencyCode.setClearButtonVisible(true);
        filterCurrencyCode.setValueChangeMode(ValueChangeMode.EAGER);
        filterIbanNumber.setPlaceholder("Filter by Iban Number");
        filterIbanNumber.setClearButtonVisible(true);
        filterIbanNumber.setValueChangeMode(ValueChangeMode.EAGER);
        filterPairTransaction.setPlaceholder("Filter by Currency Pair");
        filterPairTransaction.setClearButtonVisible(true);
        filterPairTransaction.setValueChangeMode(ValueChangeMode.EAGER);

        ibanDtoGrid.setColumns("bankName", "bankLocalisation", "currencyCode", "ibanNumber");
        transactionGrid.setColumns("date", "userEmail", "inputIbanNumber", "outputIbanNumber", "currencyPair",
                "inputValue", "outputValue", "purchased", "sold", "difference");

        filterCurrencyCode.addValueChangeListener(event -> updateCurrencyCode(dataTransfer));
        filterIbanNumber.addValueChangeListener(event -> updateIbanNumber(dataTransfer));
        filterPairTransaction.addValueChangeListener(event -> updateTransactionPair(dataTransfer));
        checkGitHubButton.addClickListener(event -> navigateToGitHub());
        checkLinkedInButton.addClickListener(event -> navigateToLinkedIn());
        refresh(dataTransfer);

        IbanForm ibanForm = new IbanForm(dataTransfer, userOnTheTable);
        IbanToUpdateForm ibanToUpdateForm = new IbanToUpdateForm(dataTransfer, userOnTheTable);
        IbanToDeleteForm ibanToDeleteForm = new IbanToDeleteForm(dataTransfer, userOnTheTable);
        VerticalLayout mainContentIban = new VerticalLayout(ibanDtoGrid, instructionIban, ibanForm,
                ibanToUpdateForm, ibanToDeleteForm);
        mainContentIban.setSizeFull();


        add(logo, logOut, checkGitHubButton, checkLinkedInButton, filterCurrencyCode, filterIbanNumber, mainContentIban);

        TransactionForm transactionForm = new TransactionForm(dataTransfer, userOnTheTable);
        VerticalLayout mainContentTransaction = new VerticalLayout(transactionGrid, transactionForm);
        mainContentTransaction.setSizeFull();

        add(filterPairTransaction, mainContentTransaction, instuctionTransaction);
        //setSizeFull();
    }

    public void refresh(DataTransfer dataTransfer) {
        ibanDtoGrid.setItems(dataTransfer.getIbans(dataTransfer.getUserToMain(), "", null));
        transactionGrid.setItems(dataTransfer.getTransactions(dataTransfer.getUserToMain(), "", null));
    }

    private void updateCurrencyCode(DataTransfer dataTransfer) {
        ibanDtoGrid.setItems(dataTransfer.getIbans(dataTransfer.getUserToMain(), "currencyCode",
                filterCurrencyCode.getValue()));
    }

    private void updateIbanNumber(DataTransfer dataTransfer) {
        ibanDtoGrid.setItems(dataTransfer.getIbans(dataTransfer.getUserToMain(), "ibanNumber",
                filterIbanNumber.getValue()));
    }

    private void updateTransactionPair(DataTransfer dataTransfer) {
        transactionGrid.setItems(dataTransfer.getTransactions(dataTransfer.getUserToMain(), "pair",
                filterPairTransaction.getValue()));
    }

    private void navigateToGitHub() {
        UI.getCurrent().getPage().open("https://github.com/radoslaw-lazur");
    }

    private void navigateToLinkedIn() {
        UI.getCurrent().getPage().open("https://www.linkedin.com/in/rados%C5%82aw-%C5%82azur-050597137/");
    }
}
