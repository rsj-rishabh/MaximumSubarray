import java.util.Scanner;
import java.util.Random;

public class task5 {
    int kadane(int arr[], int start, int end, int n)	//kadane's algorithm
    {
        int sum = 0, maximum_sum = Integer.MIN_VALUE;
        end = -1;    		//No position in the beginning
        int temp = 0;

        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            if (sum < 0)
            {
                sum = 0;
                temp = i+1;
            }
            else if (sum > maximum_sum) 		     //get maximum sum, and update start and end index
            {
                maximum_sum = sum;
                start = temp;
                end = i;
            }
        }
        if (end != -1)
            return maximum_sum;
        //when all elements are negative in the array
        maximum_sum = arr[0];
        start = end = 0;

        // Find the maximum element in array
        for (int i = 1; i < n; i++) {
            if (arr[i] > maximum_sum) {
                maximum_sum = arr[i];
                start = end = i;
            }
        }
        return maximum_sum;
    }


    void logic (int[][] matrix) {
        int left_end = 0, right_end = 0, top_end = 0, bottom_end=0;
        int maximum_sum = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l, r;
        int[] temp = new int[rows];
        int sum, start=0, end=-1;
        for (l = 0; l < cols; l++)
        {
            for(int i = 0; i<rows; i++)		//temp initially holds all 0
                temp[i] = 0;

            for (r = l; r < cols; ++r)
            {
                for (int i = 0; i < rows; ++i)    //for each row, find the sum
                    temp[i] += matrix[i][r];
                sum = kadane(temp, start, end, rows);    //find sum of rectangle (top, l) and (bottom r)

                if (sum > maximum_sum) 			 //find maximum value of sum, then update corner points
                {
                    maximum_sum = sum;
                    left_end = l;
                    right_end = r;
                    top_end = start;
                    bottom_end = end;
                }
            }
        }
        System.out.println(top_end+" "+left_end+" "+bottom_end+" "+right_end+" "+maximum_sum);
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
        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
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
