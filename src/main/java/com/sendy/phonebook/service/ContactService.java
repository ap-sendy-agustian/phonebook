package com.sendy.phonebook.service;

import com.sendy.phonebook.entity.Contact;
import com.sendy.phonebook.entity.ContactDto;
import com.sendy.phonebook.entity.ContactRequestDto;
import com.sendy.phonebook.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    /**
     * API FindAll
     * Default = Return list of all contacts
     * If name and phoneNumber are provided, return list of contacts that match the name and phoneNumber (ignore case)
     * @param contactDto
     * @return List<Contact>
     */
    public List<Contact> findAll(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setPhoneNumber(contactDto.getPhoneNumber());


        Example<Contact> example = Example.of(contact, ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        );

        return contactRepository.findAll(example);
    }

    /**
     * API findById
     * find contact by id
     * If not found will throw NoSuchElementException
     * @param id
     * @return contact
     */
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Contact not found"));
    }

    /**
     * API saveContact
     * save contact based on contactRequestDto
     * @param contactRequestDto
     * @return contact
     */
    public Contact saveContact(ContactRequestDto contactRequestDto) {
        Contact contact = Contact.builder()
                .name(contactRequestDto.getName())
                .phoneNumber(contactRequestDto.getPhoneNumber())
                .build();

        return contactRepository.save(contact);
    }

    /**
     * API deleteContact
     * If not found will throw NoSuchElementException
     * delete by contact after found by id given from parameter
     * @param id
     * @return contact
     */
    public Contact deleteContact(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Contact not found"));
        contactRepository.delete(contact);
        return contact;
    }

    /**
     * API updateContact
     * update contact based on id and contactRequestDto
     * If not found will throw NoSuchElementException
     * @param id
     * @param contactRequestDto
     * @return contact
     */
    public Contact updateContact(Long id, ContactRequestDto contactRequestDto) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Contact not found"));
        contact.setName(contactRequestDto.getName());
        contact.setPhoneNumber(contactRequestDto.getPhoneNumber());
        return contactRepository.save(contact);
    }

}
