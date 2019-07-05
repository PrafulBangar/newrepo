package com.group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Update
{
//    public static void main(String args[])
    public void updateRecord()

    {   User user = new User();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter user id to update =");
        String newid=sc.next();
        user.setid(newid);



        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "rootpasswordgiven");
            Statement st=con.createStatement();
            System.out.println("Enter new user name =");
            String newname=sc.next();
            user.setname(newname);

            System.out.println("Enter new user age =");
            int newage=sc.nextInt();
            user.setAge(newage);

            String querry = ("update user set name='"+user.getname()+"',age='"+user.getage()+"' where id='" +user.getid()+ "'");
            int x=st.executeUpdate(querry);

            if(x>0)
                System.out.println("Updated Successfully");
            else
                System.out.println("failed to Update");

            con.close();

        }
        catch(Exception e)
        {
            System.out.println("e");

        }

    }


}
