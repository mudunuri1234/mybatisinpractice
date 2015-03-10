package com.learning.db.mybatis.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

import com.learning.db.mybatis.PetDAO;
import com.learning.db.mybatis.PetDVO;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 11, 2013
 * Time: 7:12:33 AM
 * <p/>
 * http://code.google.com/p/mybatis/wiki/DocUpgrade3
 */
public class SpringBatisMain {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext appContext =
                    new ClassPathXmlApplicationContext(new String[]
                            {"applicationContext-myBatis.xml"});

            PetDAO petDAOImpl = (PetDAO) appContext.getBean("petDAOImpl");

            //Select
            List<PetDVO> users = petDAOImpl.getAllPetsData();
            System.out.println("--- pets ---" + users.size());

            PetDVO petDVO = petDAOImpl.getPetObject("Fluffy");
            System.out.println("--- petDVO ---" + petDVO);

            List<String> speciesList = petDAOImpl.getAllSpecies();
            System.out.println("--- speciesList ---" + speciesList);

            List<PetDVO> petsList = petDAOImpl.selectPets("f");
            System.out.println("--- petsList ---" + petsList);

            List<PetDVO> allSnakes = petDAOImpl.findAllSnakes();
            System.out.println("--- allSnakes ---" + allSnakes);

            List<PetDVO> snakePets = petDAOImpl.findSnakePets();
            System.out.println("--- snakePets ---" + snakePets);

            List<PetDVO> selectPets = petDAOImpl.selectPetsIn();
            System.out.println("--- selectPets ---" + selectPets.size());


            PetDVO petObj = new PetDVO();
            petObj.setName("Slim 1");
            petObj.setOwner("Suk 1");
            petObj.setSpecies("snake");
            petObj.setSex("f");
            petObj.setDeath(new Date());

            //petDAOImpl.createPet(petObj);

            // Update
            PetDVO petDataObj = new PetDVO();
            petDataObj.setName("Slim 1");
            petDataObj.setSex("m");
            petDataObj.setBirth(new Date());
            //petDAOImpl.updatePetData(petDataObj);

            PetDVO petDataObj1 = new PetDVO();
            petDataObj1.setName("Slim");
            petDataObj1.setBirth(new Date());
            petDataObj1.setDeath(new Date());
            petDataObj1.setSex("f");
            //petDAOImpl.updatePetDynamically(petDataObj1);

            //Delete
            PetDVO petDataObj2 = new PetDVO();
            petDataObj2.setName("Slim 1");
            petDataObj2.setSpecies("snake");
            //petDAOImpl.deletePet(petDataObj2);

            // petDAOImpl.insertUser();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

