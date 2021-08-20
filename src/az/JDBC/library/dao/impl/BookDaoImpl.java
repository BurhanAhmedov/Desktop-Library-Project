package az.JDBC.library.dao.impl;

import Model.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Book;
import Model.Genre;
import Model.Info;
import az.JDBC.library.dao.BookDao;
import az.JDBC.library.dao.DBHelper;

public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> getBookList() throws Exception {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT id,Name,Page,Purchase_price,Sale_price,Profit,Stock FROM library.book where active=1";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);) {

            if (connect != null) {

                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setName(rs.getString("Name"));
                    book.setPage(rs.getInt("Page"));
                    book.setSalePrice(rs.getFloat("Sale_price"));
                    book.setPurchasePrice(rs.getFloat("Purchase_price"));
                    book.setProfit(rs.getFloat("Profit"));
                    book.setStock(rs.getInt("Stock"));
                    bookList.add(book);

                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public void addBook(Book book) throws Exception {
        String sql = "insert into book(name,Sale_price,page,Purchase_price,Stock) values(?,?,?,?,?)";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, book.getName());
            ps.setFloat(2, book.getSalePrice());
            ps.setInt(3, book.getPage());
            ps.setFloat(4, book.getPurchasePrice());
            ps.setInt(5, book.getStock());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getBookById(Long bookId) throws Exception {
        Book book = new Book();
        String sql = "Select id,Name,Page,Sale_price,Purchase_price,Profit,Stock from book where active=1 and id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {

            ps.setLong(1, bookId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("Name"));
                book.setPage(rs.getInt("Page"));
                book.setSalePrice(rs.getFloat("Sale_price"));
                book.setPurchasePrice(rs.getFloat("Purchase_price"));
                book.setProfit(rs.getFloat("Profit"));
                book.setStock(rs.getInt("Stock"));
            } else {
                book = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void editBook(Book book) throws Exception {
        String sql = "update  book set Name=?,Purchase_price=?,Sale_price=?,Page=?,Profit=?,Stock=? where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            Float newSalePrice = book.getSalePrice()-(book.getSalePrice()*book.getDiscount()/100);
            ps.setString(1, book.getName());
            ps.setFloat(2, book.getPurchasePrice());
            ps.setFloat(3, book.getSalePrice());
            ps.setFloat(3, newSalePrice);
            ps.setInt(4, book.getPage());
            ps.setFloat(5, book.getProfit());
            ps.setInt(6, book.getStock());
            ps.setLong(7, book.getId());
            
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Long BookId) {
        String sql = "update  book set active=0 where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, BookId);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> searchBook(String keyword) throws Exception {
        List<Book> bookList = new ArrayList<>();
        String sql = "Select * from Book where (id like ? or name like ? or page like ? or purchase_price like ? or sale_price like ? or profit like ? or stock like ?) and active=1";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");
            ps.setString(6, "%" + keyword + "%");
            ps.setString(7, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setId(rs.getLong("id"));
                book.setPage(rs.getInt("page"));
                book.setPurchasePrice(rs.getFloat("purchase_price"));
                book.setSalePrice(rs.getFloat("sale_price"));
                book.setProfit(rs.getFloat("Profit"));
                book.setStock(rs.getInt("stock"));
                bookList.add(book);
            }
        }

        return bookList;
    }

    @Override
    public void saleBook(Integer count, Long selectedId,Float sale_price) throws Exception {
        String sql = "update book set Stock=Stock-?,Profit=Profit+? where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            Float profit=count*sale_price;
            ps.setInt(1, count);
            ps.setFloat(2, profit);
            ps.setLong(3, selectedId);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
