class task2optimized {
    public static void main (String args[]) {
        // defining inputs
        int n = 5;
        String stdInput = "5 4 -1 7 8";

        // converting input string to array of numbers
        String[] splitInput = stdInput.split("\\s");
        int[] input = new int[n]; 
        for (int i=0; i<n; i++) {
            input[i] = Integer.parseInt( splitInput[i] );
        }

        // code logic
        // defining a result variables
        int maxSum = Integer.MIN_VALUE;
        int leftPoint = -1;
        int rightPoint = -1;

        // first loop to specify left pointer
        for (int left=0; left<n; left++) {
            int currentSum = 0;
            // second loop to specify right pointer
            for (int right=left; right<n; right++) {
                currentSum += input[right];
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
}