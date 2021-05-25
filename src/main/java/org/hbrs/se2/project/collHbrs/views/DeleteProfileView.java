package org.hbrs.se2.project.collHbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;



@Route(value = "DeleteProfile", layout = AppView.class)
@PageTitle("Delete Profile")
@CssImport("./styles/views/entercar/enter-car-view.css")
public class DeleteProfileView extends Div {

    private com.vaadin.flow.component.button.Button back = new com.vaadin.flow.component.button.Button("Back");
    private com.vaadin.flow.component.button.Button delete = new com.vaadin.flow.component.button.Button("Delete");

    public DeleteProfileView() {
        addClassName("delete-profile-view");

        add(createNameField());
        add(createPasswordField());
        add(createButtonLayout());

    }

    private TextField createNameField() {
        //TextField to enter the Username
        TextField usernameField = new TextField("Enter your Name");
        //usernameField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        return usernameField;
    }

    private PasswordField createPasswordField() {
        // add password field
        PasswordField passwordfield = new PasswordField();
        passwordfield.setLabel("Password");
        passwordfield.setPlaceholder("Enter password");
        passwordfield.setValue("secret1");
        return passwordfield;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(delete);
        buttonLayout.add(back);
        return buttonLayout;
    }

    // need DialogField -> "your account was deleted"
    // Exception for wrong input
}

