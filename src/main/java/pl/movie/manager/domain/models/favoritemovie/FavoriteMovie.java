package pl.movie.manager.domain.models.favoritemovie;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "favorite_movies"
        ,uniqueConstraints = { @UniqueConstraint(columnNames = { "movieId" }) })
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class FavoriteMovie {

    @Id
    @GeneratedValue
    private Long Id;

    @NonNull
    private String movieId;

}
