package com.example.asmpringboot.api;

import com.example.asmpringboot.entity.Street;
import com.example.asmpringboot.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetApi {
    @Autowired
    StreetService streetService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> findAll(){
        return ResponseEntity.ok(streetService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Street> street = streetService.findById(id);
        if (!street.isPresent()) {
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        return ResponseEntity.ok(street.get());//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> save(@RequestBody Street street){
        return ResponseEntity.ok(streetService.save(street));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Street> update(@PathVariable int id, @RequestBody Street updateStreet){
        Optional<Street> street = streetService.findById(id);//tim product theo id
        if (!street.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        Street exitsStreet = street.get();
        exitsStreet.setName(updateStreet.getName());
        exitsStreet.setDistrict(updateStreet.getDistrict());
        exitsStreet.setFounding(updateStreet.getFounding());
        exitsStreet.setDescription(updateStreet.getDescription());
        exitsStreet.setStatus(updateStreet.getStatus());
        return ResponseEntity.ok(streetService.save(exitsStreet));//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Street> street = streetService.findById(id);//tim product theo id
        if (!street.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        streetService.deleteById(id);
        return ResponseEntity.ok().build();//cos du lieu tra ve
    }
}
