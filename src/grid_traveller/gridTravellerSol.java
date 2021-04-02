package grid_traveller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class gridTravellerSol {
    static Scanner input = new Scanner(System.in);

    static String getPairString(String row, String column) {
        return "(" + row + "," + column + ")";
    }

    static int compareBigIntegers(String num, String toCompare) {
        return new BigInteger(num).compareTo(new BigInteger(toCompare));
    }

    static String subtractTwoString(String num, String toSubtract) {
        int result = Integer.parseInt(num) - Integer.parseInt(toSubtract);
        return Integer.toString(result);
    }

    static HashMap<String, BigInteger> hashObj = new HashMap<String, BigInteger>();

    static BigInteger getNumberOfPaths(String row, String column) {
        //if any of the parameters becomes 0 or invalid
        if ((compareBigIntegers(row, "0") == 0) || (compareBigIntegers(column, "0") == 0)) {
            return new BigInteger("0");
        }
        //if get our base case (1,1)
        if ((compareBigIntegers(row, "1") == 0) && (compareBigIntegers(column, "1") == 0)) {
            return new BigInteger("1");
        }
        if(hashObj.containsKey(getPairString(row, column))) {
            return hashObj.get(getPairString(row, column));
        } else {
            //toPush = gridSize after right move + grid size after down move
            BigInteger toPush = getNumberOfPaths(row, subtractTwoString(column, "1"))
                    .add(getNumberOfPaths(subtractTwoString(row, "1"), column));
            hashObj.put(getPairString(row, column), toPush);
            return hashObj.get(getPairString(row, column));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of rows: ");
        var rows = input.nextLine();
        System.out.println("Enter number of columns: ");
        var columns = input.nextLine();
        System.out.println("Number of reaching to bottom-right corner from left-right corner of a " +
                getPairString(rows, columns) + " grid is/are -> " + getNumberOfPaths(rows, columns));
        System.out.println("Hashed Object : ");
        System.out.println(hashObj);
    }
}
