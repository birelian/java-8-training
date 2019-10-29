package training;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.ImmutablePair;
import training.model.Movie;

/**
 * Welcome to the steams training
 * <p>
 * Please, implement all the methods and pass all the tests
 * <p>
 * More info in spanish: https://www.belikesoftware.com/java-8-streams/
 * More info in english: https://www.baeldung.com/java-8-streams
 */
class Streams {

    Stream<String> getAStreamOfNames(final String[] names) {

        return Stream.of(names);
    }

    Stream<String> getAStreamOfNames(final List<String> names) {

        return names.stream();
    }

    Stream<String> getAStreamOfTwoNames(final String firstName, final String secondName) {

        return Stream.of(firstName, secondName);
    }

    List<String> getAListOfNames(final Stream<String> streamOfNames) {

        return streamOfNames.collect(Collectors.toList());
    }

    Stream<Integer> getAStreamOfIntegersFromZeroToTen() {

        return IntStream.rangeClosed(0, 10).boxed();
    }

    void printTheMessages(final List<String> messages) {

        messages.forEach(System.out::println);
    }

    List<String> convertTheNumbersToStrings(final List<Integer> numbers) {

        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.toList());
    }

    List<Integer> getOnlyTheEvenNumbers(final List<Integer> numbers) {

        return numbers.stream()
            .filter(integer -> integer % 2 == 0)
            .collect(Collectors.toList());
    }

    Integer getTheFirstEvenNumberOrNullIfNotFound(final List<Integer> numbers) {

        return numbers.stream()
            .filter(integer -> integer % 2 == 0)
            .findFirst()
            .orElse(null);
    }

    int sumTheEvenNumbers(final List<Integer> numbers) {

        return numbers.stream()
            .filter(integer -> integer % 2 == 0)
            .reduce(Integer::sum)
            .orElse(0);
    }

    boolean checkIfAllTheNumbersAreEven(final List<Integer> numbers) {

        return numbers.stream()
            .noneMatch(number -> number % 2 != 0);
    }

    List<String> getTheNamesInUpperCase(final List<String> names) {

        return names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    List<String> getTheDistinctNames(final List<String> names) {

        return names.stream()
            .distinct()
            .collect(Collectors.toList());
    }

    List<String> getTheFirstThreeNames(final List<String> names) {

        return names.stream()
            .limit(3)
            .collect(Collectors.toList());
    }

    List<String> sortTheNames(final List<String> disorderedNames) {

        return disorderedNames.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    long countTheNamesThatStartWithTheLetterD(final List<String> names) {

        return names.stream()
            .filter(name -> name.startsWith("D"))
            .count();
    }

    Set<String> getAllTheCharactersFromTheMovies(final List<Movie> movies) {

        return movies.stream()
            .flatMap(movie -> movie.getCharacters()
                .stream())
            .collect(Collectors.toSet());
    }

    Map<Integer, String> getTheMovieNamesById(final List<Movie> movies) {

        return movies.stream()
            .collect(Collectors.toMap(Movie::getId, Movie::getName));
    }

    Map<String, List<Movie>> getTheMoviesOfEachDirector(final List<Movie> movies) {

        return movies.stream()
            .collect(Collectors.groupingBy(Movie::getDirector));
    }

    Map<String, Movie> getTheMovieOfEachCharacter(final List<Movie> movies) {

        return movies.stream()
            .flatMap(this::getMoviesOfCharacters)
            .collect(Collectors.toMap(ImmutablePair::getLeft, ImmutablePair::getRight));
    }

    Integer getTheYearWithMoreMovies(final List<Movie> movies) {

        return movies.stream()
            .collect(Collectors.groupingBy(Movie::getYear, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    private Stream<ImmutablePair<String, Movie>> getMoviesOfCharacters(Movie movie) {

        return movie.getCharacters()
            .stream()
            .map(character -> new ImmutablePair<>(character, movie));

    }
}
