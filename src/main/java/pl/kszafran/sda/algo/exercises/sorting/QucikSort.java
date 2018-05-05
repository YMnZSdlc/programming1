package pl.kszafran.sda.algo.exercises.sorting;

public class QucikSort {
    public static void main(String[] args) {

        int[]tab = {1,3,2,4,6,5};
        qucikSort(tab);
    }

    public static void qucikSort(int[] array) {
        quickSortIn(array, 0, array.length - 1);
    }

    public static void quickSortIn(int[] array, int start, int end) {
        if (start<end){
            int index = start + 1;
            for (int i = start + 1; i < end; i++) {
                if (array[i] < array[start]) {
                    swap(array, i, index++);
                }
            }
            swap(array, index-1, start);
            quickSortIn(array,start,index-1);
            quickSortIn(array,index+1,end);
        }
    }

    public static void swap(int[] arrayToSwap, int a, int b) {
        int tmp = arrayToSwap[a];
        arrayToSwap[a] = arrayToSwap[b];
        arrayToSwap[b] = tmp;
    }
}
