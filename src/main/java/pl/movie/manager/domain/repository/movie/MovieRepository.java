package pl.movie.manager.domain.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.movie.manager.domain.models.movie.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    Movie findMovieByTitle(@Param("title")String title);

    Movie findMovieByImdbId(@Param("imdbId")String imdbId);

    void deleteMovieByTitle(@Param("title") String title);
}
