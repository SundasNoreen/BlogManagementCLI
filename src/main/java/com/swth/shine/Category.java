package com.swth.shine;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Category
{
    public static ArrayList Category_Wise(String Category) {
        ArrayList<blog> BlogPosts = new ArrayList<blog>();
        Connection con = null;
        int BlogID;
        String Title;
        String Author;
        int AuthorID;
        String Blog;
        String Disclaimer;
        String Admin;
        Blob Pic;
        Date date;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM blogs WHERE Category  ='" + Category + "'ORDER BY Date DESC");
            BlogPosts.clear();
            while (rs.next()) {
                BlogID = rs.getInt(1);
                Title = rs.getString(2);
                Category = rs.getString(3);
                Author=rs.getString(4);
                AuthorID=rs.getInt(5);
                Blog=rs.getString(6);
                Disclaimer=rs.getString(7);
                Admin=rs.getString(8);
                Pic = rs.getBlob(9);
                date = rs.getDate(10);
                BlogPosts.add(new blog(BlogID, Title , Category, Author,AuthorID, Blog, Disclaimer, Admin, Pic,date));
            }
        } catch (Exception ex) {
            System.out.println("Failed to Load Posts.");
        }
        return BlogPosts;
    }
}
