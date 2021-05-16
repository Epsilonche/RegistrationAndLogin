package com.example.application.views.profile;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello-world", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Profile")
public class ProfileView extends Div {

    public ProfileView() {
        addClassName("profile-view");
        add(new Text("Content placeholder"));
    }

}
