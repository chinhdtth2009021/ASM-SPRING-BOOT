package com.example.asmpringboot.api;

import com.example.asmpringboot.entity.Street;
import com.example.asmpringboot.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/street")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class StreetApi {
    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> getList() {
        return ResponseEntity.ok(streetService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> create(@RequestBody Street street) {
        return ResponseEntity.ok(streetService.save(street));
    }
}