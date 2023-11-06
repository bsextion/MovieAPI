package dev.fullstack.movies.repos;

import dev.fullstack.movies.beans.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MovieRepo extends MongoRepository<Movie, ObjectId> {

Optional<Movie> findMovieByImdbId(String imdbId);
}
