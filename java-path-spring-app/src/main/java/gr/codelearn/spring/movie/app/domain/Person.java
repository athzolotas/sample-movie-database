package gr.codelearn.spring.movie.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * This class represents a person in our movie database
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSONS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSONS_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseEntity {
    @NotNull(message = "Customer's email should not be empty.")
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotNull(message = "Customer's firstname should be present.")
    @Column(length = 20, nullable = false)
    private String firstname;

    @NotNull(message = "Customer's firstname should be present.")
    @Column(length = 30, nullable = false)
    private String lastname;

    @Min(value = 4, message = "")
    @Max(value = 100, message = "")
    private Integer age;

    @JsonIgnoreProperties("person")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "person")
    private Set<MovieCast> movieCasts;
}
