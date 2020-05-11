/* *****************************************************************************
 *  Name:              Jonathan Trost
 *  Coursera User ID:  Computer Science: Programming With A Purpose
 *  Last modified:     11 April 2020
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        int numOfMines = Integer.parseInt(args[2]);

        int[][] battlefield = new int[row + 2][col + 2];

        // Place Mines ' -1'
        for (int x = row; x > 0; x--) {
            for (int y = col; y > 0; y--) {
                if (numOfMines > 0) {
                    battlefield[x][y] = -1;
                    numOfMines--;
                }
                else {
                    break;
                }
            }
        }

        // Shuffle Mines
        for (int x = 1; x < row; x++) {
            for (int y = 1; y < col; y++) {
                int r = (x * y) + (int) (Math.random() * ((row * col) - (x * y)));
                // turn r into xRandom and yRandom
                int xRandom = (r % row) + 1;
                int yRandom = (r / row) + 1;

                int holder = battlefield[xRandom][(yRandom)];
                battlefield[xRandom][yRandom] = battlefield[x][y];
                battlefield[x][y] = holder;
            }
        }


        // Count mines
        for (int x = 1; x <= row; x++) {
            for (int y = 1; y <= col; y++) {
                if (battlefield[x][y] != -1) {
                    if (battlefield[x - 1][y - 1] == -1) {
                        battlefield[x][y]++;
                    }
                    if (battlefield[x - 1][y] == -1) {
                        battlefield[x][y]++;
                    }
                    if (battlefield[x - 1][y + 1] == -1) {
                        battlefield[x][y]++;
                    }
                    if (battlefield[x][y - 1] == -1) {
                        battlefield[x][y]++;
                    }
                    if (battlefield[x][y + 1] == -1) {
                        battlefield[x][y]++;
                    }
                    if (battlefield[x + 1][y - 1] == -1) {
                        battlefield[x][y]++;
                    }
                    if (battlefield[x + 1][y] == -1) {
                        battlefield[x][y]++;
                    }
                    if (battlefield[x + 1][y + 1] == -1) {
                        battlefield[x][y]++;
                    }
                }
            }
        }

        // Print field
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (battlefield[i][j] == -1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(battlefield[i][j]);
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
