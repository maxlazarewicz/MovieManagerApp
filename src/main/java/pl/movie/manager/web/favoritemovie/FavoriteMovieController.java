package pl.movie.manager.web.favoritemovie;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity getAllFavoriteMovie() {
        return new ResponseEntity(favoriteMovieService.getAllFavoriteMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getFavoriteMovieById(@PathVariable Long id) {
        return new ResponseEntity(favoriteMovieService.getFavoriteMovieById(id), HttpStatus.OK);
    }

    @PostMapping("/add/{movieId}")
    public ResponseEntity addFavoriteMovies(@PathVariable String movieId){
        return new ResponseEntity(favoriteMovieService.addFavoriteMovie(movieId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{movieId}")
    public void deleteFavoriteMovie(@PathVariable Long movieId){
        favoriteMovieService.deleteFavoriteMovie(movieId);
    }
}

