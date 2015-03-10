package com.learning.db.mybatis;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jun 1, 2013
 * Time: 9:02:05 AM
 */
public class PetDetails {

    private List<PetDVO> petData;

    public List<PetDVO> getPetData() {
        return petData;
    }

    public void setPetData(List<PetDVO> petData) {
        this.petData = petData;
    }

}
