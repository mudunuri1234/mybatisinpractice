package com.learning.db.mybatis.core;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.*;

import com.learning.db.mybatis.PetDVO;
import com.learning.db.mybatis.Employee;
import com.learning.db.mybatis.Dept;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: May 27, 2013
 * Time: 7:58:34 AM
 */
public class CoreMyBatisMain {

    private static Logger logger = Logger.getLogger(CoreMyBatisMain.class);

    public static void main(String[] args) {
        try {
            CoreMyBatisMain main = new CoreMyBatisMain();

//            List<PetDVO> allPets = main.getAllPetsData();
//            System.out.println("----- allPets ------" + allPets.size());
//
//            PetDVO  pet = main.getPetObject("Fluffy");
//            System.out.println("----- pet ------" + pet);
//
//            List<String> allSpecies = main.getAllSpecies();
//            System.out.println("----- allSpecies ------" + allSpecies);
//
//            List<PetDVO> pets = main.selectPets("m");
//            System.out.println("----- pets ------" + pets);
//
//            List<PetDVO> allSnakes = main.findAllSnakes();
//            System.out.println("----- allSnakes ------" + allSnakes);

//            List<PetDVO> snakePets = main.findSnakePets();
//            System.out.println("----- snakePets ------" + snakePets);

//            List<PetDVO> selectdPets = main.selectPetsIn();
//            System.out.println("----- selectdPets ------" + selectdPets);

             Dept dept = main.getEmployeeAndDeptData();
             List<Employee> empList = dept.getEmployee();
             for(Employee employee : empList) {
                 System.out.println(employee.getEmpId() + "-" +
                     "-" + employee.getEmpName() + "-" + employee.getSalary());    
             }



//            PetDVO petObj = new PetDVO();
//            petObj.setName("Slimmmy");
//            petObj.setOwner("Suk");
//            petObj.setSpecies("snake");
//            petObj.setSex("m");
//            petObj.setBirth(new Date());
//
//            main.createPet(petObj);


//            // Update
//            PetDVO petDataObj = new PetDVO();
//            petDataObj.setName("Slimmy");
//            petDataObj.setSex("f");
//            petDataObj.setBirth(new Date());
//            //main.updatePetData(petDataObj);
//
//            //Delete
//            PetDVO petDataObj2 = new PetDVO();
//            petDataObj2.setName("Slimmy1");
//            petDataObj2.setSpecies("snake");
//            main.deletePet(petDataObj2);


//            PetDVO petDVO = new PetDVO();
//            petDVO.setName("Slim");
//            petDVO.setBirth(new Date());
//            petDVO.setDeath(new Date());
//            petDVO.setSex("m");
//            main.updatePetDynamically(petDVO);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static SqlSession getSqlSession() throws Exception {
        String resource = "core-mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

    public Dept getEmployeeAndDeptData() throws Exception {
       HashMap<String, Integer> inputMap = new HashMap<String, Integer>();
       inputMap.put("deptId", 1);

       return (Dept) getSqlSession().selectOne("getEmployeeAndDeptData", inputMap);
    }

    public List<PetDVO> getAllPetsData() throws Exception {
        return getSqlSession().selectList("getAllPets");
    }

    public PetDVO getPetObject(String petName) throws Exception {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", petName);
        return (PetDVO) getSqlSession().selectOne("getPetObject", inputMap);
    }

    public List<String> getAllSpecies() throws Exception {
        return getSqlSession().selectList("getAllSpecies");
    }

    public List<PetDVO> selectPets(String sex) throws Exception {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("sex", sex);

        //org.apache.ibatis.logging.LogFactory.useCommonsLogging();
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        return getSqlSession().selectList("selectPets", inputMap);
    }

    public List<PetDVO> findAllSnakes() throws Exception {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", "snake");
        inputMap.put("sex", "f");
        inputMap.put("owner", "De%");

        //org.apache.ibatis.logging.LogFactory.useCommonsLogging();
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        return getSqlSession().selectList("findAllSnakes", inputMap);
    }

    public List<PetDVO> findSnakePets() throws Exception {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", "snake");
        inputMap.put("sex", "f");
        //inputMap.put("owner", "De%");
        return getSqlSession().selectList("findSnakePets", inputMap);
    }

    public List<PetDVO> selectPetsIn() throws Exception {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        List<String> speciesList = new ArrayList<String>();
        speciesList.add("snake");
        speciesList.add("cat");
        speciesList.add("dog");
        inputMap.put("speciesList", speciesList);
        return getSqlSession().selectList("selectPetsIn", inputMap);
    }

    public void createPet(PetDVO petDVO) throws Exception {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("id", petDVO.getId());
        inputMap.put("name", petDVO.getName());
        inputMap.put("owner", petDVO.getOwner());
        inputMap.put("species", petDVO.getSpecies());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("birth", petDVO.getBirth());

        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("createPet", inputMap);
        sqlSession.commit();

        System.out.println("--- Id value ---" + inputMap.get("id"));
    }


    public void updatePetData(PetDVO petDVO) throws Exception {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("name", petDVO.getName());

        SqlSession sqlSession = getSqlSession();
        sqlSession.update("updatePetData", inputMap);
        sqlSession.commit();
    }

    public void updatePetDynamically(PetDVO petDVO) throws Exception {
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("death", petDVO.getDeath());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("name", petDVO.getName());

        System.out.println("--- inputMap ---" + inputMap);
        SqlSession sqlSession = getSqlSession();
        sqlSession.update("updatePetDynamically", inputMap);
        sqlSession.commit();
    }

    public void deletePet(PetDVO petDVO) throws Exception {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("species", petDVO.getSpecies());
        inputMap.put("name", petDVO.getName());

        System.out.println("--- deletePet ---" + inputMap);
        SqlSession sqlSession = getSqlSession();
        sqlSession.update("deletePet", inputMap);
        sqlSession.commit();
    }


}
