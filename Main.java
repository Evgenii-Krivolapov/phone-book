package practice;

import java.util.Scanner;

public class Main {

    static PhoneBook Book = new PhoneBook();

    public static void main(String[] args) {
        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            String phone = "";
            String name = "";
            String[] stringSplit = input.split(" ");
            if (!stringSplit[0].matches(Book.regularName) && !stringSplit[0].matches(Book.regularPhone) &&
                    !stringSplit[0].equals("LIST")) {
                System.out.println("Неверный формат ввода");
                continue;
            }
            if (stringSplit[0].matches(Book.regularPhone)) {
                phone += stringSplit[0];
                System.out.println("Такого номера в телефонной книге нет.");
                System.out.println("Введите имя телефона для абонента " + phone);
                String nameInput = scanner.nextLine();
                String[] commandName = nameInput.split(" ");
                if (commandName[0].matches(Book.regularName)) {
                    name += commandName[0];
                    Book.addContact(phone, name);
                    System.out.println("Контакт сохранен!");
                }
            }
            if (stringSplit[0].matches(Book.regularName)) {
                name += stringSplit[0];
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента " + name);
                String phoneInput = scanner.nextLine();
                String[] commandPhone = phoneInput.split(" ");
                if (commandPhone[0].matches(Book.regularPhone)) {
                    phone += commandPhone[0];
                    Book.addContact(phone, name);
                    System.out.println("Контакт сохранен!");
                }
            }
            if (stringSplit[0].equals("LIST")) {
                for (String list : Book.getAllContacts()) {
                    System.out.println(list);
                }
            }
        }
    }
}