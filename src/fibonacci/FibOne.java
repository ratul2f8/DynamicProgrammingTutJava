package fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

//get nth number of fibonacci
public class FibOne {
    //recursion
    public static BigInteger getFib(BigInteger fact) {
        //equal == 0
        //greater == 1
        //smaller == -1
        if (fact.compareTo(new BigInteger("2")) == 1) {
            return getFib(fact.subtract(new BigInteger("1")))
                    .add(getFib(fact.subtract(new BigInteger("2"))));
        }
        return new BigInteger("1");
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number : ");
        String fact = input.nextLine();
        //brute-force
        var result = new BigInteger("1");
        var prev1 = new BigInteger("1");
        var prev2 = new BigInteger("1");
        for (int i = 1; i <= Integer.parseInt(fact); i++) {
            if (i > 2) {
                result = prev1.add(prev2);
                prev1 = prev2;
                prev2 = result;
            }
        }
        System.out.println(fact + "th number in fibonacci series  is : " + result);
        System.out.println(fact + "th number in fibonacci series  is : " + getFib(new BigInteger(fact)));
    }
}
