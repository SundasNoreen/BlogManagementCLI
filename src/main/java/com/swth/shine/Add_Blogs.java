package com.swth.shine;

import com.swth.shine.Admin_DashBoard;
import com.swth.shine.Author_Details;
import com.swth.shine.ConsoleColors;
import com.swth.shine.Home_Page_Category_Wise;

import java.sql.*;
import java.util.*;

public class Add_Blogs
{
    private int BlogID;
    Connection conn = null;
    private String Title;
    private String Category;
    private String Author;
    private int AuthorID;
    private String Blog;
    private String Disclaimer;
    private String Admin;
    public String UserName;
    private Blob Pic;
    Scanner uni = new Scanner(System.in);

    public void add_blog(String UserName) {
        this.UserName=UserName;
        System.out.println(ConsoleColors.CYAN_BOLD+"\nEnter the Title: ");
        Title=uni.nextLine();
        System.out.println(ConsoleColors.PURPLE_BOLD+"Choose the Category: ");
        System.out.println(ConsoleColors.GREEN+"1. National Politics");
        System.out.println(ConsoleColors.GREEN+"2. Global Politics");
        System.out.println(ConsoleColors.GREEN+"3. Technology");
        System.out.println(ConsoleColors.GREEN+"4. View Point");
        System.out.println(ConsoleColors.GREEN+"5. Media Logs");
        System.out.println(ConsoleColors.GREEN+"6. Life Style");
        System.out.println(ConsoleColors.GREEN+"7. Sports");
        int n= uni.nextInt();
        switch (n)
        {
            case 1:
                System.out.println(ConsoleColors.GREEN_BOLD+"\nNational Politics: ");
                Category="National";
                break;
            case 2:
                System.out.println(ConsoleColors.GREEN_BOLD+"\nGlobal Politics: ");
                Category="Global";
                break;
            case 3:
                System.out.println(ConsoleColors.GREEN_BOLD+"\nTechnology: ");
                Category="Technology";
                break;
            case 4:
                System.out.println(ConsoleColors.GREEN_BOLD+"\nView Point: ");
                Category="View Point";
                break;
            case 5:
                System.out.println(ConsoleColors.GREEN_BOLD+"\nMedia Logs: ");
                Category="Media Logs";
                break;
            case 6:
                System.out.println(ConsoleColors.GREEN_BOLD+"\nLife Style: ");
                Category="Life Style";
                break;
            case 7:
                System.out.println(ConsoleColors.GREEN_BOLD+"\nSports: ");
                Category="Sports";
                break;
            default:
                System.out.println(ConsoleColors.RED+"Enter a Valid Option.");
                Admin_DashBoard neo = new Admin_DashBoard();
                neo.admin_commands();
                break;
        }
        uni.nextLine();
        System.out.println(ConsoleColors.CYAN_BOLD+"Enter Blog Content.");
        Blog=uni.nextLine();
        System.out.println(ConsoleColors.RED_BOLD+"Author Details");
        System.out.println(ConsoleColors.PURPLE_BOLD+"Enter Author Name: ");
        Author= uni.nextLine();
        System.out.println(ConsoleColors.PURPLE_BOLD+"Enter City: ");
        String City= uni.next();
        System.out.println(ConsoleColors.PURPLE_BOLD+"Enter Author Email: ");
        String Author_Email= uni.next();
        uni.nextLine();
        System.out.println(ConsoleColors.PURPLE_BOLD+"Enter Author Intro: ");
        String Intro= uni.nextLine();
        System.out.println(ConsoleColors.PURPLE_BOLD+"Enter Author Phone Number: ");
        long Phone= uni.nextLong();

        if (City.equals(null))
        {
            Author_Details m1 = new Author_Details();
            AuthorID=m1.check_author(Author,Author_Email,null,Intro,Phone);
        }
        else if (Phone==0)
        {
            Author_Details m2 = new Author_Details();
            AuthorID=m2.check_author(Author,Author_Email,City,Intro,0);
        }
        else if (City.equals(null) || Phone == 0 )
        {
            Author_Details m3 = new Author_Details();
            AuthorID=m3.check_author(Author,Author_Email,null,Intro,0);
        }
        else
        {
            Author_Details m4 = new Author_Details();
            AuthorID=m4.check_author(Author,Author_Email,City,Intro,Phone);
        }
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query="INSERT INTO `blogs`(`Title`, `Category`, `Author`, `AuthorID`, `Blog`, `Admin`) VALUES ('"+Title+"','"+Category+"','"+Author+"','"+AuthorID+"','"+Blog+"','"+UserName+"')";
            Statement stmt = conn.prepareStatement(query);
            stmt.execute(query);
            System.out.println(ConsoleColors.CYAN_BOLD+"Blog was Added Successfully.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ConsoleColors.CYAN_BOLD+"There was an error in adding Blog. Try Again.");
        }
    }}
