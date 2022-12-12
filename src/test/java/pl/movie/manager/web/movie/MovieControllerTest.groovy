package pl.movie.manager.web.movie

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import pl.movie.manager.domain.models.favoritemovie.FavoriteMovie
import pl.movie.manager.domain.models.movie.Movie
import pl.movie.manager.domain.repository.favoritemovie.FavoriteMovieRepository
import pl.movie.manager.domain.repository.movie.MovieRepository
import pl.movie.manager.domain.service.favoritemovie.FavoriteMovieService
import pl.movie.manager.domain.service.movie.MovieService
import pl.movie.manager.infrastructure.config.TestConfig
import spock.lang.Shared
import spock.lang.Specification

@AutoConfigureMockMvc(addFilters = false)
@EnableJpaRepositories(basePackages = "pl.movie.manager.domain.*")
@EntityScan(basePackages = "pl.movie.manager.domain.*")
@EnableWebMvc
@SpringBootTest(classes =
        [
                Movie.class,
                MovieService.class,
                MovieRepository.class,
                TestConfig.class
        ])
class MovieControllerTest extends Specification {


    @Autowired
    MockMvc mvc;

    @Shared
    ObjectMapper objectMapper;

    //Wykonuje sie za kazdym jednym pojedynczym tescie
    def setupSpec() {
        objectMapper = new ObjectMapper();
    }


    def 'Should return list of Movies and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/movie/list")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        and:
        with(objectMapper.readValue(response.contentAsString, Map)) {

        }
    }

    def 'Should add Movie and Http 201'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.post("/movie/add").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(getValidMovie())))
                .andReturn().response
        then:
        response.status == HttpStatus.CREATED.value()
    }

    def getValidMovie() {
        return Movie.builder()
                .imdbId("ttt333")
                .poster("www.wwww.pl")
                .title("W trawie piszczy")
                .type("movie")
                .year("1989")
    }
}

