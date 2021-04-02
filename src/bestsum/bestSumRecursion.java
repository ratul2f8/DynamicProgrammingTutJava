package bestsum;

import java.util.*;
import java.util.stream.Collectors;
//n = branching factor(number.size()
//m = height of the tree(worst case : targetSum(1))
//time complexity = O(n^m*m)
//space complexity = O(m^2)
public class bestSumRecursion {
    static List<Integer> getBestSum(Integer targetSum, List<Integer> numbers){
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        List<Integer> shortestCombo = null;
        for(int number: numbers){
            var remainder = targetSum - number;
            List<Integer> remainderResult = getBestSum(remainder, numbers);
            if(remainderResult != null){
                var remainderCombo = new ArrayList<>(remainderResult);
                remainderCombo.add(number);
                if((shortestCombo == null) || (shortestCombo.size() > remainderCombo.size())){
                    shortestCombo = new ArrayList<>(remainderCombo);
                }
            }
        }
        return shortestCombo;
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the target-sum: ");
        var targetSum = input.nextInt();
        input.nextLine();
        System.out.println("Enter the numbers array separated by space: ");
        var numbersStr = input.nextLine();
        List<Integer> numbers = Arrays.stream(numbersStr.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Best Sum: " + getBestSum(targetSum, numbers));
    }
}
