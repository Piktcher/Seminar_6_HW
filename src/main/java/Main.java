import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {

//        Реализуйте структуру телефонной книги с помощью HashSet.
//        Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
//        их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

        HashSet<String> contacts = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\Обучение гик\\7. Java\\Seminar_6_HW\\Seminar_6_HW\\src\\main\\java\\Contacts.txt"))) {
            String line = reader.readLine();

            while (line != null) {
                contacts.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            System.out.println("Выберите желаемое действие для списка контактов, где:\n" +
                    "1 - Добавить контакт\n" +
                    "2 - Вывести список контактов\n" +
                    "3 - Закрыть программу\n");

            Scanner s = new Scanner(System.in);
            String action = s.next();

            if (action.equals("1")) {
                PhoneBookActions.addContact(contacts);
                continue;
            }
            if (action.equals("2")) {
                PhoneBookActions.printOut(contacts);
                continue;
            }
            if (action.equals("3")) PhoneBookActions.terminate(contacts);

            else System.out.println("Выберите действие из спискаn\n");
        }

    }
}
