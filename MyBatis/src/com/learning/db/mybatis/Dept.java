package com.learning.db.mybatis;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jul 5, 2013
 * Time: 9:45:41 AM
 */
public class Dept {

    private Integer deptId;
    private String deptName;
    private String locName;
    private List<Employee> employee;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

}
