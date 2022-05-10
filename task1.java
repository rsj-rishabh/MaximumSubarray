import java.util.Random;
import java.util.Scanner;

class task1 {
    void logic (int[] arr) {
        // defining a result variables
        int maxSum = Integer.MIN_VALUE;
        int leftPoint = -1;
        int rightPoint = -1;
        int n = arr.length;

        // first loop to specify left pointer
        for (int left=0; left<n; left++) {
            // second loop to specify right pointer
            for (int right=left; right<n; right++) {
                // initialize a current sum variable
                int currentSum = 0;
                // third loop to calculate the sum
                for (int i=left; i<=right; i++) {
                    currentSum += arr[i];
                }
                // if current sum is greater than the maximum recorded sum,
                // assign new values to our answer
                if (currentSum > maxSum) {
                    leftPoint = left;
                    rightPoint = right;
                    maxSum = currentSum;
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