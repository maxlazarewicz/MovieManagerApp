package pl.movie.manager.infrastructure.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pl.movie.manager.domain.client.movie.MovieClientService;
import pl.movie.manager.domain.repository.movie.MovieRepository;

@Slf4j
@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    MovieClientService movieClientService;
    @Autowired
    MovieRepository movieRepository;

    private final static String pattern = "abc";

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        String totalResult = movieClientService.getMovies(pattern, "1").getTotalResults();

        for (int i = 1; i < Integer.parseInt(totalResult) / 10; i++) {
            movieRepository.saveAll(movieClientService.getMovies(pattern, Integer.toString(i)).getSearch());
        }
    }
}