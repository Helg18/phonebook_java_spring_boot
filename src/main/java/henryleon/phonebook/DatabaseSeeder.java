package henryleon.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private ContactsRepository contactsRepository;

    @Autowired
    public DatabaseSeeder(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Henry", "Leon", "helg18@gmail.com", 584129876543L));
        contacts.add(new Contact("Alisson", "Leon", "al25@gmail.com", 972154602509L));
        contacts.add(new Contact("Doris", "Mora", "dm00@gmail.com", 803497305610L));
        contacts.add(new Contact("Barbara", "Liskov", "barbara@liskov.com", 803799607509L));
        contacts.add(new Contact("Ada", "Lovelace", "ada@lovelace.com", 975034894037L));

        contactsRepository.saveAll(contacts);
    }
}
