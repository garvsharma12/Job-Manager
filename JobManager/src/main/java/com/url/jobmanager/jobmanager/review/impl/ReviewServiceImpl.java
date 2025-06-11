package com.url.jobmanager.jobmanager.review.impl;

import com.url.jobmanager.jobmanager.Company.Company;
import com.url.jobmanager.jobmanager.Company.CompanyRepository;
import com.url.jobmanager.jobmanager.Company.CompanyService;
import com.url.jobmanager.jobmanager.review.Review;
import com.url.jobmanager.jobmanager.review.ReviewRepository;
import com.url.jobmanager.jobmanager.review.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    public ReviewServiceImpl(ReviewRepository reviewRepository,  CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long id, Review review) {
        Company company = companyService.getCompanyById(id);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Review review, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null){
            review.setCompany(companyService.getCompanyById(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            Review review  = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company, companyId);
            return true;
        }
        return false;
    }


}
