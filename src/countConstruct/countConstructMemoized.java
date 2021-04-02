package countConstruct;
//complexities are same as canContruct
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class countConstructMemoized{
    static Scanner input = new Scanner(System.in);
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static Integer countConstruct(String target,List<String> wordBank){
        if(hashMap.containsKey(target)) return hashMap.get(target);
        if(target.equals("")) return 1;
        var possibleWaysToConstruct = 0;
        for(String word: wordBank){
            if(target.startsWith(word)){
                String remaining = target.substring(word.length());
                Integer remainingPossible = countConstruct(remaining, wordBank);
                if(remainingPossible != 0){
                    possibleWaysToConstruct += remainingPossible;
                }
            }
        }
        hashMap.put(target, possibleWaysToConstruct);
        return possibleWaysToConstruct;
    }

    public static void main(String[] args) {
        System.out.println("Enter the target word: ");
        String target = input.nextLine();
        System.out.println("Enter the words of the word-bank array separated by space:");
        String wordBankStr = input.nextLine();
        List<String> wordBank = Arrays.stream(wordBankStr.split(" "))
                .collect(Collectors.toList());
        System.out.println("Number of ways: " + countConstruct(target, wordBank));
    }
}
