package com.learning.db.mybatis.tx.annotations;

import com.learning.db.mybatis.tx.dao.PetDVO;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 1:59:02 PM
 */
public interface PetDAO {

    public void insertPet(PetDVO petDVO);

    public void updatePetData(PetDVO petDVO);

    public void doInsertAndUpdateInTx();
}