/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DataAccess.DictionaryDao;

/**
 *
 * @author dotha
 */
public class DictionaryModel {
    private final DictionaryDao dao;

    public DictionaryModel(DictionaryDao dao) {
        this.dao = dao;
    }

    public void addWord(String eng, String vi) {
        dao.addWord(eng, vi);
    }

    public void removeWord(String eng) {
        dao.removeWord(eng);
    }

    public String translate(String eng) {
        return dao.translate(eng);
    }
}
