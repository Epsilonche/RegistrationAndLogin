package org.hbrs.se2.project.collhbrs.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.collhbrs.datatypes.RegistrationResult;
import org.hbrs.se2.project.collhbrs.control.RegistrationControl;
import org.hbrs.se2.project.collhbrs.dtos.impl.UserDTOImpl;


import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;

import com.vaadin.flow.internal.MessageDigestUtil;

import com.vaadin.flow.server.StreamResource;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;



@Route(value = "register")
@PageTitle("Registrierung")
public class RegistrationView extends Div{

    private TextField first_name = new TextField("Vorname");
    private TextField last_name = new TextField("Nachname");
    private TextField email= new TextField("E-Mail");
    private TextField username = new TextField("Benutzername");
    private PasswordField password = new PasswordField("Passwort"); //hidden password
    private RadioButtonGroup<String> user_typ = new RadioButtonGroup<>();

    private Button signUp = new Button("registrieren");
    private Binder<UserDTOImpl> binder = new Binder(UserDTOImpl.class);

    public RegistrationView(RegistrationControl registrationService){
        addClassName("registration");

        add(createTitle());
        add(createFormLayout());

        add(createSimpleUpload());

        add(createButtonLayout());


        binder.bindInstanceFields(this);
        clearForm();

        signUp.addClickListener(e -> {
            // Speicherung der Daten über das zuhörige Control-Object.
            // Daten des Autos werden aus Formular erfasst und als DTO übergeben.
            // Zusätzlich wird das aktuelle UserDTO übergeben.
            RegistrationResult result =  registrationService.createUser(binder.getBean());

            if (result.isSaved() == true) {
                Notification.show("Erfolgreich registriert");
                clearForm();
            }
            else{
                Notification.show(result.getResultDescription());
            }


        });

    }
    private void clearForm() {
        binder.setBean(new UserDTOImpl());
    }
    private Component createTitle() {
        return new H3("Registrierung:");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        user_typ.setLabel("Ich bin ein");
        user_typ.setItems("Student","Unternehmen");
        formLayout.add(first_name,last_name,email,username, password,user_typ);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        signUp.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(signUp);
        return buttonLayout;
    }

    /* Upload Image Code copied from :
    *  Credits : https://github.com/vaadin/vaadin-upload-flow/blob/master/vaadin-upload-flow-demo/src/main/java/com/vaadin/flow/component/upload/demo/UploadView.java
    *
    */
    private Component createSimpleUpload() {
        HorizontalLayout uploadLayout = new HorizontalLayout();

        Div output = new Div();

        //@formatter:off
        // begin-source-example
        // source-example-heading: Simple in memory receiver for single file upload
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);

        upload.addSucceededListener(event -> {
            Component component = createComponent(event.getMIMEType(),
                    event.getFileName(), buffer.getInputStream());
            showOutput(event.getFileName(), component, output);
        });
        // end-source-example
        //@formatter:on
        upload.setMaxFileSize(500 * 1024);
        upload.setId("test-upload");
        output.setId("test-output");

        uploadLayout.add(upload ,output);
        return uploadLayout;
    }

    private Component createComponent(String mimeType, String fileName,
                                      InputStream stream) {

        if (mimeType.startsWith("image")) {
            Image image = new Image();
            try {

                byte[] bytes = IOUtils.toByteArray(stream);
                image.getElement().setAttribute("src", new StreamResource(
                        fileName, () -> new ByteArrayInputStream(bytes)));
                try (ImageInputStream in = ImageIO.createImageInputStream(
                        new ByteArrayInputStream(bytes))) {
                    final Iterator<ImageReader> readers = ImageIO
                            .getImageReaders(in);
                    if (readers.hasNext()) {
                        ImageReader reader = readers.next();
                        try {
                            reader.setInput(in);
                            image.setWidth(reader.getWidth(0) + "px");
                            image.setHeight(reader.getHeight(0) + "px");
                        } finally {
                            reader.dispose();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return image;
        }
        Div content = new Div();
        String text = String.format("Mime type: '%s'\nSHA-256 hash: '%s'",
                mimeType, MessageDigestUtil.sha256(stream.toString()));
        content.setText(text);
        return content;
    }
    private void showOutput(String text, Component content,
                            HasComponents outputContainer) {
        HtmlComponent p = new HtmlComponent(Tag.P);
        p.getElement().setText(text);
        outputContainer.add(p);
        outputContainer.add(content);
    }
}
