package az.JDBC.library.service.impl;

import java.util.List;

import Model.Book;
import Model.Info;
import az.JDBC.library.dao.BookDao;
import az.JDBC.library.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getBookList() throws Exception {

        return bookDao.getBookList();
    }

    @Override
    public void addBook(Book book) throws Exception {
        bookDao.addBook(book);
    }

    @Override
    public Book getBookById(Long bookId) throws Exception {
        return bookDao.getBookById(bookId);

    }

    @Override
    public void editBook(Book book) throws Exception {
        bookDao.editBook(book);
    }

    @Override
    public void deleteBook(Long BookId) throws Exception {
        bookDao.deleteBook(BookId);
    }

    @Override
    public List<Book> searchBook(String keyword) throws Exception {

        return bookDao.searchBook(keyword);
    }

    @Override
    public void saleBook(Integer count, Long selectedId,Float sale_price) throws Exception {
        bookDao.saleBook(count, selectedId,sale_price);
    }

}
