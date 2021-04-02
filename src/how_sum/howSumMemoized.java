package how_sum;

import java.util.*;
import java.util.stream.Collectors;

public class howSumMemoized {
    static Scanner input = new Scanner(System.in);
    static HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    static List<Integer> getSum(Integer targetSum, List<Integer> numbers) {
        if (hashMap.containsKey(targetSum)) return hashMap.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;
        for (Integer num : numbers) {
            var remainder = targetSum - num;
            var remainderList = getSum(remainder, numbers);
            if (remainderList != null) {
                remainderList.add(num);
                hashMap.put(targetSum, remainderList);
                return hashMap.get(targetSum);
            }
        }
        hashMap.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Enter target sum: ");
        var targetSum = input.nextInt();
        System.out.println("Enter numbers separated by space");
        input.nextLine();
        var numbersStr = input.nextLine();
        List<Integer> numbers = Arrays.stream(numbersStr.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Possible combination for getting the target sum "
                + targetSum + " from numbers " + numbersStr + " is -> " +
                getSum(targetSum, numbers));
    }
}
