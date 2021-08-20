package az.JDBC.library.service;

import java.util.List;

import Model.Genre;

public interface GenreService {

    List<Genre> getGenreList() throws Exception;

    void addGenre(Genre genre) throws Exception;

    Genre getGenreById(Long genreId) throws Exception;

    void editGenre(Genre genre) throws Exception;

    void deleteGenre(Long genreId) throws Exception;

    List<Genre> searchGenre(String keyword) throws Exception;

}
