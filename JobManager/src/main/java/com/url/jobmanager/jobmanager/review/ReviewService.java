package com.url.jobmanager.jobmanager.review;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long id, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Review review, Long reviewId);
    boolean deleteReview(Long companyId, Long reviewId);
}
