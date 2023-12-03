package homework.phonebook;


public interface PhoneBook {
    void addContact(String name, String phoneNumber);

    void findContact(String name);

    void deleteContact(String name);

    void saveContacts();

    void loadContacts();

    void printContacts();
}
