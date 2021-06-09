package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.hbrs.se2.project.collhbrs.control.VacancyManager;
import org.hbrs.se2.project.collhbrs.control.ShowVacancyControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.hbrs.se2.project.collhbrs.control.ShowUserControl;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.dtos.VacDTO;

import java.util.List;

@Route(value = "showvac", layout = AppView.class)
@PageTitle("Stellenausschreibungen anzeigen")
public class ShowVacancyView  extends Div {
    private List<VacDTO> vacList;

    public ShowVacancyView(ShowVacancyControl  showVacancyControl ) {

        addClassName("show-vacancy-view");

        // Auslesen alle abgespeicherten Autos aus der DB (über das Control)

       vacList = showVacancyControl.readAllVacancys();

        // Titel überhalb der Tabelle
        add(this.createTitle());

        // Hinzufügen der Tabelle (bei Vaadin: ein Grid)
        add(this.createGridTable());
    }

    private Component createGridTable() {
        Grid<VacDTO> grid = new Grid<>();

        // Befüllen der Tabelle mit den zuvor ausgelesenen Autos
        ListDataProvider<VacDTO> dataProvider = new ListDataProvider<>(
                vacList);
        grid.setDataProvider(dataProvider);

        Grid.Column<VacDTO> brandColumn = grid
                .addColumn(VacDTO::getTitle).setHeader("Titel");
        Grid.Column<VacDTO> modelColumn = grid.addColumn(VacDTO::getDescription)
                .setHeader("Beschreibung");

        HeaderRow filterRow = grid.appendHeaderRow();

        // First filter
        TextField modelField = new TextField();
        modelField.addValueChangeListener(event -> dataProvider.addFilter(
                vac -> StringUtils.containsIgnoreCase(vac.getTitle(),
                        modelField.getValue())));

        modelField.setValueChangeMode(ValueChangeMode.EAGER);

        filterRow.getCell(modelColumn).setComponent(modelField);
        modelField.setSizeFull();
        modelField.setPlaceholder("Filter");

        // Second filter
        TextField brandField = new TextField();
        brandField.addValueChangeListener(event -> dataProvider
                .addFilter(vac -> StringUtils.containsIgnoreCase(
                        String.valueOf(vac.getDescription()), modelField.getValue())));

        brandField.setValueChangeMode(ValueChangeMode.EAGER);

        filterRow.getCell(brandColumn).setComponent(brandField);
        brandField.setSizeFull();
        brandField.setPlaceholder("Filter");

        return grid;
    }

    private Component createTitle() {
        return new H3("Nach Stellenanzeigen suchen");
    }

}
