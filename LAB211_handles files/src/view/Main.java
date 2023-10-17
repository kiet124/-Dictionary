/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.Manager;
/**
 *
 * @author dotha
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.findPersonInfo();
                    break;
                case 2:
                    Manager.copyNewFile();
                    break;
                case 3:
                    return;
            }
        }
    }
}