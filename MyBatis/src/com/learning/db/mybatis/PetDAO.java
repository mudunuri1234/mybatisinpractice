package com.learning.db.mybatis;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 11, 2013
 * Time: 9:27:45 AM
 */
public interface PetDAO {

    List<PetDVO> getAllPetsData();

    PetDVO getPetObject(String petName);

    List<String> getAllSpecies();

    List<PetDVO> selectPets(String sex);

    List<PetDVO> findAllSnakes();

    List<PetDVO> findSnakePets();

    List<PetDVO> selectPetsIn();

    void createPet(PetDVO petDVO);

    void updatePetData(PetDVO petDVO);

    void updatePetDynamically(PetDVO petDVO);

    void deletePet(PetDVO petDVO);

    List<PetDVO> callReadAllPets();

    void callReadPet();

    void callPetOwnerFunction();

    public void insertUser();

}
