package az.JDBC.library.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Model.Author;
import Model.Book;
import Model.Employee;
import Model.Genre;
import Model.User;
import Util.Utility;
import az.JDBC.library.dao.AuthorDao;
import az.JDBC.library.dao.BookDao;
import az.JDBC.library.dao.EmployeeDao;
import az.JDBC.library.dao.GenreDao;
import az.JDBC.library.dao.RentDao;
import az.JDBC.library.dao.UserDao;
import az.JDBC.library.dao.impl.AuthorDaoImpl;
import az.JDBC.library.dao.impl.BookDaoImpl;
import az.JDBC.library.dao.impl.EmployeeDaoImpl;
import az.JDBC.library.dao.impl.GenreDaoImpl;
import az.JDBC.library.dao.impl.RentDaoImpl;
import az.JDBC.library.dao.impl.UserDaoImpl;
import az.JDBC.library.gui.LoginFrame;
import az.JDBC.library.gui.MainFrame;
import az.JDBC.library.service.AuthorService;
import az.JDBC.library.service.BookService;
import az.JDBC.library.service.EmployeeService;
import az.JDBC.library.service.GenreService;
import az.JDBC.library.service.RentService;
import az.JDBC.library.service.UserService;
import az.JDBC.library.service.impl.AuthorServiceImpl;
import az.JDBC.library.service.impl.BookServiceImpl;
import az.JDBC.library.service.impl.EmployeeServiceImpl;
import az.JDBC.library.service.impl.GenreServiceImpl;
import az.JDBC.library.service.impl.RentServiceImpl;
import az.JDBC.library.service.impl.UserServiceImpl;
import az.JDBC.library.dao.LoginDao;
import az.JDBC.library.dao.impl.LoginDaoImpl;
import az.JDBC.library.service.LoginService;
import az.JDBC.library.service.impl.LoginServiceImpl;

public class MainClass {

    public static void main(String[] args) {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

//            MainFrame mainFrame=new MainFrame(bookService,authorService,genreService,employeeService,userService,rentService);
//            mainFrame.setVisible(true);
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
