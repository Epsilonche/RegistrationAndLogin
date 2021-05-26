package org.hbrs.se2.project.hellocar.dtos.impl;

import org.hbrs.se2.project.hellocar.dtos.SecurityDTO;

public class SecurityDTOImpl  implements SecurityDTO{
    private int    security_question_id;
    private String security_question;

    public int getId() {
        return security_question_id;
    }

    public void setId(int security_question_id) {
        this.security_question_id = security_question_id;
    }

    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }
}
