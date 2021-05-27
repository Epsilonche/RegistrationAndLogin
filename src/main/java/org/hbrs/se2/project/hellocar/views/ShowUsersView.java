package org.hbrs.se2.project.hellocar.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.hellocar.control.RegistrationControl;
import org.hbrs.se2.project.hellocar.control.RegistrationResult;
import org.hbrs.se2.project.hellocar.control.ShowUserControl;
import org.hbrs.se2.project.hellocar.dtos.impl.UserDTO;
import org.hbrs.se2.project.hellocar.util.Globals;

import java.util.List;
@Route(value = "users")
@PageTitle("ShowUsers")

public class ShowUsersView extends Div {
    private List<UserDTO> personList;

    public ShowUsersView( ShowUserControl userControl ) {
        addClassName("show-users-view");

        // Auslesen alle abgespeicherten Autos aus der DB (über das Control)
        try {
            personList = userControl.readAllUsers();
        }catch(Exception e ){
            e.printStackTrace();
        }
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
                .setHeader("Password");


        return grid;
    }

    private Component createTitle() {
        return new H3("Search for Users");
    }


}
