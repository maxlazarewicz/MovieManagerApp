package pl.movie.manager.web.movie;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.movie.manager.domain.models.movie.Movie;
import pl.movie.manager.domain.service.movie.MovieService;

@Slf4j
@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/list")
    @Operation(summary = "Showing all movies from https://www.omdbapi.com/ by pattern")
    public ResponseEntity getMovies(){
        return new ResponseEntity(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    @Operation(summary = "You can find movie, just enter the title")
    public ResponseEntity getMovieByTitle(@PathVariable String title){
        return new ResponseEntity(movieService.getMovieByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/id/{imdbId}")
    @Operation(summary = "Enter the imdbId, and find movie")
    public ResponseEntity getMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity(movieService.getMovieByImdbID(imdbId), HttpStatus.OK );
    }

    @PostMapping("/add/{movieId}")
    @Operation(summary = "Add new movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        return new ResponseEntity(movieService.addMovie(movie), HttpStatus.OK);
    }
}

