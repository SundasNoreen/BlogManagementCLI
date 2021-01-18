package com.swth.shine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin_Class
{
    private String LoginID;
    private String Name;
    private String EmailID;
    private String PassWord;

    public String getLoginID() { return LoginID; }
    public void setLoginID(String LoginID) { this.LoginID = LoginID; }
    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }
    public String getEmailID() { return EmailID; }
    public void setEmailID(String EmailID) { this.EmailID = EmailID; }
    public String getPassWord() { return PassWord; }
    public void setPassWord(String PassWord) { this.PassWord = PassWord; }

    Admin_Class(String LoginID, String Name, String EmailID, String Password)
    {
        this.LoginID=LoginID;
        this.Name=Name;
        this.EmailID=EmailID;
        this.PassWord=Password;
    }
    Admin_Class (String LoginID, String PassWord)
    {
        this.LoginID=LoginID;
        this.PassWord=PassWord;
        login(LoginID,PassWord);
    }
    public boolean login(String LoginID, String PassWord)
    {
        String UserName=LoginID;
        String Password=PassWord;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM editors ");
            while (rs.next()) {
                LoginID=rs.getString(3);
                PassWord=rs.getString(4);
                if (UserName.equals(LoginID) && Password.equals(PassWord))
                {
                    return true;
                }
            }
        } catch (Exception ex)
        {
            return false;
        }
        return false;
    }
    public static void new_admin(String Name, String EmailID, String LoginID, String Password)
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query="INSERT INTO `editors`(`Name`, `Email ID`, `Login`, `Password`) VALUES ('"+Name+"','"+EmailID+"','"+LoginID+"','"+Password+"')";
            Statement stmt = conn.prepareStatement(query);
            stmt.execute(query);
            System.out.println(ConsoleColors.CYAN_BOLD+"Admin was Added Successfully.");
        } catch (Exception ex) {
            System.out.println(ConsoleColors.CYAN_BOLD+"There was an error in adding Admin. Try Again.");
        }
    }

}
