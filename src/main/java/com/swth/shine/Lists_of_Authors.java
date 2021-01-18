package com.swth.shine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lists_of_Authors {
    public static void Authors_List() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/blogs", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM authors");
            System.out.println(ConsoleColors.CYAN_BOLD+"\nID      Name");
            while (rs.next()) {
                int AuthorID = rs.getInt(1);
                String Author = rs.getString(2);
                System.out.println(ConsoleColors.GREEN+AuthorID + "       " + Author);
            }
        } catch (Exception ex) {
            System.out.println("Failed to Load Authors List.");
        }
    }
}
