package com.gsu.dbs.team5.repositories;

import com.gsu.dbs.team5.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    // Custom query methods can be added here if needed
}
