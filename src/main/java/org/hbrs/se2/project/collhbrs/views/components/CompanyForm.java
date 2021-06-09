package org.hbrs.se2.project.collhbrs.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.hbrs.se2.project.collhbrs.dtos.impl.CompanyDTOImpl;

public class CompanyForm extends FormLayout {
    private TextField branch = new TextField("branch");
    private TextField title = new TextField("title");
    private TextField role = new TextField("role");
    private TextField company = new TextField("company");
    private TextField description= new TextField("description");

    private Button save = new Button("Profil erstellen");
    private Binder<CompanyDTOImpl> companyBinder = new Binder(CompanyDTOImpl.class);




    public CompanyForm() {
        add(branch,
            title,
            role,
            company,
            description,
                createButtonLayout()
        );
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        save.addClickListener( click -> { createCompany(companyBinder.getBean());

        });
        return buttonLayout;
    }

    private void createCompany(CompanyDTOImpl bean) {
        System.out.print("COMPANY CREATED ");
    }

    public CompanyDTOImpl getCompanyForm(){
        return companyBinder.getBean();
    }


}
