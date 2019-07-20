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
        contacts.add(new Contact("Henry", "Leon", "helg18@gmail.com", 584121234567L));
        contacts.add(new Contact("Alisson", "Leon", "aclm@gmail.com", 584241212121L));
        contacts.add(new Contact("Doris", "Mora", "dmmq@gmail.com", 584261478520L));
        contacts.add(new Contact("Barbara", "Liskov", "bbll.solid@gmail.com", 582617894561L));

        contactsRepository.saveAll(contacts);
    }
}
