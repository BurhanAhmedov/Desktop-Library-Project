package az.JDBC.library.dao;

import java.util.List;

import Model.Author;

public interface AuthorDao {

    List<Author> getAuthorList() throws Exception;

    void addAuthor(Author author) throws Exception;

    Author getAuthorById(Long authorId) throws Exception;

    void editAuthor(Author author) throws Exception;

    void deleteAuthor(Long authorId) throws Exception;

    List<Author> searchAuthor(String keyword) throws Exception;

}
