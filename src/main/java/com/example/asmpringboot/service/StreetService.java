package com.example.asmpringboot.service;

import com.example.asmpringboot.entity.Street;
import com.example.asmpringboot.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    StreetRepository streetRepository;

    public Street save(Street street) {
        return streetRepository.save(street);
    }

    public List<Street> findAll() {
        return streetRepository.findAll();
    }

    public Optional<Street> findById(int id) {
        return streetRepository.findById(id);
    }
    public void deleteById(int id) {
        streetRepository.deleteById(id);
    }
}
