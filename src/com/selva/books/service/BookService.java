package com.selva.books.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.selva.books.dao.BookDAO;
import com.selva.books.model.Book;

@Path("/books")
public class BookService {
	 
    // URI:
    // /contextPath/servletPath/books
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Book> getBooks_JSON() {
        List<Book> listOfBooks = BookDAO.getAllBooks();
        return listOfBooks;
    }
 
    // URI:
    // /contextPath/servletPath/Books/{bookNo}
    @GET
    @Path("/{bookNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Book getBook(@PathParam("bookNo") String bookNo) {
        return BookDAO.getBook(bookNo);
    }
 
    // URI:
    // /contextPath/servletPath/Books
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Book addBook(Book book) throws SQLException {
        return BookDAO.addBook(book);
    }
 
    // URI:
    // /contextPath/servletPath/Books
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Book updateBook(Book book) throws SQLException {
        return BookDAO.updateBook(book);
    }
 
    @DELETE
    @Path("/{bookNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteBook(@PathParam("bookNo") String bookNo) throws NumberFormatException, SQLException {
        BookDAO.deleteBook(bookNo);
    }
 
}
