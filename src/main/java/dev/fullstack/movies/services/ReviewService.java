package dev.fullstack.movies.services;

import dev.fullstack.movies.beans.Movie;
import dev.fullstack.movies.beans.Review;
import dev.fullstack.movies.repos.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review addReview(String reviewBody, String imdbId) {
        Review review = reviewRepo.insert(new Review(reviewBody));
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
