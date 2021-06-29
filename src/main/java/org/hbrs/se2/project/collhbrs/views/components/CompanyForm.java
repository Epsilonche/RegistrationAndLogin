package org.hbrs.se2.project.collhbrs.views.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.CompanyDTOImpl;
import org.hbrs.se2.project.collhbrs.util.Globals;


public class CompanyForm extends FormLayout {
    private TextField branch = new TextField("branch");
    private TextField title = new TextField("title");
    private TextField role = new TextField("role");
    private TextField company = new TextField("company");
    private TextField description= new TextField("description");

    private Button save = new Button("Profil erstellen");
    private Binder<CompanyDTOImpl> companyBinder = new Binder(CompanyDTOImpl.class);

    public CompanyForm(ProfileManager service) {

        companyBinder.bindInstanceFields(this);
        clearForm();

        save.addClickListener( click -> {
            UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
            service.createCompanyProfile(companyBinder.getBean(),userDTO);
        });

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
        return buttonLayout;
    }

    public CompanyDTOImpl getCompanyForm(){
        return companyBinder.getBean();
    }

    private void clearForm() {
        companyBinder.setBean(new CompanyDTOImpl());
    }


}
