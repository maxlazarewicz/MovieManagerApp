package pl.movie.manager.domain.client.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.movie.manager.infrastructure.config.ClientConfig;

@FeignClient(
        value = "movie",
        url = "${client.movie.url}",
        configuration = ClientConfig.class)
public interface MovieClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "",
            produces = "application/json")
    MovieWrapper getMovies(@RequestParam(value = "s") String searchPattern,
                           @RequestParam(value = "apikey") String apikey,
                           @RequestParam(value = "type") String type,
                           @RequestParam(value = "page") String page);
}
