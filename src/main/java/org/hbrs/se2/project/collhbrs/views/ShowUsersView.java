package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
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
import org.hbrs.se2.project.collhbrs.control.ShowUserControl;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;

import java.util.List;
@Route(value = "users")
@PageTitle("ShowUsers")

public class ShowUsersView extends Div {
    private List<UserDTO> personList;

    public ShowUsersView( ShowUserControl userControl ) {
        addClassName("show-users-view");

        // Auslesen alle abgespeicherten Autos aus der DB (über das Control)

        personList = userControl.readAllUsers();

        // Titel überhalb der Tabelle
        add(this.createTitle());

        // Hinzufügen der Tabelle (bei Vaadin: ein Grid)
        add(this.createGridTable());
    }

    private Component createGridTable() {
        Grid<UserDTO> grid = new Grid<>();

        // Befüllen der Tabelle mit den zuvor ausgelesenen Autos
        ListDataProvider<UserDTO> dataProvider = new ListDataProvider<>(
                personList);
        grid.setDataProvider(dataProvider);

        Grid.Column<UserDTO> brandColumn = grid
                .addColumn(UserDTO::getUsername).setHeader("Username");
        Grid.Column<UserDTO> modelColumn = grid.addColumn(UserDTO::getPassword)
                .setHeader("Model");

        HeaderRow filterRow = grid.appendHeaderRow();

        // First filter
        TextField modelField = new TextField();
        modelField.addValueChangeListener(event -> dataProvider.addFilter(
                user -> StringUtils.containsIgnoreCase(user.getUsername(),
                        modelField.getValue())));

        modelField.setValueChangeMode(ValueChangeMode.EAGER);

        filterRow.getCell(modelColumn).setComponent(modelField);
        modelField.setSizeFull();
        modelField.setPlaceholder("Filter");

        // Second filter
        TextField brandField = new TextField();
        brandField.addValueChangeListener(event -> dataProvider
                .addFilter(user -> StringUtils.containsIgnoreCase(
                        String.valueOf(user.getPassword()), brandField.getValue())));

        brandField.setValueChangeMode(ValueChangeMode.EAGER);

        filterRow.getCell(brandColumn).setComponent(brandField);
        brandField.setSizeFull();
        brandField.setPlaceholder("Filter");

        return grid;
    }

    private Component createTitle() {
        return new H3("Search for Users");
    }


}
