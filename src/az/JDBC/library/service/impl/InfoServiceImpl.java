/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.service.impl;

import Model.Info;
import az.JDBC.library.dao.InfoDao;
import az.JDBC.library.service.InfoService;
import java.util.List;

/**
 *
 * @author burha
 */
public class InfoServiceImpl implements InfoService {

    private InfoDao infoDao;

    public InfoServiceImpl(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

//    @Override
//    public List<Info> infoList() throws Exception {
//        return infoDao.infoList();
//    }
    @Override
    public List<Info> getBookInfoById(Long infoId) throws Exception {
        return infoDao.getBookInfoById(infoId);
    }

    @Override
    public List<Info> getAuthorInfoById(Long authorId) throws Exception {
        return infoDao.getAuthorInfoById(authorId);
    }

    @Override
    public List<Info> getGenreInfoById(Long genreId) throws Exception {
        return infoDao.getGenreInfoById(genreId);
    }

    @Override
    public void addInfo(Info info) throws Exception {
        infoDao.addInfo(info);
    }

    @Override
    public void editInfo(Info info) throws Exception {
        infoDao.editInfo(info);
    }

    @Override
    public Info getInfoById(Long selectedId) throws Exception {
        return infoDao.getInfoById(selectedId);
    }

    @Override
    public void deleteInfo(Long selectedId) throws Exception {
        infoDao.deleteInfo(selectedId);
    }

}
