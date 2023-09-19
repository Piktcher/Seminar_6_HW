import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class PhoneBookActions {

    public static void addContact(HashSet<String> phonebook) {

        System.out.println("Введите ФИО контакта");
        Scanner n = new Scanner(System.in);
        String name = n.next();

        System.out.println("Введите телефон контакта");
        Scanner p = new Scanner(System.in);
        String phone = n.next();

        boolean flag = false;
        while (!flag) {
            if (phonebook.toString().contains(name)) {
                System.out.println("Такой человек уже добавлен, введите дополнительную информацию для контакта:");
                Scanner extra = new Scanner(System.in);
                String info = extra.next();
                name += " (" + info + ")";
            }
            else {
                phonebook.add(name + " " + phone);
                System.out.println("Новый контакт успешно добавлен!\n");
                flag = true;
            }
        }

    }

    public static void printOut(HashSet<String> phonebook) {

        ArrayList<String> temp = new ArrayList<>(phonebook);
        temp.sort(Comparator.naturalOrder());

        for (String i: temp) {
            System.out.println(i);
        }
    }

    public static void terminate(HashSet<String> phonebook) throws IOException {
        System.out.println("До свидания!");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\Обучение гик\\7. Java\\Seminar_6_HW\\Seminar_6_HW\\src\\main\\java\\Contacts.txt"));
            for (String i: phonebook.stream().toList()) {
                writer.write(i + "\n");
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        exit(0);

    }

}
