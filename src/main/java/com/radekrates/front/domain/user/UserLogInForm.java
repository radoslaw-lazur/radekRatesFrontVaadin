package com.radekrates.front.domain.user;

import com.radekrates.front.mainview.MainView;
import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLogInForm extends FormLayout {
    private EmailField userEmail = new EmailField("E-mail");
    private PasswordField password = new PasswordField("Password");
    private Button logInButton = new Button("Log in");
    private Binder<UserLogInDto> binder = new Binder<>(UserLogInDto.class);
    private Image logo = new Image();

    public UserLogInForm(@Autowired DataTransfer dataTransfer) {
        logo.setSrc("https://zapodaj.net/images/9700ac87f542a.jpg");
        HorizontalLayout buttons = new HorizontalLayout(logInButton);
        HorizontalLayout images = new HorizontalLayout(logo);
        logInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(images, new Label(), userEmail, password, buttons);
        binder.bindInstanceFields(this);
        UserLogInDto userLogInDto = new UserLogInDto(userEmail.getValue(), password.getValue());
        binder.setBean(userLogInDto);
        logInButton.addClickListener(event -> process(dataTransfer, userLogInDto));
    }

    private void process(DataTransfer dataTransfer, UserLogInDto userLogInDto) {
        ValidatedUser validatedUser = dataTransfer.getUserValidation(userLogInDto);
        if ((userLogInDto.getUserEmail().equals(validatedUser.getUserEmail()) &&
                (userLogInDto.getPassword().equals(validatedUser.getPassword())))) {
            UserLogInDto userLogInDtoBean = binder.getBean();
            dataTransfer.setUserToMain(userLogInDtoBean);
            MainView mainView = new MainView(dataTransfer);
            mainView.refresh(dataTransfer);
            UI.getCurrent().navigate("main");
        }
    }
}
