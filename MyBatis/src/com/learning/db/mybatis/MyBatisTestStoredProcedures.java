package com.learning.db.mybatis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 11, 2013
 * Time: 2:13:31 PM
 */
public class MyBatisTestStoredProcedures {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext appContext =
                    new ClassPathXmlApplicationContext(new String[]
                            {"applicationContext-myBatis.xml"});

            PetDAO petDAOImpl = (PetDAO) appContext.getBean("petDAOImpl");
//            List<PetDVO> procResult = petDAOImpl.callReadAllPets();
//
//            System.out.println("--- procResult ---" + procResult.size());
//            for (PetDVO petDVObj : procResult) {
//                System.out.println("--- name ---" + petDVObj.getName());
//            }
//
//            petDAOImpl.callReadPet();

            petDAOImpl.callPetOwnerFunction();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
