package org.hbrs.se2.project.collHbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.collHbrs.dtos.RegistrationResult;
import org.hbrs.se2.project.collHbrs.dtos.impl.UserDTO;
import org.hbrs.se2.project.collHbrs.control.RegistrationControl;
@Route(value = "register")
@PageTitle("Registration")
public class RegistrationView extends Div{
    private TextField username = new TextField("Username");
    private TextField password = new TextField("Password");

    private Button signUp = new Button("Sign up");
    private Binder<UserDTO> binder = new Binder(UserDTO.class);

    public RegistrationView(RegistrationControl registrationService){
        addClassName("registration");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        signUp.addClickListener(e -> {
            // Speicherung der Daten über das zuhörige Control-Object.
            // Daten des Autos werden aus Formular erfasst und als DTO übergeben.
            // Zusätzlich wird das aktuelle UserDTO übergeben.
            RegistrationResult result =  registrationService.createUser(binder.getBean());

            if (result.isSaved() == true) {
                Notification.show("registration successful.");
                clearForm();
            }
            else{
                Notification.show(result.getResultDescription());
            }


        });

    }
    private void clearForm() {
        binder.setBean(new UserDTO());
    }
    private Component createTitle() {
        return new H3("Registration form");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(username, password);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        signUp.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(signUp);
        return buttonLayout;
    }



}

