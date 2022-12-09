package pl.movie.manager.domain.repository.favoritemovie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.movie.manager.domain.models.favoritemovie.FavoriteMovie;

import java.util.List;

@Repository
public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Long> {

    @Query(value = "Select * from movies m inner join favorite_movies fm where m.imdb_id = fm.movie_id", nativeQuery = true)
    List<FavoriteMovie> findAllFavoriteMovies();
}
