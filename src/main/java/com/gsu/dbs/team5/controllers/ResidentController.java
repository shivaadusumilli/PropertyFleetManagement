package com.gsu.dbs.team5.controllers;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsu.dbs.team5.services.ResidentService;
import com.gsu.dbs.team5.entities.Resident;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {
    @Autowired
    private ResidentService residentService;

    @GetMapping
    public List<Resident> getAllResidents() {
        return residentService.getAllResidents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resident> getResidentById(@PathVariable Integer id) throws RelationNotFoundException {
        Resident resident = residentService.getResidentById(id);
        return ResponseEntity.ok(resident);
    }

    @PostMapping
    public ResponseEntity<Resident> createResident(@RequestBody Resident resident) {
        Resident savedResident = residentService.createResident(resident);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResident);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resident> updateResident(@PathVariable Integer id, @RequestBody Resident residentDetails) throws RelationNotFoundException {
        Resident updatedResident = residentService.updateResident(id, residentDetails);
        return ResponseEntity.ok(updatedResident);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResident(@PathVariable Integer id) throws RelationNotFoundException {
        residentService.deleteResident(id);
        return ResponseEntity.noContent().build();
    }
}
