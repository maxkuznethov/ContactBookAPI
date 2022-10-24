package ru.mirea.contact_book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.contact_book.entities.Contact;
import ru.mirea.contact_book.services.ContactService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactRestController {
    @Autowired
    ContactService contactService;

    @GetMapping("/contact/get")
    public List<Contact> getAll() {
        return contactService.getAllContacts();
    }

    @DeleteMapping("contact/delete")
    public void deleteAll(){
        contactService.deleteAllContacts();
    }

    @PostMapping("/contact/create")
    public Contact createContact(@RequestBody @Valid Contact contact) {
       return contactService.createContact(contact);
    }

    @GetMapping("contact/get/{id}")
    public Contact getContact(@PathVariable Long id){
        return contactService.getContact(id);
    }

    @DeleteMapping("contact/delete/{id}")
    public void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }

    @PutMapping("/contact/update/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact ){
        return contactService.updateContact(id, contact);
    }
}
