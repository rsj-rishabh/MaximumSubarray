import java.util.Random;
import java.util.Scanner;

public class task4 {
    void logic (int[][] matrix) {
        // stores corner positions of the answer
        int x1=0, y1=0, x2=0, y2=0;

        // Stores maximum submatrix sum
        int maxSubmatrix = 0;

        // get size of matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {                // Take each row as starting row
            for (int j = 0; j < cols; j++) {            // Take each column as the starting column
                for (int k = i; k < rows; k++) {        // Take each row as the ending row
                    for (int l = j; l < cols; l++) {    // Take each column as the ending columnn
                        int sumSubmatrix = 0;           //topleft index(i, j) and bottom right index (k, l)
                        for (int m = i; m <= k; m++) {
                            for (int n = j; n <= l; n++) {
                                sumSubmatrix += matrix[m][n];
                            }
                        }
                        if(maxSubmatrix<sumSubmatrix) {
                            maxSubmatrix=sumSubmatrix;
                            x1 = i;
                            y1 = j;
                            x2 = k;
                            y2 = l;
                        }
                    }
                }
            }
        }

        //checking correctness of the code
        if(x1>x2 || y1>y2)
            System.out.println("Not correct solution");

        //printing answer
        System.out.println(+x1+" "+y1+" "+x2+" "+y2+" "+maxSubmatrix);
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
