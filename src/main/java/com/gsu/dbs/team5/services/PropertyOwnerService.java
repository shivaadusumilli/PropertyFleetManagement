package com.gsu.dbs.team5.services;

import com.gsu.dbs.team5.entities.PropertyOwner; // Adjust the package name based on your structure
import com.gsu.dbs.team5.repositories.PropertyOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyOwnerService {

    private final PropertyOwnerRepository propertyOwnerRepository;

    public PropertyOwnerService(PropertyOwnerRepository propertyOwnerRepository) {
        this.propertyOwnerRepository = propertyOwnerRepository;
    }

    public List<PropertyOwner> getAllPropertyOwners() {
        return propertyOwnerRepository.findAll();
    }

    public Optional<PropertyOwner> getPropertyOwnerById(Integer id) {
        return propertyOwnerRepository.findById(id);
    }

    public PropertyOwner savePropertyOwner(PropertyOwner propertyOwner) {
        return propertyOwnerRepository.save(propertyOwner);
    }

    public void deletePropertyOwner(Integer id) {
        propertyOwnerRepository.deleteById(id);
    }
}
