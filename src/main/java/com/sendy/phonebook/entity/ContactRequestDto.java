package com.sendy.phonebook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequestDto {
    private String phoneNumber;
    private String name;
}
