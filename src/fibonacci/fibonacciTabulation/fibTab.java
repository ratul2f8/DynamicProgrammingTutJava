package fibonacci.fibonacciTabulation;
//both space and time complexity is: O(n)
import java.math.BigInteger;
import java.util.*;

//class Person{
//    public String name;
//    public Person(String name){
//        this.name = name;
//    }
//    public Person(){
//        this.name = "John Doe";
//    }
//}
public class fibTab {
    static BigInteger strToBigInt(String num){
        return new BigInteger(num);
    }
    static BigInteger intToBigInt(Integer num){
        return new BigInteger(num.toString());
    }
    static BigInteger getFib(Integer n){
        //basically initializing the series list with (n+1) number of zeroes

        List<BigInteger> series = new ArrayList<BigInteger>(Collections.nCopies(n+1,intToBigInt(0)));
        //Tips...
        //if you wished to initialize with your own objects
        //List<Person> personSeries = Stream.generate(Person::new).limit(60).collect(Collectors.toList());
        series.set(1, intToBigInt(1));
        for (int i = 1; i <= n; i++) {
            var currentElemet = series.get(i);
            //if two or more than two items remaining
            if((n - i) >= 2 ){
                series.set(i+1, series.get(i+1).add(currentElemet));
                series.set(i+2, series.get(i+2).add(currentElemet));
            }
            //if one item remaing
            else if((n - i) == 1 ){
                series.set(i+1, series.get(i+1).add(currentElemet));
            }
        }
        return series.get(n);
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the n: ");
        Integer num = input.nextInt();
        System.out.println(num + "th number of fibonacci series is: " + getFib(num));
    }
}
