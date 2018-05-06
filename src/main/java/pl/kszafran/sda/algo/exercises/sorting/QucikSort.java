package pl.kszafran.sda.algo.exercises.sorting;

public class QucikSort {
    public static void main(String[] args) {

        int[]tab = {25,1,3,2,4,6,5, 8, 12, 3, 89, 73};
        printArray(tab);
        qucikSort(tab);
        printArray(tab);
    }

    public static void qucikSort(int[] array) {
        if (array == null || array.length==0)
            return;
        quickSortIn(array, 0, array.length - 1);
    }

    public static void quickSortIn(int[] array, int lowIndex, int hiIndex) {
        int fromLow = lowIndex;
        int fromHi = hiIndex;
        int pivot = array[fromLow+(fromHi-fromLow)/2];

        while (fromLow<=fromHi){
            while (array[fromLow]<pivot)
                fromLow++;
            while (array[fromHi]>pivot)
                fromHi--;
            if (fromLow<=fromHi){
                swap(array, fromHi,fromLow);
                fromLow++;
                fromHi--;
            }
        }
        if (lowIndex<fromHi)
            quickSortIn(array,lowIndex,fromHi);
        if (fromLow<hiIndex)
            quickSortIn(array,fromLow,hiIndex);
    }

    public static void swap(int[] arrayToSwap, int a, int b) {
        int tmp = arrayToSwap[a];
        arrayToSwap[a] = arrayToSwap[b];
        arrayToSwap[b] = tmp;
    }

    public static void printArray (int... tab){
        for (int i : tab) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

           /* if (start<end){
            int index = start + 1;
            for (int i = start + 1; i < end; i++) {
                if (array[i] < array[start]) {
                    swap(array, i, index++);
                }
            }
            swap(array, index-1, start);
            quickSortIn(array,start,index-1);
            quickSortIn(array,index+1,end);
        }*/
}
