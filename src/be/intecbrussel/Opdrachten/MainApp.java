package be.intecbrussel.Opdrachten;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.Random;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("---- Opdracht - 1 ----\n");
        // Doe de voorbeeldjes na van de Consumer, Supplier, Function en Runnable.

        // Consumer:
        Consumer<String> function = (String food) -> System.out.println("Eating a " + food);
        function.accept("cookie");

        // Supplier:
        Supplier<String> function1 = () -> {
            String time = LocalTime.now().toString();
            return "The time right now is: " + time;
        };
        System.out.println(function1.get());

        // Function:
        Function<String, Integer> function2 = (a) -> a.length();
        System.out.println(function2.apply("cookie"));

        // Runnable:
        Runnable function3 = () -> System.out.println("Hello");
        function3.run();

        System.out.println("---- Opdracht - 2 ----\n");
        // Maak een Consumer Object waarbij dat je de leeftijd van de gebruiker moet vragen.
        // Als die jonger is dan 18 jaar, dan print de functie: “You’re too young!”
        // Als die ouder is dan 17 jaar, dant print de functie: “You’re too old.

        Consumer<Integer> leeftijd = (Integer age) -> {

            if (age < 18) {
                System.out.println("You're too young.");
            } else if (age > 18) {
                System.out.println("You're too old.");
            } else {
                System.out.println("Invalid age!");
            }
        };
        leeftijd.accept(20);

        System.out.println("---- Opdracht - 3 ----\n");
        // Maak Een Supplier die een randomNumber tussen 1 en 4 genereert.
        // Die randomNumber wordt gebruikt in een Function.
        // Deze functie geeft je dan de correcte percentage waarde terug in een Sysout.
        // Bvb.: 1 -> 25%. 4-> 100%

        Supplier<Integer> randomNumber = () -> new Random().nextInt(1, 5);


        Function<Integer, String> percentage = (number) -> number * 25 + "%";

        System.out.println(percentage.apply(randomNumber.get()));

        System.out.println("---- Opdracht - 4 ----\n");
        // Zoek een manier om 2 waarden mee te geven aan een Consumer en een Function.
        // Je gaat hiervoor moeten googlen.

        System.out.println("BiConsumer");
        // BiConsumer
        BiConsumer<Integer, Double> biConsumer = (n, n2) -> System.out.println(n + n2);
        biConsumer.accept(2, 5.5);

        System.out.println("\nBiFunction");
        // BiFunction
        BiFunction<Integer, Double, Double> biFunction = (intNumber, doubleNumber) -> intNumber * doubleNumber;

        System.out.println(biFunction.apply(5,3.0));

        System.out.println("---- Opdracht - 5 ----\n");
        // We gaan lambda’s nu toepassen op Streams.
        // Copy-paste volgende lijn, en vul de Stream aan met lambdas.
        // Je gaat enkel de getallen afprinten die deelbaar zijn door 8, nadat je ze gedeeld hebt door 4:
        // IntStream.of(5,8,640,1111,27,16).

        IntStream.of(5,8,640,1111,27,16)
                .map(value -> value / 4)
                .filter(value -> value % 8 == 0)
                .forEach(value -> System.out.println("Numbers divisible by 8:\n" + value));

        System.out.println("---- Opdracht - 6 ----\n");
        // Onderstaande Array kopieer je.
        //
        // String [] animals = {"Cow","ShaRk", "DOg","PirAnha", "MouSE", "CaT","ParRoT","DOLphin"};
        //
        // Plaats deze array in een nieuwe array(Gebruik toArray).
        // Alle dieren moeten in lowercase staan, En je houdt enkel de dieren die de letter ‘a’ in hun naam hebben.
        // Bonus: Je gaat nu ook de array moeten sorteren op basis van de lengte van het woord. (Hint: Comparator.)

        String[] animals = {"Cow", "ShaRk", "DOg", "PirAnha", "MouSE", "CaT", "ParRoT", "DOLphin"};

        String[] newAnimals = Stream.of(animals).toArray(String[]::new);

        Stream.of(newAnimals)
                .map(animal -> animal.toLowerCase())
                .filter(animal -> animal.contains("a"))
                .sorted(Comparator.comparing(animal -> animal.length()))
                .forEach(animal -> System.out.println(animal));

        System.out.println("---- Opdracht - 7 ----\n");
        // Deze opdracht heb je al eens gedaan.
        // Doe deze nu eens opnieuw, maar dit keer gebruik je streams om de resultaten af te printen:

        ShoePair nike = new ShoePair("Nike", false, "white", 41, 69.99);
        ShoePair timberLand = new ShoePair("Timberland", true, "brown", 41, 219.99);
        ShoePair balenciaga = new ShoePair("Balenciaga",true,"black", 45, 429.99);
        ShoePair nike2 = new ShoePair("Nike",true,"white", 42,29.99);
        ShoePair timberLand2 = new ShoePair("TimberLand",true,"black", 39, 170);
        ShoePair balenciaga2 = new ShoePair("Balenciaga",false,"black", 45, 50);
        ShoePair nike3 = new ShoePair("Nike",true,"white", 41, 79.99);
        ShoePair timberLand3 = new ShoePair("TimberLand",true,"yellow", 41, 80);
        ShoePair balenciaga3 = new ShoePair("Balenciaga",false,"black", 37, 349.99);

        ShoePair [] shoePairs = {nike,timberLand,balenciaga,nike2,timberLand2,balenciaga2,nike3,timberLand3,balenciaga3};

        Stream.of(shoePairs)
                .filter(shoes -> shoes.getSize() == 41)
                .filter(shoes -> shoes.isComplete())
                .forEach(shoes -> System.out.println(shoes));
    }
}
