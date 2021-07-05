package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.entities.Company;
import org.hbrs.se2.project.collhbrs.entities.Student;
import org.hbrs.se2.project.collhbrs.entities.User;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.hbrs.se2.project.collhbrs.services.ImageService;
import org.hbrs.se2.project.collhbrs.util.Globals;
import org.hbrs.se2.project.collhbrs.views.components.CompanyForm;
import org.hbrs.se2.project.collhbrs.views.components.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Route(value = "profile" , layout = AppView.class)
@PageTitle("Mein Profil")

public class ProfileView extends Div {

    private Upload upload;
    private User user;
    private HorizontalLayout imageContainer;
    @Autowired
    private UserRepository userRepository;


    private final CompanyForm companyForm;
    private final StudentForm studentForm;
    private UserDTO current_user = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Student current_student;
    private Company current_company;

    private Button edit = new Button("edit");
    private Dialog form_dialog = new Dialog();

    private Button delete = new Button("Profil löschen");


    public ProfileView(ProfileManager profileManager) {

        //TODO Edit user data

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

        Button save = new Button("Speichern");
        save.addClickListener(buttonClickEvent -> {
            if(current_user.getUserTyp().equals("Student")){
                studentForm.save(profileManager);
            }
            if(current_user.getUserTyp().equals("Unternehmen")){
                companyForm.save(profileManager);
            }
            form_dialog.close();
            UI.getCurrent().getPage().reload();
        });
        form_dialog.add(save);

        if(profileManager.checkIfProfileIsCreated(current_user)){
            if(current_user.getUserTyp().equals("Student")){
                current_student = profileManager.getStudentById(current_user.getUserId());
            }
            if(current_user.getUserTyp().equals("Unternehmen")){
                current_company = profileManager.getCompanyById(current_user.getUserId());
            }
            add(createTitle());
            initUploaderImage();
            add(showProfileLayout());
            add(createButtonEditLayout());

            delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
            add(delete);

        }else {
            add(new H3("Sie müssen erst ein Profil erstellen:"));
            form_dialog.addComponentAtIndex(0,new H3("Sie müssen erst ein Profil erstellen:"));
            Button erstellen = new Button("Profil erstellen");
            erstellen.addClickListener(buttonClickEvent -> {form_dialog.open();});
            add(erstellen);
            form_dialog.open();
        }


        delete.addClickListener(e-> {
            Dialog delete_dialog = new Dialog();
            delete_dialog.add(new DeleteProfileView(profileManager));
            delete_dialog.open();
        });



    }

    private Component showProfileLayout() {
        VerticalLayout userProfileInformation = new VerticalLayout();

        Image profilePicture = getCurrentUserImage();
        Span firstNameLine = new Span("Vorname: "+current_user.getFirstName());
        Span lastNameLine = new Span("Nachname: "+current_user.getLastName());
        Span emailLine = new Span("Email: "+current_user.geteMail());
        Span userTypeLine = new Span("Benutzer Typ: "+current_user.getUserTyp());

        if(current_user.getProfilePicture() == null){
            Image defaultProfilePicture = new Image();
            defaultProfilePicture.setSrc("https://moonvillageassociation.org/wp-content/uploads/2018/06/default-profile-picture1.jpg");
            defaultProfilePicture.setWidth("100px");
            defaultProfilePicture.setHeight("100px");
            userProfileInformation.add(defaultProfilePicture);
        }
        else{
            userProfileInformation.add(profilePicture);
        }
        userProfileInformation.add(new H4("Benutzerdaten:"),
                firstNameLine,
                lastNameLine,
                emailLine,
                userTypeLine);

        if(current_user.getUserTyp().equals("Student") ){

            Span matrikelNrLine = new Span("Matrikel Nr: "+current_student.getMatrikelNr());
            Span degreeCourseLine = new Span("Studiengang: "+current_student.getDegreeCourse());
            Span universityLine  = new Span("Universität/Hochschule: "+current_student.getUniversity());

            userProfileInformation.add(new H4("Student Profildaten:"),
                    matrikelNrLine,
                    degreeCourseLine,
                    universityLine);

        }
        if(current_user.getUserTyp().equals("Unternehmen")){
            Span titleLine = new Span("Title: "+current_company.getTitle());
            Span descriptionLine = new Span("Description: "+current_company.getDescription());

            userProfileInformation.add(new H4("Company Profildaten:"),
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

    private void initUploaderImage() {
        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        upload = new Upload(buffer);
        upload.setAcceptedFileTypes("image/jpeg","image/jpg", "image/png", "image/gif");

        upload.addSucceededListener(event -> {
            String attachmentName = event.getFileName();
            try {
                // The image can be jpg png or gif, but we store it always as png file in this example
                BufferedImage inputImage = ImageIO.read(buffer.getInputStream(attachmentName));
                ByteArrayOutputStream pngContent = new ByteArrayOutputStream();
                ImageIO.write(inputImage, "png", pngContent);
                saveProfilePicture(pngContent.toByteArray());
                //showImage(userRepository.getUserByUserId(current_user.getUserId()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        add(upload);
    }
    private void saveProfilePicture(byte[] imageBytes) {
        user = userRepository.findByUserId(current_user.getUserId());
        user.setProfilePicture(imageBytes);
        user = userRepository.save(user);
    }

    private void initImageContainer(){
        imageContainer = new HorizontalLayout();
        imageContainer.setWidth("100px");
        imageContainer.setHeight("100px");
        imageContainer.getStyle().set("overflow-x", "auto");
        add(imageContainer);
    }

    private Image getCurrentUserImage(){

        StreamResource sr = new StreamResource("user", () ->  {
            return new ByteArrayInputStream(current_user.getProfilePicture());
        });
        sr.setContentType("image/png");
        Image image = new Image(sr, "profile-picture");
        image.setHeight("100px");
        image.setWidth("100px");
        return image;
    }
}