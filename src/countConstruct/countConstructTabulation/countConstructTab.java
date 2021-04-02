package countConstruct.countConstructTabulation;

import java.util.*;
import java.util.stream.Collectors;
//m = target.length
//n = wordBank.length
//time complexity: O(m^2*n)
//space complexity: O(m)
public class countConstructTab {
    static Integer getPossibleCounts(String target, List<String> wordBank){
        List<Integer> list = new ArrayList<>(Collections.nCopies(target.length()+1, 0));
        //set the base case to 1
        list.set(0, 1);
        for(var i = 0; i <= target.length(); i++){
            var currentValue = list.get(i);
            if(currentValue != 0){
                for(var word: wordBank){
                    if(target.substring(i).startsWith(word)){
                        var val = list.get(i+word.length());
                        val += currentValue;
                        list.set( i + word.length(), val);
                    }
                }
            }
        }
        //System.out.println(list);
        return list.get(target.length());
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the target word: ");
        var target = input.nextLine();
        System.out.println("Enter the words of the word-bank array separated by space: ");
        var wordBankStr = input.nextLine();
        List<String> wordBank = Arrays.stream(wordBankStr.split(" ")).collect(Collectors.toList());
        System.out.println("Possible ways: " + getPossibleCounts(target, wordBank));
    }
}
//purple
//purp p ur le purpl
//2
//enterapotentpot
//a p ent enter ot o t
//4