package training;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Welcome to the lambdas training
 * <p>
 * Please, implement all the methods and pass all the tests
 * <p>
 * More info in spanish: https://www.adictosaltrabajo.com/2015/12/04/expresiones-lambda-con-java-8/
 * More info in english: https://www.baeldung.com/java-8-functional-interfaces
 */
class Lambdas {

    /*
    Supplier
     */
    Supplier<Integer> getASupplierThatProvidesTheCurrentYear() {

        return () -> LocalDate.now().getYear();
    }

    void printCurrentYear() {

        System.out.println(getASupplierThatProvidesTheCurrentYear().get());
    }


    /*
    Consumer
     */
    Consumer<String> getAConsumerThatPrintsAString() {

        return System.out::println;
    }

    void printValue(final String value) {

        getAConsumerThatPrintsAString().accept(value);
    }


    /*
    Function
     */
    Function<String, Integer> getAFunctionThatCountsTheNumberOfCharactersOfAString() {

        return String::length;
    }

    void printNumberOfCharacters(final String myString) {

        System.out.println(getAFunctionThatCountsTheNumberOfCharactersOfAString().apply(myString));
    }


    /*
    Predicate
     */
    Predicate<Integer> getAPredicateThatDetectsAnEvenNumber() {

        return number -> number % 2 == 0;
    }

    void printWhetherANumberIsEvenOrNot(final Integer number) {

        System.out.println(getAPredicateThatDetectsAnEvenNumber().test(number));
    }


    /*
    UnaryOperator
     */
    UnaryOperator<String> getAUnaryOperatorThatTransformsAStringToUpperCase() {

        return String::toUpperCase;
    }

    void printAStringToUpperCase(final String myString) {

        System.out.println(getAUnaryOperatorThatTransformsAStringToUpperCase().apply(myString));
    }
}
