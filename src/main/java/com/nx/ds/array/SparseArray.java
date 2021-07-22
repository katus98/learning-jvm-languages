package com.nx.ds.array;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-22
 */
public class SparseArray {
    /**
     * 二维棋盘转化为稀疏数组存储在磁盘
     */
    @Test
    void saveChess() {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        show(chessArray);
        int[][] sparseArray = binaryToSparse(chessArray);
        show(sparseArray);
        try {
            save("src/main/resources/file.ser", sparseArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从磁盘中载入稀疏数组并复盘
     */
    @Test
    void loadChess() {
        try {
            int[][] sparseArray = load("src/main/resources/file.ser");
            show(sparseArray);
            int[][] binaryArray = sparseToBinary(sparseArray);
            show(binaryArray);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Data
    @AllArgsConstructor
    private static class TwoDimArray implements Serializable {
        private static final long serialVersionUID = -6849944470754887460L;
        int[][] data;
    }

    private static int[][] binaryToSparse(int[][] binaryArray) {
        if (binaryArray.length == 0) {
            return new int[][]{{0, 0, 0}};
        }
        int sum = 0;
        for (int[] row : binaryArray) {
            for (int item : row) {
                if (item != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = binaryArray.length;
        sparseArray[0][1] = binaryArray[0].length;
        sparseArray[0][2] = sum;
        int rowNum = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            for (int j = 0; j < binaryArray[i].length; j++) {
                if (binaryArray[i][j] != 0) {
                    rowNum++;
                    sparseArray[rowNum][0] = i;
                    sparseArray[rowNum][1] = j;
                    sparseArray[rowNum][2] = binaryArray[i][j];
                }
            }
        }
        return sparseArray;
    }

    private static int[][] sparseToBinary(int[][] sparseArray) {
        int[][] binaryArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            binaryArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return binaryArray;
    }

    private static void save(String filename, int[][] array) throws IOException {
        TwoDimArray savedObject = new TwoDimArray(array);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(savedObject);
        oos.close();
    }

    private static int[][] load(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        TwoDimArray savedObject = (TwoDimArray) ois.readObject();
        ois.close();
        return savedObject.getData();
    }

    private static void show(int[][] array) {
        for (int[] row : array) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
