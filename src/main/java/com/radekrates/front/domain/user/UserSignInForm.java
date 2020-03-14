package com.radekrates.front.domain.user;

import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSignInForm extends FormLayout {
    private EmailField email = new EmailField("User E-mail");
    private PasswordField password = new PasswordField("Password");
    private TextField userFirstName = new TextField("User First Name");
    private TextField userLastName = new TextField("User Last Name");
    private ComboBox<AgeType> age = new ComboBox<>("Age");
    private ComboBox<CountryType> country = new ComboBox<>("Country");
    private Button signInButton = new Button("Sign in");
    private Button logInButton = new Button("Log in");
    private Binder<UserSignInFormDto> binder = new Binder<>(UserSignInFormDto.class);
    private Image logo = new Image();
    private Label description = new Label("Password must contain at least one lower case," +
            " upper case, numeric and special character. When you have been registered, press Log in button.");
    private Label info = new Label("After signing in, there is a need to activate the account with the activation " +
            "link displayed in the activation E-mail. Thanks :)");

    public UserSignInForm(@Autowired DataTransfer dataTransfer) {
        logo.setSrc("https://zapodaj.net/images/9700ac87f542a.jpg");
        age.setItems(AgeType.values());
        country.setItems(CountryType.values());
        HorizontalLayout buttons = new HorizontalLayout(signInButton, description, logInButton);
        HorizontalLayout images = new HorizontalLayout(logo);
        signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        logInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(images, new Label(), email, password, userFirstName, userLastName, age, country, buttons, info);
        binder.bindInstanceFields(this);
        binder.setBean(new UserSignInFormDto(email.getValue(), password.getValue(), userFirstName.getValue(),
                userLastName.getValue(), age.getValue(), country.getValue()));
        signInButton.addClickListener(event -> process(dataTransfer));
        logInButton.addClickListener(event -> UI.getCurrent().navigate("logIn"));
    }

    private void process(DataTransfer dataTransfer) {
        UserSignInFormDto userSignInFormDtoBean = binder.getBean();
        dataTransfer.saveUser(userSignInFormDtoBean);
        UI.getCurrent().navigate("logIn");
    }
}
