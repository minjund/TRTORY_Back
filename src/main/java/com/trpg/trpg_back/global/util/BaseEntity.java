package com.trpg.trpg_back.global.util;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "reg_date", updatable = false, columnDefinition = "timestamp", nullable = false)
    private LocalDateTime reg_date;

    @UpdateTimestamp
    @Column(name = "mod_date", columnDefinition = "timestamp", nullable = false)
    private LocalDateTime mod_date;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        reg_date = now;
        mod_date = now;
    }

    @PreUpdate
    public void preUpdate() {
        mod_date = LocalDateTime.now();
    }
}
