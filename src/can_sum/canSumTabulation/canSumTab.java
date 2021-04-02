package can_sum.canSumTabulation;

import java.util.*;
import java.util.stream.Collectors;
//m = target.length
//n = numberBank.length
//time complexity = O(mn);
//spcae complexity = O(m);
public class canSumTab {
    static Boolean isPossible(Integer target, List<Integer> numbers){
        List<Boolean> list = new ArrayList<>(Collections.nCopies(target+1, false));
        //target 0 -> true;
        list.set(0, true);
        for(var i = 0; i <= target; i++){
            for(var number: numbers){
                //if current element is true
                if(list.get(i)){
                    //if indexes are not overflowing
                    if((number+i) <= target){
                        list.set(number+i, true);
                    }
                }
            }
        }
        return list.get(target);
    }
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the target word: ");
        var target = input.nextInt();
        System.out.println("Enter the numbers of the number-bank array separated space: ");
        input.nextLine();
        String numberBankStr = input.nextLine();
        List<Integer> numberBank = Arrays.stream(numberBankStr.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Is Possible: " + isPossible(target, numberBank));
    }
}
