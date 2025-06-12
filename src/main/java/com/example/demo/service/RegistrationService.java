package com.example.demo.service;

import com.example.demo.entities.Registration;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(Long id) {
        Optional<Registration> registration = registrationRepository.findById(id);
        return registration.orElse(null);
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration updateRegistration(Long id, Registration registration) {
        Optional<Registration> existingRegistration = registrationRepository.findById(id);
        if (existingRegistration.isEmpty()) return null;
        Registration r = existingRegistration.get();
        r.setStudent(registration.getStudent());
        r.setStaff(registration.getStaff());
        r.setParent(registration.getParent());
        r.setGradeLevel(registration.getGradeLevel());
        return registrationRepository.save(r);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public List<Registration> findByStudentId(Long studentId) {
        return registrationRepository.findByStudentId(studentId);
    }

    public List<Registration> findByParentId(Long parentId) {
        return registrationRepository.findByParentId(parentId);
    }

    public List<Registration> findByStaffId(Long staffId) {
        return registrationRepository.findByStaffId(staffId);
    }
}
