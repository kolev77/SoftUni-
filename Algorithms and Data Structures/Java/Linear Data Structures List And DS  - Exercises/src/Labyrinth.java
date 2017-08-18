import java.io.*;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Labyrinth {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Integer n = Integer.valueOf(br.readLine());
        String[][] lab = ReadLab(n);

        boolean[][] visited = new boolean[n][n];

        int row = 0;
        int col = 0;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lab[i][j].equals("*")) {
                    row = i;
                    col = j;
                    break;
                }
            }
            if (found)
                break;
        }

        ArrayDeque<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(row, col, true, 0));

        while (queue.size() != 0) {
            Cell current = queue.poll();
            visited[current.getRow()][current.getCol()] = true;

            row = current.getRow();
            col = current.getCol();


            if (!lab[row][col].equals("*")) {
                lab[row][col] = String.valueOf(current.getMoves());
            }

            // UP
            if (row - 1 >= 0 && !lab[row - 1][col].equals("x") && !visited[row - 1][col]) {
                queue.add(new Cell(row - 1, col, false, current.Moves + 1));
            }

            //right
            if (col + 1 < lab[1].length && !lab[row][col + 1].equals("x") && !visited[row][col + 1]) {
                queue.add(new Cell(row, col + 1, false, current.getMoves() + 1));

            }
            // down
            if (row + 1 < lab[0].length && !lab[row + 1][col].equals("x") && !visited[row + 1][col]) {
                queue.add(new Cell(row + 1, col, false, current.getMoves() + 1));
            }
            // left
            if (col - 1 >= 0 && !lab[row][col - 1].equals("x") && !visited[row][col - 1]) {
                queue.add(new Cell(row, col - 1, false, current.getMoves() + 1));
            }
        }
        PrintLab(lab);
    }

    private static String[][] ReadLab(Integer n) throws IOException {

        String[][] lab = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                lab[i][j] = line[j];
            }
        }
        return lab;
    }

    private static void PrintLab(String[][] lab) {
        for (int i = 0; i < lab[0].length; i++) {
            for (int j = 0; j < lab[1].length; j++) {

                if (lab[i][j].equals("*")) {
                    System.out.print("*");
                } else if (lab[i][j].equals("0")) {
                    System.out.print("u");
                } else {
                    System.out.print(lab[i][j]);
                }
            }
            System.out.println();
        }
    }
}


class Cell {
    int Row;
    int Col;
    boolean Visited;
    int Moves;

    public Cell(int row, int col, boolean visited, int moves) {
        this.Row = row;
        this.Col = col;
        this.Visited = visited;
        this.Moves = moves;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int col) {
        Col = col;
    }

    public boolean isVisited() {
        return Visited;
    }

    public void setVisited(boolean visited) {
        Visited = visited;
    }

    public int getMoves() {
        return Moves;
    }

    public void setMoves(int moves) {
        Moves = moves;
    }
}