package org.hbrs.se2.project.collhbrs.views.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.StudentDTOImpl;
import org.hbrs.se2.project.collhbrs.util.Globals;
import org.hbrs.se2.project.collhbrs.views.ProfileView;

public class StudentForm extends FormLayout {
    private TextField first_name = new TextField("Vorname");
    private TextField last_name = new TextField("Name");
    private EmailField email = new EmailField("E-Mail");
    private IntegerField matrikel_nr = new IntegerField("Matikelnummer");
    private TextField university = new TextField("Universität");
    private TextField degree_course = new TextField("Studiengang");

    private Button save = new Button("Speichern");
    private Binder<StudentDTOImpl> studentBinder = new Binder(StudentDTOImpl.class);

    public StudentForm(ProfileManager service) {

        studentBinder.bindInstanceFields(this);
        clearForm();

        save.addClickListener( click -> {
            UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
            service.createStudentProfile(studentBinder.getBean(),userDTO);
        });




        UserDTO current_user = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
        service.setUserIntoSession(current_user);
        service.setStudentIntoSession();
        if(service.checkIfStudentProfileIsCreated(current_user)){
            studentBinder.setBean(service.getCurrentStudentDTO());
        }


        add(first_name,
                last_name,
                email,
                matrikel_nr,
                university,
                degree_course,
                createButtonLayout()
        );
        remove(createButtonLayout());
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        return buttonLayout;
    }

    private void clearForm() {
        studentBinder.setBean(new StudentDTOImpl());
    }

    public void save(ProfileManager service){
        UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
        service.createStudentProfile(studentBinder.getBean(),userDTO);
    }
    public void removeButton(){
        this.remove(save);
    }
}
