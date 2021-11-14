package gr.codelearn.spring.movie.app.bootstrap;

import gr.codelearn.spring.movie.app.base.AbstractLogComponent;
import gr.codelearn.spring.movie.app.domain.Genre;
import gr.codelearn.spring.movie.app.domain.Person;
import gr.codelearn.spring.movie.app.domain.Movie;
import gr.codelearn.spring.movie.app.domain.MovieCast;
import gr.codelearn.spring.movie.app.domain.MovieGenre;
import gr.codelearn.spring.movie.app.service.PersonService;
import gr.codelearn.spring.movie.app.service.MovieService;
import gr.codelearn.spring.movie.app.service.MovieCastService;
import gr.codelearn.spring.movie.app.service.GenreService;
import gr.codelearn.spring.movie.app.service.MovieGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
    private final PersonService personService;
    private final MovieCastService movieCastService;
    private final MovieService movieService;
    private final GenreService genreService;
    private final MovieGenreService movieGenreService;

    @Override
    public void run(String... args) {
        generatePersons();
        generateGenres();
        generateMovies();
        generateMovieCasts();
        generateMovieGenres();
        logger.info("Content runner finished");
    }

    private void generatePersons() {
        List<Person> persons = personService.createAll(
                Person.builder().email("tonyblack@nobody.com")
                        .firstname("Tony").lastname("Blck")
                        .age(47).build(),
                Person.builder().email("fredperry@nobody.com")
                        .firstname("Fred").lastname("Perry")
                        .age(15).build(),
                Person.builder().email("tomhanks@nobody.com")
                        .firstname("Tom").lastname("Hanks")
                        .age(54).build(),
                Person.builder().email("christinebrown@nobody.com")
                        .firstname("Christine").lastname("Brown")
                        .age(28).build(),
                Person.builder().email("hellengreen@nobody.com")
                        .firstname("Helen").lastname("Green")
                        .age(47).build(),
                Person.builder().email("johnmcalister@nobody.com")
                        .firstname("John").lastname("Mc Calister")
                        .age(29).build());

        logger.info("{} persons created.", persons.size());

        personService.findAll().forEach(p -> logger.info("{}", p));
    }

    private void generateGenres() {
        List<Genre> genres = genreService.createAll(
                Genre.builder().name("Adventure").build(),
                Genre.builder().name("Mystery").build(),
                Genre.builder().name("Fantasy").build()
        );
    }

    private void generateMovies() {
        List<Movie> movies = movieService.createAll(
                Movie.builder().title("Lord of the Rings")
                        .year("2001")
                        .build(),
                Movie.builder().title("Avatar")
                        .year("2010")
                        .build()
        );

        movieService.findAll().forEach(m -> logger.info("{}", m));
    }

    private void generateMovieCasts() {
        List<MovieCast> movieCasts = movieCastService.createAll(
                MovieCast.builder()
                        .person(personService.findByEmail("tonyblack@nobody.com"))
                        .movie(movieService.findByTitle("Lord of the Rings"))
                        .role("DIRECTOR")
                        .build(),
                MovieCast.builder()
                        .person(personService.findByEmail("fredperry@nobody.com"))
                        .movie(movieService.findByTitle("Lord of the Rings"))
                        .role("ACTOR")
                        .build(),
                MovieCast.builder()
                        .person(personService.findByEmail("tomhanks@nobody.com"))
                        .movie(movieService.findByTitle("Lord of the Rings"))
                        .role("ACTOR")
                        .build(),
                MovieCast.builder()
                        .person(personService.findByEmail("christinebrown@nobody.com"))
                        .movie(movieService.findByTitle("Lord of the Rings"))
                        .role("PRODUCER")
                        .build(),
                MovieCast.builder()
                        .person(personService.findByEmail("christinebrown@nobody.com"))
                        .movie(movieService.findByTitle("Avatar"))
                        .role("DIRECTOR")
                        .build(),
                MovieCast.builder()
                        .person(personService.findByEmail("johnmcalister@nobody.com"))
                        .movie(movieService.findByTitle("Avatar"))
                        .role("PRODUCER")
                        .build(),
                MovieCast.builder()
                        .person(personService.findByEmail("tomhanks@nobody.com"))
                        .movie(movieService.findByTitle("Avatar"))
                        .role("ACTOR")
                        .build(),
                MovieCast.builder()
                        .person(personService.findByEmail("fredperry@nobody.com"))
                        .movie(movieService.findByTitle("Avatar"))
                        .role("ACTOR")
                        .build()
        );
    }

    private void generateMovieGenres() {
        List<MovieGenre> movieGenres = movieGenreService.createAll(
                MovieGenre.builder()
                        .genre(genreService.findByName("Adventure"))
                        .movie(movieService.findByTitle("Lord of the Rings"))
                        .build(),
                MovieGenre.builder()
                        .genre(genreService.findByName("Mystery"))
                        .movie(movieService.findByTitle("Avatar"))
                        .build(),
                MovieGenre.builder()
                        .genre(genreService.findByName("Fantasy"))
                        .movie(movieService.findByTitle("Avatar"))
                        .build()
        );
    }
}

