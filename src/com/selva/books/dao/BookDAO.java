package com.selva.books.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selva.books.model.Book;


public class BookDAO {
	private static final Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
	private static Connection con;
	List<Book> list;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Welcome123");
			initBooks();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void initBooks() throws SQLException {
		Book book;
	
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from books");
		while (rs.next()) {
			book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3));
			booksMap.put(book.getId(), book);
		}
	}

	public static Book getBook(String bookNo) {
		return booksMap.get(Integer.parseInt(bookNo));
	}

	public static Book addBook(Book book) throws SQLException {
		PreparedStatement pstmt = 
				con.prepareStatement("insert into books values(?, ?, ?)");
		pstmt.setInt(1, book.getId());
		pstmt.setString(2, book.getTitle());
		pstmt.setString(3, book.getAuthor());
		pstmt.executeQuery();
		booksMap.put(book.getId(), book);
		return book;
	}

	public static Book updateBook(Book book) throws SQLException {
		PreparedStatement pstmt = 
				con.prepareStatement("update books set title = ?, author = ? where id = ?");
		pstmt.setInt(3, book.getId());
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.executeQuery();
		booksMap.put(book.getId(), book);
		return book;
	}

	public static void deleteBook(String bookNo) throws NumberFormatException, SQLException {
		PreparedStatement pstmt = 
				con.prepareStatement("delete from books where id = ?");
		pstmt.setInt(1, Integer.parseInt(bookNo));
		pstmt.executeQuery();

		booksMap.remove(Integer.parseInt(bookNo));
	}

	public static List<Book> getAllBooks() {
		Collection<Book> c = booksMap.values();
		List<Book> list = new ArrayList<Book>();
		list.addAll(c);
		return list;
	}

}
