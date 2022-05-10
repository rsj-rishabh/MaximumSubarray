import java.util.Random;
import java.util.Scanner;

public class task3a {
    int dp = Integer.MIN_VALUE;
    int leftPoint = 0;
    int rightPoint = 0;

    public int findMaximumSum (int i, int[] arr) {
        if (i == arr.length-1) {
            if (arr[i] > dp) {
                dp = arr[i];
                rightPoint = i;
            }
            return arr[i];
        }
        int currentSum = 0;
        int tmp = arr[i] + findMaximumSum(i+1, arr);
        if (arr[i] > tmp) {
            currentSum = arr[i];
            if (currentSum > dp) {
                dp = currentSum;
                leftPoint = i;
                rightPoint = i;
            }
        } else {
            currentSum = tmp;
            if (currentSum > dp) {
                dp = currentSum;
                leftPoint = i;
            }
        }
        return currentSum;
    }

    void logic (int[] arr) {
        // calling recursion function
        int sum = findMaximumSum(0, arr);
        if (sum > dp) {
            dp = sum;
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