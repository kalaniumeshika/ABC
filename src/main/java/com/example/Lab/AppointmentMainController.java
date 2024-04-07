package com.example.Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class AppointmentMainController {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentMainController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping("/appointments")
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment) {
        try {
            // Save the appointment
            Appointment savedAppointment = appointmentRepository.save(appointment);

            // Generate a unique appointment number
            int appointmentNumber = savedAppointment.getId();

            // Return the appointment number to the user
            return ResponseEntity.ok("Appointment scheduled successfully. Your appointment number is: " + appointmentNumber);
        } catch (Exception e) {
            // If there is an error while saving the appointment, return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add appointment.");
        }
    }

    @GetMapping("/getappointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        try {
            // Fetch all appointments from the database
            List<Appointment> appointments = appointmentRepository.findAll();

            // Return the list of appointments as a response
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            // If there is an error while fetching appointments, return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
