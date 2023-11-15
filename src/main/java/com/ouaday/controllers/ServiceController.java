package com.ouaday.controllers;

import com.ouaday.entities.Service;
import com.ouaday.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("")
    public List<Service> getAllService(){
        return serviceService.findAll();
    }

    @GetMapping("/{id}")
    public Service getById(@PathVariable long id) {
        return serviceService.findById(id);
    }

    @PostMapping("")
    public Service creeService(@RequestBody Service service) {
        service.setId(0L);
        return serviceService.create(service);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateService(@PathVariable Long id, @RequestBody Service service) {

        if (service == null) {
            return new ResponseEntity<Object>("service avec ID " + id + " n exite pas", HttpStatus.BAD_REQUEST);
        } else {
            service.setId(id);
            serviceService.update(service);
            return ResponseEntity.ok("Update avec succes");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Service service = serviceService.findById(id);

        if (service == null) {
            return new ResponseEntity<Object>("Service avec ID " + id + " n exite pas", HttpStatus.BAD_REQUEST);
        } else {
            serviceService.delete(service);
            return ResponseEntity.ok(" Suppression avec succes ");

        }
    }
}
