package pl.movie.manager.domain.client.movie;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieClientService {

    @Autowired
    MovieClient movieClient;
    @Autowired
    MovieClientProperties movieClientProperties;

    public MovieWrapper getMovies(String searchPattern, String page) {
        return movieClient.getMovies(searchPattern,
                movieClientProperties.getApiKey(),
                movieClientProperties.getType(),
                page);
    }
}
