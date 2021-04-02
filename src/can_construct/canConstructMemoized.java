package can_construct;
//m = target.length
//n = wordBank.length
//time complexity = O(n* m^2)
//space complexity = O(m^2)
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class canConstructMemoized {
    static Scanner input = new Scanner(System.in);
    static HashMap<String, Boolean> hashMap = new HashMap<>();
    static boolean canConstruct(String target, List<String> wordBank){
        if(target.equals("")) return true;
        if(hashMap.containsKey(target)) return hashMap.get(target);
        for(String word: wordBank){
            if(target.startsWith(word)){
                String remainder = target.substring(word.length());
                if(canConstruct(remainder, wordBank)){
                    hashMap.put(target, true);
                    return true;
                }

            }
        }
        hashMap.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter the target word : ");
        String target = input.nextLine();
        System.out.println("Enter the words of word-bank array separated by space: ");
        String wordsStr = input.nextLine();
        List<String> wordsList = Arrays.stream(wordsStr.split(" ")).collect(Collectors.toList());
        System.out.println("Can construct? " + canConstruct(target, wordsList));
        System.out.println("Hashmap" + hashMap);
    }
}
//enterapotentpot
//a p ent enter ot o t