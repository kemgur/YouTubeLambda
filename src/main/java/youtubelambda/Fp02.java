package youtubelambda;

import java.util.*;
import java.util.stream.Collectors;

public class Fp02 {

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

                System.out.println(getMaxValue(l));
                System.out.println(getMaxWithSort(l));
                System.out.println(getMinValue(l));
                System.out.println(getMinWithSort(l));
                System.out.println(getMinGreaterThanSevenEvenEl(l));
                System.out.println(getHalfDistinctReverseEl(l));

        }

        //1)Create a method to find the maximum value from the list elements
        //1.Way:
        public static int getMaxValue(List<Integer> l) {
                return l.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
        }
        //2.Way:
        public static int getMaxWithSort(List<Integer> list){
                return list.stream().sorted().reduce(Integer.MIN_VALUE, (x, y)->y);
        }

        //2)Create a method to find the minimum value from the list elements
        //1.Way:
        public static int getMinValue(List<Integer> l) {
                return l.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        }
        //2.Way:
        public static int getMinWithSort(List<Integer> list){
                return list.stream().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (x, y)->y);
        }

        //3)Create a method to find the minimum value which is greater than 7 and even from the list
        public static int getMinGreaterThanSevenEvenEl(List<Integer> list){
                return list.stream().filter(t->(t>7 && t%2==0)).reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        }

        //4)Create a method to find the half of the elements which are distinct and greater than 5 in reverse order from the list.
        public static List getHalfDistinctReverseEl(List<Integer> list){
                return list.stream().distinct().filter(t->t>5).map(t->t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }

}
