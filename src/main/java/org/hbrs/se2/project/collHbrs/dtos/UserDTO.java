package org.hbrs.se2.project.collHbrs.dtos;

import java.util.List;

public interface UserDTO {
    public int getId();
    public String getFirstName();
    public String getLastName();
    public List<RolleDTO> getRoles();
}
