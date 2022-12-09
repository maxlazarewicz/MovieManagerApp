package pl.movie.manager.domain.service.movie;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.movie.manager.domain.models.movie.Movie;
import pl.movie.manager.domain.repository.movie.MovieRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Transactional
    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Movie with ID + " + id + "Not Found"));
    }

    @Transactional
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    public Movie getMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @Transactional
    public Movie getMovieByImdbID( String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    @Transactional
    public Movie addMovie(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @Transactional
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Transactional
    public void deleteMovieByTitle(String title) {
        movieRepository.deleteMovieByTitle(title);
    }
}
