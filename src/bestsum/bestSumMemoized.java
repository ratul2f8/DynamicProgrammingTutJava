package bestsum;

//n = branching factor(number.size()
//m = height of the tree(worst case : targetSum(1))
//time complexity = O(m^2*n)
//space complexity = O(m^2)
import java.util.*;
import java.util.stream.Collectors;

public class bestSumMemoized {
    static HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
    static List<Integer> getBestSum(Integer targetSum, List<Integer> numbers){
        if(hashMap.containsKey(targetSum)) return hashMap.get(targetSum);
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
        hashMap.put(targetSum, shortestCombo);
        return shortestCombo;
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the target-sum");
        var targetSum = input.nextInt();
        input.nextLine();
        System.out.println("Enter the numbers array separated by space: ");
        var numbersStr = input.nextLine();
        List<Integer> numbers = Arrays.stream(numbersStr.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Best Sum: " + getBestSum(targetSum, numbers));
    }
}