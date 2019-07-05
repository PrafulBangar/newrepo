package com.group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Read
{
//    public static void main(String args[])

    public void readRecords()
    {
        Scanner sc =new Scanner(System.in);
        //System.out.println("Enter user id to read information =");
        //String id;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "rootpasswordgiven");
            Statement st=con.createStatement();

            String querry="select * from user";
            ResultSet x=st.executeQuery(querry);

            while(x.next()) {
                String id = x.getString("id");
                String name = x.getString("name");
                int age = x.getInt("age");

                System.out.format("%s,%s,%d",id,name,age);
                System.out.println();
            }


            con.close();

        }
        catch(Exception e)
        {
           System.out.println("e");

        }

    }


}
