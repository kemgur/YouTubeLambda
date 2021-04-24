package youtubelambda;

import java.util.ArrayList;
import java.util.List;

public class Fp03 {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);
        printElFunctional(l);
        System.out.println();
        printEvenFunctional(l);
        System.out.println();
        printSquareOdds(l);
    }

    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(Method Reference)
    //In Method Reference we use existing Java Methods or Methods created by us
    //Syntax of Method Reference ==> Class Name + :: + Method Name
    public static void printElFunctional(List<Integer> l){
        l.stream().forEach(Utils::printWithSpace);
    }

    //2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(Functional)
    public static void printEvenFunctional(List<Integer> l){
        l.stream().filter(Utils::checkToBeEven).forEach(Utils::printWithSpace);
    }

    //3)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements.
    public static void printSquareOdds(List<Integer> l){
        l.stream().filter(Utils::checkToBeOdd).map(Utils::getSquare).forEach(Utils::printWithSpace);
    }

}
