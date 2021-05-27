package org.hbrs.se2.project.hellocar.dtos.impl;

import org.hbrs.se2.project.hellocar.dtos.SkillsDTO;

public class SkillsDTOImpl implements SkillsDTO {

    private int skill_id;
    private String skill_name;
    private String skill_description;

    public int getId() {
        return skill_id;
    }

    public void setId(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_description() {
        return skill_description;
    }

    public void setSkill_description(String skill_description) {
        this.skill_description = skill_description;
    }
}
