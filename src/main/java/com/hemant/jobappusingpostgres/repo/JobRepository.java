package com.hemant.jobappusingpostgres.repo;

import com.hemant.jobappusingpostgres.model.JobModel;
import com.hemant.jobappusingpostgres.model.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobModel,Integer> {
    List<JobModel> findByJobStatus(JobStatus jobStatus);
    List<JobModel> findByCompany_CompanyId(String companyId);
    List<JobModel> findByJobNameContainingIgnoreCase(String jobName);
}
