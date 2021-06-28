package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.hbrs.se2.project.collhbrs.control.ShowVacancyControl;
import org.hbrs.se2.project.collhbrs.dtos.VacDTO;
import org.hbrs.se2.project.collhbrs.util.Globals;

import java.util.List;

/*
Autor: Michael Klein und Sebastian Holst
View um Stellenausschreibungen anzuzeigen und nach Titel und/oder Beschreibung zu filtern
ON THE FLY SUCHE


 */

@Route(value = Globals.Pages.VACANCY_VIEW, layout = AppView.class)
@PageTitle("Stellenausschreibungen suchen")
@CssImport("./styles/views/showcars/show-cars-view.css")
public class ShowVacancyView extends Div  {

    private List<VacDTO> personList;

    public ShowVacancyView( ShowVacancyControl vacancyControl ) {
        addClassName("show-vac-view");

        // Auslesen alle abgespeicherten Vacancies aus der DB (über das Control)
        personList = vacancyControl.readAllVacancys();

        // Titel überhalb der Tabelle
        add(this.createTitle());

        // Hinzufügen der Tabelle (bei Vaadin: ein Grid)
        add(this.createGridTable());
    }

    private Component createGridTable() {
        Grid<VacDTO> grid = new Grid<>();

        // Befüllen der Tabelle mit den zuvor ausgelesenen Vacs
        ListDataProvider<VacDTO> dataProvider = new ListDataProvider<>(
                personList);
        grid.setDataProvider(dataProvider);

        Grid.Column<VacDTO> titleColumn = grid
                .addColumn(VacDTO::getTitle).setHeader("Titel");

        Grid.Column<VacDTO> descColumn = grid.addColumn(VacDTO::getDescription)
                .setHeader("Beschreibung");

        Grid.Column<VacDTO> wplaceColumn = grid.addColumn(VacDTO::getWorkplace)
                .setHeader("Arbeitsort");

        Grid.Column<VacDTO> hoColumn = grid.addColumn(VacDTO::getHomeoffice)
                .setHeader("Homeoffice");

        Grid.Column<VacDTO> salColumn = grid.addColumn(VacDTO::getSalary)
                .setHeader("Gehalt (€)");

        Grid.Column<VacDTO> startColumn = grid.addColumn(VacDTO::getStartDate)
                .setHeader("Arbeitsbeginn");

        Grid.Column<VacDTO> endColumn = grid.addColumn(VacDTO::getEndDate)
                .setHeader("Arbeitsende");

        HeaderRow filterRow = grid.appendHeaderRow();

        // Filter um Stellenausschreibungen nach Titel zu filtern
        TextField titleField = new TextField();
        titleField.addValueChangeListener(event -> dataProvider.addFilter(
                vac -> StringUtils.containsIgnoreCase(vac.getTitle(),
                        titleField.getValue())));

        titleField.setValueChangeMode(ValueChangeMode.EAGER);

        filterRow.getCell(titleColumn).setComponent(titleField);
        titleField.setSizeFull();
        titleField.setPlaceholder("Filter");



        // Filter um Stellenausschreibungen nach Beschreibung zu filtern
        TextField descField = new TextField();
        descField.addValueChangeListener(event -> dataProvider
                .addFilter(vac -> StringUtils.containsIgnoreCase(
                        String.valueOf(vac.getDescription()), descField.getValue())));

        descField.setValueChangeMode(ValueChangeMode.EAGER);

        filterRow.getCell(descColumn).setComponent(descField);
        descField.setSizeFull();
        descField.setPlaceholder("Filter");

        return grid;
    }

    private Component createTitle() {
        return new H3("Stellenausschreibungen suchen");
    }


};