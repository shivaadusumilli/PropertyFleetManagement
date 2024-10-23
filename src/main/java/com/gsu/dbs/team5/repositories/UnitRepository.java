package com.gsu.dbs.team5.repositories;

import com.gsu.dbs.team5.entities.Unit;
import com.gsu.dbs.team5.entities.UnitId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, UnitId> {
    // Custom query methods can be added here if needed
}
