package can_construct.canConstructTabulation;

import java.util.*;
import java.util.stream.Collectors;
//m = target.length
//n = wordBank.length
//time complexity = O(m^2*n)
//space complexity = O(m)
public class canConstructTab {
    static Boolean isPossible(String target, List<String> wordBank){
        List<Boolean> list = new ArrayList<>(Collections.nCopies(target.length()+1, false));
        //set the first element to true;
        list.set(0, true);
        for(var i = 0; i <= target.length(); i++){
            var currenyElement = list.get(i);
            //if our current-element is zero
            if(currenyElement){
                for(var word: wordBank){
                    if(target.substring(i).startsWith(word)){
                        list.set(i+word.length(), true);
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
        List<String> wordBank = Arrays.stream(wordBankStr.split(" "))
                .collect(Collectors.toList());
        System.out.println("Is Possible: " + isPossible(target, wordBank));
    }
}
//abcdef
//ab abc cd def abcd
