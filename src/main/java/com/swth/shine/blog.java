package com.swth.shine;
import java.awt.*;
import java.util.Date;
import java.sql.*;

public class blog
{
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

    public void setBlogID(int BlogID)
    {
        this.BlogID = BlogID;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public void setCategory(String Category)
    {
        this.Category = Category;
    }
    public void setAuthor(String Author)
    {
        this.Author = Author;
    }
    public void setAuthorID(int AuthorID)
    {
        this.AuthorID = AuthorID;
    }
    public void setBlog(String Blog)
    {
        this.Blog = Blog;
    }
    public void setDisclaimer(String Disclaimer)
    {
        this.Disclaimer = Disclaimer;
    }
    public void setAdmin(String Admin)
    {
        this.Admin = Admin;
    }
    public void setPic(Blob Pic)
    {
        this.Pic = Pic;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public int getBlogID() { return BlogID; }
    public String getTitle()
    {
        return Title;
    }
    public String getCategory() { return Category; }
    public String getAuthor()
    {
        return Author;
    }
    public int getAuthorID()
    {
        return AuthorID;
    }
    public String getBlog()
    {
        return Blog;
    }
    public String getDisclaimer()
    {
        return Disclaimer;
    }
    public String getAdmin()
    {
        return Admin;
    }
    public Blob getPic()
    {
        return Pic;
    }
    public Date getDate()
    {
        return date;
    }

    blog(int BlogID,String Title,String Category, String Author,int AuthorID, String Blog, String Disclaimer, String Admin, Blob Pic,Date date)
    {
        this.BlogID=BlogID;
        this.Title=Title;
        this.Author=Author;
        this.AuthorID=AuthorID;
        this.Blog=Blog;
        this.Disclaimer=Disclaimer;
        this.Admin=Admin;
        this.Pic=Pic;
        this.date=date;
    }
}
