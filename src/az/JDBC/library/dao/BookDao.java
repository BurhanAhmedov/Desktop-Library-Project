package az.JDBC.library.dao;

import java.util.List;

import Model.Book;
import Model.Info;

public interface BookDao {

    List<Book> getBookList() throws Exception;

    void addBook(Book book) throws Exception;

    Book getBookById(Long bookId) throws Exception;

    void deleteBook(Long BookId) throws Exception;

    void editBook(Book book) throws Exception;

    List<Book> searchBook(String keyword) throws Exception;

    void saleBook(Integer count, Long selectedId,Float sale_price) throws Exception;

}
