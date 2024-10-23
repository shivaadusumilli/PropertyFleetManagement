package com.gsu.dbs.team5.services;

import com.gsu.dbs.team5.entities.Staff;
import com.gsu.dbs.team5.repositories.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(int staffId) {
        return staffRepository.findById(staffId);
    }

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public void deleteStaff(int staffId) {
        staffRepository.deleteById(staffId);
    }
}
