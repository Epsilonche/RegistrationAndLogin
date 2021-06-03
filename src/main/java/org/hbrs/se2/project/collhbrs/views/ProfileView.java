package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouteAlias;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.util.Globals;

@Route(value = "profile" )
@PageTitle("Mein Profil")

public class ProfileView extends Div {
    //Student Form Attribute
    private TextField first_name = new TextField("Vorname");
    private TextField last_name = new TextField("Name");
    private EmailField email = new EmailField("E-Mail");
    private DatePicker date_of_birth = new DatePicker("Geburstdatum");
    private TextField skills = new TextField("Fähigkeiten");
    private IntegerField matrikel_nr = new IntegerField("Matikelnummer");
    private IntegerField phone = new IntegerField("Telefonnummer");
    private TextField street = new TextField("Straße");
    private IntegerField house_number = new IntegerField("Hausnummer");
    private IntegerField postal_code = new IntegerField("PLZ");
    private TextField city = new TextField("Ort");
    private TextField university = new TextField("Universität");
    private TextField degree_course = new TextField("Studiengang");
    private ComboBox<String> security_question_id = new ComboBox<>("Sicherheitsfrage");
    private TextField security_answer = new TextField("Antwort Sicherheitsfrage");

    //company attributes
    private TextField branch = new TextField("branch");
    private TextField title = new TextField("title");
    private TextField role = new TextField("role");
    private TextField company = new TextField("company");
    private TextField description= new TextField("description");



    private Button edit = new Button("Profil bearbeiten");
    private Button delete = new Button ("Profil löschen");

    public ProfileView() {

        addClassName("person-form-view");
        add(createTitle());
        //based on profilManager show StudentView or UnternehmerView
        if("student".equals("student")) {
            add(createStudentFormLayout());
        }else{
            add(createCompanyFormLayout());
        }
        add(createButtonLayout());
        fillwithdata();

        security_question_id.setItems("In welcher Stadt bzw. an welchem Ort wurden Sie geboren?","Welches war Ihr erstes Konzert, das Sie besucht haben?","Geben Sie Marke und Modell Ihres ersten Autos an.");
        //Durch betätigen des Buttons edit wird der Benutzer auf Profil
        //bearbeiten weitergeleitet
        edit.addClickListener(e-> {
            UI.getCurrent().navigate(Globals.Pages.PROFILE_EDIT);});

        //Durch betätigen des Buttons edit wird der Benutzer auf Profil
        //löschen weitergeleitet
        delete.addClickListener(e-> {
            UI.getCurrent().navigate(Globals.Pages.PROFILE_DELETE);
        });
    }
    //Füllen der Felder mit den Daten des aktuellen Users
    //Felder vor der Bearbeitung schützen

    private void fillwithdata(){
        UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
        first_name.setValue(userDTO.getFirstName()); first_name.setReadOnly(true);
        last_name.setValue(userDTO.getLastName());last_name.setReadOnly(true);
        university.setReadOnly(true);
        security_answer.setReadOnly(true);
        skills.setReadOnly(true);
        security_question_id.setReadOnly(true);
        street.setReadOnly(true);
        house_number.setReadOnly(true);
        date_of_birth.setReadOnly(true);
        postal_code.setReadOnly(true);
        phone.setReadOnly(true);
        email.setReadOnly(true);
        city.setReadOnly(true);
        degree_course.setReadOnly(true);
        matrikel_nr.setReadOnly(true);

    }

    private Component createTitle() {

        return new H3("Mein Profil");
    }
    //Hinzufügen der Felder auf der Seite
    private Component createStudentFormLayout() {
        FormLayout formLayout = new FormLayout();
//        binder.bindInstanceFields(this);
        email.setErrorMessage("Bitte geben Sie eine gültige E-Mail ein");
        formLayout.add(first_name, last_name, date_of_birth, email,skills,street,
                house_number,postal_code,city,phone,matrikel_nr,university,degree_course,
                security_question_id,security_answer);
        return formLayout;
    }
    private Component createCompanyFormLayout() {
        FormLayout formLayout = new FormLayout();
//        binder.bindInstanceFields(this);

        email.setErrorMessage("Bitte geben Sie eine gültige E-Mail ein");
        formLayout.add(title,role,company,description,branch);
        return formLayout;
    }


    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        edit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        buttonLayout.add(edit);
        buttonLayout.add(delete);

        return buttonLayout;
    }



}