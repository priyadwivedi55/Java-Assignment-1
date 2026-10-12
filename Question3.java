import java.util.Scanner;

public class Question3 {

    static void display(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\\t");
            }
            System.out.println();
        }
    }

    static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    static boolean isSquare(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    static boolean isDiagonal(int[][] matrix) {
        if (!isSquare(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isIdentity(int[][] matrix) {
        if (!isSquare(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                }
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of Matrix A: ");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();

        System.out.print("Enter rows and columns of Matrix B: ");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();

        if (rowsA <= 0 || colsA <= 0 || rowsB <= 0 || colsB <= 0) {
            System.out.println("Rows and columns must be positive.");
            sc.close();
            return;
        }

        int[][] a = new int[rowsA][colsA];
        int[][] b = new int[rowsB][colsB];

        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        if (rowsA == rowsB && colsA == colsB) {
            int[][] sum = new int[rowsA][colsA];
            int[][] difference = new int[rowsA][colsA];

            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsA; j++) {
                    sum[i][j] = a[i][j] + b[i][j];
                    difference[i][j] = a[i][j] - b[i][j];
                }
            }

            System.out.println("\\nAddition (A + B):");
            display(sum);
            System.out.println("Subtraction (A - B):");
            display(difference);
        } else {
            System.out.println("Addition and subtraction require equal dimensions.");
        }

        if (colsA == rowsB) {
            int[][] product = new int[rowsA][colsB];

            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        product[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            System.out.println("Multiplication (A x B):");
            display(product);
        } else {
            System.out.println("Multiplication is not possible for these dimensions.");
        }

        System.out.println("Transpose of Matrix A:");
        display(transpose(a));

        System.out.println("Transpose of Matrix B:");
        display(transpose(b));

        System.out.println("Matrix A is square: " + isSquare(a));
        System.out.println("Matrix B is square: " + isSquare(b));
        System.out.println("Matrix A is diagonal: " + isDiagonal(a));
        System.out.println("Matrix B is diagonal: " + isDiagonal(b));
        System.out.println("Matrix A is identity: " + isIdentity(a));
        System.out.println("Matrix B is identity: " + isIdentity(b));

        sc.close();
    }
}
