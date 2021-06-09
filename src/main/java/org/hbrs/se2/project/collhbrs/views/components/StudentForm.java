package org.hbrs.se2.project.collhbrs.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;

public class StudentForm extends FormLayout {
    private TextField first_name = new TextField("Vorname");
    private TextField last_name = new TextField("Name");
    private EmailField email = new EmailField("E-Mail");
    private IntegerField matrikel_nr = new IntegerField("Matikelnummer");
    private TextField university = new TextField("Universität");
    private TextField degree_course = new TextField("Studiengang");


    private Button save = new Button("Profil erstellen");

    public StudentForm() {
        //addClassName("student-form");

        add(    first_name,
                last_name,
                email,
                matrikel_nr,
                university,
                degree_course
                );
    }
}
