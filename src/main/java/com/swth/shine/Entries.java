package com.swth.shine;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Entries
{
    private Connection con = null;
    public static ArrayList<Entries> BlogPosts = new ArrayList<Entries>();
    private String Title;
    private String Name;
    private String Email;
    private String Blog;
    private String intro;
    private long Phone;
    private String City;
    private Statement stmt = null;
    private ResultSet rs = null;
    Scanner no = new Scanner(System.in);
    Entries()
    {

    }
    Entries(String Name,String Email,String intro,long Phone,String City,String Title,String Blog)
    {
        this.Name=Name;
        this.Email=Email;
        this.intro=intro;
        this.Phone=Phone;
        this.City=City;
        this.Title=Title;
        this.Blog=Blog;
    }

    public String getTitle()
    {
        return Title;
    }
    public String getEmail() { return Email; }
    public String getName() { return Name; }
    public String getintro()
    {
        return intro;
    }
    public long getPhone()
    {
        return Phone;
    }
    public String getCity()
    {
        return City;
    }
    public String getBlog()
    {
        return Blog;
    }
    private void entries_All()
    {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM write_for_us ");
            BlogPosts.clear();
            while (rs.next()) {
                Name = rs.getString(1);
                Email = rs.getString(2);
                intro = rs.getString(3);
                Phone=rs.getLong(4);
                City=rs.getString(5);
                Title=rs.getString(6);
                Blog=rs.getString(7);
                BlogPosts.add(new Entries(Name,Email,intro,Phone,City,Title,Blog));
            }
        } catch (Exception ex) {
        }
    }
    public void all_entries() {
        Entries One = new Entries();
        One.entries_All();
        System.out.println(ConsoleColors.CYAN_BOLD + "ID      " +
                ConsoleColors.PURPLE + "Date    " +
                ConsoleColors.RED + "      Blog");
        System.out.println(ConsoleColors.GREEN_BOLD + "___________________________________________________________________________________________________");
        for (Entries x : BlogPosts) {
            System.out.println(ConsoleColors.CYAN_BOLD + "\nName: " + x.getName());
            System.out.println(ConsoleColors.RED_BOLD + "Email: " + x.getEmail());
            System.out.println(ConsoleColors.PURPLE_BOLD + "About: " + x.getintro());
            System.out.println(ConsoleColors.GREEN_BOLD + "Phone Number: " + x.getPhone());
            System.out.println(ConsoleColors.YELLOW_BOLD + "City: " + x.getCity());
            System.out.println(ConsoleColors.CYAN_BOLD + "Title: " + x.getTitle());
            System.out.println(ConsoleColors.PURPLE_BOLD + "Blog: " + x.getBlog());

        }
    }
    public void del_entries()
    {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement st = con.prepareStatement("Delete  FROM write_for_us");
            st.executeUpdate();
            System.out.println(ConsoleColors.CYAN_BOLD+"\nEntries Cleared Successfully.");
        }
        catch (Exception x)
        {
            System.out.println(ConsoleColors.RED_BOLD+"Sorry! We were unable to process your request.");
        }
    }
}
