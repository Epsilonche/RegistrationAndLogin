package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.CompanyDTOImpl;
import org.hbrs.se2.project.collhbrs.dtos.impl.StudentDTOImpl;
import org.hbrs.se2.project.collhbrs.util.Globals;
import org.hbrs.se2.project.collhbrs.views.components.CompanyForm;
import org.hbrs.se2.project.collhbrs.views.components.StudentForm;

@Route(value = "profile" , layout = AppView.class)
@PageTitle("Mein Profil")

public class ProfileView extends Div {
    //Student Form Attribute
    private TextField first_name = new TextField("Vorname");
    private TextField last_name = new TextField("Name");
    private EmailField email = new EmailField("E-Mail");
    private IntegerField matrikel_nr = new IntegerField("Matikelnummer");
    private TextField university = new TextField("Universität");
    private TextField degree_course = new TextField("Studiengang");

    //company attributes
    private TextField branch = new TextField("branch");
    private TextField title = new TextField("title");
    private TextField role = new TextField("role");
    private TextField company = new TextField("company");
    private TextField description= new TextField("description");



    private Button save = new Button("Profil erstellen");
    private Button delete = new Button ("Profil löschen");

    private Button create_profile = new Button("Profil erstellen");
    //private Binder<StudentDTOImpl> studentBinder = new Binder(StudentDTOImpl.class);
    //private Binder<CompanyDTOImpl> companyBinder = new Binder(CompanyDTOImpl.class);


    private final CompanyForm companyForm;
    private final StudentForm studentForm;


    public ProfileView(ProfileManager profileManager) {
        /*
        addClassName("person-form-view");
        add(createTitle());
        //based on profilManager show StudentView or UnternehmerView
        if(profileManager.checkIfProfileIsCreated()) {
            if (profileManager.isStudent()) {
                add(createStudentFormLayout());
            } else if (profileManager.isCompany()) {
                add(createCompanyFormLayout());
            }
        }else{
            add(create_profile);
        }
        add(createButtonLayout());
        fillwithdata();

        save.addClickListener(e-> {
            if(profileManager.isStudent()) {
                studentBinder.bindInstanceFields(this);
                profileManager.createStudentProfile(studentBinder.getBean());
            }else if(profileManager.isCompany()){
                companyBinder.bindInstanceFields(this);
                profileManager.createCompanyProfile(companyBinder.getBean());
            }
        });

        //Durch betätigen des Buttons edit wird der Benutzer auf Profil
        //löschen weitergeleitet
        delete.addClickListener(e-> {
            UI.getCurrent().navigate(Globals.Pages.PROFILE_DELETE);
        });


        create_profile.addClickListener(e-> {
            //TODO : routes to page with form to create a profile
        });*/
        companyForm = new CompanyForm(profileManager);
        Div companyDiv = new Div(companyForm);
        companyDiv.addClassName("company-div");

        studentForm = new StudentForm(profileManager);
        Div studentDiv = new Div(studentForm);
        studentDiv.addClassName("student-div");

        add(companyDiv,studentDiv);


    }
    //Füllen der Felder mit den Daten des aktuellen Users
    //Felder vor der Bearbeitung schützen

    private void fillwithdata(){
        UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
        first_name.setValue(userDTO.getFirstName());
        last_name.setValue(userDTO.getLastName());
    }

    private Component createTitle() {

        return new H3("Mein Profil");
    }
    //Hinzufügen der Felder auf der Seite
    private Component createStudentFormLayout() {
        FormLayout formLayout = new FormLayout();
//        binder.bindInstanceFields(this);
        email.setErrorMessage("Bitte geben Sie eine gültige E-Mail ein");
        formLayout.add(matrikel_nr,university,degree_course);
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
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);

        buttonLayout.add(save);
        buttonLayout.add(delete);

        return buttonLayout;
    }



}