package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.impl.UserDTOImpl;


@Route(value = "delete")
@PageTitle("Delete Profile")
@CssImport("./styles/views/entercar/enter-car-view.css")
public class DeleteProfileView extends Div {


    private PasswordField password = new PasswordField("Passwort");
    private TextField username = new TextField("Username");

    private com.vaadin.flow.component.button.Button back = new com.vaadin.flow.component.button.Button("Back");
    private com.vaadin.flow.component.button.Button delete = new com.vaadin.flow.component.button.Button("Delete");

    private Binder<UserDTOImpl> binder = new Binder(UserDTOImpl.class);

    public DeleteProfileView(ProfileManager profileManager) {
        addClassName("person-form-view");
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();


        delete.addClickListener(e -> {

            profileManager.deleteUser(binder.getBean());
            Notification.show("Profil gelöscht");
            UI.getCurrent().navigate(RegistrationView.class);
        });
        back.addClickListener(e ->{
            UI.getCurrent().navigate(ProfileView.class);

        });

    }
    private void clearForm() {
        binder.setBean(new UserDTOImpl());
    }

    private Component createTitle() {

        return new H3("Profil löschen");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(username, password);
        return formLayout;
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
