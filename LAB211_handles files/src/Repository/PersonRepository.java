/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.util.ArrayList;
import model.Person;
/**
 *
 * @author dotha
 */
public class PersonRepository {

    private ArrayList<Person> personList;

    public PersonRepository() {
        personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public ArrayList<Person> getAllPersons() {
        return personList;
    }
}