package com.hemant.jobappusingpostgres.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String companyId;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String companyPhone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    private List<JobModel> totalJobs;

}
