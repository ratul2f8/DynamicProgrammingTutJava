package stairCase;

import java.util.*;
import java.util.stream.Collectors;
//tutorial followed: https://www.youtube.com/watch?v=5o-kdjv7FD0
//consider converting Integer to BigInteger for larger possible values;
public class staircaseProblem {
    static Scanner input = new Scanner(System.in);
    //Memoize the solution
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static Integer getTotalNumberOfPossibleMoves(Integer stairs, List<Integer> moves) {
        if(hashMap.containsKey(stairs)) return hashMap.get(stairs);
        if (stairs == 0) return 1;
        var possibleMoves = 0;
        for (Integer move : moves) {

            if (stairs >= move) {
                var remaining = stairs - move;
                var remainingResult = getTotalNumberOfPossibleMoves(remaining, moves);
                if (remainingResult != 0) {
                    possibleMoves += remainingResult;
                }
            }

        }
        hashMap.put(stairs, possibleMoves);
        return possibleMoves;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of stairs");
        var stairs = input.nextInt();
        System.out.println("Enter how many steps possible ca be taken separated by space: ");
        //ie: 1 3 5
        input.nextLine();
        String possibleMovesStr = input.nextLine();
        List<Integer> possibleMoves = Arrays.stream(possibleMovesStr.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //List<Integer> possibleMoves = new ArrayList<>(Arrays.asList(1, 2));
        System.out.println("Possible moves: " + getTotalNumberOfPossibleMoves(stairs, possibleMoves));
    }
}
