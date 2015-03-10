package com.learning.db.mybatis;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 14, 2013
 * Time: 10:01:38 AM
 */
public class User {

    private int id;
    private String firstNmae;
    private String lastName;       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
