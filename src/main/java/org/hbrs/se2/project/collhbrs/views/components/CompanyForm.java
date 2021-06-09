package org.hbrs.se2.project.collhbrs.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CompanyForm extends FormLayout {
    private TextField branch = new TextField("branch");
    private TextField title = new TextField("title");
    private TextField role = new TextField("role");
    private TextField company = new TextField("company");
    private TextField description= new TextField("description");

    private Button save = new Button("Profil erstellen");

    public CompanyForm() {
        add(branch,
            title,
            role,
            company,
            description
        );
    }
}
