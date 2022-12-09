package pl.movie.manager.domain.client.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieClientProperties {

    @Value("${client.movie.apikey}")
    private String apiKey;
    @Value("${client.movie.type}")
    private String type;
}
