package com.learning.db.mybatis.tx.annotations;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import org.mybatis.spring.SqlSessionTemplate;
import com.learning.db.mybatis.tx.dao.PetDVO;


/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 1:59:24 PM
 */
//@Transactional
@Component    
public class PetDAOImpl implements PetDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional(readOnly = false)
    public void doInsertAndUpdateInTx() {
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slimmy1");
        petDVO.setOwner("Steve");
        petDVO.setSpecies("snake");
        petDVO.setSex("m");
        petDVO.setBirth(new Date());
        // Insert a record
        insertPet(petDVO);

        // Create an error to get the exception
        int i = 0;
        int j = 100 / i;

        // Update a record
        PetDVO petDataObj = new PetDVO();
        petDataObj.setName("Slimmy");
        petDataObj.setSex("m");
        petDataObj.setBirth(new Date());
        updatePetData(petDataObj);
    }

    public void insertPet(PetDVO petDVO) {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("name", petDVO.getName());
        inputMap.put("owner", petDVO.getOwner() );
        inputMap.put("species", petDVO.getSpecies() );
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("death", petDVO.getDeath());

        sqlSessionTemplate.insert("createPet", inputMap);
    }

    public void updatePetData(PetDVO petDVO) {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("name", petDVO.getName());

        sqlSessionTemplate.update("updatePetData", inputMap);
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

}