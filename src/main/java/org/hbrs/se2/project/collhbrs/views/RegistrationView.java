package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.collhbrs.datatypes.RegistrationResult;
import org.hbrs.se2.project.collhbrs.control.RegistrationControl;
import org.hbrs.se2.project.collhbrs.dtos.impl.UserDTOImpl;

@Route(value = "register", layout = AppView.class)
@PageTitle("Registrierung")
public class RegistrationView extends Div{

    private TextField first_name = new TextField("Vorname");
    private TextField last_name = new TextField("Nachname");
    private TextField email= new TextField("E-Mail");
    private TextField username = new TextField("Benutzername");
    private PasswordField password = new PasswordField("Passwort"); //hidden password


    private Button signUp = new Button("registrieren");
    private Binder<UserDTOImpl> binder = new Binder(UserDTOImpl.class);

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
                Notification.show("Erfolgreich registriert");
                clearForm();
            }
            else{
                Notification.show(result.getResultDescription());
            }


        });

    }
    private void clearForm() {
        binder.setBean(new UserDTOImpl());
    }
    private Component createTitle() {
        return new H3("Registrierung:");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(first_name,last_name,email,username, password);
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
