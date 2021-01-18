package com.swth.shine;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Home_Page_First_Four
{
    public static ArrayList<blog> BlogPosts = new ArrayList<blog>();
    private Connection con = null;
    private int BlogID;
    private String Title;
    private String Category;
    private String Author;
    private int AuthorID;
    private String Blog;
    private String Disclaimer;
    private String Admin;
    private Blob Pic;
    private Date date;
    private Statement stmt = null;
    private ResultSet rs = null;

    private void First_Four() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM blogs ORDER BY Date DESC LIMIT 0,4");
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
        }
    }
    public void get_first_four()
    {
        Home_Page_First_Four One = new Home_Page_First_Four();
        One.First_Four();
        System.out.println(ConsoleColors.CYAN_BOLD+"ID      "+
                ConsoleColors.PURPLE+"Date    "+
                ConsoleColors.RED+"      Blog");
        System.out.println(ConsoleColors.GREEN_BOLD+"___________________________________________________________________________________________________");
        for (blog x: BlogPosts)
        {
            System.out.println(ConsoleColors.CYAN+x.getBlogID()+"    "+
                    ConsoleColors.PURPLE+x.getDate()+"    "+
                    ConsoleColors.RED+x.getTitle()+"  "+ConsoleColors.GREEN+"BY  "+
                    ConsoleColors.BLUE+x.getAuthor()+"    ");
        }
    }

}
