package com.learning.db.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 11, 2013
 * Time: 5:23:30 AM
 */
public class PetDAOImpl implements PetDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    public List<PetDVO> getAllPetsData() {
        return  sqlSessionTemplate.selectList("getAllPets");
    }

    public PetDVO getPetObject(String petName) {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", petName);
        return (PetDVO) sqlSessionTemplate.selectOne("getPetObject", inputMap);
    }

    public List<String> getAllSpecies() {
        return  sqlSessionTemplate.selectList("getAllSpecies");
    }

    public List<PetDVO> selectPets(String sex) {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("sex", sex);
        return  sqlSessionTemplate.selectList("selectPets", inputMap);
    }

    public List<PetDVO> findAllSnakes() {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", "snake");
        inputMap.put("sex", "f");
        inputMap.put("owner", "De%");
        return  sqlSessionTemplate.selectList("findAllSnakes", inputMap);
    }

     public List<PetDVO> findSnakePets() {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", "snake");
        //inputMap.put("sex", "f");
        //inputMap.put("owner", "Su%");
        return  sqlSessionTemplate.selectList("findSnakePets", inputMap);
    }

    public List<PetDVO> selectPetsIn() {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        List<String> speciesList = new ArrayList<String>();
        speciesList.add("snake");
        speciesList.add("cat");
        speciesList.add("dog");
        inputMap.put("speciesList", speciesList);
        return  sqlSessionTemplate.selectList("selectPetsIn", inputMap);
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

    public void updatePetDynamically(PetDVO petDVO) {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("death", petDVO.getDeath());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("name", petDVO.getName());

        System.out.println("--- inputMap ---" + inputMap);
        sqlSessionTemplate.update("updatePetDynamically", inputMap);
    }

    public void deletePet(PetDVO petDVO) {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", petDVO.getSpecies());
        inputMap.put("name", petDVO.getName());

        System.out.println("--- deletePet ---" + inputMap);
        sqlSessionTemplate.update("deletePet", inputMap);
    }

//    public List<PetDVO> callReadAllPets() {
//        return sqlSessionTemplate.selectList("callReadAllPets");
//    }

    public List<PetDVO> callReadAllPets() {
        HashMap<String, List<PetDVO>> inputMap = new HashMap<String, List<PetDVO>>();
        List<PetDVO> petList = new ArrayList<PetDVO>();
        inputMap.put("petData", petList);

        sqlSessionTemplate.selectList("callReadAllPets", inputMap);
        List<PetDVO> outputData = inputMap.get("petData");
        return outputData;
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

    public void callPetOwnerFunction() {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", "Slim");
        inputMap.put("owner", "");

        sqlSessionTemplate.selectOne("callPetOwnerFunction", inputMap);
        System.out.println("--- Function result owner ---" + inputMap.get("owner"));
    }

    public void insertUser() {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        User user = new User();
        inputMap.put("id", user.getId());
        inputMap.put("firstName", "John");
        inputMap.put("lastName", "Smith");

        sqlSessionTemplate.insert("insertUser", inputMap);
        System.out.println("--- Id value ---" + inputMap.get("id"));
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

}
