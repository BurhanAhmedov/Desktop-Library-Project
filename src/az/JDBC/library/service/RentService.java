/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.service;

import java.util.List;
import Model.Rent;

/**
 *
 * @author burha
 */
public interface RentService {

    List<Rent> getRentList() throws Exception;

    void addRent(Rent rent) throws Exception;

    Rent getRentById(Long rentId) throws Exception;

    void editRent(Rent rent) throws Exception;

    void deleteRent(Long rentId) throws Exception;

    List<Rent> searchRent(String keyword) throws Exception;

}
