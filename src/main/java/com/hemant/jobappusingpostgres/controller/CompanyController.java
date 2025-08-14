package com.hemant.jobappusingpostgres.controller;

import com.hemant.jobappusingpostgres.model.CompanyModel;
import com.hemant.jobappusingpostgres.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    CompanyRepository  companyRepository;

    @PostMapping
    public ResponseEntity<CompanyModel> createCompany(@RequestBody CompanyModel company) {

        return ResponseEntity.ok().body(companyRepository.save(company));
    }

    @GetMapping
    public ResponseEntity<List<CompanyModel>> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(companyRepository.findAll());
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyModel> updateCompany(@PathVariable String companyId,@RequestBody CompanyModel company) {
        company.setCompanyId(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(companyRepository.save(company));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable String companyId) {
        companyRepository.findById(companyId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        companyRepository.deleteById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body("Company deleted successfully");
    }
}
