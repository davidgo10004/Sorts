package sort;

public class MergeSort {
    
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(
            T[] array, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (((T) leftArray[i]).compareTo((T) rightArray[j]) <= 0) {
                array[k++] = (T) leftArray[i++];
            } else {
                array[k++] = (T) rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = (T) leftArray[i++];
        }

        while (j < n2) {
            array[k++] = (T) rightArray[j++];
        }
    }

}
