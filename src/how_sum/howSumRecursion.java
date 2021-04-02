package how_sum;

import java.util.*;
import java.util.stream.Collectors;

public class howSumRecursion {
    static Scanner input = new Scanner(System.in);

    static List<Integer> howSum(Integer targetSum, List<Integer> numbers){
        //base case -> if the target sum is 0 then return an empty array to the parent
        //then the parent will add the edge(number) to the empty array
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        for(Integer num: numbers){
            var remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, numbers);
            if(remainderResult != null){
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println("Enter target sum : ");
        var targetSum = input.nextInt();
        System.out.println("Enter array of numbers separated by space : ");
        input.nextLine();
        var numbersStr = input.nextLine();
        List<Integer> numbers = Arrays.stream(numbersStr.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Possible combination for getting the target sum "
        + targetSum + " from numbers " + numbersStr + " is -> " +
                howSum(targetSum, numbers));
    }
}
