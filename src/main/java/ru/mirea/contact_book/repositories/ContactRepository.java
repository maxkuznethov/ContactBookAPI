package ru.mirea.contact_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.contact_book.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
