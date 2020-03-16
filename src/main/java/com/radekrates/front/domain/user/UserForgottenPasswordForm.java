package com.radekrates.front.domain.user;

import com.radekrates.front.mainview.MainView;
import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

public class UserForgottenPasswordForm extends FormLayout {
    private Image logo = new Image();
    private EmailField userEmail = new EmailField("E-mail");
    private Button password = new Button("Get my password");
    private Button returnToLogIn = new Button("Return");
    private Label info = new Label("To get password you have to be activated. Check the Email inbox for password.");
    private Binder<UserForgottenPasswordFormDto> binder = new Binder<>(UserForgottenPasswordFormDto.class);

    public UserForgottenPasswordForm(@Autowired DataTransfer dataTransfer) {
        logo.setSrc("https://zapodaj.net/images/d291b05e536d8.jpg");
        password.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        returnToLogIn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(logo, new Label(), userEmail, new Label(), password, new Label(), info, new Label(), returnToLogIn);
        binder.bindInstanceFields(this);
        binder.setBean(new UserForgottenPasswordFormDto(userEmail.getValue()));
        password.addClickListener(event -> process(dataTransfer));
        returnToLogIn.addClickListener(event -> UI.getCurrent().navigate("logIn"));
    }

    private void process(DataTransfer dataTransfer) {
        UserForgottenPasswordFormDto remindedUser = binder.getBean();
        dataTransfer.remindPassword(remindedUser);
        MainView mainView = new MainView(dataTransfer);
        mainView.refresh(dataTransfer);
        UI.getCurrent().navigate("logIn");
    }
}
