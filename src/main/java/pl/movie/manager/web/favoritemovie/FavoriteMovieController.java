package pl.movie.manager.web.favoritemovie;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.graalvm.compiler.word.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.movie.manager.domain.service.favoritemovie.FavoriteMovieService;

@Slf4j
@RestController
@RequestMapping("/favoritemovie")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class FavoriteMovieController {

    @Autowired
    FavoriteMovieService favoriteMovieService;

    @GetMapping("/list")
    @Operation(summary = "Showing your favorite movies")
    public ResponseEntity getAllFavoriteMovie() {
        return new ResponseEntity(favoriteMovieService.getAllFavoriteMovies(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Showing favorite movie by Id")
    public ResponseEntity getFavoriteMovieById(@PathVariable Long id) {
        return new ResponseEntity(favoriteMovieService.getFavoriteMovieById(id), HttpStatus.OK);
    }

    @PostMapping("/add/{movieId}")
    @Operation(summary = "Add movie to favorites by enter  IMDBID")
    public ResponseEntity addFavoriteMovies(@PathVariable String movieId){
        return new ResponseEntity(favoriteMovieService.addFavoriteMovie(movieId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{movieId}")
    @Operation(summary = "Delete movie from favorite")
    public void deleteFavoriteMovie(@PathVariable Long movieId){
        favoriteMovieService.deleteFavoriteMovie(movieId);
    }
}

