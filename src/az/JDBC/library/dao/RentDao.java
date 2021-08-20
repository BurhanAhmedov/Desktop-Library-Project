/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.dao;

import Model.Rent;
import java.util.List;

/**
 *
 * @author burha
 */
public interface RentDao {

    List<Rent> getRentList() throws Exception;

    void addRent(Rent rent) throws Exception;

    Rent getRentById(Long rentId) throws Exception;

    void editRent(Rent rent) throws Exception;

    void deleteRent(Long rentId) throws Exception;

    List<Rent> searchRent(String keyword) throws Exception;

}
