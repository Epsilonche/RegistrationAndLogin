package org.hbrs.se2.project.hellocar.dtos.impl;

import org.hbrs.se2.project.hellocar.dtos.BranchDTO;

public class BranchDTOImpl implements BranchDTO {
    private int branch_id;
    private String branch_name;

    public int getId() {
        return branch_id;
    }
    public void setId(int branch_id) {
        this.branch_id = branch_id;
    }
    public String getBranch_name() {
        return branch_name;
    }
    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

}
