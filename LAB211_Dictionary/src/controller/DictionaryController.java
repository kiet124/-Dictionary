/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DictionaryModel;

/**
 *
 * @author dotha
 */
public class DictionaryController {
    private final DictionaryModel model;

    public DictionaryController(DictionaryModel model) {
        this.model = model;
    }

   

    public void addWord(String eng, String vi) {
        model.addWord(eng, vi);
    }

    public void removeWord(String eng) {
        model.removeWord(eng);
    }

    public String translate(String eng) {
        return model.translate(eng);
    }
}