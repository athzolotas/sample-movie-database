package gr.codelearn.spring.movie.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * This class represents an order submitted by a customer.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MOVIEGENRES")
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIEGENRES_SEQ", initialValue = 1, allocationSize = 1)
public class MovieGenre extends BaseEntity {

    @JsonIgnoreProperties("movieGenres")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Movie movie;

    @JsonIgnoreProperties("movieGenres")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Genre genre;
}
