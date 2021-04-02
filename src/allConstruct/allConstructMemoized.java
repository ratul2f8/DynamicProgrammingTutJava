package allConstruct;
//m = target.length;
//n = wordBank/length
//time complexity: O(n^m)
//space complexity: O(m)
import java.util.*;
import java.util.stream.Collectors;

public class allConstructMemoized {
    static HashMap<String, List<List<String>>> hashMap = new HashMap<>();

    static List<List<String>> getPossibleCombinations(String target, List<String> wordBank) {
        if (hashMap.containsKey(target)) return hashMap.get(target);
        if (target.equals(""))
            return Arrays.stream(new String[][]{{}}).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> possibleCombinations = new ArrayList<>();
        for (String word : wordBank) {
            //List<List<String>> eachPossibleCombo = new ArrayList<>();
            if (target.startsWith(word)) {
                String remaining = target.substring(word.length());
                var remainingResult = getPossibleCombinations(remaining, wordBank);
                if (remainingResult.size() != 0) {
                    for (var i = 0; i < remainingResult.size(); i++) {
                        List<String> toPush = new ArrayList<>();
                        toPush.add(word);
                        toPush.addAll(remainingResult.get(i));
                        possibleCombinations.add(toPush);
                    }
                }
            }
        }
        hashMap.put(target, possibleCombinations);
        return possibleCombinations;
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the target-word: ");
        var target = input.nextLine();
        System.out.println("Enter the words of the word-bank array separated by space: ");
        String wordBankStr = input.nextLine();
        List<String> wordBank = Arrays.stream(wordBankStr.split(" ")).collect(Collectors.toList());
        System.out.println("Possible combination: " + getPossibleCombinations(target, wordBank));
        System.out.println(hashMap);
    }
}
