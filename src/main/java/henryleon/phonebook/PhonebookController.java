package henryleon.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/contacts")
public class PhonebookController {
    private ContactsRepository contactsRepository;

    @Autowired
    public PhonebookController(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List all() {
        return this.contactsRepository.findAll();
    }

    @RequestMapping(value = "/searchByNumber/{number}", method = RequestMethod.GET)
    public List getByNumber(@PathVariable Long number) {
        return this.contactsRepository.findAll().stream().filter(x -> x.getTelefono() == number).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByName/{name}", method = RequestMethod.GET)
    public List getByName(@PathVariable String name) {
        return this.contactsRepository.findAll().stream().filter(x -> x.getNombre().equals(name)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByLastName/{lastName}", method = RequestMethod.GET)
    public List getByLastName(@PathVariable String lastName) {
        return this.contactsRepository.findAll().stream().filter(x -> x.getApellido().equals(lastName)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/searchByEmail/{email}", method = RequestMethod.GET)
    public List getByEmail(@PathVariable String email) {
        return this.contactsRepository.findAll().stream().filter(x -> x.getEmail().equals(email)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List create(@RequestBody Contact newContact){
        this.contactsRepository.save(newContact);

        return this.contactsRepository.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public List update(@PathVariable Long id, @RequestBody Contact updateContact){
        contactsRepository.deleteById(id);
        contactsRepository.save(updateContact);

        return contactsRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List delete(@PathVariable Long id){
        contactsRepository.deleteById(id);
        return contactsRepository.findAll();
    }
}
