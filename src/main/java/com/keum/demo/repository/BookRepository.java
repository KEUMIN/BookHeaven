package com.keum.demo.repository;

import com.keum.demo.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static int sequence = 10; //static 사용

    private static BookRepository bookRepository = new BookRepository();

    public static BookRepository getBookRepository() {
        return bookRepository;
    }

    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";

    // 드라이버 등록 => 한번만 수행 (생성자)
    public BookRepository() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception ex) { }
    }
    public void getConnection() {
        try {
            connection = DriverManager.getConnection(URL, "hr", "01040962435");
        } catch(Exception ex) { }
    }
    // 오라클 종료
    public void disConnection() {
        try {
            if(preparedStatement!=null) preparedStatement.close();
            if(connection!=null) connection.close();
        } catch(Exception ex) { }
    }
    public Book save(Book book) {
        getConnection();
        book.setBookid(++sequence);
        String insertQuery = "insert into book values (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, book.getBookid());
            preparedStatement.setString(2, book.getBookname());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setInt(4, book.getPrice());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disConnection();
        }
        return book;
    }
    public Book findById(int id) {
        Book findBook = new Book();
        try {
            getConnection();
            preparedStatement = connection.prepareStatement("select * from book where bookid = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                findBook.setBookid(resultSet.getInt(1));
                findBook.setBookname(resultSet.getString(2));
                findBook.setPublisher(resultSet.getString(3));
                findBook.setPrice(resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disConnection();
        }
        return findBook;
    }
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            getConnection();
            preparedStatement = connection.prepareStatement("select * from book order by bookid");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookid(resultSet.getInt(1));
                book.setBookname(resultSet.getString(2));
                book.setPublisher(resultSet.getString(3));
                book.setPrice(resultSet.getInt(4));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disConnection();
        }
        return books;
    }
}
