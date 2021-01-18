package com.swth.shine;
import java.util.*;

public class console
{
    public static void main(String[] args)
    {
        boolean flag=true;
        while (flag) {
            Scanner opt = new Scanner(System.in);
            System.out.println(ConsoleColors.GREEN_BOLD+"\nWELCOME TO SHINE WITH THE SUN");
            System.out.println(ConsoleColors.CYAN+"Enter 1 to View Latest Blogs.");
            System.out.println(ConsoleColors.PURPLE+"Enter 2 to View Blogs by Category.");
            System.out.println(ConsoleColors.CYAN+"Enter 3 to View Some Suggested Blogs.");
            System.out.println(ConsoleColors.PURPLE+"Enter 4 to View Blogs by Author.");
            System.out.println(ConsoleColors.CYAN+"Enter 5 if you want to Contact us.  ");
            System.out.println(ConsoleColors.PURPLE+"Enter 6 if You are an Admin and Want to Sign-In. ");
            System.out.println(ConsoleColors.CYAN+"Enter 7 to Exit.");
            System.out.println(ConsoleColors.PURPLE+"");
            int Option = opt.nextInt();
            if (Option == 7) {
                System.out.println(ConsoleColors.GREEN_BOLD+" Thankyou For Your Visiting us.");
                flag = false;
                System.exit(0);
            }
            if (Option == 1) {
                Home_Page_First_Four myblog = new Home_Page_First_Four();
                System.out.println(ConsoleColors.GREEN_BOLD+"\nRecent Blogs: ");
                myblog.get_first_four();
                System.out.println(ConsoleColors.PURPLE_BOLD+"\nEnter BlogID to Read the Complete Blog, Press 0 to Go Back.: ");
                int id=opt.nextInt();
                if (id==0)
                {continue;}
                Complete_Blog myfull =new Complete_Blog(id);
            }
            else if (Option == 2) {
                String Category;
                System.out.println(ConsoleColors.BLACK+"Choose Category: ");
                System.out.println(ConsoleColors.PURPLE+"1. National Politics");
                System.out.println(ConsoleColors.CYAN+"2. Global Politics");
                System.out.println(ConsoleColors.PURPLE+"3. Technology");
                System.out.println(ConsoleColors.CYAN+"4. View Point");
                System.out.println(ConsoleColors.PURPLE+"5. Media Logs");
                System.out.println(ConsoleColors.CYAN+"6. Life Style");
                System.out.println(ConsoleColors.PURPLE+"7. Sports");
                int choice = opt.nextInt();
                ArrayList<blog> x= null;
                switch (choice)
                {
                    case 1:
                        System.out.println(ConsoleColors.GREEN_BOLD+"\nNational Politics: ");
                        x=Home_Page_Category_Wise.Category_Wise("National");
                        break;
                    case 2:
                        System.out.println(ConsoleColors.GREEN_BOLD+"\nGlobal Politics: ");
                        x=Home_Page_Category_Wise.Category_Wise("Global");
                        break;
                    case 3:
                        System.out.println(ConsoleColors.GREEN_BOLD+"\nTechnology: ");
                        x=Home_Page_Category_Wise.Category_Wise("Technology");
                        break;
                    case 4:
                        System.out.println(ConsoleColors.GREEN_BOLD+"\nView Point: ");
                        x=Home_Page_Category_Wise.Category_Wise("View Point");
                        break;
                    case 5:
                        System.out.println(ConsoleColors.GREEN_BOLD+"\nMedia Logs: ");
                        x=Home_Page_Category_Wise.Category_Wise("Media Logs");
                        break;
                    case 6:
                        System.out.println(ConsoleColors.GREEN_BOLD+"\nLife Style: ");
                        x=Home_Page_Category_Wise.Category_Wise("Life Style");
                        break;
                    case 7:
                        System.out.println(ConsoleColors.GREEN_BOLD+"\nSports: ");
                        x=Home_Page_Category_Wise.Category_Wise("Sports");
                        break;
                    default:
                        System.out.println(ConsoleColors.RED+"Enter a Valid Option.");
                        break;
                }
                System.out.println(ConsoleColors.CYAN_BOLD+"ID      "+
                        ConsoleColors.PURPLE+"Date    "+
                        ConsoleColors.RED+"      Blog");
                System.out.println(ConsoleColors.GREEN_BOLD+"___________________________________________________________________________________________________");
                for (blog y: x)
                {
                    System.out.println(ConsoleColors.CYAN+y.getBlogID()+"    "+
                            ConsoleColors.PURPLE+y.getDate()+"    "+
                            ConsoleColors.RED+y.getTitle()+"  "+ConsoleColors.GREEN+"BY  "+
                            ConsoleColors.BLUE+y.getAuthor()+"    ");
                }
                System.out.println(ConsoleColors.PURPLE_BOLD+"\nEnter BlogID to Read the Complete Blog, Press 0 to Go Back.: ");
                int id=opt.nextInt();
                if (id==0)
                {continue;}
                Complete_Blog myfull=new Complete_Blog(id);
            }
            else if (Option == 3) {
                Home_Page_Get_Read_More myblog = new Home_Page_Get_Read_More();
                System.out.println(ConsoleColors.GREEN_BOLD+"\nRecent Blogs: ");
                myblog.get_read_more();
                System.out.println(ConsoleColors.PURPLE_BOLD+"\nEnter BlogID to Read the Complete Blog, Press 0 to Go Back.: ");
                int id=opt.nextInt();
                if (id==0)
                {continue;}
                Complete_Blog myfull =new Complete_Blog(id);
            }
            else if (Option==4)
            {
                Lists_of_Authors.Authors_List();
                System.out.println(ConsoleColors.BLUE+"Enter the Author ID to View their Blog Lists, Press 0 to Go Back:");
                int sel=opt.nextInt();
                if (sel==0)
                {continue;}
                Author myauth=new Author(sel);
                System.out.println(ConsoleColors.PURPLE_BOLD+"\nEnter BlogID to Read the Complete Blog, Press 0 to Go Back.: ");
                int id=opt.nextInt();
                if (id==0)
                {continue;}
                Complete_Blog myfull =new Complete_Blog(id);
            }
            else if (Option==6)
            {
                System.out.println(ConsoleColors.GREEN_BOLD+"\nEnter UserName: ");
                String username= opt.next();
                System.out.println(ConsoleColors.CYAN_BOLD+"\nEnter Password: ");
                String password= opt.next();
                Admin_Class myobj = new Admin_Class(username,password);
                if (myobj.login(username,password))
                {
                    Admin_DashBoard adm = new Admin_DashBoard(username);
                    adm.admin_commands();
                }
                else
                {
                    System.out.println(ConsoleColors.PURPLE_BOLD+"\nLogin Failed! Try Again.");
                    continue;
                }
            }
            else if (Option==5)
            {
                Write_For_us new1=new Write_For_us();
                new1.write();
            }
        }
    }
}
