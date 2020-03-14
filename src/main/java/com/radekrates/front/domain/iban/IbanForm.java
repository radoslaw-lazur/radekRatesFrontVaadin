package com.radekrates.front.domain.iban;

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

public class IbanForm extends FormLayout {

    private TextField bankName = new TextField("Bank Name");
    private TextField bankLocalisation = new TextField("Bank Localisation");
    private ComboBox<CurrencyType> currencyCode = new ComboBox<>("Currency Type");
    private TextField ibanNumber = new TextField("Iban Number");
    private Button save = new Button("Save Iban");
    private Label info = new Label("Please fill out all fields for validation");
    private Binder<IbanFormDto> binder = new Binder<>(IbanFormDto.class);


    public IbanForm(@Autowired  DataTransfer dataTransfer, UserLogInDto userLogInDto) {
        currencyCode.setItems(CurrencyType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, info);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(bankName, bankLocalisation, currencyCode, ibanNumber, buttons);
        binder.bindInstanceFields(this);
        binder.setBean(new IbanFormDto(bankName.getValue(), bankLocalisation.getValue(),
                currencyCode.getValue(), ibanNumber.getValue()));
        save.addClickListener(event -> save(dataTransfer, userLogInDto.getUserEmail()));
    }

    private void save(DataTransfer dataTransfer, String userEmail) {
        IbanFormDto ibanFormDto = binder.getBean();
        dataTransfer.saveIban(ibanFormDto, userEmail);
        MainView mainView = new MainView(dataTransfer);
        mainView.refresh(dataTransfer);
        UI.getCurrent().getPage().reload();
    }
}
