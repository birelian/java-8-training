package training;

import java.util.stream.Collectors;
import training.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Welcome to the optionals training
 * <p>
 * Please, implement all the methods and pass all the tests
 * <p>
 * More info in spanish: https://experto.dev/java-8-optional/
 * More info in english: https://www.baeldung.com/java-optional
 */
class Optionals {

	Optional<String> getAnEmptyOptional() {

		return Optional.empty();
	}

	Optional<String> getAnOptionalOfANullableMessage(final String message) {

		return Optional.ofNullable(message);
	}

	boolean checkIfTheMessageProvidedHasValue(final Supplier<Optional<String>> messageSupplier) {

		return messageSupplier.get().isPresent();
	}

	String getTheMessageProvidedOrNullIfItHasNoValue(final Supplier<Optional<String>> messageSupplier) {

		return messageSupplier.get().orElse(null);
	}

	void printTheMessageProvidedOnlyIfItHasValue(final Supplier<Optional<String>> messageSupplier) {

		messageSupplier.get().ifPresent(System.out::println);
	}

	String getTheMessageProvidedOrTheDefaultMessageIfItHasNoValue(final Supplier<Optional<String>> messageSupplier,
		final Supplier<String> defaultMessageSupplier) {

		return messageSupplier.get().orElseGet(defaultMessageSupplier);
	}

	String getTheMessageProvidedOrThrowIllegalArgumentExceptionIfItHasNoValue(final Supplier<Optional<String>> messageSupplier) {
		return messageSupplier.get().orElseThrow(IllegalArgumentException::new);
	}

	Optional<String> getTheMessageProvidedInUpperCase(final Supplier<Optional<String>> messageSupplier) {

		return messageSupplier.get().map(String::toUpperCase);
	}

	Optional<Integer> getTheNumberProvidedOnlyIfItIsAnEvenNumber(final Supplier<Optional<Integer>> numberSupplier) {

		return numberSupplier.get().filter(number -> number % 2 == 0);
	}

	Optional<String> getTheMessageContentInUpperCase(final Supplier<Optional<Message>> messageSupplier) {

		return messageSupplier.get().flatMap(Message::getContent).map(String::toUpperCase);
	}

	List<String> getTheMessageContentsThatHaveValue(final Supplier<List<Message>> messagesSupplier) {

		return messagesSupplier.get().stream()
			.map(Message::getContent)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(Collectors.toList());

	}
}
