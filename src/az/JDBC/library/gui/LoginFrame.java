/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.gui;

import Model.Login;
import az.JDBC.library.dao.AuthorDao;
import az.JDBC.library.dao.BookDao;
import az.JDBC.library.dao.EmployeeDao;
import az.JDBC.library.dao.GenreDao;
import az.JDBC.library.dao.InfoDao;
import az.JDBC.library.dao.LoginDao;
import az.JDBC.library.dao.RentDao;
import az.JDBC.library.dao.UserDao;
import az.JDBC.library.dao.impl.AuthorDaoImpl;
import az.JDBC.library.dao.impl.BookDaoImpl;
import az.JDBC.library.dao.impl.EmployeeDaoImpl;
import az.JDBC.library.dao.impl.GenreDaoImpl;
import az.JDBC.library.dao.impl.InfoDaoImpl;
import az.JDBC.library.dao.impl.LoginDaoImpl;
import az.JDBC.library.dao.impl.RentDaoImpl;
import az.JDBC.library.dao.impl.UserDaoImpl;
import az.JDBC.library.service.AuthorService;
import az.JDBC.library.service.BookService;
import az.JDBC.library.service.EmployeeService;
import az.JDBC.library.service.GenreService;
import az.JDBC.library.service.InfoService;
import az.JDBC.library.service.LoginService;
import az.JDBC.library.service.RentService;
import az.JDBC.library.service.UserService;
import az.JDBC.library.service.impl.AuthorServiceImpl;
import az.JDBC.library.service.impl.BookServiceImpl;
import az.JDBC.library.service.impl.EmployeeServiceImpl;
import az.JDBC.library.service.impl.GenreServiceImpl;
import az.JDBC.library.service.impl.InfoServiceImpl;
import az.JDBC.library.service.impl.LoginServiceImpl;
import az.JDBC.library.service.impl.RentServiceImpl;
import az.JDBC.library.service.impl.UserServiceImpl;

/**
 *
 * @author burha
 */
public class LoginFrame extends javax.swing.JFrame {

    BookDao bookDao = new BookDaoImpl();
    BookService bookService = new BookServiceImpl(bookDao);
    AuthorDao authorDao = new AuthorDaoImpl();
    AuthorService authorService = new AuthorServiceImpl(authorDao);
    GenreDao genreDao = new GenreDaoImpl();
    GenreService genreService = new GenreServiceImpl(genreDao);
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl(userDao);
    RentDao rentDao = new RentDaoImpl();
    RentService rentService = new RentServiceImpl(rentDao);
    LoginDao loginDao = new LoginDaoImpl();
    LoginService loginService = new LoginServiceImpl(loginDao);
    InfoDao infoDao = new InfoDaoImpl();
    InfoService infoService = new InfoServiceImpl(infoDao);

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        incorrectTxt.setVisible(false);
        showbtn.setVisible(true);
        hidebtn.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        incorrectTxt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        usernameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        signupBtn = new javax.swing.JButton();
        showbtn = new javax.swing.JButton();
        hidebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 150));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 148, 20));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon("C:\\Users\\burha\\OneDrive\\İş masası\\Java\\B-Library\\Logos,Photos\\lib.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 80));

        jPanel2.setBackground(new java.awt.Color(11, 1, 39));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginBtn.setBackground(new java.awt.Color(51, 153, 255));
        loginBtn.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel2.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 92, 37));

        clearBtn.setBackground(new java.awt.Color(255, 51, 51));
        clearBtn.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 88, 37));

        incorrectTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        incorrectTxt.setForeground(new java.awt.Color(204, 0, 0));
        incorrectTxt.setText("Error Message");
        jPanel2.add(incorrectTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 182, 256, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Username");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 95, -1, -1));
        jPanel2.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 141, 210, 30));
        jPanel2.add(usernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 93, 210, 30));

        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Password");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 143, -1, -1));

        signupBtn.setBackground(new java.awt.Color(204, 255, 255));
        signupBtn.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        signupBtn.setText("Sign Up");
        signupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBtnActionPerformed(evt);
            }
        });
        jPanel2.add(signupBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        showbtn.setBackground(new java.awt.Color(11, 1, 39));
        showbtn.setForeground(new java.awt.Color(11, 1, 39));
        showbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\burha\\OneDrive\\İş masası\\Java\\B-Library\\show.png")); // NOI18N
        showbtn.setFocusable(false);
        showbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        showbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showbtnActionPerformed(evt);
            }
        });
        jPanel2.add(showbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 30, 30));

        hidebtn.setBackground(new java.awt.Color(11, 1, 39));
        hidebtn.setForeground(new java.awt.Color(11, 1, 39));
        hidebtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\burha\\OneDrive\\İş masası\\Java\\B-Library\\hidden.png")); // NOI18N
        hidebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hidebtnActionPerformed(evt);
            }
        });
        jPanel2.add(hidebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 30, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 82, 440, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hidebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidebtnActionPerformed
        showbtn.setVisible(true);
        hidebtn.setVisible(false);
        passwordTxt.setEchoChar('*');
    }//GEN-LAST:event_hidebtnActionPerformed

    private void showbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showbtnActionPerformed
        showbtn.setVisible(false);
        hidebtn.setVisible(true);
        passwordTxt.setEchoChar((char)0);

    }//GEN-LAST:event_showbtnActionPerformed

    private void signupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBtnActionPerformed
        SignUpFrame signUpFrame = new SignUpFrame();
        signUpFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        usernameTxt.setText("");
        passwordTxt.setText("");

    }//GEN-LAST:event_clearBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            try {
                Login login = loginService.login(username, password);
                if (login != null) {
                    MainFrame mainFrame = new MainFrame(bookService, authorService, genreService, employeeService, userService, rentService, infoService);
                    mainFrame.setVisible(true);
                    this.dispose();
                } else {
                    incorrectTxt.setText("Username or Password is incorrect");
                    incorrectTxt.setVisible(true);
                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        } else {
            incorrectTxt.setText("Username or Password is empty");
            incorrectTxt.setVisible(true);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton hidebtn;
    private javax.swing.JLabel incorrectTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton showbtn;
    private javax.swing.JButton signupBtn;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
