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
        }
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
    }
}
