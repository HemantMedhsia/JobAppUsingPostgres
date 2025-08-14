package com.hemant.jobappusingpostgres.controller;

import com.hemant.jobappusingpostgres.model.CompanyModel;
import com.hemant.jobappusingpostgres.model.JobModel;
import com.hemant.jobappusingpostgres.repo.CompanyRepository;
import com.hemant.jobappusingpostgres.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {
    @Autowired
    CompanyRepository  companyRepository;

    @Autowired
    JobRepository jobRepository;

    @PostMapping("/{companyId}/create")
    public ResponseEntity<JobModel> createJob(
            @RequestBody JobModel job,
            @PathVariable String companyId
    ) {
        CompanyModel company = companyRepository.findById(companyId)
                .orElseThrow(
                        ()-> new RuntimeException("Company Not Found")
                );

        job.setCompany(company);
        JobModel savedJob = jobRepository.save(job);
        return ResponseEntity.status(HttpStatus.OK).body(savedJob);
    }

    @GetMapping
    public List<JobModel> getAllJobs() {
        return jobRepository.findAll();
    }
}
