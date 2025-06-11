public class MatrixMultiply {
    static int[][] matA = { {1, 2}, {3, 4} };
    static int[][] matB = { {2, 0}, {1, 2} };
    static int[][] result = new int[2][2];

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            result[0][0] = matA[0][0]*matB[0][0] + matA[0][1]*matB[1][0];
            result[0][1] = matA[0][0]*matB[0][1] + matA[0][1]*matB[1][1];
        });

        Thread t2 = new Thread(() -> {
            result[1][0] = matA[1][0]*matB[0][0] + matA[1][1]*matB[1][0];
            result[1][1] = matA[1][0]*matB[0][1] + matA[1][1]*matB[1][1];
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        for (int[] r : result) {
            for (int x : r) System.out.print(x + " ");
            System.out.println();
        }
    }
}