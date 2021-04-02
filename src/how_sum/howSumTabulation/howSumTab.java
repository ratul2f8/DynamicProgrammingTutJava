package how_sum.howSumTabulation;

import java.util.*;
import java.util.stream.Collectors;
//m = target
//n = numberBank.length
//time complexity = O(m^2*n)
//space complexity = O(m^2)
public class howSumTab {
    static List<Integer> getCombination(Integer target, List<Integer> numbers){
        List<List<Integer>> list = new ArrayList<>(Collections.nCopies(target+1, null));
        //set teh base case target = 0 -> []
        list.set(0, new ArrayList<>());
        for(var i = 0; i <= target; i++){
            var currentElement = list.get(i);
            if(currentElement != null){
                for(var number: numbers){
                    //if index is not overflowing
                    if((number+i) <= target){
                        list.set(number+i, new ArrayList<>(currentElement));
                        list.get(number+i).add(number);
                    }
                }
            }
        }
        return list.get(target);
    }
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the target-number: ");
        var target = input.nextInt();
        System.out.println("Enter the numbers of the numberBanks array separated by space:");
        input.nextLine();
        String numbersBankStr = input.nextLine();
        List<Integer> numbersBank = Arrays.stream(numbersBankStr.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Possible combination: " + getCombination(target, numbersBank));
    }
}
