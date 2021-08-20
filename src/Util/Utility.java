package Util;

import java.util.List;

import Model.Author;
import Model.Book;
import Model.Employee;
import Model.Genre;
import Model.User;

public class Utility {

    public static void getBookList(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println("id:" + book.getId() + " -- Name:" + book.getName() + " -- Page:" + book.getPage()
                    + " -- Purchase price:" + book.getPurchasePrice() + " -- Sale price:" + book.getSalePrice()
                    + " AZN");
        }

    }

    public static void getAuthorList(List<Author> authorList) {
        for (Author author : authorList) {
            System.out.println("id:" + author.getId() + " -- Full Name:" + author.getFullName());
        }
    }

    public static void getGenreList(List<Genre> genreList) {
        for (Genre genre : genreList) {
            System.out.println("id:" + genre.getId() + " -- Genre:" + genre.getName());
        }
    }

    public static void getEmployeeList(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println("id:" + employee.getId() + " -- Name:" + employee.getName() + " -- Surname:"
                    + employee.getSurname() + " -- Position:" + employee.getPosition() + " -- Salary:"
                    + employee.getSalary() + " -- Telephone:" + employee.getTelephone() + " -- Email:"
                    + employee.getE_mail() + " -- Identity No:" + employee.getIdendity_No() + " -- Recruitment:"
                    + employee.getRecruitment() + " -- Dismissal:" + employee.getDismissal());
        }
    }

    public static void getUserList(List<User> userList) {
        for (User user : userList) {
            System.out.println("id:" + user.getId() + " -- Name:" + user.getName() + " -- Surname:" + user.getSurname()
                    + " -- Gender:" + user.getGender() + " -- Identity No:" + user.getIdentity_No() + " -- Telephone:"
                    + user.getTelephone() + " -- E-mail:" + user.getE_mail());

        }

    }
}
