package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "John", "555-1234");
        addContact(phoneBook, "Jane", "555-5678");
        addContact(phoneBook, "John", "555-7890");
        addContact(phoneBook, "Alice", "555-4321");
        addContact(phoneBook, "Alice", "777-4321");

        printPhoneBook(phoneBook);
    }

    public static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    public static void printPhoneBook(Map<String, List<String>> phoneBook) {
    
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
