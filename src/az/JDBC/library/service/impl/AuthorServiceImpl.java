package az.JDBC.library.service.impl;

import java.util.List;

import Model.Author;
import az.JDBC.library.dao.AuthorDao;
import az.JDBC.library.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> getAuthorList() throws Exception {
        // TODO Auto-generated method stub
        return authorDao.getAuthorList();
    }

    @Override
    public void addAuthor(Author author) throws Exception {
        authorDao.addAuthor(author);
    }

    @Override
    public Author getAuthorById(Long authorId) throws Exception {

        return authorDao.getAuthorById(authorId);
    }

    @Override
    public void editAuthor(Author author) throws Exception {
        authorDao.editAuthor(author);
    }

    @Override
    public void deleteAuthor(Long authorId) throws Exception {
        authorDao.deleteAuthor(authorId);
    }

    @Override
    public List<Author> searchAuthor(String keyword) throws Exception {
        // TODO Auto-generated method stub
        return authorDao.searchAuthor(keyword);
    }

}
