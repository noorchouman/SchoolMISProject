package com.example.demo.service;

import com.example.demo.Parent;
import com.example.demo.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent getParentById(Long id) {
        Optional<Parent> parent = parentRepository.findById(id);
        return parent.orElse(null);
    }

    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public Parent updateParent(Long id, Parent parent) {
        Optional<Parent> existingParent = parentRepository.findById(id);
        if (existingParent.isEmpty()) return null;
        Parent p = existingParent.get();
        p.setName(parent.getName());
        p.setAddress(parent.getAddress());
        p.setPhoneNumber(parent.getPhoneNumber());
        p.setChildren(parent.getChildren());
        p.setRegistrations(parent.getRegistrations());
        return parentRepository.save(p);
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }

    public List<Parent> findByPhoneNumber(String phoneNumber) {
        return parentRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Parent> searchByName(String name) {
        return parentRepository.findByNameContainingIgnoreCase(name);
    }
}
