package com.gsu.dbs.team5.services;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsu.dbs.team5.entities.Resident;
import com.gsu.dbs.team5.repositories.ResidentRepository;

@Service
public class ResidentService {
    @Autowired
    private ResidentRepository residentRepository;

    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    public Resident getResidentById(Integer id) throws RelationNotFoundException {
        return residentRepository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Resident not found with id : "+id));
    }

    public Resident createResident(Resident resident) {
        return residentRepository.save(resident);
    }

    public Resident updateResident(Integer id, Resident residentDetails) throws RelationNotFoundException {
        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Resident not found"));

        resident.setFirstName(residentDetails.getFirstName());
        resident.setLastName(residentDetails.getLastName());
        resident.setEmail(residentDetails.getEmail());
        resident.setPhone(residentDetails.getPhone());

        return residentRepository.save(resident);
    }

    public void deleteResident(Integer id) throws RelationNotFoundException {
        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Resident not found"));

        residentRepository.delete(resident);
    }
}
