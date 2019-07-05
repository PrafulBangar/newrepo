package com.group;


import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String args[]){

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "rootpasswordgiven");

                if (con != null) {
                    System.out.println("connected");

                } else {
                    System.out.println("not connected");

                }
                con.close();
            }
            catch(Exception e){ System.out.println(e);}
        }


    }

