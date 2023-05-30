package com.example.shelterbot.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
public class DogsShelter extends Shelter {
    public DogsShelter(Long id, String name, int age, List<Pet> pet) {
        super(id, name, age, pet);
    }
}
