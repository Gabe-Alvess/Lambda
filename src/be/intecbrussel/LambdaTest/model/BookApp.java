package be.intecbrussel.LambdaTest.model;

import java.time.LocalDate;

public class BookApp {
    public static void main(String[] args) {
        Book [] books = getBookArray();

        System.out.println(
                "Newest book:\n" + Book.getNewestBook(books).getTitle() +
                "\nRealese Date -> " + Book.getNewestBook(books).getReleaseDate().format(Book.getFormatter()) + "\n"
        );
        Book.printYoungestWriter(books);
        System.out.println("\nBooks sorted by title:");
        Book.printSortedByTitle(books);
        System.out.println("Books per Author:");
        Book.countBooksPerAuthor(books);
        System.out.println("\nBooks realesed in 2016:");
        Book.printBooksReleasedIn2016(books);
    }

    private static Book[] getBookArray() {
        Person joanne = new Person("Joanne", "Rowling", LocalDate.of(1965, 7, 31));
        Person arthur = new Person("Arthur", "Ignatius Conan Doyle", LocalDate.of(1859, 5, 22));
        Person jules = new Person("Jules", "Verne", LocalDate.of(1828, 2, 8));
        Person jonathan = new Person("Jonathan", "Swift", LocalDate.of(1667, 11, 30));

        Book b1 = new Book("Harry Potter and the Philosopher’s Stone", joanne, LocalDate.of(1997,6,26), "Fantasy" );
        Book b2 = new Book("A Study in Scarlet", arthur, LocalDate.of(1887,11,1), "Mystery");
        Book b3 = new Book("Around the World in Eighty Days", jules, LocalDate.of(1872, 11, 6), "Fiction");
        Book b4 = new Book("Twenty Thousand Leagues Under the Sea", jules, LocalDate.of(1870, 1, 1), "Science Fiction");
        Book b5 = new Book("Gulliver's Travels", jonathan, LocalDate.of(1726, 1, 1), "Fiction");

        return new Book[] {b1,b2,b3,b4,b5};
    }
}
