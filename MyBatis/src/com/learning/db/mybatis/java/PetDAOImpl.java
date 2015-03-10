package com.learning.db.mybatis.java;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.InputStream;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

import com.learning.db.mybatis.PetDVO;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: May 29, 2013
 * Time: 8:03:44 PM
 */
public class PetDAOImpl {

    private static SqlSession getSqlSession() throws Exception {
        String resource = "java-mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(PetMapper.class);

        return sqlSessionFactory.openSession();
    }

    public List<PetDVO> getAllPetsData() throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.getAllPetsData();
    }

    public PetDVO getPetObject(String petName) throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.getPetObject(petName);
    }

    List<PetDVO> selectAllPets() throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.selectAllPets();
    }

    public List<PetDVO> selectPets(String sex) throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.selectPets(sex);
    }

    public void updatePetData(PetDVO petDVO) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        mapper.updatePetData(petDVO);

        sqlSession.commit();
    }

    public void updateData(Date birth, String sex, String name) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        mapper.updateData(birth, sex, name);

        sqlSession.commit();
    }

    public void deletePet(PetDVO petDVO) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);

        mapper.deletePet(petDVO);
        sqlSession.commit();
    }

    public void insertPet(PetDVO petDVO) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        mapper.insertPet(petDVO);
        sqlSession.commit();

        // Printing the generated key value
        System.out.println("--- Id value ---" + petDVO.getId());
    }

    public void callReadPet(PetDVO petDVO) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);

        mapper.callReadPet(petDVO);
    }

    public List<PetDVO> callReadAllPets() throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);

        HashMap<String, List<PetDVO>> inputMap = new HashMap<String, List<PetDVO>>();
        List<PetDVO> petList = new ArrayList<PetDVO>();
        inputMap.put("petData", petList);

        mapper.callReadAllPets(inputMap);
        List<PetDVO> outputData = inputMap.get("petData");        
        return outputData;
    }

//    public void callPetOwnerFunction() throws Exception {
//        SqlSession sqlSession = getSqlSession();
//        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
//
//        HashMap<String, String> inputMap = new HashMap<String, String>();
//        inputMap.put("name", "Slim");
//        inputMap.put("owner", "");
//
//        mapper.callPetOwnerFunction(inputMap);
//        System.out.println("--- Function result owner ---" + inputMap.get("owner"));
//    }

//   public List<PetDVO> getAllPetsUsingResultMap(String sex) throws Exception {
//        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
//        return mapper.getAllPetsUsingResultMap(sex);
//   }


}
