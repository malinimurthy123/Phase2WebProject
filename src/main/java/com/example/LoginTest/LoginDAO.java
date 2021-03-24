package com.example.LoginTest;

import bean.LoginBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    String qry;
    Connection dbCon;
    Statement theStatement;

    public boolean LoginDAOConnection(LoginBean loginBean){
        boolean status = false;
        try {
            //  Define the URL to connect -test
            String urlToConnect = "jdbc:mysql://localhost:3306/test";

            //  Define the username for db to connect
            String dbUserName = "root";

            //   Define the password
            String dbUserPassword = "";

            //  Define the driver for the database
            String mySqlDriver = "com.mysql.cj.jdbc.Driver";


            //   Load the Driver
            Class.forName(mySqlDriver);

            //	Try to establish the connection
            dbCon = DriverManager.getConnection(urlToConnect, dbUserName, dbUserPassword);

            //  Get a reference to the Statement
            theStatement = dbCon.createStatement();

			System.out.println("Successfully connected to the database...");

            // Step 2:Create a statement using connection object


            PreparedStatement preparedStatement = dbCon
                    .prepareStatement("select * from users where UserName = ? ");
            {
                preparedStatement.setString(1, LoginBean.getUsername());


                System.out.println(preparedStatement);
                //Execute query
                ResultSet rs = preparedStatement.executeQuery();
                status = rs.next();

                if (rs.next()) {
                    LoginBean loginbean = new LoginBean();
                    loginbean.setUsername(rs.getString("username"));

                }
                dbCon.close();

            }

        } catch (SQLException | ClassNotFoundException e) {
            // process sql exception
            printSQLException((SQLException) e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable tran = ex.getCause();
                while (tran != null) {
                    System.out.println("Cause: " + tran);
                    tran = tran.getCause();
                }
            }
        }
    }
}
