package com.learning.db.mybatis.tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import com.learning.db.mybatis.tx.dao.PetDAO;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jan 15, 2013
 * Time: 2:19:01 PM
 */
public class TxMain {

//    public static void main(final String[] args) throws Exception {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String [] {"applicationContext-tx.xml"});
//        PetDAO petDAO = (PetDAO) ctx.getBean("petDAOImpl");
//        petDAO.doInsertAndUpdateInTx();
//    }

//        public static void main(final String[] args) throws Exception {
//            ApplicationContext ctx = new ClassPathXmlApplicationContext
//                    (new String[]{"applicationContext-tx-template.xml"});
//            PetDAO petDAO = (PetDAO) ctx.getBean("petDAOImpl");
//            petDAO.doInsertAndUpdateUsingTxTemplate();
//        }

    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ( new String[] {"applicationContext-tx-annotations.xml"} );
        com.learning.db.mybatis.tx.annotations.PetDAO petDAO =
                (com.learning.db.mybatis.tx.annotations.PetDAO) ctx.getBean("petDAOImpl");
        petDAO.doInsertAndUpdateInTx();
    }

}
