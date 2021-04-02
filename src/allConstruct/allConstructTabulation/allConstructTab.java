package allConstruct.allConstructTabulation;

import java.util.*;
import java.util.stream.Collectors;
//m = target.length
//n = wordBank.length
//time complexity = O(n^m)
//space complexity = O(n^m)
public class allConstructTab {
    static List<List<String>> getAllPossibleCombination(String target, List<String> wordBank){
        //[[[]],[]]
        List<List<List<String>>> list = new ArrayList<>();
        for(var i = 0; i <= target.length(); i++){
            if(i == 0){
                list.add(new ArrayList<>());
                list.get(0).add(new ArrayList<>());
            }else {
                list.add(new ArrayList<>());
            }
        }
        for(var i = 0;i < list.size(); i++){
            var currentList = list.get(i);
            if(currentList.size() != 0){
                for(var word: wordBank){
                    if(target.substring(i).startsWith(word)){
                        var toAdd = new ArrayList<>(currentList);
                        for(var j = 0;j < currentList.size(); j++){
                            List<String> li = new ArrayList<>();
                            li.addAll(toAdd.get(j));
                            li.add(word);
                            toAdd.set(j, li);
                        }
                        list.get(i+word.length()).addAll(toAdd);
                    }
                }
            }
        }
        return list.get(target.length());
    }

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the target-word: ");
        var target = input.nextLine();
        System.out.println("Enter the words of the word-bank arrays separated by space: ");
        var wordBankStr = input.nextLine();
        List<String> wordBank = Arrays.stream(wordBankStr.split(" ")).collect(Collectors.toList());
        System.out.println("Possible Combinations: " + getAllPossibleCombination(target, wordBank));
    }
}
