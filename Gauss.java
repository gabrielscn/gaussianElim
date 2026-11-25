import java.util.Arrays;

public class Gauss {

    static void gaussianElimination(double[][] a){
        int row = 0;
        int rows = a.length;
        int cols = a[0].length;

        for(int col = 0; col < cols - 1; col++){
            int pivot = row;

            //finding maximum element
            for (int i = row + 1; i < rows; i++){
                if(Math.abs(a[i][col]) > Math.abs(a[pivot][col])){
                    pivot = i;
                }
            }

            if(a[pivot][col] == 0){
                System.out.println("The matrix is singular");
                continue;
            }

            if(row != pivot){
                swapRow(a, row, pivot);
            }

            for(int i = row + 1; i < rows; i++){
                double scale = a[i][col]/a[row][col];
                for(int j = col + 1; j < cols; j++){

                    a[i][j] -= a[row][j] * scale;
                }
                a[i][col] = 0;
            }

            row++;
        }
    };

    static double[] backSubstitution(double[][] a){
        int rows = a.length;
        int cols = a[0].length;

        double[] solution = new double[rows];

        for (int i = rows - 1; i >= 0; i--){
            double sum = 0;
            for(int j  =cols - 2; j > i; j--){
                sum += solution[j] * a[i][j];
            }
            solution [i] = (a[i][cols - 1] - sum) / a[i][i];

        }

        return solution;
    };

    static void swapRow(double[][] a, int rowA, int rowB){
        double[] temp = a[rowA];
        a[rowA] = a[rowB];
        a[rowB] = temp;
    }

    public static void main(String[] args) {
        double[][] a = {
            {3, 2, -4, 3},
            {2, 3, 3, 15},
            {5, -3, 1, 14}
        };

        gaussianElimination(a);
        System.out.println("Gaussian Elimination: ");
        Arrays.stream(a).forEach(x -> System.out.println(Arrays.toString(x)));

        System.out.println("\nSolution: ");
        System.out.println(Arrays.toString(backSubstitution(a)));
    }
}
