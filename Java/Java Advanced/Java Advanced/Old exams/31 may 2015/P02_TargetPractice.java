import java.util.*;

public class P02_TargetPractice {
    private static String snake;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split(" ");
        snake = scanner.nextLine();
        String[] target = scanner.nextLine().split(" ");

        String[][] matrix = new String[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        fillMatrix(matrix);

        shootInMatrix(target, matrix);

        elementsFall(matrix);

        printMatrix(matrix);
    }

    private static void elementsFall(String[][] matrix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (!matrix[j][i].equals(" ")) {
                    stack.add(matrix[j][i]);
                }
            }

            for (int j = matrix.length - 1; j >= 0; j--) {
                if (stack.size() != 0) {
                    matrix[j][i] = stack.pop();
                } else {
                    matrix[j][i] = " ";
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void shootInMatrix(String[] target, String[][] matrix) {
        int centerRow = Integer.parseInt(target[0]);
        int centerCol = Integer.parseInt(target[1]);
        int radius = Integer.parseInt(target[2]);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                double d = Math.sqrt((centerRow - row) * (centerRow - row) + (centerCol - col) * (centerCol - col));
                if (d <= radius) {
                    matrix[row][col] = " ";
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix) {
        Boolean isMovingLegt = true;

        for (int row = matrix.length - 1; row >= 0; row--) {
            int col = isMovingLegt ? matrix[0].length - 1 : 0;
            int colUpdate = isMovingLegt ? -1 : 1;

            while (0 <= col && col <= matrix[0].length - 1) {
                matrix[row][col] = getsymbol();
                col += colUpdate;
            }

            isMovingLegt = !isMovingLegt;
        }
    }

    private static String getsymbol() {
        if (sb.length() == 0) {
            sb.append(snake);
        }
        String rem = sb.substring(0, 1);
        sb.delete(0, 1);
        return rem;
    }
}