package com.praveenit.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @Column(name = "PLAN_NAME")
    private String planName;

    @Column(name = "PLAN_START_DATE")
    private LocalDate startDate;

    @Column(name = "PLAN_END_DATE")
    private LocalDate endDate;

    @Column(name = "ACTIVE_SW")
    private String activeSw;

    @Column(name = "PLAN_CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    private LocalDate createDate;

    @Column(name = "UPDATED_DATE", insertable = false)
    @UpdateTimestamp
    private LocalDate updateDate;
}
