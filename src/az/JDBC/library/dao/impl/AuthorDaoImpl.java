package az.JDBC.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.print.DocFlavor.READER;

import Model.Author;
import az.JDBC.library.dao.AuthorDao;
import az.JDBC.library.dao.DBHelper;

public class AuthorDaoImpl implements AuthorDao {

    @Override
    public List<Author> getAuthorList() throws Exception {
        List<Author> authorList = new ArrayList<>();
        String sql = "SELECT id,fullName FROM library.author where active=1";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);) {
            if (connect != null) {
                while (rs.next()) {
                    Author author = new Author();

                    author.setId(rs.getLong("id"));
                    author.setFullName(rs.getString("fullName"));

                    authorList.add(author);

                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return authorList;
    }

    @Override
    public void addAuthor(Author author) throws Exception {
        String sql = "insert into author(fullName) values(?)";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, author.getFullName());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Author getAuthorById(Long authorId) throws Exception {
        Author author = new Author();
        String sql = "Select id,FullName from author where active=1 and id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, authorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                author.setFullName(rs.getString("FullName"));
            } else {
                author = null;
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
        return author;
    }

    @Override
    public void editAuthor(Author author) throws Exception {
        String sql = "update author set Fullname=? where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, author.getFullName());
            ps.setLong(2, author.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(Long authorId) throws Exception {
        String sql = "update author set active=0 where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, authorId);
            ps.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Author> searchAuthor(String keyword) throws Exception {
        List<Author> authorList = new ArrayList<>();
        String sql = "Select * from Author where id like ? or Fullname like ? and active=1";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong("id"));
                author.setFullName(rs.getString("Fullname"));
                authorList.add(author);
            }
        }
        return authorList;
    }

}
