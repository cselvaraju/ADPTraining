package com.selva.books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksJdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Welcome123");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from books");
		while (rs.next()) {
			System.out.println("================");
			System.out.println("ID: " + rs.getInt(1));
			System.out.println("Title: " + rs.getString(2));
			System.out.println("Author: " + rs.getString(3));
		}
		System.out.println("================");
		rs.close();
		stmt.close();
		con.close();
	}

}
