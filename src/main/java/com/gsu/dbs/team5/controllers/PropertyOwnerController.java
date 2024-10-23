package com.gsu.dbs.team5.controllers;

import com.gsu.dbs.team5.entities.PropertyOwner; // Adjust the package name based on your structure
import com.gsu.dbs.team5.services.PropertyOwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-owners")
public class PropertyOwnerController {

    private final PropertyOwnerService propertyOwnerService;

    public PropertyOwnerController(PropertyOwnerService propertyOwnerService) {
        this.propertyOwnerService = propertyOwnerService;
    }

    @GetMapping
    public List<PropertyOwner> getAllPropertyOwners() {
        return propertyOwnerService.getAllPropertyOwners();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyOwner> getPropertyOwnerById(@PathVariable Integer id) {
        return propertyOwnerService.getPropertyOwnerById(id)
                .map(propertyOwner -> ResponseEntity.ok(propertyOwner))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PropertyOwner> createPropertyOwner(@RequestBody PropertyOwner propertyOwner) {
        PropertyOwner savedPropertyOwner = propertyOwnerService.savePropertyOwner(propertyOwner);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPropertyOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropertyOwner(@PathVariable Integer id) {
        propertyOwnerService.deletePropertyOwner(id);
        return ResponseEntity.noContent().build();
    }
}
