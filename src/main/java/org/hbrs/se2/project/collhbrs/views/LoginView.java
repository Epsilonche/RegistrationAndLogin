package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
//import org.apache.catalina.Globals;
import org.hbrs.se2.project.collhbrs.control.LoginControl;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.hbrs.se2.project.collhbrs.control.exception.DatabaseUserException;
import org.hbrs.se2.project.collhbrs.util.Globals;

@Route(value = "" )
@RouteAlias(value = "login")
public class LoginView extends VerticalLayout {

    @Autowired
    private LoginControl loginControl;
    private Button register = new Button("Registrieren");

    public LoginView() {
        setSizeFull();
        add(createTitle());

        register.addClickListener(e-> {
            //Globals anpasssen
            UI.getCurrent().navigate(Globals.Pages.REGISTRATION_VIEW);});

        LoginForm component = new LoginForm();
        component.addLoginListener(e -> {

            boolean isAuthenticated = false;
            try {
                isAuthenticated = loginControl.authentificate( e.getUsername() , e.getPassword() );

            } catch (DatabaseUserException databaseException) {
                Dialog dialog = new Dialog();
                dialog.add( new Text( databaseException.getReason()) );
                dialog.setWidth("400px");
                dialog.setHeight("150px");
                dialog.open();
            }
            if (isAuthenticated) {
                grabAndSetUserIntoSession();
                navigateToMainPage();

            } else {
                component.setError(true);
            }
        });

        add(component);
        add(createButtonLayout());
        this.setAlignItems( Alignment.CENTER );
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        register.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(register);
        return buttonLayout;
    }

    private Component createTitle() {
        return new H3("Herzlich Willkommen auf der Kollaborationsplattform Coll@HBRS!");
    }
    private void grabAndSetUserIntoSession() {
        UserDTO userDTO = loginControl.getCurrentUser();
        UI.getCurrent().getSession().setAttribute( Globals.CURRENT_USER , userDTO );
    }


    private void navigateToMainPage() {
        // Navigation zur Startseite, hier die Profilseite
        UI.getCurrent().navigate(Globals.Pages.PROFILE_VIEW);

    }
}
