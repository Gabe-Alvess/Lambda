package be.intecbrussel.Lambdas;

import java.util.function.Function;

public class LambdaDemoApp {
    public static void main(String[] args) {
        FunctionalInterfaceClass interfaceClassFunction =
                () -> System.out.println("Does a test");

        Runnable test = () -> System.out.println("This works too");

        interfaceClassFunction.testMethod();
        test.run();

        MathCalculateInterface powerSquareFunction =
                (double number) -> number * number;

        System.out.println(powerSquareFunction.doCauculation(5));
        System.out.println(powerSquareFunction.doCauculation(4));

        MathCalculateInterface squareRoot =
                (double number) -> Math.sqrt(number);

        Function <Double, Double> powerSquareFunction2 =
                (number) -> number * number;

        System.out.println(squareRoot.doCauculation(16));
        System.out.println(squareRoot.doCauculation(25));
        System.out.println(powerSquareFunction2.apply(6.0));



    }
}
