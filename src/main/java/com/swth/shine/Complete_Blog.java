package com.swth.shine;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Complete_Blog
{
    private int BlogID;
    private String Title;
    private String Category;
    private String Author;
    private String Blog;
    private String Disclaimer;
    private Blob Pic;
    private Date date;
    private Connection con;
    Complete_Blog(int BlogID)
    {
        this.BlogID=BlogID;
        Full_Blog();
    }
    public ArrayList<blog> Full_Blog()
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blogs WHERE BlogID='"+BlogID+"'");
            while (rs.next()) {
                Title = rs.getString(2);
                Category = rs.getString(3);
                Author = rs.getString(4);
                Blog = rs.getString(6);
                Disclaimer = rs.getString(7);
                date = rs.getDate(10);
                System.out.println(ConsoleColors.CYAN_BOLD+"\n"+Title);
                System.out.println(ConsoleColors.PURPLE+"Written By: "+Author);
                System.out.println(ConsoleColors.GREEN+"Posted On:"+date);
                System.out.println(ConsoleColors.YELLOW+Blog);
                System.out.println("Disclaimer: "+Disclaimer);
            }
        } catch (Exception ex) {
            System.out.println("Failed to Load Blog.");
        }
        return null;
    }
}
