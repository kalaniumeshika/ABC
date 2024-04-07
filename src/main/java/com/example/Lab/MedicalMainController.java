package com.example.Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class MedicalMainController {

    private final MedicalRepository medicalRepository;

    @Autowired
    public MedicalMainController(MedicalRepository medicalRepository) {
        this.medicalRepository = medicalRepository;
    }

    @PostMapping("/medical")
    public ResponseEntity<Medical> addMedicalRecord(@RequestBody Medical medical) {
        // Save the medical record to the database
        Medical savedMedical = medicalRepository.save(medical);

        // Return the saved medical record along with HTTP status 201 (Created)
        return new ResponseEntity<>(savedMedical, HttpStatus.CREATED);
    }

    @GetMapping("/medical")
    public ResponseEntity<List<Medical>> getAllMedicalRecords() {
        // Retrieve all medical records from the database
        List<Medical> medicalRecords = medicalRepository.findAll();

        // Check if any records are found
        if (medicalRecords.isEmpty()) {
            // If no records are found, return HTTP status 404 (Not Found)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // If records are found, return them along with HTTP status 200 (OK)
            return new ResponseEntity<>(medicalRecords, HttpStatus.OK);
        }
    }

}

