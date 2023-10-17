/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author dotha
 */
public class DictionaryView {
    public int getMenuChoice() {
        System.out.println("Simple English - Vietnamese Dictionary");
        System.out.println("1. Add word");
        System.out.println("2. Delete word");
        System.out.println("3. Search word");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getEnglishWord() {
        System.out.print("Enter English word: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getVietnameseTranslation() {
        System.out.print("Enter Vietnamese translation: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayTranslation(String translation) {
        System.out.println("Vietnamese translation: " + translation);
    }
}
