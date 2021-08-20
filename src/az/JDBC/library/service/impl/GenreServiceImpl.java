package az.JDBC.library.service.impl;

import java.util.List;

import Model.Genre;
import az.JDBC.library.dao.GenreDao;
import az.JDBC.library.service.GenreService;

public class GenreServiceImpl implements GenreService {

    private GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getGenreList() throws Exception {

        return genreDao.getGenreList();
    }

    @Override
    public void addGenre(Genre genre) throws Exception {
        genreDao.addGenre(genre);
    }

    @Override
    public Genre getGenreById(Long genreId) throws Exception {
        return genreDao.getGenreById(genreId);
    }

    @Override
    public void editGenre(Genre genre) throws Exception {
        genreDao.editGenre(genre);
    }

    @Override
    public void deleteGenre(Long genreId) throws Exception {
        genreDao.deleteGenre(genreId);
    }

    @Override
    public List<Genre> searchGenre(String keyword) throws Exception {
        return genreDao.searchGenre(keyword);
    }

}
