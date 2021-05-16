package com.example.application.views.vacancies;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;

@Route(value = "vacancies", layout = MainView.class)
@PageTitle("Vacancies")
public class VacanciesView extends Div {

    public VacanciesView() {
        addClassName("vacancies-view");
        add(new Text("Content placeholder"));
    }

}
