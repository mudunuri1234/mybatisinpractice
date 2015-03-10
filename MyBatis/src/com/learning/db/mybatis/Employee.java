package com.learning.db.mybatis;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jul 5, 2013
 * Time: 9:45:49 AM
 */
public class Employee {

    private Integer empId;
    private String empName;
    private Integer salary;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
