package com.swth.shine;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class All_Blogs
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
    Scanner no = new Scanner(System.in);
    private void All()
    {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM blogs ORDER BY Date DESC");
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
    public void all_Blogs()
    {
        All_Blogs One = new All_Blogs();
        One.All();
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
        System.out.println(ConsoleColors.CYAN_BOLD+"Do You Want to Delete a Blog or Go Back. Press 1 to Delete Blog.");
        int y=no.nextInt();
        if (y==1)
        {
            System.out.println(ConsoleColors.CYAN_BOLD+"\nEnter Blog ID to Delete a Blog.");
            int ID=no.nextInt();
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
                Class.forName("com.mysql.cj.jdbc.Driver");
                PreparedStatement st = con.prepareStatement("Delete FROM blogs WHERE BlogID = ?");
                st.setInt(1,ID);
                st.executeUpdate();
                System.out.println(ConsoleColors.CYAN_BOLD+"\nBlog was Deleted Successfully.");
            }
            catch (Exception x)
            {
                System.out.println(ConsoleColors.RED_BOLD+"Sorry! We were unable to process your request.");
            }
        }
        else
        {
            Admin_DashBoard neo = new Admin_DashBoard();
            neo.admin_commands();
        }
    }
}
