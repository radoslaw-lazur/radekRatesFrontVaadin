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

public class IbanToUpdateForm extends FormLayout {
    private TextField bankNameUpdate = new TextField("Update Bank Name");
    private TextField bankLocalisationUpdate = new TextField("Update Bank Localisation");
    private ComboBox<CurrencyType> currencyCodeUpdate = new ComboBox<>("Update Currency Type");
    private ComboBox<String> ibanNumberUpdate = new ComboBox<>("Iban Number to update");
    private Button update = new Button("Update Iban");
    private Label info = new Label("Please fill out all fields for validation");
    private Binder<IbanToUpdateFormDto> binder = new Binder<>(IbanToUpdateFormDto.class);

    public IbanToUpdateForm(@Autowired DataTransfer dataTransfer, UserLogInDto userLogInDto) {
        currencyCodeUpdate.setItems(CurrencyType.values());
        ibanNumberUpdate.setItems(dataTransfer.getIbansComboBox(userLogInDto));
        HorizontalLayout buttons = new HorizontalLayout(update, info);
        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(ibanNumberUpdate, bankNameUpdate, bankLocalisationUpdate, currencyCodeUpdate, buttons);
        binder.bindInstanceFields(this);
        binder.setBean(new IbanToUpdateFormDto(bankNameUpdate.getValue(), bankLocalisationUpdate.getValue(),
                currencyCodeUpdate.getValue(), ibanNumberUpdate.getValue()));
        update.addClickListener(event -> update(dataTransfer, userLogInDto.getUserEmail()));
    }

    private void update(DataTransfer dataTransfer, String userEmail) {
        IbanToUpdateFormDto ibanToUpdateFormDto = binder.getBean();
        dataTransfer.updateIban(ibanToUpdateFormDto, userEmail);
        MainView mainView = new MainView(dataTransfer);
        mainView.refresh(dataTransfer);
        UI.getCurrent().getPage().reload();
    }
}
