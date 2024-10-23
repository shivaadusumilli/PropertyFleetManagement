package com.gsu.dbs.team5.controllers;

import com.gsu.dbs.team5.entities.Staff;
import com.gsu.dbs.team5.services.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable int id) {
        return staffService.getStaffById(id)
                .map(staff -> ResponseEntity.ok(staff))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff savedStaff = staffService.saveStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable int id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
