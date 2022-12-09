package pl.movie.manager.domain.client.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.movie.manager.domain.models.movie.Movie;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieWrapper {

    @JsonProperty("Search")
    private List<Movie> Search;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("Response")
    private String Response;
}
