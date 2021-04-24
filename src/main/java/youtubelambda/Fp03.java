package youtubelambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        printElements(l);
        System.out.println();
        printEvenElements(l);
        System.out.println();
        printSquareOdds(l);
        System.out.println();
        printDistinctOddCube(l);
        System.out.println();
        System.out.println(sumOfSquaresOfEvens(l));
        System.out.println(prodOfCubesOfEvens(l));
        System.out.println(getMaxValue(l));
        System.out.println(getMinValue(l));
        System.out.println(getMinGreaterThanSevenEvenEl(l));
        System.out.println(getHalfDistinctReverseEl(l));
    }

    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(Use Method Reference)
    public static void printElements(List<Integer> l){
        l.stream().forEach(Utils::printWithSpace);
    }

    //2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(Use Method Reference)
    public static void printEvenElements(List<Integer> l){
        l.stream().filter(Utils::checkToBeEven).forEach(Utils::printWithSpace);
    }

    //3)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements.(Use Method Reference)
    public static void printSquareOdds(List<Integer> l){
        l.stream().filter(Utils::checkToBeOdd).map(Utils::getSquare).forEach(Utils::printWithSpace);
    }

    //4)Create a method to print the cube of distinct odd list elements on the console in the same line with a space between two consecutive elements.(Use Method Reference)
    public static void printDistinctOddCube(List<Integer> l){
        l.stream().distinct().filter(Utils::checkToBeOdd).map(Utils::getCube).forEach(Utils::printWithSpace);
    }

    //5)Create a method to calculate the sum of the squares of distinct even elements.(Use Method Reference)
    public static Integer sumOfSquaresOfEvens(List<Integer> l){
        return l.stream().distinct().filter(Utils::checkToBeEven).map(Utils::getSquare).reduce(0, Math::addExact);
    }

    //6)Create a method to calculate the product of the cubes of distinct even elements.(Use Method Reference)
    public static Integer prodOfCubesOfEvens(List<Integer> l){
        return l.stream().distinct().filter(Utils::checkToBeEven).map(Utils::getCube).reduce(1, Math::multiplyExact);
    }

    //7)Create a method to find the maximum value from the list elements.(Use Method Reference)
    public static int getMaxValue(List<Integer> l) {
        return l.stream().reduce(Integer.MIN_VALUE, Math::max);
    }

    //8)Create a method to find the minimum value from the list elements.(Use Method Reference)
    public static int getMinValue(List<Integer> l) {
        return l.stream().reduce(Integer.MAX_VALUE, Math::min);
    }

    //9)Create a method to find the minimum value which is greater than 7 and even from the list.(Use Method Reference)
    public static int getMinGreaterThanSevenEvenEl(List<Integer> list){
        return list.stream().filter(t->t>7).filter(Utils::checkToBeEven).reduce(Integer.MAX_VALUE, Math::min);
    }

    //10)Create a method to find the half of the elements which are distinct and greater than 5 in reverse order from the list.(Use Method Reference)
    public static List getHalfDistinctReverseEl(List<Integer> list){
        return list.stream().distinct().filter(t->t>5).map(Utils::getHalf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
