package com.hemant.jobappusingpostgres.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    private String jobName;
    private String jobDescription;
    private String jobCategory;
    private String experienceRequired;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CompanyModel company;
}
