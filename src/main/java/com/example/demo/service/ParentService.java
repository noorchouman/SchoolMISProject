package com.example.demo.service;

import com.example.demo.Parent;
import java.util.List;

public interface ParentService {
    List<Parent> getAllParents();
    Parent getParentById(Long id);
    Parent saveParent(Parent parent);
    Parent updateParent(Long id, Parent parent);
    void deleteParent(Long id);

    List<Parent> findByPhoneNumber(String phoneNumber);
    List<Parent> searchByName(String name);
}
