package com.praveenit.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "ACTIVE_SW")
    private String activeSw;

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
