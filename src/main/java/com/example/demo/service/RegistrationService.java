package com.example.demo.service;

import com.example.demo.Registration;
import java.util.List;

public interface RegistrationService {
    List<Registration> getAllRegistrations();
    Registration getRegistrationById(Long id);
    Registration saveRegistration(Registration registration);
    Registration updateRegistration(Long id, Registration registration);
    void deleteRegistration(Long id);

    List<Registration> findByStudentId(Long studentId);
    List<Registration> findByParentId(Long parentId);
    List<Registration> findByStaffId(Long staffId);
}
