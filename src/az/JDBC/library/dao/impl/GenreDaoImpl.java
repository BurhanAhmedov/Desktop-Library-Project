package az.JDBC.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import Model.Genre;
import az.JDBC.library.dao.DBHelper;
import az.JDBC.library.dao.GenreDao;

public class GenreDaoImpl implements GenreDao {

    @Override
    public List<Genre> getGenreList() throws Exception {
        List<Genre> genreList = new ArrayList<>();
        String sql = "SELECT id,name FROM library.genre where active=1";

        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);) {
            if (connect != null) {
                while (rs.next()) {
                    Genre genre = new Genre();
                    genre.setId(rs.getLong("id"));
                    genre.setName(rs.getString("name"));

                    genreList.add(genre);
                }
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return genreList;
    }

    @Override
    public void addGenre(Genre genre) throws Exception {
        String sql = "insert into genre(name)values(?)";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, genre.getName());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Genre getGenreById(Long genreId) throws Exception {
        Genre genre = new Genre();
        String sql = "Select id,name from genre where active=1 and id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, genreId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                genre.setId(rs.getLong("id"));
                genre.setName(rs.getString("name"));

            } else {
                genre = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genre;
    }

    @Override
    public void editGenre(Genre genre) throws Exception {
        String sql = "update genre set name=?  where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, genre.getName());
            ps.setLong(2, genre.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteGenre(Long genreId) throws Exception {
        String sql = "update genre set active=0  where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, genreId);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Genre> searchGenre(String keyword) throws Exception {
        List<Genre> genreList = new ArrayList<>();
        String sql = "Select * from Genre where (id like ? or name like ?) and active=1";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getLong("id"));
                genre.setName(rs.getString("name"));
                genreList.add(genre);

            }

        }
        return genreList;
    }

}
