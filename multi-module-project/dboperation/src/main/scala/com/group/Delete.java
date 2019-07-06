package com.group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Delete
{
    //public static void main(String args[])
    public  void deleteRecord()
    {    User user = new User();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter user id to delete =");
        String id=sc.next();
        user.setid(id);


        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "username", "passwordgiven");
            Statement st=con.createStatement();

            String querry="delete from user where id ='" + user.getid() + "' ";
            int x=st.executeUpdate(querry);

            if(x>0)
                System.out.println("Deleted Successfully");
            else
                System.out.println("failed to Delete");

            con.close();

        }
        catch(Exception e)
        {
            System.out.println("e");

        }

    }


}
