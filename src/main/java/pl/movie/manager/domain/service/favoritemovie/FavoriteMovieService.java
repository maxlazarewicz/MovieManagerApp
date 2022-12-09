package pl.movie.manager.domain.service.favoritemovie;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.movie.manager.domain.models.favoritemovie.FavoriteMovie;
import pl.movie.manager.domain.repository.favoritemovie.FavoriteMovieRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FavoriteMovieService {

    @Autowired
    FavoriteMovieRepository favoriteMovieRepository;


    @Transactional
    public List<FavoriteMovie> getAllFavoriteMovies() {
        return favoriteMovieRepository.findAllFavoriteMovies();
    }

    @Transactional
    public FavoriteMovie getFavoriteMovieById(Long id){
        return favoriteMovieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with " + id + " not found"));
    }

    @Transactional
    public FavoriteMovie addFavoriteMovie(String movieId){
        return favoriteMovieRepository.saveAndFlush(new FavoriteMovie(movieId));

    }

    @Transactional
    public void deleteFavoriteMovie(Long id){
        favoriteMovieRepository.deleteById(id);
    }

}
