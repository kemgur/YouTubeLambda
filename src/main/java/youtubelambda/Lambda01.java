package youtubelambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {

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

        printElementsStructured(l);
        System.out.println();
        printElementsFunctional(l);
        System.out.println();
        printEvensStructured(l);
        System.out.println();
        printEvensFunctional(l);
        System.out.println();
        printSquaresOfOdds(l);
        System.out.println();
        printDistinctSquaresOfOdds(l);
        System.out.println();
        System.out.println(sumOfSquaresOfEvens(l));
        System.out.println();
        System.out.println(prodOfCubeOfEvens(l));
        System.out.println();
        System.out.println(maxElement(l));
        System.out.println();
        System.out.println(minElement(l));
        System.out.println();
        System.out.println(diffMaxMin(l));
        System.out.println();
        sortElementsAsc1(l);
        System.out.println();
        sortElementsAsc2(l);
        System.out.println();
        sortElementsDesc(l);
    }

    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.
    public static void printElementsStructured(List<Integer> l) {
        for(Integer w : l) {
                System.out.print(w + " ");
        }
    }
    //1)Create a method to print the list elements on the console in the same line with a space between two consecutive elements.
    // ( stream() + forEach() )
    public static void printElementsFunctional(List<Integer> l) {
        l.stream().forEach(t->System.out.print(t + " "));
    }

    //2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.
    public static void printEvensStructured(List<Integer> l) {
        for(Integer w : l) {
            if(w%2==0) {
                System.out.print(w + " ");
            }
        }
    }
    //2)Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.
    //( stream() + filter() + forEach() )
    public static void printEvensFunctional(List<Integer> l) {
        l.stream().filter(t->t%2==0).forEach(t->System.out.print(t + " "));
    }

    //3)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements.
    //( stream() + filter() + map() + forEach() )
    public static void printSquaresOfOdds(List<Integer> l) {
        l.stream().filter(t->t%2!=0).map(t->t*t).forEach(t->System.out.print(t + " "));
    }

    //4)Create a method to print the cube of distinct odd list elements on the console in the same line with a space between two consecutive elements.
    //( stream() + distinct() + filter() + map() + forEach() )
    public static void printDistinctSquaresOfOdds(List<Integer> l) {
        l.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t->System.out.print(t + " "));
    }

    //5)Create a method to calculate the sum of the squares of distinct even elements
    //( stream() + distinct() + filter() + map() + reduce() )
    public static int sumOfSquaresOfEvens(List<Integer> l) {
        int sum = l.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0, (x,y)->x+y);
        return sum;
    }

    //6)Create a method to calculate the product of the cubes of distinct even elements
    //( stream() + distinct() + filter() + map() + reduce() )
    public static int prodOfCubeOfEvens(List<Integer> l) {
        int prod = l.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(x,y)->x*y);
        return prod;
    }

    //7)Create a method to calculate the maximum element in the list
    //( stream() + reduce() )
    public static Integer maxElement(List<Integer> l) {
        return l.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x : y);
    }

    //8)Create a method to calculate the minimum element in the list
    //( stream() + reduce() )
    public static Integer minElement(List<Integer> l){
        return l.stream().reduce(Integer.MAX_VALUE, (x,y)->x<y ? x : y);
    }

    //9)Create a method to calculate the difference between the maximum and minimum elements in the list
    //( stream() + reduce() )
    public static Integer diffMaxMin(List<Integer> l){
        Integer max = l.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x : y);
        Integer min = l.stream().reduce(Integer.MAX_VALUE, (x,y)->x<y ? x : y);
        return max - min;
    }

    //10)Create a method to sort list elements in ascending order
    //( stream() + sorted() +  forEach() )
    public static void sortElementsAsc1(List<Integer> l){
        l.stream().sorted().forEach(t-> System.out.print(t + " "));
    }
    public static void sortElementsAsc2(List<Integer> l){
        l.stream().sorted(Comparator.naturalOrder()).forEach(t-> System.out.print(t + " "));
    }

    //11)Create a method to sort list elements in descending order
    //( stream() + sorted() +  forEach() )
    public static void sortElementsDesc(List<Integer> l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t + " "));
    }
}
