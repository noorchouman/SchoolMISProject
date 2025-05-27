package com.example.demo;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable entity) {
        Audit audit = entity.getAudit();
        audit.setCreatedDate(LocalDateTime.now());
        audit.setCreatedBy(getCurrentUser());
        audit.setModifiedDate(LocalDateTime.now());
        audit.setModifiedBy(getCurrentUser());
    }

    @PreUpdate
    public void setUpdatedOn(Auditable entity) {
        Audit audit = entity.getAudit();
        audit.setModifiedDate(LocalDateTime.now());
        audit.setModifiedBy(getCurrentUser());
    }

    private String getCurrentUser() {
        // You can later hook this into Spring Security
        return "system"; 
    }
}

