package az.JDBC.library.service;

import java.util.List;

import Model.Book;
import Model.Info;
import az.JDBC.library.dao.BookDao;

public interface BookService {

    List<Book> getBookList() throws Exception;

    void addBook(Book book) throws Exception;

    Book getBookById(Long bookId) throws Exception;

    void editBook(Book book) throws Exception;

    void deleteBook(Long BookId) throws Exception;

    List<Book> searchBook(String keyword) throws Exception;

    void saleBook(Integer count, Long selectedId,Float sale_price) throws Exception;

}
