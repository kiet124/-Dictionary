
import DataAccess.DictionaryDao;
import controller.DictionaryController;
import model.DictionaryModel;
import view.DictionaryView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dotha
 */
public class Main {
    public static void main(String[] args) {
        DictionaryDao dao = new DictionaryDao();
        DictionaryModel model = new DictionaryModel(dao);
        DictionaryController controller = new DictionaryController(model);
        DictionaryView view = new DictionaryView();

        while (true) {
            int choice = view.getMenuChoice();

            switch (choice) {
                case 1:
                    String eng = view.getEnglishWord();
                    String vi = view.getVietnameseTranslation();
                    controller.addWord(eng, vi);
                    break;
                case 2:
                    String wordToDelete = view.getEnglishWord();
                    controller.removeWord(wordToDelete);
                    break;
                case 3:
                    String wordToTranslate = view.getEnglishWord();
                    String translation = controller.translate(wordToTranslate);
                    view.displayTranslation(translation);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
