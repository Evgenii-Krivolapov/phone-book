package practice;

import java.util.*;

public class PhoneBook {
    public TreeMap<String, TreeSet<String>> phoneBook = new TreeMap<>();
    String regularPhone = "^[7]([0-9]+){10}";
    String regularName = "[А-Яа-яёЁ]+";

    public void addContact(String phone, String name) {
        if (phone.matches(regularPhone) && name.matches(regularName)) {
            TreeSet<String> list = phoneBook.get(name);
            if (phoneBook.containsKey(name)) {
                list.add(phone);
                phoneBook.put(name, list);
            } else if (String.valueOf(phoneBook.values()).contains(phone)) {
                for (Map.Entry<String, TreeSet<String>> entry : phoneBook.entrySet()) {
                    list = new TreeSet<>();
                    phoneBook.remove(entry.getKey());
                    list.add(phone);
                    phoneBook.put(name, list);
                }
            } else if (!phoneBook.containsKey(name) && !phoneBook.containsValue(phone)) {
                list = new TreeSet<>();
                list.add(phone);
                phoneBook.put(name, list);
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }

    public String getContactByPhone(String phone) {
        String valuePhone = "";
        for (Map.Entry<String, TreeSet<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                valuePhone = entry.getKey() + " - " +
                        String.valueOf(entry.getValue()).replaceAll("[\\[\\]]", "");

            }
        }
        return valuePhone;
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contactByName = new TreeSet<>();
        for (Map.Entry<String, TreeSet<String>> entry : phoneBook.entrySet()) {
            if (entry.getKey().contains(name)) {
                String contactsName = entry.getKey() + " - " +
                        String.valueOf(entry.getValue()).replaceAll("[\\[\\]]", "");
                contactByName.add(contactsName);

            }
        }
        return contactByName;
    }

    public Set<String> getAllContacts() {
        TreeSet<String> allContacts = new TreeSet<>();
        for (Map.Entry<String, TreeSet<String>> entry : phoneBook.entrySet()) {
            String contacts = entry.getKey() + " - " +
                    String.valueOf(entry.getValue()).replaceAll("[\\[\\]]", "");
            allContacts.add(contacts);
        }
        return allContacts;
    }
}