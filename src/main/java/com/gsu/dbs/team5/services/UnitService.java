package com.gsu.dbs.team5.services;

import com.gsu.dbs.team5.entities.Unit;
import com.gsu.dbs.team5.entities.UnitId;
import com.gsu.dbs.team5.repositories.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Optional<Unit> getUnitById(UnitId unitId) {
        return unitRepository.findById(unitId);
    }

    public Unit saveUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    public void deleteUnit(UnitId unitId) {
        unitRepository.deleteById(unitId);
    }
}
