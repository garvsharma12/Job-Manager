package com.url.jobmanager.jobmanager.review;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new  ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if(isReviewSaved) return new ResponseEntity<>("review added successfully", HttpStatus.OK);
        else  return new ResponseEntity<>("review already exists", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return  new  ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @RequestBody Review review, @PathVariable Long reviewId){
        boolean isReviewUpdated = reviewService.updateReview(companyId, review, reviewId);
        if(isReviewUpdated) return new ResponseEntity<>("review updated successfully", HttpStatus.OK);
        else  return new ResponseEntity<>("review update failed", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
        if(isReviewDeleted) return new ResponseEntity<>("review deleted successfully", HttpStatus.OK);
        else  return new ResponseEntity<>("review delete failed", HttpStatus.NOT_FOUND);
    }
}
