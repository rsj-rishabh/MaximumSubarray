import java.util.Random;
import java.util.Scanner;

class task2 {
    void logic (int[] arr) {
        // defining a 2D array to store sum of all possible subarrays
        int n = arr.length;
        int[][] dp = new int[n][n];

        // first loop to specify left pointer
        for (int left=0; left<n; left++) {
            dp[left][left] = arr[left];
            // second loop to specify right pointer
            for (int right=left+1; right<n; right++) {
                dp[left][right] = dp[left][right-1] + arr[right];
            }
        }
        
        // defining a result variables
        int maxSum = Integer.MIN_VALUE;
        int leftPoint = -1;
        int rightPoint = -1;

        // searching answer in dp array
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (dp[i][j] > maxSum) {
                    maxSum = dp[i][j];
                    leftPoint = i;
                    rightPoint = j;
                }
            }
        }

        // print the answer
        System.out.println(leftPoint+" "+rightPoint+" "+maxSum);
    }

    void solve () {
        // reading inputs
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt( scan.nextLine() );
        String stdInput = scan.nextLine();
        scan.close();

        // converting input string to array of numbers
        String[] splitInput = stdInput.split("\\s");
        int[] input = new int[n]; 
        for (int i=0; i<n; i++) {
            input[i] = Integer.parseInt( splitInput[i] );
        }

        // code logic
        logic(input);
    }

    void test (int n) {
        // creating Random object
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }

        // code logic
        long startTime = System.nanoTime();
        logic(arr);
        long endTime = System.nanoTime();
        System.out.println("Executed in "+(endTime - startTime)+" nanoseconds.");
    }
}