/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.DictionaryDao;

/**
 *
 * @author dotha
 */
public class DictionaryRepository {
    private DictionaryDao dao;

    public DictionaryRepository(DictionaryDao dao) {
        this.dao = dao;
    }

    public boolean addWord(String eng, String vi) {
        return dao.addWord(eng, vi);
    }

    public boolean removeWord(String eng) {
        return dao.removeWord(eng);
    }

    public String translate(String eng) {
        return dao.translate(eng);
    }
}