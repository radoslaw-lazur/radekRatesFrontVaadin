package com.radekrates.front.signinview;

import com.radekrates.front.domain.user.UserSignInForm;
import com.radekrates.front.service.DataTransfer;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "")
public class SignInView extends HorizontalLayout {

    public SignInView(@Autowired DataTransfer dataTransfer) {

        UserSignInForm userSignInForm = new UserSignInForm(dataTransfer);
        add(userSignInForm);
    }
}
