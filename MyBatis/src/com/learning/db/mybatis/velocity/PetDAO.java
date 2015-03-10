package com.learning.db.mybatis.velocity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 1:59:02 PM
 */
public interface PetDAO {

    public PetDVO getPetObject(String petName);

    public PetDVO getPetObjectData(String petName, String sex);

    public List<PetDVO> getAllPets(List<PetDVO> petList);

    public List<PetDVO> getMatchingPets(List<String> petNamesList);

    public List<PetDVO> findAllSnakes();

    public void createPet(PetDVO petDVO);

    public void updatePetData(PetDVO petDVO);

    public void deletePet(PetDVO petDVO);

    public void callReadPet();

}
