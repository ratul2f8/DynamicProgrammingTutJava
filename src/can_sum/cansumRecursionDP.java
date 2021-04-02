package can_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cansumRecursionDP {
    static HashMap<Integer, Boolean> hashMap = new HashMap<>();

    static boolean canSum(int targetSum, List<Integer> numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (var number : numbers) {
            var remainder = targetSum - number;
            if (hashMap.containsKey(remainder)) {
                return hashMap.get(remainder);
            } else {
                var toPush = canSum(remainder, numbers);
                hashMap.put(remainder, toPush);
                return hashMap.get(remainder);
            }
        }
        return false;
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter target sum");
        var targetSum = input.nextInt();
        System.out.println("Enter the list of numbers separated by space : ");
        input.nextLine();
        var numberStr = input.nextLine();
        List<Integer> numbers = Arrays.asList(numberStr.split(" "))
                .stream().map(el -> Integer.parseInt(el))
                .collect(Collectors.toList());
        System.out.println("Can we get the sum " + targetSum + " from the list: " + numberStr + "? -> "
                + canSum(targetSum, numbers));
        System.out.println("HashMap -> \n" + hashMap);
    }
}
