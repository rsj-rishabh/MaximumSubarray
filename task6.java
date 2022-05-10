import java.util.Scanner;
import java.util.Random;

public class task6 {
    void logic (int[][] matrix) {
	
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;			//corner variables
            int mat_length = matrix.length;			//row and col variables
            int n = matrix[0].length;
            int cumulative_sum[][] = new int[mat_length + 1][n];	// temp matrix to store prefix sum
            for (int i = 0; i < mat_length; i++) {
                for (int j = 0; j < n; j++) {
                    cumulative_sum[i + 1][j] = cumulative_sum[i][j] + matrix[i][j];   	//finding cummulative prefix sum
                }
            }
            int maximum_sum = -1;
            int minimum_sum = Integer.MIN_VALUE;
            int negative_row = 0, negative_column = 0;
            int row_start = 0, row_end = 0, column_start = 0, column_end = 0;
            for (int rowStart = 0; rowStart < mat_length; rowStart++) {

                for (int row = rowStart; row < mat_length; row++) {
                    int sum = 0;				//resetting current summation after every iteration
                    int current_column_start = 0;
                    for (int column = 0; column < n; column++) {
                        sum += cumulative_sum[row + 1][column] - cumulative_sum[rowStart][column];
                        if (sum < 0) {		//if sum drops below zero, set sum to zero and continue the next iteration
                            if (minimum_sum < sum) {
                                minimum_sum = sum;
                                negative_row = row;
                                negative_column = column;
                            }
                            sum = 0;
                            current_column_start = column + 1;
                        } else if (maximum_sum < sum) {		//if current sum is greater, set corner variables for answer
                            maximum_sum = sum;
                            row_start = rowStart;
                            row_end = row;
                            column_start = current_column_start;
                            column_end = column;
                        }
                    }
                }
            }

            // Setting final corner values
            if (maximum_sum == -1) {
                x1 = negative_row;
                y1 = negative_row;
                x2 = negative_column;
                y2 = negative_column;
            }else {
                x1 = row_start;
                y1 = row_end;
                x2 = column_start;
                y2 = column_end;
            }
            System.out.println(+x1 + " " + x2 + " " + y1 + " " + y2 + " " + maximum_sum);
    }

    void solve () {	//input
        // read input from user
        Scanner scan = new Scanner(System.in);
        String dims = scan.nextLine();

        // fetch dimensions
        String[] splitDims = dims.split("\\s");
        int rows = Integer.parseInt(splitDims[0]);
        int cols = Integer.parseInt(splitDims[1]);

        // fetch matrix values
        int[][] matrix = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            String input = scan.nextLine();
            String[] splitInput = input.split("\\s");
            for (int j=0; j<cols; j++) {
                matrix[i][j] = Integer.parseInt( splitInput[j] );
            }
        }
        scan.close();
        // code logic
        logic(matrix);
    }

    void test (int n, int m) {
        Random rand = new Random();
        int[][] matrix = new int[m][n];
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = rand.nextInt(100000) -10000;
            }
        }
        // code logic
        long startTime = System.nanoTime();
        logic(matrix);
        long endTime = System.nanoTime();
        System.out.println("Executed in "+(endTime - startTime)+" nanoseconds.");
    }
}
