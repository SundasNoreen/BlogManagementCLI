package com.swth.shine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class Write_For_us {
    private String Name;
    private String Email;
    private String Intro;
    private Long Phone;
    private String City;
    private String Title;
    private String Content;
    Scanner uni=new Scanner(System.in);
    public void write()
    {
        System.out.println(ConsoleColors.CYAN_BOLD+"Enter Your Name.");
        Name=uni.nextLine();
        System.out.println(ConsoleColors.RED_BOLD+"Your Email");
        Email= uni.nextLine();
        System.out.print(ConsoleColors.CYAN_BOLD+"About You: ");
        Intro= uni.nextLine();
        System.out.print(ConsoleColors.RED_BOLD+"Phone Number: ");
        Phone= uni.nextLong();
        uni.nextLine();
        System.out.print(ConsoleColors.CYAN_BOLD+"Enter City: ");
        City= uni.next();
        System.out.print(ConsoleColors.RED_BOLD+"Enter Title of Your Blog: ");
        Title= uni.next();
        uni.nextLine();
        System.out.print(ConsoleColors.RED_BOLD+"Blog Content: ");
        Content= uni.nextLine();
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query="INSERT INTO `write_for_us`(`Name`, `Email`, `Intro`, `Phone`, `City`, `Title`, `Blog`) " +
                    "VALUES ('"+Name+"','"+Email+"','"+Intro+"','"+Phone+"','"+City+"','"+Title+"','"+Content+"')";
            Statement stmt = conn.prepareStatement(query);
            stmt.executeUpdate(query);
            System.out.println(ConsoleColors.CYAN_BOLD+"Your Message was Sent Successfully.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ConsoleColors.CYAN_BOLD+"There was an error, try contacting Administrator by some other way.");
        }

    }


}
