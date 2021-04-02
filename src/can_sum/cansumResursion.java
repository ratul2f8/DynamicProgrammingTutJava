package can_sum;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cansumResursion {
    static boolean canSum(int targetSum, List<Integer> numbers){
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;
        for(var num: numbers){
            var remainder = targetSum - num;
            if(canSum(remainder, numbers)){
                return true;
            }
        }
        return false;
    }
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter target sum : ");
        var targetSum = input.nextInt();
        System.out.println("Enter numbers array separated by space<1 2 3 4>");
        input.nextLine();
        //Get list of numbers as a string
        var numbers = input.nextLine();
        //Convert the numbers string to an integer array
        List<Integer> liNums = Arrays.asList(numbers.split(" "))
                .stream().map(el -> Integer.parseInt(el))
                .collect(Collectors.toList());
        System.out.println("Can we get the sum " + targetSum + " from the list: " + numbers + "? -> "
        + canSum(targetSum, liNums));

    }
}
