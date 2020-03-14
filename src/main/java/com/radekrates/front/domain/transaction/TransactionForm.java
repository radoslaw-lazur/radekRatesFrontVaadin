package com.radekrates.front.domain.transaction;

import com.radekrates.front.domain.user.UserLogInDto;
import com.radekrates.front.mainview.MainView;
import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionForm extends FormLayout {
    private ComboBox<String> inputIbanNumber = new ComboBox<>("Input Iban Number");
    private ComboBox<String> outputIbanNumber = new ComboBox<>("Output Iban Number");
    private TextField inputValue = new TextField("Input Value");
    private Button save = new Button("Save Transaction");
    private Label label = new Label("Please fill out all fields for validation");
    private Binder<TransactionFormDto> binder = new Binder<>(TransactionFormDto.class);


    public TransactionForm(@Autowired DataTransfer dataTransfer, UserLogInDto userLogInDto) {
        inputIbanNumber.setItems(dataTransfer.getIbansComboBox(userLogInDto));
        outputIbanNumber.setItems(dataTransfer.getIbansComboBox(userLogInDto));
        HorizontalLayout buttons = new HorizontalLayout(save, label);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(inputIbanNumber, outputIbanNumber, inputValue, new Label(), buttons);
        binder.bindInstanceFields(this);
        binder.setBean(new TransactionFormDto(inputIbanNumber.getValue(), outputIbanNumber.getValue(),
                inputValue.getValue()));
        save.addClickListener(event -> save(dataTransfer, userLogInDto.getUserEmail()));
    }

    private void save(DataTransfer dataTransfer, String userEmail) {
        TransactionFormDto transactionFormDto = binder.getBean();
        dataTransfer.saveTransaction(transactionFormDto, userEmail);
        MainView mainView = new MainView(dataTransfer);
        mainView.refresh(dataTransfer);
        UI.getCurrent().getPage().reload();
    }
}
