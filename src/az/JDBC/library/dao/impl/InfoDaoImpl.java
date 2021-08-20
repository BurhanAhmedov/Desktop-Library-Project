/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.dao.impl;

import Model.Author;
import Model.Book;
import Model.Genre;
import Model.Info;
import az.JDBC.library.dao.DBHelper;
import az.JDBC.library.dao.InfoDao;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author burha
 */
public class InfoDaoImpl implements InfoDao {

    @Override
    public List<Info> getBookInfoById(Long bookId) throws Exception {
        List<Info> infoBook = new ArrayList<>();
        String sql = "select info.id as id,b.name as Book,b.page as Page,g.name as Genre,a.fullname as Author from book b inner join info on b.id=info.id_book inner join genre g on g.id=info.id_genre inner join author a on a.id=info.id_author where b.id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, bookId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("Book"));
                book.setPage(rs.getInt("Page"));
                Author author = new Author();
                author.setFullName(rs.getString("Author"));
                Genre genre = new Genre();
                genre.setName(rs.getString("Genre"));
                Info info = new Info();
                info.setId(rs.getLong("id"));
                info.setBook(book);
                info.setAuthor(author);
                info.setGenre(genre);
                infoBook.add(info);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return infoBook;
    }

    @Override
    public List<Info> getAuthorInfoById(Long authorId) throws Exception {
        List<Info> infoAuthor = new ArrayList<>();
        String sql = "select info.id as id, b.name as Book,b.page as Page,g.name as Genre,a.fullname as Author from book b inner join info on b.id=info.id_book inner join genre g on g.id=info.id_genre inner join author a on a.id=info.id_author where a.id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, authorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("Book"));
                book.setPage(rs.getInt("Page"));
                Author author = new Author();
                author.setFullName(rs.getString("Author"));
                Genre genre = new Genre();
                genre.setName(rs.getString("Genre"));
                Info info = new Info();
                info.setId(rs.getLong("id"));
                info.setBook(book);
                info.setAuthor(author);
                info.setGenre(genre);
                infoAuthor.add(info);
            }
        }
        return infoAuthor;

    }

    @Override
    public List<Info> getGenreInfoById(Long genreId) throws Exception {
        List<Info> infoGenre = new ArrayList<>();
        String sql = "select info.id as id,b.name as Book,b.page as Page,g.name as Genre,a.fullname as Author from book b inner join info on b.id=info.id_book inner join genre g on g.id=info.id_genre inner join author a on a.id=info.id_author where g.id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, genreId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("Book"));
                book.setPage(rs.getInt("Page"));
                Author author = new Author();
                author.setFullName(rs.getString("Author"));
                Genre genre = new Genre();
                genre.setName(rs.getString("Genre"));
                Info info = new Info();
                info.setId(rs.getLong("id"));
                info.setBook(book);
                info.setAuthor(author);
                info.setGenre(genre);
                infoGenre.add(info);
            }
        }
        return infoGenre;
    }

    @Override
    public void addInfo(Info info) throws Exception {
        String sql = "insert into info(id_book,id_genre,id_author) values (?,?,?)";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, info.getBook().getId());
            ps.setLong(2, info.getGenre().getId());
            ps.setLong(3, info.getAuthor().getId());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void editInfo(Info info) throws Exception {

        String sql = "update info set id_book=?,id_genre=?,id_author=? where info.id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, info.getBook().getId());
            ps.setLong(2, info.getGenre().getId());
            ps.setLong(3, info.getAuthor().getId());
            ps.setLong(4, info.getId());
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Info getInfoById(Long selectedId) throws Exception {
        Info info = new Info();
        String sql = "select  b.name as Book,b.page as Page,g.name as Genre,a.fullname as Author from book b inner join info on b.id=info.id_book inner join genre g on g.id=info.id_genre inner join author a on a.id=info.id_author where info.id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, selectedId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("Book"));
                book.setPage(rs.getInt("Page"));
                Author author = new Author();
                author.setFullName(rs.getString("Author"));
                Genre genre = new Genre();
                genre.setName(rs.getString("Genre"));

                info.setBook(book);
                info.setAuthor(author);
                info.setGenre(genre);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return info;

    }

    @Override
    public void deleteInfo(Long selectedId) throws Exception {
        String sql = "update info set active=0 where info.id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, selectedId);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
