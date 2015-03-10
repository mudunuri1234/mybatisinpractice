package com.learning.db.mybatis.tx.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.stereotype.Component;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 1:59:24 PM
 */
@Component
public class PetDAOImpl implements PetDAO {

    private SqlSessionTemplate sqlSessionTemplate;

    private TransactionTemplate transactionTemplate;

    public void doInsertAndUpdateInTx() {
        // Insert a record
        insertPet();

        // Create an error to get the exception
        int i = 0;
        int j = 100 / i;       

        updatePetData();
    }

    public void doInsertAndUpdateInTx1() {
        try {
            // Insert a record
            insertPet();

            // Create an error to get the exception
            int i = 0;
            int j = 100 / i;

            // Update pet data
            updatePetData();

        } catch (Exception ex) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            System.out.println(" is Completed " + status.isCompleted());
            status.setRollbackOnly();
        }
    }

    public void doInsertAndUpdateUsingTxTemplate() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    // Insert a record
                    insertPet();

                    // Create an error to get the exception
                    int i = 0;
                    int j = 100 / i;

                    // Update a record
                    updatePetData();

                } catch (Exception ex) {
                    System.out.println(" is Completed " + status.isCompleted());
                    status.setRollbackOnly();
                }
            }
        });
    }

    public void insertPet() {
        // Data to be inserted
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slim1");
        petDVO.setOwner("Steve");
        petDVO.setSpecies("Snake");
        petDVO.setSex("f");
        petDVO.setBirth(new Date());

        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("name", petDVO.getName());
        inputMap.put("owner", petDVO.getOwner() );
        inputMap.put("species", petDVO.getSpecies() );
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("death", petDVO.getDeath());

        sqlSessionTemplate.insert("createPet", inputMap);
    }

    public void updatePetData() {
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slimmy");
        petDVO.setSex("f");
        petDVO.setBirth(new Date());
        
        HashMap<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("birth", petDVO.getBirth());
        inputMap.put("sex", petDVO.getSex());
        inputMap.put("name", petDVO.getName());

        sqlSessionTemplate.update("updatePetData", inputMap);
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }    

}
