package com.learning.db.mybatis;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 7, 2013
 * Time: 7:45:09 AM
 */
public class PetDVO implements Serializable {

    private Integer id;
    private String name;
    private String owner;
    private String species;
    private String sex;
    private Date birth;
    private Date death;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

	    result.append(this.getClass().getName() + " Object {" + NEW_LINE);
	    result.append(" id: " + id + NEW_LINE);
	    result.append(" name: " + name + NEW_LINE);
	    result.append(" owner: " + owner + NEW_LINE);
        result.append(" species: " + species + NEW_LINE);
        result.append(" sex: " + sex + NEW_LINE);
        result.append(" birth: " + birth + NEW_LINE);
        result.append(" death: " + death + NEW_LINE);

        result.append("}");
        
        return result.toString();
	}

}