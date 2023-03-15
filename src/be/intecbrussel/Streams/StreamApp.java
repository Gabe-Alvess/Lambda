package be.intecbrussel.Streams;

import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {
        String[] words = {"hello", "BONjoyr", "NI Hao"};

        Stream.of(words)
                .map(s -> s.toLowerCase())
                //.map(String::toLowerCase) -> method reference
                //.map(s -> s.length()) -> let op!
                .map(s -> s.replace('y', 'u'))
                .filter(s -> s.length() < 7)
                .sorted()
                //.forEach(System.out::println); -> method reference
                .forEach(s -> System.out.println(s));

        Persons[] people = {new Persons("Jos", 55), new Persons("Bob", 20), new Persons("Tom", 25) };

        Stream.of(people)
                .forEach(s -> System.out.println(s));

    }
}
