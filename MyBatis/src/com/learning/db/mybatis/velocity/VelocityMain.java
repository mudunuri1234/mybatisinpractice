package com.learning.db.mybatis.velocity;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 2:19:01 PM
 */
public class VelocityMain {

    public static void main(final String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext-mybatis-velocity.xml"});

        VelocityMain main = new VelocityMain();

        main.deletePet(context);

    }

    private void getPetObject(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
        PetDVO petDVO = petDAO.getPetObject("Slimmy");
        System.out.println("--- PetDVO ---" + petDVO);
    }

    private void getPetObjectData(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
        PetDVO petDVO = petDAO.getPetObjectData("Slimmy", "m");
        System.out.println("--- PetDVO ---" + petDVO);
    }

    public void getAllPets(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
        List<PetDVO> petList = new ArrayList<PetDVO>();

        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slimmmy");
        petList.add(petDVO);

        PetDVO petDVO1 = new PetDVO();
        petDVO1.setName("Slim");
        petList.add(petDVO1);

        List<PetDVO> petListOutput = petDAO.getAllPets(petList);
        System.out.println("--- petListOutput ---" + petListOutput.size());
    }

    public void getMatchingPets(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
        List<String> namesList = new ArrayList<String>();
        namesList.add("Slimmmy");
        namesList.add("Slim21");

        List<PetDVO> matchingPets = petDAO.getMatchingPets(namesList);
        System.out.println("--- matchingPets ---" + matchingPets.size());
    }

    public void findAllSnakes(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
        List<PetDVO> petList = petDAO.findAllSnakes();
        System.out.println("--- petList ---" + petList.size());
    }

    public void createPet(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");

        PetDVO petObj = new PetDVO();
        petObj.setName("Jumbo");
        petObj.setOwner("Jim");
        petObj.setSpecies("Elephent");
        petObj.setSex("m");
        petObj.setBirth(new Date());

        petDAO.createPet(petObj);
    }

    public void updatePetData(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slimmmy");
        petDVO.setSex("f");
        petDVO.setBirth(new Date());

        petDAO.updatePetData(petDVO);
    }

    public void deletePet(ApplicationContext context) {
        PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slim1");
        petDVO.setSpecies("Snake");

        petDAO.deletePet(petDVO);
    }

    public void callReadPet(ApplicationContext context) {
       PetDAO petDAO = (PetDAO) context.getBean("petDAOImpl");
       petDAO.callReadPet();
    }

}