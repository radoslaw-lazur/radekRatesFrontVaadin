package com.radekrates.front.domain.user;

import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
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
    private Button checkGitHubButton = new Button("Check my project on GitHub :)");
    private Button checkLinkedInButton = new Button("Check my profil on LinkedIn :)");
    private Binder<UserSignInFormDto> binder = new Binder<>(UserSignInFormDto.class);
    private Label description = new Label("Password must contain at least one lower case," +
            " upper case, numeric and special character. When you have been registered, press Log in button.");
    private Label info = new Label("After signing in, there is a need to activate the account with the activation " +
            "link displayed in the activation E-mail. Thanks :)");

    public UserSignInForm(@Autowired DataTransfer dataTransfer) {
        signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        logInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        checkGitHubButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        checkLinkedInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        age.setItems(AgeType.values());
        country.setItems(CountryType.values());
        add(checkGitHubButton, checkLinkedInButton, email, password, userFirstName, userLastName, age, country,
                signInButton, logInButton, info, description);
        binder.bindInstanceFields(this);
        binder.setBean(new UserSignInFormDto(email.getValue(), password.getValue(), userFirstName.getValue(),
                userLastName.getValue(), age.getValue(), country.getValue()));
        signInButton.addClickListener(event -> process(dataTransfer));
        logInButton.addClickListener(event -> UI.getCurrent().navigate("logIn"));
        checkGitHubButton.addClickListener(event -> navigateToGitHub());
        checkLinkedInButton.addClickListener(event -> navigateToLinkedIn());
    }

    private void process(DataTransfer dataTransfer) {
        UserSignInFormDto userSignInFormDtoBean = binder.getBean();
        dataTransfer.saveUser(userSignInFormDtoBean);
        UI.getCurrent().navigate("logIn");
    }

    private void navigateToGitHub() {
        UI.getCurrent().getPage().open("https://github.com/radoslaw-lazur");
    }

    private void navigateToLinkedIn() {
        UI.getCurrent().getPage().open("https://www.linkedin.com/in/rados%C5%82aw-%C5%82azur-050597137/");
    }
}
