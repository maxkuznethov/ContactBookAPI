package ru.mirea.contact_book.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.contact_book.entities.Contact;
import ru.mirea.contact_book.exceptions.MyEntityNotFoundException;
import ru.mirea.contact_book.repositories.ContactRepository;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id));
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact updateContact(Long id, Contact contact) {
        Contact contactToUpdate = contactRepository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id));
        if (StringUtils.isNotBlank(contact.getName())) {
            contactToUpdate.setName(contact.getName());
        }
        if (StringUtils.isNotBlank(contact.getPhone())) {
            contactToUpdate.setPhone(contact.getPhone());
        }
        return contactRepository.save(contactToUpdate);
    }

    public void deleteContact(Long id) {
        contactRepository.delete(contactRepository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id)));
    }

    public void deleteAllContacts() {
        contactRepository.deleteAll();
    }

}
