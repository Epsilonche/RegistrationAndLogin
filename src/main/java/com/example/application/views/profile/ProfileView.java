package com.example.application.views.profile;


import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.data.renderer.TemplateRenderer;

@Route(value = "profile", layout = MainView.class)
@PageTitle("Mein Profil")
public class ProfileView extends Div {

    private TextField firstName = new TextField("Vorname");
    private TextField lastName = new TextField("Name");
    private TextField Dienstleistungen = new TextField("Dienstleistungen");
    private EmailField email = new EmailField("E-Mail");
    private DatePicker dateOfBirth = new DatePicker("Geburtsdatum");
    private TextField street = new TextField("Straße");
    private TextField ort = new TextField("Ort");
    private IntegerField plz = new IntegerField("Postleitzahl");
    private PasswordField password = new PasswordField("Passwort ");
    private IntegerField matrikel = new IntegerField("Matrikelnummer");


    private Button cancel = new Button("Abbrechen");
    private Button save = new Button("Speichern");

    private Binder<SamplePerson> binder = new Binder(SamplePerson.class);

    public ProfileView(SamplePersonService personService) {
        addClassName("profile-form-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            personService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + "Angaben gespeichert.");
            clearForm();
        });
    }

    private void clearForm() {

        binder.setBean(new SamplePerson());
    }

    private Component createTitle() {
        return new H3("Profil bearbeiten");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Bitte geben Sie eine gültige E-Mail Adresse ein.");
        formLayout.add(firstName, lastName, dateOfBirth, email,password,street,ort,plz,Dienstleistungen,matrikel);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }





}

