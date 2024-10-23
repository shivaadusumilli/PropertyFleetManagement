package com.gsu.dbs.team5.repositories;

import com.gsu.dbs.team5.entities.PropertyOwner; // Adjust the package name based on your structure
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Integer> {
    // Additional custom query methods can be defined here if needed
}
