package com.cts.util;//contains the details required to connect the database.
//Update your Mysql url,userName and Password here.

import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseconnectiondetails {


    private final String url = "jdbc:mysql://localhost:3306/lawdoc";
    private final String userName = "root";
    private final String password = "12345678";
    public String getUrl() {
        return url;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    //These are the getter functions for getting the details.
}
