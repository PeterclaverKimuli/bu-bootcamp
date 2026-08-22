package Module3;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactManager {
    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();

        // add contacts here
        contacts.put("Kimuli Peter", new Contact("Kimuli Peter", "+1 617 202 8397"));
        contacts.put("Contact Two", new Contact("Contact Two", "+1 617 202 8320"));
        contacts.put("Contact Three", new Contact("Contact Three", "+1 617 202 8300"));
        contacts.put("Contact Four", new Contact("Contact Four", "+1 617 202 8411"));
        contacts.put("Contact Five", new Contact("Contact Five", "+1 617 202 6720"));

        // look up a contact
        Contact contact = contacts.get("Kimuli Peter");

        if (contact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(contact.toString());
        }

        System.out.println("");

        // print sorted list
        sortAndPrintContacts(contacts);
        System.out.println("");

        // remove contact and print again
        removeContact("Contact T", contacts);
        System.out.println("");
        sortAndPrintContacts(contacts);
    }

    public static void sortAndPrintContacts(HashMap<String, Contact> contacts) {
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact con : sorted) {
            System.out.println(con.toString());
        }
    }

    public static void removeContact(String name, HashMap<String, Contact> contacts) {
        Contact contact = contacts.get(name);

        if (contact != null) {
            contacts.remove(name);
            System.out.println("Contact: " + name + " removed successfully!");
        } else {
            System.out.println("Contact: " + name + " does not exist!");
        }
    }
}
