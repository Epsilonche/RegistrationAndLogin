package org.hbrs.se2.project.collhbrs.dtos;

public interface UserDTO {
    public int getUserId();
    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);

    public String getFirstName();

    public String getLastName();

    public String geteMail();

    public String getUserTyp();

    public byte[] getProfilePicture();


    void setProfilePicture(byte[] imageBytes);
}
