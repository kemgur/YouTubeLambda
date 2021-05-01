package youtubelambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Fp04 {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>();
            l.add("Ali");
            l.add("Mark");
            l.add("Amanda");
            l.add("Christopher");
            l.add("Jackson");
            l.add("Mariano");
            l.add("Alberto");
            l.add("Tucker");
            l.add("Benjamin");

        printUpperCase3(l);
    }

    //1) Create a method tp print all list elements in uppercase
    //1.Way: Lambda Expression
    public static void printUpperCase1(List<String> list){
        list.stream().map(t->t.toUpperCase()).forEach(Utils::printWithSpace);
    }
    //2.Way: Method Reference
    public static void printUpperCase2(List<String> list){
        list.stream().map(String::toUpperCase).forEach(Utils::printWithSpace);
    }
    //3.Way: Without stream()
    public static void printUpperCase3(List<String> list){
        list.replaceAll(String::toUpperCase);
        System.out.println(list);
    }

    //2) Create a method to print the elements after ordering according to their lengths
    //1.Way: Lambda Expression
    public static void sortLengthEl1(List<String> list){
        list.stream().sorted(Comparator.comparing(t->t.length())).forEach(Utils::printWithSpace);
    }
    //2.Way: Method Reference
    public static void sortLengthEl2(List<String> list){
        list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::printWithSpace);
    }

    //3) Create a method to sort the distinct elements by using their last characters
    //1.Way: Lambda Expression
    public static void distinctSortedLastChar(List<String> list){
        list.stream().distinct().sorted(Comparator.comparing(t->t.substring(t.length()-1))).forEach(Utils::printWithSpace);
    }

    //4) Create a method to sort the elements according to their lengths and according to their first character
    //1.Way: Lambda Expression
    public static void sortLengthInitial1(List<String> list){
        list.
                stream().
                sorted(Comparator.
                        comparing(t->t.toString().length()).
                        thenComparing(t->t.toString().substring(0,1))).
                forEach(Utils::printWithSpace);
    }
    //2.Way: Method Reference
    public static void sortLengthInitial2(List<String> list){
        list.
                stream().
                sorted(Comparator.
                        comparing(String::length).
                        thenComparing(String::compareTo)).
                forEach(Utils::printWithSpace);
    }

    //5) Remove the elements if the length of the element is greater than 5
    //1.Way: Lambda Expression
    public static void removeGreaterThanFive(List<String> list){
        list.removeIf(t->t.length()>5);
        System.out.println(list);
    }

    //6) Remove the elements if the element is starting with 'A', 'a' or ending with 'N', 'n'
    public static void removeAorN(List<String> list){
        list.removeIf(t->t.toUpperCase().startsWith("A") || t.toUpperCase().endsWith("N"));
        System.out.println(list);
    }

    //7) Create a method to print the elements with lengths in the following format. Sort the elements according to the lengths.
    //  Ali: 3        Mark: 4     Amanda: 6     etc.
    //1.Way: Method Reference
    public static void lengthNameSort(List<String> list){
        list.
                stream().
                sorted(Comparator.comparing(String::length)).
                map(t->t + ": " + t.length()).
                forEach(Utils::printWithSpace);
    }

    //8) Create a method which takes the square of the length of every element, prints them distinctly in reverse order if the square is greater than 20.
    public static void squareReversed(List<String> list){
        list.
                stream().
                map(t->t.length()*t.length()).
                filter(t->t>20).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(Utils::printWithSpace);
    }

    //9) Create a method to check if the lengths of all elements are less than 8
    public static void checkLength(List<String> list){
        boolean result = list.stream().allMatch(t->t.length()<8);
        System.out.println(result);
    }

    //10) Create a method to check if the initial of any element is not 'X'
    public static void checkInitials(List<String> list){
        boolean result = list.stream().noneMatch(t->t.startsWith("X"));
        System.out.println(result);
    }

    //11) Create a method to check if at least one of the elements ending with "r"
    public static void checkLastChar(List<String> list){
        boolean result = list.stream().anyMatch(t->t.endsWith("r"));
        System.out.println(result);
    }

    //12) Create a method to get the first element after sorting the elements by using their second last character
    public static void getFirstAfterSort(List<String> list){
        Optional<String> firstEl = list.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-2))).findFirst();
        System.out.println(firstEl);
    }

    //13) Create a method to get the last element after sorting the elements by using their length
    public static void getLastAfterSort(List<String> list){
        Optional<String> lastEl = list.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).findFirst();
        System.out.println(lastEl);
    }

}
