package SortingAlgorithm;

public class ShakerSort {
    public static void shakerSort(int[] x) {
        int temp;

        for (int i = 0; i < (x.length / 2); i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {

                if (x[j] > x[j + 1]) {
                    temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
            for (int k = 0; k < x.length - 2 - i; k++) {

                if (x[k] < x[k - 1]) {
                    temp = x[k];
                    x[k] = x[k - 1];
                    x[k - 1] = temp;
                }

            }
        }
    }
}
