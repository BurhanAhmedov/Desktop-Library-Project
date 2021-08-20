package az.JDBC.library.dao;

import java.util.List;

import Model.Genre;

public interface GenreDao {

    List<Genre> getGenreList() throws Exception;

    void addGenre(Genre genre) throws Exception;

    Genre getGenreById(Long genreId) throws Exception;

    void editGenre(Genre genre) throws Exception;

    void deleteGenre(Long genreId) throws Exception;

    List<Genre> searchGenre(String keyword) throws Exception;

}
