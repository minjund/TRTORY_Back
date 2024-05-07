package com.trpg.trpg_back.global.util;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "reg_date", columnDefinition = "timestamp", nullable = false)
    private LocalDateTime reg_date;

    @Column(name = "mod_date", columnDefinition = "timestamp", nullable = true)
    private LocalDateTime mod_date;

}
