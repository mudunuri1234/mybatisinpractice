package com.learning.db.mybatis.core;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Jul 4, 2013
 * Time: 1:45:51 PM
 */
public class CoreJDBC {

    public static void main(String[] args) {
        try {
            getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Statement getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SPOWNER", "PASSWORD");
        Statement stmt = con.createStatement();
        System.out.println("---- stmt ----" + stmt);
        return stmt;
    }

}
