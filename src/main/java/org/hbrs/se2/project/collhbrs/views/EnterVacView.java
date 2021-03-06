package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.collhbrs.control.VacancyManager;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.VacDTOImpl;
import org.hbrs.se2.project.collhbrs.util.Globals;

@Route(value = "entervacview", layout = AppView.class)
@PageTitle("Stellenausschreibung hinzufügen")
public class EnterVacView extends Div{

    //Erstellung Eingabefelder
    private TextField workplace = new TextField("Standort");
    private TextField homeoffice = new TextField("Homeoffice");
    //private DatePicker startdate= new DatePicker("Beginn");
    //private DatePicker enddate = new DatePicker("Ende");
    private IntegerField salary = new IntegerField("Gehalt");
    private TextField title = new TextField("Titel");
    private TextField description = new TextField("Beschreibung");


    private Button add = new Button("Hinzufügen");
    private Binder<VacDTOImpl> binder = new Binder(VacDTOImpl.class);

    public EnterVacView(VacancyManager vacMan){
        addClassName("vacancy");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        // Default Mapping of Vacancys attributes and the names of this View based on names
        binder.bindInstanceFields(this);
        clearForm();

        add.addClickListener(e -> {
            // Speicherung der Daten über das zuhörige Control-Object.
            // Daten der Stellenanzeige werden aus Formular erfasst und als DTO übergeben.
            // Zusätzlich wird das aktuelle UserDTO übergeben.
            UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
            vacMan.createVac(binder.getBean(),userDTO);
            Notification.show("Stellenanzeige erfolgreich hinzugefügt");
            navigateToVacPage();
            clearForm();
        });

    }
    private void clearForm() {
        binder.setBean(new VacDTOImpl());
    }
    private Component createTitle() {
        return new H3("Stellenausschreibung hinzufügen:");
    }

    //Layoutvorgabe für Eingabeformular
    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(workplace,homeoffice, salary,title,description);
        return formLayout;
    }
    //Layoutvorgabe für Button
    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(add);
        return buttonLayout;
    }

    private void navigateToVacPage()  {
        // Navigation zur Startseite, hier die jeweilige Profilseite, die noch eingebunden werden muss
        UI.getCurrent().navigate(Globals.Pages.VACANCY_VIEW);
    }


}
