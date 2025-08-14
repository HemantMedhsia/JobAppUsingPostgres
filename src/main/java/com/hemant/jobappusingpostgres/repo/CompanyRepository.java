package com.hemant.jobappusingpostgres.repo;

import com.hemant.jobappusingpostgres.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyModel,String> {
    CompanyModel findByCompanyId(String companyId);
    CompanyModel findByCompanyName(String companyName);
}
