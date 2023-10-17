/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DataAccess.FileDataAccess;
import model.Person;
import view.Main;
import Repository.PersonRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author dotha
 */
public class Manager {

    private static final PersonRepository personRepository = new PersonRepository();
    private static final FileDataAccess fileDataAccess = new FileDataAccess();

    public static int menu() {
        System.out.println("1. Find person info.");
        System.out.println("2. Copy Text to new file.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }

    public static void findPersonInfo() {
        ArrayList<Person> lp = new ArrayList<>();
        if (lp == null) {
            return;
        }
        String pathFile = Validation.checkInputPathFile();
        lp = getListPerson(pathFile);
        double money = Validation.checkInputMoney();
        printListPerson(lp, money);
    }

    public static void copyNewFile() {
        String pathFileInput = Validation.checkInputPathFile();
        String pathFileOutput = Validation.checkInputPathFile();
        String content = getNewContent(pathFileInput);
        System.out.println(content);
        writeNewContent(pathFileOutput, content);
    }

public static ArrayList<Person> getListPerson(String pathFile) {
    ArrayList<Person> lp = new ArrayList<>();
    File file = new File(pathFile);
    if (!file.exists() || !file.isFile()) {
        System.err.println("Path doesn't exist");
        return lp;
    }
    try {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferReader.readLine()) != null) {
            String[] infoPerson = line.split(";");
            if (infoPerson.length == 3) {
                String name = infoPerson[0];
                String address = infoPerson[1];
                double money = getSalary(infoPerson[2]);
                lp.add(new Person(name, address, money));
            } else {
                System.err.println("Invalid data: " + line);
            }
        }
    } catch (IOException e) {
        System.err.println("Can't read file.");
    }
    return lp;
}

    public static double getSalary(String salary) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        } finally {
            return salaryResult;
        }
    }

    public static void printListPerson(ArrayList<Person> lp, double money) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (Person person : lp) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(), person.getAddress(), person.getMoney());
            }
        }
        Collections.sort(lp);
        System.out.println("Max: " + lp.get(0).getName());
        System.out.println("Min: " + lp.get(lp.size() - 1).getName());
    }

    public static String getNewContent(String pathFileInput) {
        try {
            return fileDataAccess.readDataFromFile(pathFileInput);
        } catch (IOException e) {
            System.err.println("Can't read file");
            return "";
        }
    }

    public static void writeNewContent(String pathFileOutput, String content) {
        try {
            fileDataAccess.writeDataToFile(pathFileOutput, content);
            System.err.println("Write successful");
        } catch (IOException e) {
            System.err.println("Can’t write file");
        }
    }
}