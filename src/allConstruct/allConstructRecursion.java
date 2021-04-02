package allConstruct;
//m = target.length;
//n = wordBank/length
//time complexity: O(n^m)
//space complexity: O(m)
import java.util.*;
import java.util.stream.Collectors;

public class allConstructRecursion {
    static List<List<String>> getCombinations(String target, List<String> wordBank) {
        if (target.equals(""))
            //[[]]
            return Arrays.stream(new String[][]{{}}).map(Arrays::asList).collect(Collectors.toList());
        List<List <String>> possibleCombinations = new ArrayList<>();//[]
        for(String word: wordBank){
            if(target.startsWith(word)){
                var remaining = target.substring(word.length());
                var remainingResult = getCombinations(remaining, wordBank);
                if(remainingResult.size() != 0){
                    for (var i = 0; i < remainingResult.size(); i++) {
                        List<String> toSet = new ArrayList<>();
                        //Since we have to push the edge(word in this case) to the front
                        toSet.add(word);
                        toSet.addAll(remainingResult.get(i));
                        possibleCombinations.add(toSet);
                    }
                }
            }
        }
        return possibleCombinations;
    }

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the target-word: ");
        String target = input.nextLine();
        System.out.println("Enter the words of the word-bank separated by space: ");
        String wordBankStr = input.nextLine();
        List<String> wordBank = Arrays.stream(wordBankStr.split(" "))
                .collect(Collectors.toList());
        System.out.println("Possible combinations: " + getCombinations(target, wordBank));

    }
}
//purple
//purp p ur le purpl
//Output: Possible combinations: [[purp, le], [p, ur, p, le]]
//abcdef
//ab abc cd def abcd ef c
//Possible combinations: [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]