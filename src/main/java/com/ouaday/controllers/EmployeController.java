package com.ouaday.controllers;

import com.ouaday.entities.Employe;
import com.ouaday.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping("")
    public List<Employe> getAllEmploye(){
        return employeService.findAll();
    }

    @GetMapping("/{id}")
    public Employe getById(@PathVariable long id) {
        return employeService.findById(id);
    }

    @PostMapping("")
    public Employe creeEmploye(@RequestBody Employe employe) {
        employe.setId(0L);
        return employeService.create(employe);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {

        if (employe == null) {
            return new ResponseEntity<Object>("employe avec ID " + id + " n exite pas", HttpStatus.BAD_REQUEST);
        } else {
            employeService.update(employe);
            return ResponseEntity.ok("UPDATE AVEC SUCCEs");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Employe employe = employeService.findById(id);

        if (employe == null) {
            return new ResponseEntity<Object>("Employe avec ID " + id + " n exite pas", HttpStatus.BAD_REQUEST);
        } else {
            employeService.delete(employe);
            return ResponseEntity.ok(" Suppression avec succes ");

        }
    }
}
