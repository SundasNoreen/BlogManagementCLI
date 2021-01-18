package com.swth.shine;

import java.sql.*;

public class Author_Details
{
    private int ID;
    private String Name;
    private String Email;
    private String City;
    private String intro;
    private long Phone;

    public int check_author(String Name, String Email, String City, String intro, long Phone) {
        String Auth = Email;
        this.Name = Name;
        this.City = City;
        this.intro = intro;
        this.Phone = Phone;
        try {
            boolean flag=false;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM authors ");
            while (rs.next())
            {
                String Em = rs.getString(3);
                if (Auth.equals(Em))
                {
                    flag=true;
                    Name = rs.getString(2);
                    intro = rs.getString(5);
                    ID = rs.getInt(1);
                    break;
                }
            }
            if (!flag)
            {
                String query = "INSERT INTO `authors`( `Name`, `EmailID`, `City`, `Intro`, `PhoneNo`) VALUES ('"+Name+"','"+Auth+"','"+City+"','"+intro+"','"+Phone+"')";
                stmt = con.prepareStatement(query);
                stmt.executeUpdate(query);
                System.out.println("Success");
                ResultSet cs = stmt.executeQuery("SELECT * FROM authors WHERE EmailID='"+Auth+"'" );
                while (cs.next())
                {
                    ID = cs.getInt(1);
                }
            }
        }
         catch (Exception ex) {
            System.out.println(ConsoleColors.CYAN_BOLD+"There seems an error in Author Details. Try Again.");
        }
        return ID;
    }
}
