package com.radekrates.front.loginview;

import com.radekrates.front.domain.user.UserLogInForm;
import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "logIn")
public class LogInView extends HorizontalLayout {

    public LogInView(@Autowired DataTransfer dataTransfer) {
        UserLogInForm userLogInForm = new UserLogInForm(dataTransfer);
        add(userLogInForm);
    }
}
