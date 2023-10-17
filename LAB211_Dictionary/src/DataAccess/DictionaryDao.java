/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;



/**
 *
 * @author dotha
 */

public class DictionaryDao {
    private HashMap<String, String> dictionary = new HashMap<>();
    private final String databaseFile = "dictionary.ser";

    public DictionaryDao() {
        loadData();
    }

    public boolean addWord(String eng, String vi) {
        // Add word logic here
        if (dictionary.containsKey(eng)) {
            return false;
        }
        dictionary.put(eng, vi);
        updateDatabase();
        return true;
    }

    public boolean removeWord(String eng) {
        // Remove word logic here
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            updateDatabase();
            return true;
        } else {
            return false;
        }
    }

    public String translate(String eng) {
        // Translation logic here
        return dictionary.getOrDefault(eng, "Translation not found.");
    }

    private void updateDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(databaseFile))) {
            oos.writeObject(dictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(databaseFile))) {
            dictionary = (HashMap<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            dictionary = new HashMap<>();
        }
    }
}