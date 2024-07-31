package com.sendy.phonebook.entity;

import lombok.Data;

@Data
public class ContactDto {
    private Long id;
    private String phoneNumber;
    private String name;
}
