package com.gsu.dbs.team5.controllers;

import com.gsu.dbs.team5.entities.Unit;
import com.gsu.dbs.team5.entities.UnitId;
import com.gsu.dbs.team5.services.UnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/{unitId}/{propertyId}")
    public ResponseEntity<Unit> getUnitById(@PathVariable int unitId, @PathVariable int propertyId) {
        UnitId id = new UnitId(unitId, propertyId);
        return unitService.getUnitById(id)
                .map(unit -> ResponseEntity.ok(unit))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Unit> createUnit(@RequestBody Unit unit) {
        Unit savedUnit = unitService.saveUnit(unit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUnit);
    }

    @DeleteMapping("/{unitId}/{propertyId}")
    public ResponseEntity<Void> deleteUnit(@PathVariable int unitId, @PathVariable int propertyId) {
        UnitId id = new UnitId(unitId, propertyId);
        unitService.deleteUnit(id);
        return ResponseEntity.noContent().build();
    }
}
