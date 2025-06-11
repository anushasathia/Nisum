import java.util.Arrays;

public class ThreadSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {5, 1, 4, 2, 8, 3};

        int mid = arr.length / 2;

        Thread t1 = new Thread(() -> Arrays.sort(arr, 0, mid));
        Thread t2 = new Thread(() -> Arrays.sort(arr, mid, arr.length));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int[] sorted = new int[arr.length];
        int i = 0, j = mid, k = 0;

        while (i < mid && j < arr.length) {
            if (arr[i] < arr[j]) sorted[k++] = arr[i++];
            else sorted[k++] = arr[j++];
        }

        while (i < mid) sorted[k++] = arr[i++];
        while (j < arr.length) sorted[k++] = arr[j++];

        System.out.println("done sort: " + Arrays.toString(sorted));
    }
}