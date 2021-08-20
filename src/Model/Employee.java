package Model;

import java.util.Date;

public class Employee extends LibraryModel {

    private String name;
    private String surname;
    private String position;
    private String telephone;
    private String e_mail;
    private String idendity_No;
    private Integer salary;
    private Date recruitment;
    private Date dismissal;
    private String gender;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getIdendity_No() {
        return idendity_No;
    }

    public void setIdendity_No(String idendity_No) {
        this.idendity_No = idendity_No;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Date recruitment) {
        this.recruitment = recruitment;
    }

    public Date getDismissal() {
        return dismissal;
    }

    public void setDismissal(Date dismissal) {
        this.dismissal = dismissal;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + position;
    }

}
