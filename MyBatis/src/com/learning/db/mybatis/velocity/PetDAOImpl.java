package com.learning.db.mybatis.velocity;

import org.mybatis.spring.SqlSessionTemplate;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 1:59:24 PM
 */
public class PetDAOImpl implements PetDAO {

    private SqlSessionTemplate sqlSessionTemplate;
    
    public PetDVO getPetObject(String petName) {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", petName);
        inputMap.put("sex", "f");
        return sqlSessionTemplate.selectOne("getPetObject", inputMap);
    }

    public PetDVO getPetObjectData(String petName, String sex) {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", petName);
        inputMap.put("sex", sex);
        return sqlSessionTemplate.selectOne("getPetObjectData", inputMap);
    }

    public List<PetDVO> getAllPets(List<PetDVO> petList) {
        HashMap<String, List<PetDVO>> inputMap = new HashMap<String, List<PetDVO>>();
        inputMap.put("petList", petList);

        return sqlSessionTemplate.selectList("getAllPets", inputMap);
    }

     public List<PetDVO> getMatchingPets(List<String> petNamesList) {
        HashMap<String, List<String>> inputMap = new HashMap<String, List<String>>();
        inputMap.put("namesList", petNamesList);

        return sqlSessionTemplate.selectList("getMatchingPets", inputMap);
    }

    public List<PetDVO> findAllSnakes() {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", "snake");
        inputMap.put("sex", "m");
        inputMap.put("owner", "Den");

        return sqlSessionTemplate.selectList("findAllSnakes", inputMap);
    }

    public void createPet(PetDVO petDVO) {
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

    public void deletePet(PetDVO petDVO) {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", petDVO.getSpecies());
        inputMap.put("name", petDVO.getName());

        sqlSessionTemplate.update("deletePet", inputMap);
    }      

    public void callReadPet() {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", "Slimmy");
        inputMap.put("owner", "");
        inputMap.put("species", "");
        inputMap.put("sex", "");
        inputMap.put("birth", "");
        inputMap.put("death", "");

        sqlSessionTemplate.selectOne("callReadPet", inputMap);
        System.out.println("--- owner ---" + inputMap.get("owner"));
        System.out.println("--- species ---" + inputMap.get("species"));
    }    

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }    

}
