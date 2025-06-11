package com.url.jobmanager.jobmanager.Company.impl;

import com.url.jobmanager.jobmanager.Company.Company;
import com.url.jobmanager.jobmanager.Company.CompanyRepository;
import com.url.jobmanager.jobmanager.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public  CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> comp = companyRepository.findById(id);
        if(comp.isPresent()){
            Company c = comp.get();
            c.setDescription(company.getDescription());
            c.setCompanyName(company.getCompanyName());
            c.setJobs(company.getJobs());
            companyRepository.save(c);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
