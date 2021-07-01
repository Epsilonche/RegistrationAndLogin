package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.entities.Company;
import org.hbrs.se2.project.collhbrs.entities.Student;
import org.hbrs.se2.project.collhbrs.util.Globals;
import org.hbrs.se2.project.collhbrs.views.components.CompanyForm;
import org.hbrs.se2.project.collhbrs.views.components.StudentForm;



@Route(value = "profile" , layout = AppView.class)
@PageTitle("Mein Profil")

public class ProfileView extends Div {

    private final CompanyForm companyForm;
    private final StudentForm studentForm;
    private UserDTO current_user = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Student current_student;
    private Company current_company;

    private Button edit = new Button("edit");
    private Dialog form_dialog = new Dialog();

    public ProfileView(ProfileManager profileManager) {
        companyForm = new CompanyForm(profileManager);
        Div companyDiv = new Div(companyForm);
        companyDiv.addClassName("company-div");

        studentForm = new StudentForm(profileManager);
        Div studentDiv = new Div(studentForm);
        studentDiv.addClassName("student-div");
        if(current_user.getUserTyp().equals("Student")){
            form_dialog.add(studentDiv);
        }
        if(current_user.getUserTyp().equals("Unternehmen")){
            form_dialog.add(companyDiv);
        }


        if(profileManager.checkIfProfileIsCreated(current_user)){
            if(current_user.getUserTyp().equals("Student")){
                current_student = profileManager.getStudentById(current_user.getUserId());
            }
            if(current_user.getUserTyp().equals("Unternehmen")){
                current_company = profileManager.getCompanyById(current_user.getUserId());
            }
            add(createTitle());
            add(showProfileLayout());
            add(createButtonEditLayout());
        }else {
            add(new H3("Sie müssen erst ein Profil erstellen:"));
            Button erstellen = new Button("Profil erstellen");
            erstellen.addClickListener(buttonClickEvent -> {form_dialog.open();});
            add(erstellen);
            form_dialog.open();
        }


    }

    private Component showProfileLayout() {
        VerticalLayout userProfileInformation = new VerticalLayout();

        Span firstNameLine = new Span("Vorname: "+current_user.getFirstName());
        Span lastNameLine = new Span("Nachname: "+current_user.getLastName());
        Span emailLine = new Span("Email: "+current_user.geteMail());
        Span userTypeLine = new Span("Benutzer Typ: "+current_user.getUserTyp());

        userProfileInformation.add(new H5("Benutzerdaten:"),
                firstNameLine,
                lastNameLine,
                emailLine,
                userTypeLine);

        if(current_user.getUserTyp().equals("Student") ){

            Span matrikelNrLine = new Span("Matrikel Nr: "+current_student.getMatrikelNr());
            Span degreeCourseLine = new Span("Studiengang: "+current_student.getDegreeCourse());
            Span universityLine  = new Span("Universität/Hochschule: "+current_student.getUniversity());

            userProfileInformation.add(new H5("Student Profildaten:"),
                    matrikelNrLine,
                    degreeCourseLine,
                    universityLine);

        }
        if(current_user.getUserTyp().equals("Unternehmen")){
            Span titleLine = new Span("Title: "+current_company.getTitle());
            Span descriptionLine = new Span("Description: "+current_company.getDescription());

            userProfileInformation.add(new H5("Company Profildaten:"),
                    titleLine,
                    descriptionLine
            );

        }

        return userProfileInformation;
    }
    //Füllen der Felder mit den Daten des aktuellen Users
    //Felder vor der Bearbeitung schützen

    private Component createTitle() {
        return new H3("Mein Profil");
    }
    private Component createButtonEditLayout(){
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        buttonLayout.add(edit);
        edit.addClickListener(buttonClickEvent -> {
            form_dialog.open();
        });
        return buttonLayout;
    }


}