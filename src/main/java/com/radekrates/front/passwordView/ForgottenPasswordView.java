package com.radekrates.front.passwordView;

import com.radekrates.front.domain.user.UserForgottenPasswordForm;
import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "getPassword")
public class ForgottenPasswordView extends VerticalLayout {

    public ForgottenPasswordView(@Autowired DataTransfer dataTransfer) {
        UserForgottenPasswordForm userForgottenPasswordForm = new UserForgottenPasswordForm(dataTransfer);
        add(userForgottenPasswordForm);
        this.setSizeFull();
        this.setHorizontalComponentAlignment(Alignment.CENTER, userForgottenPasswordForm);
    }
}
