package com.learning.db.mybatis.java;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import com.learning.db.mybatis.PetDVO;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: May 29, 2013
 * Time: 8:03:06 PM
 */
public interface PetMapper {

    //http://loianegroner.com/2011/02/getting-started-with-ibatis-mybatis-annotations/

    @Select(" SELECT ID as id, NAME as name, OWNER as owner, SPECIES as species, SEX as sex, " +
            "       BIRTH as birth, DEATH as death " +
            " FROM Pet where name = #{name} ")
    public PetDVO getPetObject(String petName);

    @Select("SELECT * FROM PET")
    @Results(value = {
        @Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "owner", column = "OWNER"),
        @Result(property = "species", column = "SPECIES"),
        @Result(property = "sex", column = "SEX")
     })
    List<PetDVO> selectAllPets();

    @Select(" SELECT ID as id, NAME as name, OWNER as owner, SPECIES as species, " +
            "        SEX as sex, BIRTH as birth, DEATH as death FROM Pet ")
    public List<PetDVO> getAllPetsData();

    @Select(" SELECT ID as id, NAME as name, OWNER as owner, SPECIES as species, SEX as sex,  " +
            "         BIRTH as birth, DEATH as death   " +
            " FROM Pet where sex = #{sex} ")
    public List<PetDVO> selectPets(String sex);

    @Update(" UPDATE Pet p SET p.birth = #{birth}, p.sex = #{sex} WHERE p.name = #{name} ")
    public void updatePetData(PetDVO petDVO);

    @Update(" UPDATE Pet SET birth = #{birth}, sex = #{sex} WHERE name = #{name} ")
    public void updateData(@Param("birth")Date birth,
                           @Param("sex")String sex,
                           @Param("name")String name);

    @Delete(" DELETE FROM Pet WHERE name = #{name} AND species = #{species} ")
    public void deletePet(PetDVO petDVO);

    @Insert(" INSERT INTO Pet (ID, NAME, OWNER, SPECIES, SEX, BIRTH) " +
            " VALUES ( #{id}, #{name}, #{owner}, #{species}, #{sex}, #{birth} ) ")
    @SelectKey(statement = "SELECT PET_ID_SEQ.nextval AS id FROM dual",
            keyProperty = "id",
            before = true,
            resultType = int.class)
    public void insertPet(PetDVO petDVO);

    @Insert(" INSERT INTO Pet (ID, NAME, OWNER, SPECIES, SEX, BIRTH) " +
            " VALUES ( #{id}, #{name}, #{owner}, #{species}, #{sex}, #{birth} ) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertPetData(PetDVO petDVO);


    @Select(value = " { CALL read_pet(  " +
            "   #{name, mode=IN, jdbcType=VARCHAR},     " +
            "   #{owner, mode=OUT, jdbcType=VARCHAR},   " +
            "   #{species, mode=OUT, jdbcType=VARCHAR}, " +
            "   #{sex, mode=OUT, jdbcType=VARCHAR},     " +
            "   #{birth, mode=OUT, jdbcType=DATE},      " +
            "   #{death, mode=OUT, jdbcType=DATE}       " +
            " )} ")
    @Options(statementType = StatementType.CALLABLE)
    public void callReadPet(PetDVO petDVO);


    @Select(value = " { CALL read_all_pets( " +
            " #{petData, mode=OUT, jdbcType=CURSOR, javaType=ResultSet, resultMap=cursorData} ) } ")
    @Options(statementType = StatementType.CALLABLE)
    public List<PetDVO> callReadAllPets(HashMap<String, List<PetDVO>> inputMap);

    
//    @Select(value = "{ #{owner, javaType=String, jdbcType=VARCHAR, mode=OUT} = CALL get_pet_owner( #{name, javaType=String, jdbcType=VARCHAR, mode=IN} ) } ")
//    @Options(statementType = StatementType.CALLABLE)
//    public void callPetOwnerFunction(HashMap<String, String> inputMap);
//
//    @Select( " SELECT ID as id, NAME as name, OWNER as owner, " +
//             "   SPECIES as species, BIRTH as birth, DEATH as death  " +
//             "   FROM Pet where sex = #{sex}  ")
//    @ResultMap(value = "simplePetResultMap")
//    public List<PetDVO> getAllPetsUsingResultMap(String sex);

}
