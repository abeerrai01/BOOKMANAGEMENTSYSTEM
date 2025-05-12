package com.Book.Server.BookServer.BookController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("/Book")
public class BookController
{
    private final String url="jdbc:mysql://localhost:3306/bookserver";
    private final String username="root";
    private final String password="Swechhar";



    @GetMapping("/All")
    public List<BookInfo> GetData()
    {
        List<BookInfo> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query="SELECT * FROM BOOKINFO";
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                BookInfo book=new BookInfo();
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPublishedYear(rs.getInt("publishedYear"));
                book.setLanguage(rs.getString("language"));
                book.setNumberOfPages(rs.getInt("numberOfPages"));
                book.setRating(rs.getDouble("rating"));
                book.setAvailable(rs.getBoolean("isAvailable"));
                books.add(book);

            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    @GetMapping("/Rated")
    public List<BookInfo> Rated()
    {
        List<BookInfo> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query="SELECT * FROM BOOKINFO WHERE RATING BETWEEN 3.0 AND 5.0 ORDER BY RATING DESC;";
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                BookInfo book=new BookInfo();
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPublishedYear(rs.getInt("publishedYear"));
                book.setLanguage(rs.getString("language"));
                book.setNumberOfPages(rs.getInt("numberOfPages"));
                book.setRating(rs.getDouble("rating"));
                book.setAvailable(rs.getBoolean("isAvailable"));
                books.add(book);

            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    @GetMapping("/Genre/{name}")
    public List<BookInfo> Genre(@PathVariable String name)
    {
        List<BookInfo> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query="SELECT * FROM BOOKINFO WHERE GENRE=?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                BookInfo book=new BookInfo();
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPublishedYear(rs.getInt("publishedYear"));
                book.setLanguage(rs.getString("language"));
                book.setNumberOfPages(rs.getInt("numberOfPages"));
                book.setRating(rs.getDouble("rating"));
                book.setAvailable(rs.getBoolean("isAvailable"));
                books.add(book);

            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    @GetMapping("/Language/{name}")
    public List<BookInfo> Language(@PathVariable String name)
    {
        List<BookInfo> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query="SELECT * FROM BOOKINFO WHERE LANGUAGE=?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                BookInfo book=new BookInfo();
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPublishedYear(rs.getInt("publishedYear"));
                book.setLanguage(rs.getString("language"));
                book.setNumberOfPages(rs.getInt("numberOfPages"));
                book.setRating(rs.getDouble("rating"));
                book.setAvailable(rs.getBoolean("isAvailable"));
                books.add(book);

            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    @GetMapping("/Avaliable/{name}")
    public List<BookInfo> Available(@PathVariable String name)
    {
        List<BookInfo> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query="SELECT * FROM BOOKINFO WHERE isAvailable=?;";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                BookInfo book=new BookInfo();
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setBookName(rs.getString("bookName"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPublishedYear(rs.getInt("publishedYear"));
                book.setLanguage(rs.getString("language"));
                book.setNumberOfPages(rs.getInt("numberOfPages"));
                book.setRating(rs.getDouble("rating"));
                book.setAvailable(rs.getBoolean("isAvailable"));
                books.add(book);

            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
