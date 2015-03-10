package com.learning.db.mybatis.tx.dao;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 1:59:02 PM
 */
public interface PetDAO {

    void doInsertAndUpdateInTx();

    void doInsertAndUpdateUsingTxTemplate();

    void insertPet();

    void updatePetData();
    
}
