package henryleon.phonebook;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/contacts")
public class PhonebookController {
    public List<Contact> contacts;

    public PhonebookController() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Henry", "Leon", "helg18@gmail.com", 584121234567L));
        contacts.add(new Contact("Alisson", "Leon", "aclm@gmail.com", 584241212121L));
        contacts.add(new Contact("Doris", "Mora", "dmmq@gmail.com", 584261478520L));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List all() {
        return contacts;
    }

    @RequestMapping(value = "/searchByNumber/{number}", method = RequestMethod.GET)
    public List getByNumber(@PathVariable Long number) {
        return contacts.stream().filter(x -> x.getTelefono() == number).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByName/{name}", method = RequestMethod.GET)
    public List getByName(@PathVariable String name) {
        return contacts.stream().filter(x -> x.getNombre().equals(name)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByLastName/{lastName}", method = RequestMethod.GET)
    public List getByLastName(@PathVariable String lastName) {
        return contacts.stream().filter(x -> x.getApellido().equals(lastName)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByEmail/{email}", method = RequestMethod.GET)
    public List getByEmail(@PathVariable String email) {
        return contacts.stream().filter(x -> x.getEmail().equals(email)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List create(@RequestBody Contact newContact){
        contacts.add(newContact);
        return contacts;
    }
}
