package grid_traveller.gridTravellerTabulation;
//both space and time complexity is : O(rows*columns)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class gridTravellerTab {
    static Integer getPossibleWays(Integer rows, Integer columns){
        List<List<Integer>> grid = new ArrayList<>(
                Stream.generate(() -> new ArrayList<>(Collections.nCopies(columns+1, 0)))
                        .limit(rows + 1)
                        .collect(Collectors.toList())
        );
        grid.get(1).set(1, 1);

        for(var row = 1; row <= rows; row++){
            for(var column = 1; column <= columns; column++){
                var currentElement = grid.get(row).get(column);
                //if you are in the last row and column is not the bottom right
                if((row == rows) && (column < columns)){
                    //right
                    grid.get(row).set(column+1, currentElement + grid.get(row).get(column+1));

                }
                //if you are in the last column but rows can not be iterated
                else if((column == columns) && (row < rows)){
                    //bottom
                    grid.get(row+1).set(column, currentElement + grid.get(row+1).get(column));

                }
                //if both row and columns can be iterated
                else if((column < columns) && (row < rows)){
                    //right
                    grid.get(row).set(column+1, currentElement + grid.get(row).get(column+1));
                    //bottom
                    grid.get(row+1).set(column, currentElement + grid.get(row+1).get(column));
                }
            }
        }
        //System.out.println(grid);
        return grid.get(rows).get(columns);
    }
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter number of rows: ");
        var rows = input.nextInt();
        System.out.println("Enter number of columns: ");
        var columns = input.nextInt();
        System.out.println("Possible ways to iterate: " + getPossibleWays(rows, columns));
    }
}
