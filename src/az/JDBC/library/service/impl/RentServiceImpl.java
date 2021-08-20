/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.service.impl;

import Model.Rent;
import az.JDBC.library.dao.RentDao;
import az.JDBC.library.service.RentService;
import java.util.List;

/**
 *
 * @author burha
 */
public class RentServiceImpl implements RentService {

    private RentDao rentDao;

    public RentServiceImpl(RentDao rentDao) {
        this.rentDao = rentDao;
    }

    @Override
    public List<Rent> getRentList() throws Exception {
        return rentDao.getRentList();
    }

    @Override
    public void addRent(Rent rent) throws Exception {
        rentDao.addRent(rent);
    }

    @Override
    public Rent getRentById(Long rentId) throws Exception {
        return rentDao.getRentById(rentId);
    }

    @Override
    public void editRent(Rent rent) throws Exception {
        rentDao.editRent(rent);
    }

    @Override
    public void deleteRent(Long rentId) throws Exception {
        rentDao.deleteRent(rentId);
    }

    @Override
    public List<Rent> searchRent(String keyword) throws Exception {
        return rentDao.searchRent(keyword);
    }

}
