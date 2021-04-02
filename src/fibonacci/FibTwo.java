package fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

//memoization
public class FibTwo {
    //hash map for value to store
    public static HashMap<BigInteger, BigInteger> hashObj = new HashMap<BigInteger, BigInteger>();
    //recursion
    public static BigInteger getFib(BigInteger num){
        if(num.compareTo(new BigInteger("2")) == 1){
            //if exists
            if(hashObj.containsKey(num)){
                return hashObj.get(num);
            }
            //if not exists
            else{
                //get the result
                BigInteger toPush =  getFib(num.subtract(new BigInteger("1")))
                                     .add(getFib(num.subtract(new BigInteger("2"))));
                //store the result
                hashObj.put(num, toPush);
                //return the result
                return hashObj.get(num);
            }
        }
        return new BigInteger("1");
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter number: ");
        String s = input.nextLine();
        System.out.println(s + "th number in fibonacci series is: " + getFib(new BigInteger(s)));
        System.out.println("Hashed object is: -> ");
        //print the hash map
        System.out.println(hashObj);
    }
}
