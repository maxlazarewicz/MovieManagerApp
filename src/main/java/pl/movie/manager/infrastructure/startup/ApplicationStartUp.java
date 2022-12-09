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

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        movieRepository.saveAll(movieClientService.getMovies("abc", "1").getSearch());
    }
}