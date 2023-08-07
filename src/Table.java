import java.util.Arrays;
import java.util.Formatter;

public class Table {



    private static String[][] loadTable(String[] elements){
        int n = elements.length+1;
        String[][] resultTable = new String[n][n];
        resultTable[0][0] = "PC/USER";

        for(int i=1;i<=elements.length;i++){

            resultTable[0][i] = elements[i-1];
            resultTable[i][0] = elements[i-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    resultTable[i][j] = "Draw";
                } else if (j > i + (n - 1) / 2) {
                    resultTable[i][j] = "Lose";
                    resultTable[j][i] = "Win";
                } else {
                    resultTable[i][j] = "Win";
                    resultTable[j][i] = "Lose";
                }
            }
        }

        return resultTable;

    }
    public static void printTable(String[] args){
        String[][] table = loadTable(args);

        int numRows = table.length;
        int numCols = table[0].length;

        int[] columnWidths = new int[numCols];
        for (int col = 0; col < numCols; col++) {
            for (String[] strings : table) {
                columnWidths[col] = Math.max(columnWidths[col], strings[col].length());
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.printf("%-" + columnWidths[col] + "s", table[row][col]);
                if (col < numCols - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row == 0) {
                for (int col = 0; col < numCols; col++) {
                    for (int i = 0; i < columnWidths[col]; i++) {
                        System.out.print("-");
                    }
                    if (col < numCols - 1) {
                        System.out.print("-+-");
                    }
                }
                System.out.println();
            }

        }

    }
}



