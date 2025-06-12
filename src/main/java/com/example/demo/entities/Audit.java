package com.example.demo.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Embeddable
public class Audit {

    private String createdBy;
    private LocalDateTime createdDate;

    private String modifiedBy;
    private LocalDateTime modifiedDate;


    
}
