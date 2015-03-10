package com.learning.db.mybatis.java;

import java.util.List;
import java.util.Date;

import com.learning.db.mybatis.PetDVO;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: May 27, 2013
 * Time: 7:58:34 AM
 */
public class JavaMyBatisMain {

    public static void main(String[] args) {
        try {
            JavaMyBatisMain main = new JavaMyBatisMain();

            // Calling the private methods
            // main.selectAllPets();

            //main.getAllPetsUsingResultMap();

            // main.callReadPet();
                    
            // main.callReadAllPets();

            // main.callPetOwnerFunction();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getPetObject() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        PetDVO pet = petDAOImpl.getPetObject("Fluffy");
        System.out.println("----- pet ------" + pet);
    }

    private void getAllPetsData() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        List<PetDVO> allPets = petDAOImpl.getAllPetsData();
        System.out.println("----- size ------" + allPets.size());
    }

    private void selectPets() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        List<PetDVO> allPetsData = petDAOImpl.selectPets("f");
        System.out.println("----- size ------" + allPetsData.size());
    }

    private void selectAllPets() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        List<PetDVO> allPetsData = petDAOImpl.selectAllPets();
        System.out.println("----- size ------" + allPetsData.size());
    }

    private void updatePetData() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        PetDVO petDataObj = new PetDVO();
        petDataObj.setName("Slimmmy");
        petDataObj.setSex("m");
        petDataObj.setBirth(new Date());
        petDAOImpl.updatePetData(petDataObj);
    }

    private void updateData() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        PetDVO petDataObj = new PetDVO();
        petDataObj.setName("Slimmmy");
        petDataObj.setSex("m");
        petDataObj.setBirth(new Date());
        petDAOImpl.updateData(new Date(), "m", "Slim");
    }

    private void deletePet() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slimmmy1");
        petDVO.setSpecies("snake");
        petDAOImpl.deletePet(petDVO);
    }

    private void insertPet() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        PetDVO petObj = new PetDVO();
        petObj.setName("Slimmy");
        petObj.setOwner("Danny");
        petObj.setSpecies("snake");
        petObj.setSex("f");
        petObj.setBirth(new Date());

        petDAOImpl.insertPet(petObj);
    }

    private void callReadPet() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slimmy");

        org.apache.ibatis.logging.LogFactory.useCommonsLogging();
        petDAOImpl.callReadPet(petDVO);
        System.out.println(" Proc Output :" + petDVO);
    }

    private void callReadAllPets() throws Exception {
        PetDAOImpl petDAOImpl = new PetDAOImpl();
        List<PetDVO> outputData = petDAOImpl.callReadAllPets();
        System.out.println("---- outputData ----" + outputData);
    }

//    private void callPetOwnerFunction() throws Exception {
//        PetDAOImpl petDAOImpl = new PetDAOImpl();
//        petDAOImpl.callPetOwnerFunction();
//    }

//    private void getAllPetsUsingResultMap() throws Exception {
//        PetDAOImpl petDAOImpl = new PetDAOImpl();
//        List<PetDVO> allPets = petDAOImpl.getAllPetsUsingResultMap("m");
//        System.out.println("----- size ------" + allPets.size());
//    }
}