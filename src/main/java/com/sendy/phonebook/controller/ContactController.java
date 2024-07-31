package com.sendy.phonebook.controller;

import com.sendy.phonebook.entity.Contact;
import com.sendy.phonebook.entity.ContactDto;
import com.sendy.phonebook.entity.ContactRequestDto;
import com.sendy.phonebook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact-service")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public List<Contact> getContacts(ContactDto contactDto) {
        return contactService.findAll(contactDto);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable(value = "id") Long id) {
        return contactService.findById(id);
    }

    @PostMapping
    public Contact saveContact(@RequestBody ContactRequestDto contactRequestDto) {
        return contactService.saveContact(contactRequestDto);
    }

    @DeleteMapping("/{id}")
    public Contact deleteContact(@PathVariable(value = "id") Long id) {
        return contactService.deleteContact(id);
    }

    @PatchMapping("/{id}")
    public Contact updateContact(@PathVariable(value = "id") Long id, @RequestBody ContactRequestDto contactRequestDto) {
        return contactService.updateContact(id, contactRequestDto);
    }
}
