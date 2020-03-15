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
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

public class IbanToDeleteForm extends FormLayout {
    private ComboBox<String> ibanNumber = new ComboBox<>("Select Iban to delete");
    private Button deleteButton = new Button("Delete Iban");
    private Binder<IbanToDeleteFormDto> binder = new Binder<>(IbanToDeleteFormDto.class);

    public IbanToDeleteForm(@Autowired DataTransfer dataTransfer, UserLogInDto userLogInDto) {
        ibanNumber.setItems(dataTransfer.getIbansComboBox(userLogInDto));
        HorizontalLayout buttons = new HorizontalLayout(deleteButton);
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        add(ibanNumber, new Label(), buttons);
        binder.bindInstanceFields(this);
        binder.setBean(new IbanToDeleteFormDto(ibanNumber.getValue()));
        deleteButton.addClickListener(event -> delete(dataTransfer, userLogInDto));
    }

    private void delete(DataTransfer dataTransfer, UserLogInDto userLogInDto) {
        IbanToDeleteFormDto ibanToDeleteFormDto = binder.getBean();
        dataTransfer.deleteIbanById(ibanToDeleteFormDto, userLogInDto);
        MainView mainView = new MainView(dataTransfer);
        mainView.refresh(dataTransfer);
        UI.getCurrent().getPage().reload();
    }
}
