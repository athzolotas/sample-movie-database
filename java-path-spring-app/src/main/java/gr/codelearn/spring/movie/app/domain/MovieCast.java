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
@Table(name = "MOVIECASTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIECASTS_SEQ", initialValue = 1, allocationSize = 1)
public class MovieCast extends BaseEntity {
    @Column(length = 10, nullable = false)
    private String role;

    @JsonIgnoreProperties("movieCasts")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Person person;

    @JsonIgnoreProperties("movieCasts")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Movie movie;
}
