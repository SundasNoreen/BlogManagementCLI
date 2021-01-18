package com.swth.shine;
import java.io.Console;
import java.util.Scanner;

public class Admin_DashBoard
{
    private String UserName;
    Admin_DashBoard()
    {

    }
    Admin_DashBoard(String UserName)
    {
        this.UserName=UserName;
    }
    public void admin_commands()
    {
        this.UserName=UserName;
        boolean flag=true;
        while (flag)
        {
           Scanner option = new Scanner(System.in);
           System.out.println(ConsoleColors.GREEN_BOLD+"\nWELCOME TO ADMIN DASHBOARD");
           System.out.println(ConsoleColors.PURPLE_BOLD+"\nPress 1 to View or Delete Blogs.");
           System.out.println(ConsoleColors.CYAN_BOLD+"Press 2 to Add Blogs from Entries.");
           System.out.println(ConsoleColors.PURPLE_BOLD+"Press 3 to Clear Entries.");
           System.out.println(ConsoleColors.CYAN_BOLD+"Press 4 to Add Admins.");
           System.out.println(ConsoleColors.PURPLE_BOLD+"Press 5 to LogOut.");
           int n=option.nextInt();
           if (n==5)
           {
               System.gc();
               console.main(null);

           }
           else if (n==1)
           {
               All_Blogs One = new All_Blogs();
               One.all_Blogs();
               continue;
           }
           else if (n==2)
           {
               Entries One_Two=new Entries();
               One_Two.all_entries();
               System.out.println(ConsoleColors.YELLOW_BOLD+"\nDo you Want to Add Blog From Above Entries or Directly. Press 1 to Continue.");
               int s=option.nextInt();
               if (s==1){
                   Add_Blogs One = new Add_Blogs();
                   One.add_blog(UserName);
                   Admin_DashBoard adm = new Admin_DashBoard(UserName);
                   adm.admin_commands();
               }
               else
                   {
                       Admin_DashBoard adm = new Admin_DashBoard(UserName);
                       adm.admin_commands();
                   }
           }
           else if (n==3)
           {
               System.out.println(ConsoleColors.YELLOW_BOLD+"\nAre You Sure You Want to Clear All Entries? Press 1 to Continue.");
               int b=option.nextInt();
               if (b==1)
               {
                    Entries One = new Entries();
                    One.del_entries();
               }
               else
               {
                   Admin_DashBoard adm = new Admin_DashBoard(UserName);
                   adm.admin_commands();
               }
           }
            else if (n==4)
           {
               String LoginID;
               String Name;
               String EmailID;
               String PassWord;
               System.out.println(ConsoleColors.PURPLE_BOLD+"\nADMIN DETAILS");
               option.nextLine();
               System.out.println(ConsoleColors.CYAN_BOLD+"Enter Name ");
               Name=option.nextLine();
               System.out.println(ConsoleColors.RED_BOLD+"Enter Email ID ");
               EmailID=option.nextLine();
               System.out.println(ConsoleColors.GREEN_BOLD+"Enter LoginID: ");
               LoginID= option.next();
               option.nextLine();
               System.out.println(ConsoleColors.CYAN_BOLD+"Enter Password: ");
               PassWord= option.nextLine();
               Admin_Class.new_admin(Name, EmailID, LoginID, PassWord);
           }
            else
           {
               System.out.println(ConsoleColors.YELLOW_BOLD+"Enter a Valid Choice.");
           }
           }





    }}


