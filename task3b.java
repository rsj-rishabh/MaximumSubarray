import java.util.Random;
import java.util.Scanner;

public class task3b {
    void logic (int[] arr) {
        // defining a variable to store maximum sum obtained after each iteration
        int dp = arr[0];
        int currentSum = 0;
        int leftPoint = 0;
        int rightPoint = 0;
        int n = arr.length;

        // first loop to specify left pointer
        for (int i=0; i<n; i++) {
            if (currentSum < 0) {
                // if currentSum is less than zero,
                // we do not need to include the previous array
                // as adding its sum will only result in a decrement of maximum sum
                currentSum = arr[i];
                // set  dp = max(currentSum, dp)
                if (currentSum > dp) {
                    dp = currentSum;
                    leftPoint = i;
                    rightPoint = i;
                }
            } else {
                currentSum += arr[i];
                // set  dp = max(currentSum, dp)
                if (currentSum > dp) {
                    dp = currentSum;
                    rightPoint = i;
                }
            }
        }
        
        // print the answer
        System.out.println(leftPoint+" "+rightPoint+" "+dp);
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
