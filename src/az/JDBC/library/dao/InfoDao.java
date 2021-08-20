/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.dao;

import Model.Info;
import java.util.List;

/**
 *
 * @author burha
 */
public interface InfoDao {

    // List<Info> infoList() throws Exception;
    List<Info> getBookInfoById(Long bookId) throws Exception;

    List<Info> getAuthorInfoById(Long authorId) throws Exception;

    List<Info> getGenreInfoById(Long genreId) throws Exception;

    void addInfo(Info info) throws Exception;

    void editInfo(Info info) throws Exception;

    void deleteInfo(Long selectedId) throws Exception;

    Info getInfoById(Long selectedId) throws Exception;

}
