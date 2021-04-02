package can_construct;
//m = target.length
//n = wordBank.length
//time complexity = O(n^m * m)
//space complexity = O(m^2)
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class canConstructRecursion {
    static Scanner input = new Scanner(System.in);

    static boolean canConstruct(String target, List<String> words){
        if(target.equals("")) return true;
        for(String word: words){
            if(target.startsWith(word)){
                String remaining = target.substring(word.length());
                if(canConstruct(remaining, words)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter word to construct");
        String word = input.nextLine();
        System.out.println("Enter the phrases separated by space: ");
        String phrases = input.nextLine();
        List<String> phrasesList = Arrays.stream(phrases.split(" "))
                .collect(Collectors.toList());
        System.out.println("Is possible: " + canConstruct(word, phrasesList));
    }
}
