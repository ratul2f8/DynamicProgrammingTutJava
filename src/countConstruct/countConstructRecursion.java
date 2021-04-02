package countConstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class countConstructRecursion {
    static Scanner input = new Scanner(System.in);
    static Integer countConstruct(String target, List<String> wordBank) {
        if (target.equals("")) return 1;
        int totalPossibleWays = 0;
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String remaining = target.substring(word.length());
                var possibleWays = countConstruct(remaining, wordBank);
                if (possibleWays != 0) {
                    totalPossibleWays += possibleWays;
                }
            }
        }
        return totalPossibleWays;
    }

    public static void main(String[] args) {
        System.out.println("Enter the target-word: ");
        String target = input.nextLine();
        System.out.println("Enter the words of word-bank separated by space: ");
        String wordBankStr = input.nextLine();
        List<String> wordBank = Arrays.stream(wordBankStr.split(" ")).collect(Collectors.toList());
        System.out.println("Total possible ways: " + countConstruct(target, wordBank));
    }
}

//purple
//purp p ur le purpl
// 2