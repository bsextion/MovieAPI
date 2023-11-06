package dev.fullstack.movies.services;

import dev.fullstack.movies.beans.Movie;
import dev.fullstack.movies.repos.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> allMovies() {
        return movieRepo.findAll();
    }

    public Optional<Movie> getMovie(String id) {
        return movieRepo.findMovieByImdbId(id);
    }
}
