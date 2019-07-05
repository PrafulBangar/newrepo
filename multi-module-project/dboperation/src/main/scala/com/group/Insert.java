package com.group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Insert
{
//public static void main(String args[])
public void insertRecord()
    {
    User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id =");
        String id = sc.next();
        user.setid(id);

        System.out.println("Enter user name =");
        String name = sc.next();
        user.setname(name);
        System.out.println("Enter user age =");
        int age = sc.nextInt();
        user.setAge(age);
try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "rootpasswordgiven");
    Statement st=con.createStatement();

    String querry="insert into user values('"+ user.getid()+"','"+user.getname()+"','"+user.getage()+"')";
    int x=st.executeUpdate(querry);

    if(x>0)
        System.out.println("Inserted Successfully");
    else
        System.out.println("failed to insert");

con.close();

}
catch(Exception e)
{
    System.out.println("e");

}

}


}
