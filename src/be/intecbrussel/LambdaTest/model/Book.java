package be.intecbrussel.LambdaTest.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Stream;

public class Book {
    public String title;
    public Person author;
    public LocalDate releaseDate;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public String genre;

    public Book(String title, Person author, LocalDate releaseDate, String genre) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public String getGenre() {
        return genre;
    }

    public static Book getNewestBook(Book[] books) {
        // Mijn opllossing
//        Book [] sortedBooks = Stream.of(books)
//                .sorted(Comparator.comparing(Book::getReleaseDate).reversed())
//                .toArray(Book[]::new);
//        return sortedBooks[0];

        // Opllossing van Manuel
        Book newestBook = Stream.of(books)
                .max(Comparator.comparing(book -> book.getReleaseDate())).get();

        return newestBook;
    }

    public static void printYoungestWriter(Book[] books ) {
        // Mijn opllossing
//        Person [] sortedBooks = Stream.of(books)
//                .map(book -> book.getAuthor())
//                .sorted(Comparator.comparing(Person::getDateOfBirth).reversed())
//                .toArray(Person[]::new);
//
//        System.out.println(
//                "The Youngest writter is " +
//                        sortedBooks[0].getFirstName() + " " +
//                        sortedBooks[0].getLastName() + " - Date of Birth: " +
//                        sortedBooks[0].getDateOfBirth().format(formatter)
//        );

        // Opllossing van Manuel
        System.out.println(
                "Youngest Writter:\n" +
                Stream.of(books)
                        .map(Book::getAuthor)
                        .max(Comparator.comparing(Person::getDateOfBirth))
                        .get()
        );
    }

    public static void printSortedByTitle(Book[] books) {
        // Mijn opllossing
        Stream.of(books)
                .sorted(Comparator.comparing(book -> book.getTitle()))
                .forEach(book -> System.out.println(book.getTitle() + "\n"));
    }

    public static void countBooksPerAuthor(Book[] books) {
        // Mijn opllossing
//        Person [] authorArray = Stream.of(books)
//                .map(item -> item.getAuthor())
//                .distinct()
//                .toArray(Person[]::new);
//
//        Person[] unicAuthorsArr = Stream.of(authorArray).toArray(Person[]::new);
//
//        Stream.of(unicAuthorsArr).forEach(person -> {
//            int bookCount = Stream.of(authorArray).filter(author -> author.hashCode() == person.hashCode()).toArray(Person[]::new).length;
//            System.out.println(person.getFirstName() + " " + person.getLastName() + " -> " + bookCount);
//        });

        //  1ste opllossing van Manuel
//        Stream.of(books)
//                .map(Book::getAuthor)
//                .distinct()
//                .peek(author -> System.out.print(author.getFirstName() + " " + author.getLastName() + " -> "))
//                .forEach(author ->
//                        System.out.println(
//                                Stream.of(books)
//                                .filter(book -> book.getAuthor().equals(author))
//                                .count())
//                    );

        // 2de opllossing van Manuel
        Stream.of(books)
                .map(Book::getAuthor)
                .distinct()
                .forEach(author -> {
                    System.out.print(author.getFirstName() + " " + author.getLastName() + " -> ");
                    long count = Stream.of(books)
                            .filter(book -> book.getAuthor().equals(author))
                            .count();
                    System.out.println(count);
                });
    }

    public static void printBooksReleasedIn2016(Book[] books) {
        // Mijn opllossing
//        Book[] booksRealesedIn2016 = Stream.of(books)
//                .filter(book -> book.getReleaseDate().getYear() == 2016)
//                .toArray(Book[]::new);
//
//        if (booksRealesedIn2016.length == 0) {
//            System.out.println("No books released in 2016!");
//        } else {
//            Stream.of(booksRealesedIn2016).forEach(book -> System.out.println(book.getTitle() + " - Release Date -> " + book.getReleaseDate().format(Book.getFormatter())));
//        }

        // Opllosing van Manueel
        if (
                Stream.of(books)
                        .filter(book -> book.getReleaseDate().getYear() == 2016)
                        .peek(System.out::println)
                        .count() == 0
        ) {
            System.out.println("No books release in 2016");
        }
    }

    @Override
    public String toString() {
        return "Book: " +
                "\nTitle -> " + title +
                "\nAuthor -> " + author.getFirstName() + " " + author.getLastName() +
                "\nRelease Date -> " + releaseDate.format(formatter) +
                "\nGenre -> " + genre + "\n";
    }
}
